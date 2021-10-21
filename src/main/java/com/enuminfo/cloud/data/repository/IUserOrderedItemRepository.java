/**
 * 
 */
package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.cloud.data.model.UserOrderedItem;

/**
 * @author SIVA KUMAR
 */
public interface IUserOrderedItemRepository extends PagingAndSortingRepository<UserOrderedItem, Long> {

	Iterable<UserOrderedItem> findByUserOrder(Long order);

	Iterable<UserOrderedItem> findByProduct(Long product);
	
	Iterable<UserOrderedItem> findByUserOrderAndProduct(Long order, Long product);
}
