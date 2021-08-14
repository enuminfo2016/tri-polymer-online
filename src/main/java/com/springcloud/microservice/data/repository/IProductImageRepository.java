/**
 * 
 */
package com.springcloud.microservice.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springcloud.microservice.data.model.ProductImage;

/**
 * @author SIVA KUMAR
 */
@Repository
public interface IProductImageRepository extends PagingAndSortingRepository<ProductImage, Long> {
	
	Iterable<ProductImage> findByProduct(Long product);
}