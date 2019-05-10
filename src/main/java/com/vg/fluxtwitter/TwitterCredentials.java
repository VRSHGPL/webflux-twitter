package com.vg.fluxtwitter;

public class TwitterCredentials {
    private final String apiKey;
    private final String apiSecret;
    private final String accessToken;
    private final String accessTokenSecret;

    TwitterCredentials(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        this.apiKey = consumerKey;
        this.apiSecret = consumerSecret;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
    }

    String getConsumerKey() {
        return apiKey;
    }

    String getConsumerSecret() {
        return apiSecret;
    }

    String getAccessToken() {
        return accessToken;
    }

    String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    @Override
    public String toString() {
        return "TwitterCredentials{" + "apiKey='" + apiKey + '\'' + ", apiSecret='" + apiSecret + '\''
                + ", accessToken='" + accessToken + '\'' + ", accessTokenSecret='" + accessTokenSecret + '\'' + '}';
    }
}
