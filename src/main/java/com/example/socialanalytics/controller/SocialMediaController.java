package com.example.socialanalytics.controller;

import com.example.socialanalytics.model.SocialMediaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.socialanalytics.service.SocialMediaService;

@RestController
@RequestMapping("/social")
public class SocialMediaController {

    @Autowired
    private SocialMediaService socialMediaService;

    @GetMapping("/{platform}")
    public SocialMediaResponse getTrendingData(@PathVariable String platform) {
        return socialMediaService.fetchTrendingData(platform);
    }
}
