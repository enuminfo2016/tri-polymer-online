package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.UserOrderDeliveryLocation;

import reactor.core.publisher.Mono;

@Repository
public interface IUserOrderDeliveryLocationRepository
		extends ReactiveCrudRepository<UserOrderDeliveryLocation, Long> {
	Mono<UserOrderDeliveryLocation> findByUserOrder(Long userOrder);
}
