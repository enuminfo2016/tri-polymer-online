package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.UserDetail;

import reactor.core.publisher.Mono;

@Repository
public interface IUserDetailRepository extends ReactiveCrudRepository<UserDetail, Long> {
	Mono<UserDetail> findByPhone(Long phone);
	Mono<UserDetail> findByPhoneAndEmail(Long phone, String email);
}
