package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.User;

import reactor.core.publisher.Mono;

@Repository
public interface IUserRepository extends ReactiveCrudRepository<User, Long> {
	Mono<User> findByUsernameAndPassword(String username, String password);
}
