package com.vg.fluxtwitter.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.vg.fluxtwitter.model.Tweet;

/**
 * spring will kick in auto implementation SimpleReactiveMongoRepository at runtime .
 * this implementation returns a ReactiveStreams Publisher in the form of Mono or Flux.
 * 
 * @author varsha.gopal
 *
 */
public interface TweetRepository extends ReactiveCrudRepository<Tweet, Long> {

}
