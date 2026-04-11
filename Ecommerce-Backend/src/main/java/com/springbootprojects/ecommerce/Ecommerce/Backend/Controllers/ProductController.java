package com.springbootprojects.ecommerce.Ecommerce.Backend.Controllers;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.ProductDTO;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{pId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long pId){
        return ResponseEntity.ok(productService.getProductById(pId));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO productDTO1 = productService.createProduct(productDTO);
        return new ResponseEntity<>(productDTO1, HttpStatus.CREATED);
    }
}























