package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IProductRepository extends ReactiveCrudRepository<Product, Long> {
	Mono<Product> findByName(String name);
	Flux<Product> findByCategory(Long category);
	Flux<Product> findByStatus(Boolean status);
}
