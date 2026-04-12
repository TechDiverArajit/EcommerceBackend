package com.springbootprojects.ecommerce.Ecommerce.Backend.Controllers;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request.ProductRequest;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.ProductResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;



    @GetMapping("/{pId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long pId){
        return ResponseEntity.ok(productService.getProductById(pId));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.createProduct(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }


}























