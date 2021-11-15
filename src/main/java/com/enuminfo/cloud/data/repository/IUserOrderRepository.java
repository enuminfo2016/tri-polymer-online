package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.UserOrder;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserOrderRepository extends PagingAndSortingRepository<UserOrder, Long> {
}
