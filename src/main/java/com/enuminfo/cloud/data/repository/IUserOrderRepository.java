package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.User;
import com.enuminfo.cloud.data.model.UserOrder;

import reactor.core.publisher.Flux;

@Repository
public interface IUserOrderRepository extends ReactiveCrudRepository<UserOrder, Long> {
	Flux<UserOrder> findByStatus(String status);
	Flux<UserOrder> findByUserAndStatusOrderByOrderedDateDesc(User user, String status);
	Flux<UserOrder> findByStatusOrDeliveryStatus(String status, String deliveryStatus);
}
