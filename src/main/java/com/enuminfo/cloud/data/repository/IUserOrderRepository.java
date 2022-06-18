package com.enuminfo.cloud.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.User;
import com.enuminfo.cloud.data.model.UserOrder;

@Repository
public interface IUserOrderRepository extends PagingAndSortingRepository<UserOrder, Long> {
	List<UserOrder> findByStatus(String status);
	List<UserOrder> findByUserAndStatusOrderByOrderedDateDesc(User user, String status);
	List<UserOrder> findByStatusOrDeliveryStatus(String status, String deliveryStatus);
}
