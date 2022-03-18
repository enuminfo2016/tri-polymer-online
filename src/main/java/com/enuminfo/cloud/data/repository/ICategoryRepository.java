package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.Category;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ICategoryRepository extends ReactiveCrudRepository<Category, Long> {
	Mono<Category> findByName(String name);
	Flux<Category> findByStatus(Boolean status);
}
