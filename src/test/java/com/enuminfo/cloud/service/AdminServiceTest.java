package com.enuminfo.cloud.service;

import com.enuminfo.cloud.data.model.Category;
import com.enuminfo.cloud.data.repository.ICategoryRepository;
import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.service.impl.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class AdminServiceTest {
    @InjectMocks AdminService adminService;
    @Mock ICategoryRepository categoryRepository;

    @Test
    void testForAllCategories() {
        log.info("### AdminServiceTest.testForAllCategories ... ");
        Iterable<Category> categories = new ArrayList<>();
        Mockito.when(categoryRepository.findByStatus(Mockito.anyBoolean())).thenReturn(categories);
        List<CategoryDto> categoryDtos = adminService.getAllCategories();
        Assertions.assertNotNull(categoryDtos);
    }
}
