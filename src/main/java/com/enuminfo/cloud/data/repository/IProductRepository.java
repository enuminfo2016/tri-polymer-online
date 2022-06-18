package com.enuminfo.cloud.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.Product;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
	Product findByName(String name);
	List<Product> findByCategory(Long category);
	List<Product> findByStatus(Boolean status);
}
