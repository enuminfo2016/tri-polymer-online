package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.enuminfo.cloud.data.model.UserOrderedItem;

import reactor.core.publisher.Flux;

public interface IUserOrderedItemRepository extends ReactiveCrudRepository<UserOrderedItem, Long> {
	Flux<UserOrderedItem> findByUserOrder(Long order);
	Flux<UserOrderedItem> findByProduct(Long product);
	Flux<UserOrderedItem> findByUserOrderAndProduct(Long order, Long product);
}
