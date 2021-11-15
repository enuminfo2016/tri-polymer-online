package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.ProductImage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductImageRepository extends PagingAndSortingRepository<ProductImage, Long> {
	Iterable<ProductImage> findByProductAndMainImg(Long product, Boolean mainImg);
}
