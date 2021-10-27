package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
	Iterable<Category> findByStatus(Boolean status);
}
