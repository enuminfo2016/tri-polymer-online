package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.Location;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ILocationRepository extends ReactiveCrudRepository<Location, Long> {
	Flux<Location> findByCountry(Long country);
	Flux<Location> findByState(String state);
	Flux<Location> findByCity(String city);
	Mono<Location> findByName(String name);
}
