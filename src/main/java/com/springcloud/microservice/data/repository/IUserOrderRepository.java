/**
 * 
 */
package com.springcloud.microservice.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springcloud.microservice.data.model.User;
import com.springcloud.microservice.data.model.UserOrder;

/**
 * @author SIVA KUMAR
 */
public interface IUserOrderRepository extends PagingAndSortingRepository<UserOrder, Long> {

	Iterable<UserOrder> findByStatus(String status);

	Iterable<UserOrder> findByUserAndStatusOrderByOrderedDateDesc(User user, String status);

	Iterable<UserOrder> findByStatusOrDeliveryStatus(String status, String deliveryStatus);
}
