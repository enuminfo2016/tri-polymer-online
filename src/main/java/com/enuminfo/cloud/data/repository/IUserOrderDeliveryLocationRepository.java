package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.UserOrderDeliveryLocation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserOrderDeliveryLocationRepository
		extends PagingAndSortingRepository<UserOrderDeliveryLocation, Long> {
}
