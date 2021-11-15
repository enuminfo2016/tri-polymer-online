package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
}
