package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.User;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
	User findByUsernameAndPassword(String username, String password);
}
