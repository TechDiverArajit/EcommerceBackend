package com.springbootprojects.ecommerce.Ecommerce.Backend.Controllers;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request.CategoryRequest;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request.ProductRequest;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.CategoryResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.ProductResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{cId}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long cId){
        return ResponseEntity.ok(categoryService.getCategoryById(cId));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest){
        CategoryResponse categoryResponse = categoryService.createCategory(categoryRequest);
        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);


    }
}
