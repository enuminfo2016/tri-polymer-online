package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.UserOrderedPayment;

@Repository
public interface IUserOrderedPaymentRepository extends ReactiveCrudRepository<UserOrderedPayment, Long> {
}
