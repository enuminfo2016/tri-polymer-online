/**
 * 
 */
package com.springcloud.microservice.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springcloud.microservice.data.model.UserOrderedItem;

/**
 * @author SIVA KUMAR
 */
public interface IUserOrderedItemRepository extends PagingAndSortingRepository<UserOrderedItem, Long> {

	Iterable<UserOrderedItem> findByUserOrder(Long order);

	Iterable<UserOrderedItem> findByProduct(Long product);
	
	Iterable<UserOrderedItem> findByUserOrderAndProduct(Long order, Long product);
}
