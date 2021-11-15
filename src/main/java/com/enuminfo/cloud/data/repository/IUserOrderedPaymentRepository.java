package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.UserOrderedPayment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserOrderedPaymentRepository extends PagingAndSortingRepository<UserOrderedPayment, Long> {
}
