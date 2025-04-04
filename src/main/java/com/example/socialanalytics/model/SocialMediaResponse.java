package com.example.socialanalytics.model;

import java.util.List;

public class SocialMediaResponse {
    private String platform;
    private List<String> trendingHashtags;
    private int totalPosts;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<String> getTrendingHashtags() {
        return trendingHashtags;
    }

    public void setTrendingHashtags(List<String> trendingHashtags) {
        this.trendingHashtags = trendingHashtags;
    }

    public int getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(int totalPosts) {
        this.totalPosts = totalPosts;
    }
}
