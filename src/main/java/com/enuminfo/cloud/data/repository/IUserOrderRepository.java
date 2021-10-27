package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.UserOrder;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserOrderRepository extends PagingAndSortingRepository<UserOrder, Long> {
}
