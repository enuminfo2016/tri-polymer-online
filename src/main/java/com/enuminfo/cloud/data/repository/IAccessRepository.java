package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.Access;

@Repository
public interface IAccessRepository extends ReactiveCrudRepository<Access, Long> {
}
