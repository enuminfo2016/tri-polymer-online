package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.Access;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccessRepository extends PagingAndSortingRepository<Access, Long> {
}
