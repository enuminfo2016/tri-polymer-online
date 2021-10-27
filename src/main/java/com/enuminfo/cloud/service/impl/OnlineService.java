package com.enuminfo.cloud.service.impl;

import com.enuminfo.cloud.data.model.*;
import com.enuminfo.cloud.data.repository.*;
import com.enuminfo.cloud.rest.dto.CatalogProductDto;
import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.rest.dto.LocationDto;
import com.enuminfo.cloud.service.IOnlineService;
import com.enuminfo.cloud.util.Constants;
import com.enuminfo.cloud.util.DateTimeUtil;
import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OnlineService implements IOnlineService {

	@Autowired
	ICountryRepository countryRepository;
	@Autowired
	ILocationRepository locationRepository;
	@Autowired
	ICategoryRepository categoryRepository;
	@Autowired
	IProductRepository productRepository;
	@Autowired
	ICatalogProductRepository catalogProductRepository;
	@Autowired
	ICatalogRepository catalogRepository;
	@Autowired IUserOrderedItemRepository userOrderedItemRepository;
	@Autowired IProductImageRepository productImageRepository;

	@Override
	public List<String> getAllCountries() {
		List<String> values = new ArrayList<>();
		countryRepository.findByStatus(Boolean.TRUE).forEach(model -> {
			values.add(model.getName());
		});
		return values;
	}

	@Override
	public List<String> getAllStates(String country) {
		List<String> values = new ArrayList<>();
		Optional<Country> optional = countryRepository.findByName(country);
		if (optional.isPresent()) {
			Country countryModel = optional.get();
			locationRepository.findByCountry(countryModel.getId()).forEach(model -> {
				values.add(model.getName());
			});
		}
		return values;
	}

	@Override
	public List<String> getAllCities(String state) {
		List<String> values = new ArrayList<>();
		locationRepository.findByState(state).forEach(model -> {
			values.add(model.getName());
		});
		return values;
	}

	@Override
	public List<LocationDto> getAllLocations(String city) {
		List<LocationDto> locationDtos = new ArrayList<>();
		Iterable<Location> models = locationRepository.findByCity(city);
		for(Location model: models) {
			LocationDto dto = new LocationDto();
			dto.setId(model.getId());
			dto.setName(model.getName());
			dto.setPin(model.getPin());
			dto.setCity(model.getCity());
			dto.setState(model.getState());
			Optional<Country> optional = countryRepository.findById(model.getCountry());
			if (optional.isPresent()) 
				dto.setCountry(optional.get().getName());
			locationDtos.add(dto);
		}
		return locationDtos;
	}

	@Override
	public List<CatalogProductDto> getProductsByCategory(String value) {
		List<CatalogProductDto> catalogProductDtos = new ArrayList<>();
		List<String> dates = DateTimeUtil.getInstance().getFinancialYearStartNEndDates();
		Optional<Catalog> optionalCatalog = catalogRepository.findByStartDateAndEndDate(dates.get(0), dates.get(1));
		Catalog catalog = (optionalCatalog.isPresent() ? optionalCatalog.get() : null);
		if (catalog != null) {
			List<CatalogProduct> catalogProducts = IteratorUtils.toList(catalogProductRepository.findByCatalog(catalog.getId()).iterator());
			for (CatalogProduct catalogProduct: catalogProducts) {
				Optional<Product> optionalProduct = productRepository.findById(catalogProduct.getProduct());
				Product product = (optionalProduct.isPresent() ? optionalProduct.get() : null);
				Optional<Category> optionalCategory = categoryRepository.findById(Long.parseLong(value));
				Category category = (optionalCategory.isPresent() ? optionalCategory.get() : null);
				if ((product != null && category != null) && (Long.parseLong(value) == product.getCategory())) {
					CatalogProductDto dto = new CatalogProductDto();
					dto.setId(catalogProduct.getId());
					dto.setTitle(product.getName());
					dto.setCategory(optionalCategory.get().getName());
					dto.setQuantity(catalogProduct.getQuantity());
					dto.setNewPrice(catalogProduct.getPrice());
					dto.setOldPrice(catalogProduct.getPrice());
					if (dto.getQuantity() != 0) dto.setSale(Constants.SALE);
					else dto.setOutOfStock(Constants.OUT_OF_STOCK);
					List<ProductImage> mainProductImages = IteratorUtils.toList(productImageRepository.findByProductAndMainImg(product.getId(), Boolean.TRUE).iterator());
					dto.setMainImg(Constants.IMAGE_PATH + mainProductImages.get(0).getImgName());
					dto.setDetailsLink(String.valueOf(dto.getId()));
					catalogProductDtos.add(dto);
				}
			}
		}
		return catalogProductDtos;
	}

	@Override
	public Map<CategoryDto, List<CatalogProductDto>> getAllProducts() {
		Map<CategoryDto, List<CatalogProductDto>> catalogProductByCategoryMap = new TreeMap<>();
		Iterable<Category> models = categoryRepository.findByStatus(Boolean.TRUE);
		models.forEach(model -> {
			CategoryDto dto = new CategoryDto();
			dto.setId(model.getId());
			dto.setName(model.getName());
			dto.setDescription(model.getDescription());
			catalogProductByCategoryMap.put(dto, getProductsByCategory(model.getName()));
		});
		return catalogProductByCategoryMap;
	}

	@Override
	public CatalogProductDto getProductDetailByProduct(String value) {
		CatalogProduct catalogProduct = catalogProductRepository.findByProduct(Long.parseLong(value));
		Optional<Product> optionalProduct = productRepository.findById(Long.parseLong(value));
		Product product = (optionalProduct.isPresent() ? optionalProduct.get() : new Product());
		Optional<Category> optionalCategory = categoryRepository.findById(product.getCategory());
		Category category = (optionalCategory.isPresent() ? optionalCategory.get() : new Category());
		CatalogProductDto dto = new CatalogProductDto();
		dto.setId(catalogProduct.getId());
		dto.setTitle(product.getName());
		dto.setCategory(category != null ? category.getName() : StringUtils.EMPTY);
		dto.setQuantity(catalogProduct.getQuantity());
		dto.setNewPrice(catalogProduct.getPrice());
		dto.setOldPrice(catalogProduct.getPrice());
		if (dto.getQuantity() != 0) dto.setSale(Constants.SALE);
		else dto.setOutOfStock(Constants.OUT_OF_STOCK);
		List<ProductImage> mainProductImages = IteratorUtils.toList(productImageRepository.findByProductAndMainImg(product.getId(), Boolean.TRUE).iterator());
		dto.setMainImg(Constants.IMAGE_PATH + mainProductImages.get(0).getImgName());
		List<String> images = new ArrayList<>();
		images.add(Constants.IMAGE_PATH + mainProductImages.get(0).getImgName());
		List<ProductImage> remainingProductImages = IteratorUtils.toList(productImageRepository.findByProductAndMainImg(product.getId(), Boolean.FALSE).iterator());
		for (ProductImage image: remainingProductImages) {
			images.add(Constants.IMAGE_PATH + image.getImgName());
		}
		dto.setImages(images);
		dto.setDetailsLink(String.valueOf(dto.getId()));
		return dto;
	}
}
