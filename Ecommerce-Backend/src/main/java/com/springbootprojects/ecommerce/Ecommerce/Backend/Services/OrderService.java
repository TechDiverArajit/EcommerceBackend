package com.springbootprojects.ecommerce.Ecommerce.Backend.Services;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request.OrderRequest;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.OrderResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.UserEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.OrderEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories.UserRepository;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserRepository customerRepository;
    public OrderResponse getOrderById(Long oId) {
        OrderEntity orderEntity = orderRepository.findById(oId).orElse(null);
        return modelMapper.map(orderEntity, OrderResponse.class);
    }


    public OrderResponse createOrder(OrderRequest orderRequest) {
        OrderEntity orderEntity = modelMapper.map(orderRequest,OrderEntity.class);
        UserEntity customer = customerRepository.findById(orderRequest.getCustomerId()).orElseThrow(()-> new RuntimeException());
        orderEntity.setId(null);
        orderEntity.setCustomer(customer);
        OrderEntity savedEntity = orderRepository.save(orderEntity);
        return modelMapper.map(savedEntity,OrderResponse.class);


    }
}
