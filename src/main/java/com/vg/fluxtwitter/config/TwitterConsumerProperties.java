package com.vg.fluxtwitter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("ov")
public class TwitterConsumerProperties {
    private String apiKey;
    private String apiSecret;
    private String apiAccessToken;
    private String apiAccessTokenSecret;

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public String getApiAccessToken() {
        return apiAccessToken;
    }

    public void setApiAccessToken(String apiAccessToken) {
        this.apiAccessToken = apiAccessToken;
    }

    public String getApiAccessTokenSecret() {
        return apiAccessTokenSecret;
    }

    public void setApiAccessTokenSecret(String apiAccessTokenSecret) {
        this.apiAccessTokenSecret = apiAccessTokenSecret;
    }
}
