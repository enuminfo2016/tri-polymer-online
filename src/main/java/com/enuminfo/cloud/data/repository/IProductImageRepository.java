/**
 * 
 */
package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.ProductImage;

/**
 * @author SIVA KUMAR
 */
@Repository
public interface IProductImageRepository extends PagingAndSortingRepository<ProductImage, Long> {
	
	Iterable<ProductImage> findByProductAndMainImg(Long product, Boolean mainImg);
}
