/**
 * 
 */
package com.springcloud.microservice.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.microservice.data.model.Catalog;
import com.springcloud.microservice.data.model.CatalogProduct;
import com.springcloud.microservice.data.model.Category;
import com.springcloud.microservice.data.model.Country;
import com.springcloud.microservice.data.model.Location;
import com.springcloud.microservice.data.model.Product;
import com.springcloud.microservice.data.model.UserOrderedItem;
import com.springcloud.microservice.data.repository.ICatalogProductRepository;
import com.springcloud.microservice.data.repository.ICatalogRepository;
import com.springcloud.microservice.data.repository.ICategoryRepository;
import com.springcloud.microservice.data.repository.ICountryRepository;
import com.springcloud.microservice.data.repository.ILocationRepository;
import com.springcloud.microservice.data.repository.IProductRepository;
import com.springcloud.microservice.data.repository.IUserOrderedItemRepository;
import com.springcloud.microservice.rest.dto.CatalogProductDto;
import com.springcloud.microservice.rest.dto.CategoryDto;
import com.springcloud.microservice.rest.dto.LocationDto;
import com.springcloud.microservice.service.IOnlineService;
import com.springcloud.microservice.util.DateTimeUtil;

/**
 * @author SIVA KUMAR
 */
@Service
public class OnlineService implements IOnlineService {
	
	@Autowired ICountryRepository countryRepository;	
	@Autowired ILocationRepository locationRepository;
	@Autowired ICategoryRepository categoryRepository;
	@Autowired IProductRepository productRepository;
	@Autowired ICatalogProductRepository catalogProductRepository;
	@Autowired ICatalogRepository catalogRepository;
	@Autowired IUserOrderedItemRepository userOrderedItemRepository;

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
	public List<CatalogProductDto> getAllCatalogProductsByCategory(String categoryName) {
		List<CatalogProductDto> dtos = new ArrayList<>();
		List<Date> dates = DateTimeUtil.getInstance().getFinancialYearStartNEndDates();
		Optional<Catalog> optionalCatalog = catalogRepository.findByDatesBetween(dates.get(0), dates.get(1));
		Catalog catalog = (optionalCatalog.isPresent() ? optionalCatalog.get() : null);
		if (catalog != null) {
			Iterable<CatalogProduct> catalogProducts = catalogProductRepository.findByCatalog(catalog.getId());
			for (Iterator<CatalogProduct> iteratorCatalogProduct = catalogProducts.iterator(); iteratorCatalogProduct.hasNext();) {
				CatalogProduct catalogProduct = iteratorCatalogProduct.next();
				Optional<Product> optionalProduct = productRepository.findById(catalogProduct.getProduct());
				Product product = (optionalProduct.isPresent() ? optionalProduct.get() : null);
				if (product != null) {
					Optional<Category> optionalCategory = categoryRepository.findById(product.getCategory());
					Category category = (optionalCategory.isPresent() ? optionalCategory.get() : null);
					if (category != null && category.getName().equalsIgnoreCase(categoryName)) {
						CatalogProductDto dto = new CatalogProductDto();
						dto.setId(catalogProduct.getId());
						dto.setProduct(product.getName());
						dto.setCategory(category.getName());
						dto.setQuantity(catalogProduct.getQuantity());
						dto.setPrice(catalogProduct.getPrice());
						double selectedProductQuantity = dto.getQuantity();
						Iterable<UserOrderedItem> orderedItems = userOrderedItemRepository.findByProduct(catalogProduct.getProduct());
						for (Iterator<UserOrderedItem> iterator = orderedItems.iterator(); iterator.hasNext();) {
							UserOrderedItem orderedItem = iterator.next();
							selectedProductQuantity = selectedProductQuantity - orderedItem.getQuantity();
						}
						dto.setQuantity(selectedProductQuantity);
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
}