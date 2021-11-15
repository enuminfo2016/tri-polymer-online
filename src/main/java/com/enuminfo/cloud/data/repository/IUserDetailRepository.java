package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.UserDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDetailRepository extends PagingAndSortingRepository<UserDetail, Long> {
}
