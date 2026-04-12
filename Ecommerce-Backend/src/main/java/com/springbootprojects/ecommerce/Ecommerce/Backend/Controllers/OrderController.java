package com.springbootprojects.ecommerce.Ecommerce.Backend.Controllers;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request.OrderRequest;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request.ProductRequest;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.OrderResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.ProductResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Services.OrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @GetMapping("/{oId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long oId){
        return ResponseEntity.ok(orderService.getOrderById(oId));
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse = orderService.createOrder(orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }
}
