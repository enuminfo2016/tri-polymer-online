package com.enuminfo.cloud.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.Category;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
	Category findByName(String name);
	List<Category> findByStatus(Boolean status);
}
