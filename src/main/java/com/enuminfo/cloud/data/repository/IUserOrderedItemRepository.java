package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.UserOrderedItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserOrderedItemRepository extends PagingAndSortingRepository<UserOrderedItem, Long> {
}
