package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.Country;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ICountryRepository extends ReactiveCrudRepository<Country, Long> {
	Mono<Country> findByName(String name);
	Flux<Country> findByStatus(Boolean status);
}
