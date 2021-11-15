package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.UserOrderedItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserOrderedItemRepository extends PagingAndSortingRepository<UserOrderedItem, Long> {
}
