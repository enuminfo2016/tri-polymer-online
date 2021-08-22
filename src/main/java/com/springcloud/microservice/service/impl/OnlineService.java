/**
 * 
 */
package com.springcloud.microservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.microservice.data.model.Catalog;
import com.springcloud.microservice.data.model.CatalogProduct;
import com.springcloud.microservice.data.model.Category;
import com.springcloud.microservice.data.model.Country;
import com.springcloud.microservice.data.model.Location;
import com.springcloud.microservice.data.model.Product;
import com.springcloud.microservice.data.model.ProductImage;
import com.springcloud.microservice.data.repository.ICatalogProductRepository;
import com.springcloud.microservice.data.repository.ICatalogRepository;
import com.springcloud.microservice.data.repository.ICategoryRepository;
import com.springcloud.microservice.data.repository.ICountryRepository;
import com.springcloud.microservice.data.repository.ILocationRepository;
import com.springcloud.microservice.data.repository.IProductImageRepository;
import com.springcloud.microservice.data.repository.IProductRepository;
import com.springcloud.microservice.data.repository.IUserOrderedItemRepository;
import com.springcloud.microservice.rest.dto.CatalogProductDto;
import com.springcloud.microservice.rest.dto.CategoryDto;
import com.springcloud.microservice.rest.dto.LocationDto;
import com.springcloud.microservice.service.IOnlineService;
import com.springcloud.microservice.util.Constants;
import com.springcloud.microservice.util.DateTimeUtil;

/**
 * @author SIVA KUMAR
 */
@SuppressWarnings("unchecked")
@Service
public class OnlineService implements IOnlineService {

	@Autowired ICountryRepository countryRepository;	
	@Autowired ILocationRepository locationRepository;
	@Autowired ICategoryRepository categoryRepository;
	@Autowired IProductRepository productRepository;
	@Autowired ICatalogProductRepository catalogProductRepository;
	@Autowired ICatalogRepository catalogRepository;
	@Autowired IUserOrderedItemRepository userOrderedItemRepository;
	@Autowired IProductImageRepository productImageRepository;

	@Override
	public List<String> getAllCountries() {
		List<String> values = new ArrayList<>();
		Iterable<Country> models = countryRepository.findByStatus(Boolean.TRUE);
		for (Country model: models) {
			values.add(model.getName());
		}
		return values;
	}

	@Override
	public List<String> getAllStates(String country) {
		List<String> values = new ArrayList<>();
		Optional<Country> optional = countryRepository.findByName(country);
		if (optional.isPresent()) {
			Country countryModel = optional.get();
			Iterable<Location> models = locationRepository.findByCountry(countryModel.getId());
			for (Location model: models) {
				values.add(model.getName());
			}
		}
		return values;
	}

	@Override
	public List<String> getAllCities(String state) {
		List<String> values = new ArrayList<>();
		Iterable<Location> models = locationRepository.findByState(state);
		for(Location model: models) {
			values.add(model.getName());
		}
		return values;
	}

	@Override
	public List<String> getAllLocations(String city) {
		List<String> values = new ArrayList<>();
		Iterable<Location> models = locationRepository.findByCity(city);
		for(Location model: models) {
			values.add(model.getName());
		}
		return values;
	}

	@Override
	public LocationDto getLocationByName(String location) {
		LocationDto dto = new LocationDto();
		Optional<Location> optional = locationRepository.findByName(location);
		if (optional.isPresent()) {
			Location model = optional.get();
			dto.setId(model.getId());
			dto.setName(model.getName());
			dto.setCity(model.getCity());
		}
		return dto;
	}

	@Override
	public List<CatalogProductDto> getAllCatalogProductsByCategory(String value) {
		List<CatalogProductDto> dtos = new ArrayList<>();
		List<String> dates = DateTimeUtil.getInstance().getFinancialYearStartNEndDates();
		Optional<Catalog> optionalCatalog = catalogRepository.findByStartDateAndEndDate(dates.get(0), dates.get(1));
		Catalog catalog = (optionalCatalog.isPresent() ? optionalCatalog.get() : null);
		if (catalog != null) {
			List<CatalogProduct> catalogProducts = IteratorUtils.toList(catalogProductRepository.findByCatalog(catalog.getId()).iterator());
			for (CatalogProduct catalogProduct: catalogProducts) {
				Optional<Product> optionalProduct = productRepository.findById(catalogProduct.getProduct());
				Product product = (optionalProduct.isPresent() ? optionalProduct.get() : null);
				if (product != null) {
					if (Long.parseLong(value) == product.getCategory()) {
						CatalogProductDto dto = new CatalogProductDto();
						dto.setId(catalogProduct.getId());
						dto.setTitle(product.getName());
						dto.setCategory(categoryRepository.findById(Long.parseLong(value)).get().getName());
						dto.setQuantity(catalogProduct.getQuantity());
						dto.setNewPrice(catalogProduct.getPrice());
						dto.setOldPrice(catalogProduct.getPrice());
						if (dto.getQuantity() != 0) dto.setSale(Constants.SALE);
						else dto.setOutOfStock(Constants.OUT_OF_STOCK);
						List<ProductImage> mainProductImages = IteratorUtils.toList(productImageRepository.findByProductAndMainImg(product.getId(), Boolean.TRUE).iterator());
						dto.setMainImg(Constants.IMAGE_PATH + mainProductImages.get(0).getImgName());
						dto.setDetailsLink(String.valueOf(dto.getId()));
						dtos.add(dto);
					}
				}
			}
		}
		return dtos;
	}

	@Override
	public Map<CategoryDto, List<CatalogProductDto>> getAllCatalogProducts() {
		Map<CategoryDto, List<CatalogProductDto>> catalogProductByCategoryMap = new TreeMap<>();
		Iterable<Category> models = categoryRepository.findByStatus(Boolean.TRUE);
		models.forEach(model -> {
			CategoryDto dto = new CategoryDto();
			dto.setId(model.getId());
			dto.setName(model.getName());
			dto.setDescription(model.getDescription());
			catalogProductByCategoryMap.put(dto, getAllCatalogProductsByCategory(model.getName()));
		});
		return catalogProductByCategoryMap;
	}

	@Override
	public CatalogProductDto getCatalogProductDetailByProduct(String value) {
		CatalogProduct catalogProduct = catalogProductRepository.findByProduct(Long.parseLong(value));
		Optional<Product> optionalProduct = productRepository.findById(Long.parseLong(value));
		Product product = (optionalProduct.isPresent() ? optionalProduct.get() : null);
		CatalogProductDto dto = new CatalogProductDto();
		dto.setId(catalogProduct.getId());
		dto.setTitle(product.getName());
		dto.setCategory(categoryRepository.findById(product.getCategory()).get().getName());
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
