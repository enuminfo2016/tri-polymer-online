package com.enuminfo.cloud.service;

import com.enuminfo.cloud.data.model.*;
import com.enuminfo.cloud.data.repository.*;
import com.enuminfo.cloud.rest.dto.CatalogProductDto;
import com.enuminfo.cloud.rest.dto.LocationDto;
import com.enuminfo.cloud.service.impl.OnlineService;
import com.enuminfo.cloud.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class OnlineServiceTest {
    @InjectMocks
    OnlineService onlineService;
    @Mock
    ICountryRepository countryRepository;
    @Mock
    ILocationRepository locationRepository;
    @Mock
    ICatalogRepository catalogRepository;
    @Mock
    ICategoryRepository categoryRepository;
    @Mock
    IProductRepository productRepository;
    @Mock
    ICatalogProductRepository catalogProductRepository;

    @Test
    public void testForAllCountries() {
        log.info("### OnlineServiceTest.testForAllCountries ... ");
        Iterable<Country> countries = new ArrayList<>();
        Mockito.when(countryRepository.findByStatus(Mockito.anyBoolean())).thenReturn(countries);
        List<String> values = onlineService.getAllCountries();
        Assertions.assertNotNull(values);
    }

    @Test
    public void testForAllStates() {
        log.info("### OnlineServiceTest.testForAllStates ... ");
        List<String> values = onlineService.getAllStates("India");
        Assertions.assertNotNull(values);
    }

    @Test
    public void testForAllCities() {
        log.info("### OnlineServiceTest.testForAllCities ... ");
        List<String> values = onlineService.getAllCities("Karnataka");
        Assertions.assertNotNull(values);
    }

    @Test
    public void testForAllLocations() {
            log.info("### OnlineServiceTest.testForAllLocations ... ");
            Iterable<Location> locations = new ArrayList<>();
            Mockito.when(locationRepository.findByCity(Mockito.anyString())).thenReturn(locations);
            List<LocationDto> values = onlineService.getAllLocations("Bengaluru");
            Assertions.assertNotNull(values);
        }

        @Test
        public void testForProductsByCategory() {
            log.info("### OnlineServiceTest.testForProductsByCategory ... ");
            Optional<Catalog> optionalCatalog = Optional.of(new Catalog());
            Mockito.when(catalogRepository.findByStartDateAndEndDate(Mockito.anyString(), Mockito.anyString())).thenReturn(optionalCatalog);
            List<CatalogProduct> catalogProducts = new ArrayList<>();
            Mockito.when(catalogProductRepository.findByCatalog(Mockito.anyLong())).thenReturn(catalogProducts);
            Optional<Product> optionalProduct = Optional.of(new Product());
            Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(optionalProduct);
            List<CatalogProductDto> catalogProductDtos = onlineService.getProductsByCategory("");
            Assertions.assertNotNull(catalogProductDtos);
    }
}
