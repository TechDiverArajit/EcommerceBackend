package com.springbootprojects.ecommerce.Ecommerce.Backend.Services;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request.CategoryRequest;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.CategoryResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.ProductResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.CategoryEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.ProductEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryResponse getCategoryById(Long cId) {
        CategoryEntity category = categoryRepository.findById(cId).orElse(null);
        return modelMapper.map(category,CategoryResponse.class);
    }

    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        CategoryEntity category = modelMapper.map(categoryRequest,CategoryEntity.class);
        CategoryEntity savedEntity = categoryRepository.save(category);
        return modelMapper.map(savedEntity, CategoryResponse.class);
    }
}
