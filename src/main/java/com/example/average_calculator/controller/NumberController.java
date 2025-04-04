package com.example.average_calculator.controller;

import com.example.average_calculator.model.NumberResponse;
import com.example.average_calculator.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/numbers")
public class NumberController {

    @Autowired
    private NumberService numberService;

    @GetMapping("/{numberid}")
    public NumberResponse getNumbers(@PathVariable String numberid) {
        return numberService.fetchAndProcessNumbers(numberid);
    }
}
