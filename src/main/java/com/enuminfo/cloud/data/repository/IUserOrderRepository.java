/**
 * 
 */
package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.cloud.data.model.User;
import com.enuminfo.cloud.data.model.UserOrder;

/**
 * @author SIVA KUMAR
 */
public interface IUserOrderRepository extends PagingAndSortingRepository<UserOrder, Long> {

	Iterable<UserOrder> findByStatus(String status);

	Iterable<UserOrder> findByUserAndStatusOrderByOrderedDateDesc(User user, String status);

	Iterable<UserOrder> findByStatusOrDeliveryStatus(String status, String deliveryStatus);
}
