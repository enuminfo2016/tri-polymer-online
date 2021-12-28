package com.enuminfo.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.cloud.data.model.Catalog;
import com.enuminfo.cloud.data.model.CatalogProduct;
import com.enuminfo.cloud.data.model.Category;
import com.enuminfo.cloud.data.model.Country;
import com.enuminfo.cloud.data.model.Location;
import com.enuminfo.cloud.data.model.Product;
import com.enuminfo.cloud.data.model.ProductImage;
import com.enuminfo.cloud.data.repository.ICatalogProductRepository;
import com.enuminfo.cloud.data.repository.ICatalogRepository;
import com.enuminfo.cloud.data.repository.ICategoryRepository;
import com.enuminfo.cloud.data.repository.ICountryRepository;
import com.enuminfo.cloud.data.repository.ILocationRepository;
import com.enuminfo.cloud.data.repository.IProductImageRepository;
import com.enuminfo.cloud.data.repository.IProductRepository;
import com.enuminfo.cloud.data.repository.IUserOrderedItemRepository;
import com.enuminfo.cloud.rest.dto.CatalogProductDto;
import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.rest.dto.LocationDto;
import com.enuminfo.cloud.service.IOnlineService;
import com.enuminfo.cloud.util.Constants;
import com.enuminfo.cloud.util.DateTimeUtil;

@Service
@SuppressWarnings({ "unchecked" })
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
	@Autowired
	IUserOrderedItemRepository userOrderedItemRepository;
	@Autowired
	IProductImageRepository productImageRepository;

	@Override
	public List<String> getAllCountries() {
		List<String> values = new ArrayList<>();
		countryRepository.findByStatus(Boolean.TRUE).forEach(model -> values.add(model.getName()));
		return values;
	}

	@Override
	public List<String> getAllStates(String country) {
		List<String> values = new ArrayList<>();
		Optional<Country> optional = countryRepository.findByName(country);
		if (optional.isPresent()) {
			Country countryModel = optional.get();
			locationRepository.findByCountry(countryModel.getId()).forEach(model -> values.add(model.getName()));
		}
		return values;
	}

	@Override
	public List<String> getAllCities(String state) {
		List<String> values = new ArrayList<>();
		locationRepository.findByState(state).forEach(model -> values.add(model.getName()));
		return values;
	}

	@Override
	public List<LocationDto> getAllLocations(String city) {
		List<LocationDto> locationDtos = new ArrayList<>();
		Iterable<Location> locations = locationRepository.findByCity(city);
		for (Location location : locations) {
			LocationDto locationDto = new LocationDto();
			locationDto.setId(location.getId());
			locationDto.setName(location.getName());
			locationDto.setPin(location.getPin());
			locationDto.setCity(location.getCity());
			locationDto.setState(location.getState());
			Optional<Country> optional = countryRepository.findById(location.getCountry());
			if (optional.isPresent())
				locationDto.setCountry(optional.get().getName());
			locationDtos.add(locationDto);
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
			List<CatalogProduct> catalogProducts = IteratorUtils
					.toList(catalogProductRepository.findByCatalog(catalog.getId()).iterator());
			for (CatalogProduct catalogProduct : catalogProducts) {
				Optional<Product> optionalProduct = productRepository.findById(catalogProduct.getProduct());
				Product product = (optionalProduct.isPresent() ? optionalProduct.get() : null);
				Optional<Category> optionalCategory = categoryRepository.findById(Long.parseLong(value));
				Category category = (optionalCategory.isPresent() ? optionalCategory.get() : null);
				if ((product != null && category != null) && (Long.parseLong(value) == product.getCategory())) {
					CatalogProductDto catalogProductDto = new CatalogProductDto();
					catalogProductDto.setId(catalogProduct.getId());
					catalogProductDto.setTitle(product.getName());
					catalogProductDto.setCategory(optionalCategory.get().getName());
					catalogProductDto.setQuantity(catalogProduct.getQuantity());
					catalogProductDto.setNewPrice(catalogProduct.getPrice());
					catalogProductDto.setOldPrice(catalogProduct.getPrice());
					if (catalogProductDto.getQuantity() != 0)
						catalogProductDto.setSale(Constants.SALE);
					else
						catalogProductDto.setOutOfStock(Constants.OUT_OF_STOCK);
					List<ProductImage> mainProductImages = IteratorUtils.toList(
							productImageRepository.findByProductAndMainImg(product.getId(), Boolean.TRUE).iterator());
					catalogProductDto.setMainImg(Constants.IMAGE_PATH + mainProductImages.get(0).getImgName());
					catalogProductDto.setDetailsLink(String.valueOf(catalogProductDto.getId()));
					catalogProductDtos.add(catalogProductDto);
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
		CatalogProductDto catalogProductDto = new CatalogProductDto();
		catalogProductDto.setId(catalogProduct.getId());
		catalogProductDto.setTitle(product.getName());
		catalogProductDto.setCategory(category != null ? category.getName() : null);
		catalogProductDto.setQuantity(catalogProduct.getQuantity());
		catalogProductDto.setNewPrice(catalogProduct.getPrice());
		catalogProductDto.setOldPrice(catalogProduct.getPrice());
		if (catalogProductDto.getQuantity() != 0)
			catalogProductDto.setSale(Constants.SALE);
		else
			catalogProductDto.setOutOfStock(Constants.OUT_OF_STOCK);
		List<ProductImage> mainProductImages = IteratorUtils
				.toList(productImageRepository.findByProductAndMainImg(product.getId(), Boolean.TRUE).iterator());
		catalogProductDto.setMainImg(Constants.IMAGE_PATH + mainProductImages.get(0).getImgName());
		List<String> images = new ArrayList<>();
		images.add(Constants.IMAGE_PATH + mainProductImages.get(0).getImgName());
		List<ProductImage> remainingProductImages = IteratorUtils
				.toList(productImageRepository.findByProductAndMainImg(product.getId(), Boolean.FALSE).iterator());
		for (ProductImage image : remainingProductImages) {
			images.add(Constants.IMAGE_PATH + image.getImgName());
		}
		catalogProductDto.setImages(images);
		catalogProductDto.setDetailsLink(String.valueOf(catalogProductDto.getId()));
		return catalogProductDto;
	}
}
