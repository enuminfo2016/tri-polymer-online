package com.enuminfo.cloud.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.enuminfo.cloud.data.model.Category;
import com.enuminfo.cloud.data.repository.ICategoryRepository;
import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.service.impl.AdminService;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
class AdminServiceTest {
	static IAdminService adminService;
	static ICategoryRepository categoryRepository;

	@BeforeAll
	static void init() {
		adminService = new AdminService();
		categoryRepository = mock(ICategoryRepository.class);
	}
	
	@Test
	void shouldGetAllCategories() {
		when(categoryRepository.findByStatus(Boolean.TRUE)).thenReturn(Flux.just(new Category()));
		Flux<CategoryDto> fluxCategoryDto = adminService.getAllCategories();
		StepVerifier.create(fluxCategoryDto).consumeNextWith(categoryDto -> {
			assertEquals(categoryDto.getId(), 0);
		}).verifyComplete();
	}

	@Test
	void shouldGetAllCategoriesNotFound() {
		when(categoryRepository.findByStatus(Boolean.TRUE)).thenReturn(Flux.empty());
		Flux<CategoryDto> fluxCategoryDto = adminService.getAllCategories();
		StepVerifier.create(fluxCategoryDto).expectErrorMatches(throwable -> throwable instanceof Exception).verify();
	}
}
