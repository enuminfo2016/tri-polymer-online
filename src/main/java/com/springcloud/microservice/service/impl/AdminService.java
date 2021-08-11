/**
 * 
 */
package com.springcloud.microservice.service.impl;

import java.text.ParseException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.microservice.data.model.Category;
import com.springcloud.microservice.data.model.Product;
import com.springcloud.microservice.data.model.ProductImage;
import com.springcloud.microservice.data.repository.ICatalogProductRepository;
import com.springcloud.microservice.data.repository.ICatalogRepository;
import com.springcloud.microservice.data.repository.ICategoryRepository;
import com.springcloud.microservice.data.repository.IDeliveryLocationRepository;
import com.springcloud.microservice.data.repository.IProductImageRepository;
import com.springcloud.microservice.data.repository.IProductRepository;
import com.springcloud.microservice.data.repository.IUserOrderedItemRepository;
import com.springcloud.microservice.rest.dto.CatalogDto;
import com.springcloud.microservice.rest.dto.CategoryDto;
import com.springcloud.microservice.rest.dto.LocationDto;
import com.springcloud.microservice.rest.dto.ProductDto;
import com.springcloud.microservice.service.IAdminService;
import com.springcloud.microservice.util.Constants;
import com.springcloud.microservice.util.ImageUtil;

/**
 * @author SIVA KUMAR
 */
@Service
public class AdminService implements IAdminService {
	
	@Autowired IProductRepository productRepository;
	@Autowired ICategoryRepository categoryRepository;
	@Autowired ICatalogRepository catalogRepository;
	@Autowired ICatalogProductRepository catalogProductRepository;
	@Autowired IUserOrderedItemRepository userOrderedItemRepository;
	@Autowired IDeliveryLocationRepository deliveryLocationRepository;
	@Autowired IProductImageRepository productImageRepository;

	@Override
	public void saveCategory(CategoryDto dto) throws ParseException {
		Category category = null;
		if (dto.getId() == 0) {
			Optional<Category> optionalCategory = categoryRepository.findByName(dto.getName());
			Category existingCategory = (optionalCategory.isPresent() ? optionalCategory.get() : null);
			category = (existingCategory != null ? existingCategory : new Category());
			category.setCreatedBy(System.getProperty(Constants.SYSTEM_USERNAME));
			category.setCreatedOn(new Date());
		} else {
			Optional<Category> optionalCategory = categoryRepository.findById(dto.getId());
			category = (optionalCategory.isPresent() ? optionalCategory.get() : new Category());
		}
		category.setStatus(Boolean.TRUE);
		category.setUpdatedBy(System.getProperty(Constants.SYSTEM_USERNAME));
		category.setUpdatedOn(new Date());
		category.setName(dto.getName());
		category.setDescription(dto.getDescription());
		categoryRepository.save(category);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<CategoryDto> dtos = new ArrayList<>();
		Iterable<Category> categories = categoryRepository.findByStatus(Boolean.TRUE);
		for (Category category: categories) {
			CategoryDto dto = new CategoryDto();
			dto.setId(category.getId());
			dto.setName(category.getName());
			dto.setDescription(category.getDescription());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void removeCategory(long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			category.setStatus(Boolean.FALSE);
			categoryRepository.save(category);
		}
	}

	@Override
	public void saveProduct(ProductDto dto) throws ParseException {
		Product product = null;
		if (dto.getId() == 0) {
			Optional<Product> optionalProduct = productRepository.findByName(dto.getName());
			Product existingProduct = (optionalProduct.isPresent() ? optionalProduct.get() : null);
			product = (existingProduct != null ? existingProduct : new Product());
			product.setCreatedBy(System.getProperty(Constants.SYSTEM_USERNAME));
			product.setCreatedOn(new Date());
		} else {
			Optional<Product> optionalProduct = productRepository.findById(dto.getId());
			product = (optionalProduct.isPresent() ? optionalProduct.get() : new Product());
		}
		product.setStatus(Boolean.TRUE);
		product.setUpdatedBy(System.getProperty(Constants.SYSTEM_USERNAME));
		product.setUpdatedOn(new Date());
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		Optional<Category> optionalCategory = categoryRepository.findByName(dto.getCategory());
		Category existingCategory = (optionalCategory.isPresent() ? optionalCategory.get() : null);
		if (existingCategory != null) {
			product.setCategory(existingCategory.getId());
			productRepository.save(product);
		}
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<ProductDto> dtos = new ArrayList<>();
		Iterable<Product> products = productRepository.findByStatus(Boolean.TRUE);
		for (Product product: products) {
			ProductDto dto = new ProductDto();
			dto.setId(product.getId());
			dto.setName(product.getName());
			dto.setDescription(product.getDescription());
			Optional<Category> optionalCategory = categoryRepository.findByName(dto.getCategory());
			Category existingCategory = (optionalCategory.isPresent() ? optionalCategory.get() : null);
			if (existingCategory != null)
				dto.setCategory(existingCategory.getName());
			Iterable<ProductImage> productImages = productImageRepository.findByProduct(product.getId());
			Map<String, Object> images = new HashMap<>();
			productImages.forEach(productImage -> {
				images.put(productImage.getImgName(), ImageUtil.decompressBytes(productImage.getImgData()));
			});
			dto.setImages(images);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void removeProduct(long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			product.setStatus(Boolean.FALSE);
			productRepository.save(product);
		}
	}

	@Override
	public void saveCatalog(CatalogDto dto) throws ParseException {
		
	}

	@Override
	public List<CatalogDto> getAllCatalogs() {
		List<CatalogDto> dtos = new ArrayList<>();
		return dtos;
	}

	@Override
	public void removeCatalog(long id) {
		
	}

	@Override
	public List<LocationDto> getAllDeliveryLocations() {
		List<LocationDto> dtos = new ArrayList<>();
		return dtos;
	}

	@Override
	public void saveDeliveryLocation(LocationDto dto) throws ParseException {
		
	}

	@Override
	public List<LocationDto> getAllDeliveryLocations(String location) {
		List<LocationDto> dtos = new ArrayList<>();
		return dtos;
	}
}
