package com.springbootprojects.ecommerce.Ecommerce.Backend.Services;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request.ProductRequest;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.ProductResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.CategoryEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.ProductEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories.CategoryRepository;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;



    public ProductResponse getProductById(Long pId) {
        ProductEntity productEntity = productRepository.findById(pId).orElse(null);
        return modelMapper.map(productEntity,ProductResponse.class);

    }

    public ProductResponse createProduct(ProductRequest productRequest) {
        ProductEntity productEntity = modelMapper.map(productRequest,ProductEntity.class);
        CategoryEntity category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() -> new RuntimeException());
        productEntity.setId(null);
        productEntity.setCategory(category);
        ProductEntity savedEntity = productRepository.save(productEntity);
        return modelMapper.map(savedEntity,ProductResponse.class);
    }
}
