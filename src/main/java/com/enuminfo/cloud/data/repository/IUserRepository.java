package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
}
