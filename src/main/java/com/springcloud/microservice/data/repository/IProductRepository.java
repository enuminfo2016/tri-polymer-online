/**
 * 
 */
package com.springcloud.microservice.data.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springcloud.microservice.data.model.Product;

/**
 * @author SIVA KUMAR
 */
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

	Optional<Product> findByName(String name);

	Iterable<Product> findByCategory(Long category);

	Iterable<Product> findByStatus(Boolean status);
}
