package com.enuminfo.cloud.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.enuminfo.cloud.data.model.Country;
import com.enuminfo.cloud.data.model.Location;
import com.enuminfo.cloud.data.repository.ICatalogProductRepository;
import com.enuminfo.cloud.data.repository.ICatalogRepository;
import com.enuminfo.cloud.data.repository.ICategoryRepository;
import com.enuminfo.cloud.data.repository.ICountryRepository;
import com.enuminfo.cloud.data.repository.ILocationRepository;
import com.enuminfo.cloud.data.repository.IProductRepository;
import com.enuminfo.cloud.rest.dto.LocationDto;
import com.enuminfo.cloud.service.impl.OnlineService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class OnlineServiceTest {
	@InjectMocks OnlineService onlineService;
	@Mock ICountryRepository countryRepository;
	@Mock ILocationRepository locationRepository;
	@Mock ICatalogRepository catalogRepository;
	@Mock ICategoryRepository categoryRepository;
	@Mock IProductRepository productRepository;
	@Mock ICatalogProductRepository catalogProductRepository;

	@Test
	void testForAllCountries() {
		log.info("### OnlineServiceTest.testForAllCountries ... ");
		Iterable<Country> countries = new ArrayList<>();
		Mockito.when(countryRepository.findByStatus(Mockito.anyBoolean())).thenReturn(countries);
		List<String> values = onlineService.getAllCountries();
		Assertions.assertNotNull(values);
	}

	@Test
	void testForAllStates() {
		log.info("### OnlineServiceTest.testForAllStates ... ");
		List<String> values = onlineService.getAllStates("India");
		Assertions.assertNotNull(values);
	}

	@Test
	void testForAllCities() {
		log.info("### OnlineServiceTest.testForAllCities ... ");
		List<String> values = onlineService.getAllCities("Karnataka");
		Assertions.assertNotNull(values);
	}

	@Test
	void testForAllLocations() {
		log.info("### OnlineServiceTest.testForAllLocations ... ");
		Iterable<Location> locations = new ArrayList<>();
		Mockito.when(locationRepository.findByCity(Mockito.anyString())).thenReturn(locations);
		List<LocationDto> values = onlineService.getAllLocations("Bengaluru");
		Assertions.assertNotNull(values);
	}
}
