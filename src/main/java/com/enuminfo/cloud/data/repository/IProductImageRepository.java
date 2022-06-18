package com.enuminfo.cloud.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.ProductImage;

@Repository
public interface IProductImageRepository extends PagingAndSortingRepository<ProductImage, Long> {
	List<ProductImage> findByProductAndMainImg(Long product, Boolean mainImg);
}
