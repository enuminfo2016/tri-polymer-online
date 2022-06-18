package com.enuminfo.cloud.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.cloud.data.model.UserOrderedItem;

public interface IUserOrderedItemRepository extends PagingAndSortingRepository<UserOrderedItem, Long> {
	List<UserOrderedItem> findByUserOrder(Long order);
	List<UserOrderedItem> findByProduct(Long product);
	List<UserOrderedItem> findByUserOrderAndProduct(Long order, Long product);
}
