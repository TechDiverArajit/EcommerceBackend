package com.springbootprojects.ecommerce.Ecommerce.Backend.Services;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.ProductDTO;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.ProductEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    public ProductDTO getProductById(Long pId) {
        ProductEntity productEntity = productRepository.findById(pId).orElse(null);
        return modelMapper.map(productEntity,ProductDTO.class);

    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = modelMapper.map(productDTO,ProductEntity.class);
        ProductEntity savedEntity = productRepository.save(productEntity);
        return modelMapper.map(productEntity,ProductDTO.class);
    }
}
