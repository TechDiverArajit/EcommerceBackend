package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.OrderEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class PaymentRequest {
    private Long orderId;
    private String transactionID;
    private String status;
    private String method;
    private Double amount;

}
