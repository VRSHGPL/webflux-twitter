package com.vg.fluxtwitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import com.vg.fluxtwitter.config.TwitterConsumerProperties;
import com.vg.fluxtwitter.model.Tweet;
import com.vg.fluxtwitter.repository.TweetRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class TwitterStreamConfig {
    public static final Logger LOGGER = LoggerFactory.getLogger(TwitterStreamConfig.class);

    @Bean
    ApplicationRunner twitterStream(WebClient.Builder wcb, OAuth1SignatureUtil oauthUtil, TweetRepository repo) {
        return args -> {
            WebClient webclient = wcb.baseUrl("https://api.twitter.com/1.1")
                    .filter((oauthFilter(oauthUtil)))
                    .filter(logRequest())
                    .build();

            Flux<Tweet> tweets = webclient.get()
                    .uri(uriBuilder -> uriBuilder.path("/statuses/home_timeline.json").build())
                    .exchange()
                    .flatMapMany(clientReponse -> clientReponse.bodyToFlux(Tweet.class));
            repo.saveAll(tweets).log().subscribe(a -> LOGGER.info("Message read from flux : {}" , (a.getText())));
        };

    }

    private ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(request -> {
            LOGGER.info("Request: {} {}", request.method(), request.url());
            request.headers()
                    .forEach((name, values) -> values.forEach(value -> LOGGER.info("Header: {}={}", name, value)));
            return Mono.just(request);
        });
    }

    @Bean
    OAuth1SignatureUtil oAuth1SignatureUtil(TwitterConsumerProperties props) {
        TwitterCredentials creds = new TwitterCredentials(props.getApiKey(),
                props.getApiSecret(),
                props.getApiAccessToken(),
                props.getApiAccessTokenSecret());
        return new OAuth1SignatureUtil(creds);
    }

    private ExchangeFilterFunction oauthFilter(OAuth1SignatureUtil oauthUtil) {
        return ExchangeFilterFunction.ofRequestProcessor(req -> {
            ClientRequest oauthReq = ClientRequest.from(req)
                    .headers(headers -> headers.add(HttpHeaders.AUTHORIZATION, oauthUtil.oAuth1Header(req)))
                    .build();
            return Mono.just(oauthReq);
        });
    }

}
