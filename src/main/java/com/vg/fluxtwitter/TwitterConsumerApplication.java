package com.vg.fluxtwitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.vg.fluxtwitter.config.TwitterConsumerProperties;

@EnableReactiveMongoRepositories
@EnableConfigurationProperties(TwitterConsumerProperties.class)
@PropertySource("application.properties")
@SpringBootApplication
public class TwitterConsumerApplication {
    public static Logger LOGGER = LoggerFactory.getLogger(TwitterConsumerApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(TwitterConsumerApplication.class, args);    }
}
