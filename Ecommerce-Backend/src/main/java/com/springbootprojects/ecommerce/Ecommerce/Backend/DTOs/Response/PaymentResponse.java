package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response;

import lombok.Data;
import org.aspectj.weaver.ast.Or;

@Data
public class PaymentResponse {

    private Long id;
    private OrderResponse order;
    private String transactionID;
    private String status;
    private String method;
    private Double amount;


}
