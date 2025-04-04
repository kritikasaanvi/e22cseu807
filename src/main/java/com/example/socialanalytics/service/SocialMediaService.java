package com.example.socialanalytics.service;

import com.example.socialanalytics.model.SocialMediaResponse;
import org.springframework.stereotype.Service;  // <- ✅ Import this
import java.util.Arrays;
import java.util.List;

@Service  // <- ✅ Add this annotation
public class SocialMediaService {

    public SocialMediaResponse fetchTrendingData(String platform) {
        SocialMediaResponse response = new SocialMediaResponse();
        response.setPlatform(platform);

        List<String> hashtags;
        int totalPosts;

        if ("twitter".equalsIgnoreCase(platform)) {
            hashtags = Arrays.asList("#Java", "#SpringBoot", "#OpenAI");
            totalPosts = 1234;
        } else if ("instagram".equalsIgnoreCase(platform)) {
            hashtags = Arrays.asList("#InstaDaily", "#Travel", "#Photography");
            totalPosts = 890;
        } else {
            hashtags = Arrays.asList("#Trending", "#SocialMedia");
            totalPosts = 500;
        }

        response.setTrendingHashtags(hashtags);
        response.setTotalPosts(totalPosts);

        return response;
    }
}
