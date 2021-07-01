/**
 * 
 */
package com.springcloud.microservice.data.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springcloud.microservice.data.model.Category;

/**
 * @author SIVA KUMAR
 */
public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {

	Optional<Category> findByName(String name);

	Iterable<Category> findByStatus(Boolean status);
}
