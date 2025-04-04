package com.example.average_calculator.service;

import com.example.average_calculator.model.NumberResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class NumberService {

    private static final int WINDOW_SIZE = 10;
    private final List<Integer> numberWindow = new ArrayList<>();

    private final Map<String, String> apiMap = Map.of(
            "p", "http://20.244.56.144/evaluation-service/primes",
            "f", "http://20.244.56.144/evaluation-service/fibo",
            "e", "http://20.244.56.144/evaluation-service/even",
            "r", "http://20.244.56.144/evaluation-service/rand"
    );

    public NumberResponse fetchAndProcessNumbers(String id) {
        NumberResponse response = new NumberResponse();
        List<Integer> prevState = new ArrayList<>(numberWindow);

        if (!apiMap.containsKey(id)) {
            return null;
        }

        try {
            RestTemplate restTemplate = new RestTemplate();

            // Use LinkedHashMap for safer casting
            LinkedHashMap result = restTemplate.getForObject(apiMap.get(id), LinkedHashMap.class);

            if (result == null || result.get("numbers") == null) {
                return null;
            }

            // Safe cast
            List<Integer> freshNumbers = (List<Integer>) result.get("numbers");

            Set<Integer> uniqueNumbers = new LinkedHashSet<>(numberWindow);
            for (Integer num : freshNumbers) {
                if (!uniqueNumbers.contains(num)) {
                    uniqueNumbers.add(num);
                }
            }

            // Maintain window size of 10
            while (uniqueNumbers.size() > WINDOW_SIZE) {
                Iterator<Integer> it = uniqueNumbers.iterator();
                it.next();
                it.remove();
            }

            List<Integer> currState = new ArrayList<>(uniqueNumbers);
            double avg = currState.stream().mapToInt(i -> i).average().orElse(0.0);

            numberWindow.clear();
            numberWindow.addAll(currState);

            response.setWindowPrevState(prevState);
            response.setWindowCurrState(currState);
            response.setNumbers(freshNumbers);
            response.setAvg(Math.round(avg * 100.0) / 100.0);

            return response;

        } catch (Exception e) {
            System.out.println("Error while fetching numbers: " + e.getMessage());
            return null;
        }
    }
}
