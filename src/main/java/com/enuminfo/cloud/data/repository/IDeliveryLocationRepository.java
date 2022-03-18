package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.DeliveryLocation;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IDeliveryLocationRepository extends ReactiveCrudRepository<DeliveryLocation, Long> {
	Flux<DeliveryLocation> findByLocation(Long location);
	Mono<DeliveryLocation> findByStreetAndLandmark1AndLandmark2AndLocation(String street, String landmark1, String landmark2, Long location);
}
