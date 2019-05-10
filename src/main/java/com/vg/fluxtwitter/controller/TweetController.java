package com.vg.fluxtwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.vg.fluxtwitter.repository.TweetRepository;

@RestController
public class TweetController {

    @Autowired
    private TweetRepository tweetRepository;

  /*  @GetMapping("/tweets")
    public Flux<Tweet> getAllTweets() {
        return tweetRepository.findAll();
    }

    @PutMapping("/tweets")
    public Mono<Tweet> createTweet(@Valid @RequestBody Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @GetMapping("/tweets/{id}")
    public Mono<ResponseEntity<Tweet>> getTweetById(@PathVariable(value = "id") String id) {
        return tweetRepository.findById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }*/
}
