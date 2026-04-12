package com.springbootprojects.ecommerce.Ecommerce.Backend.Exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
@Getter
@Setter
@Builder
public class ApiError {
    private String message;
    private HttpStatus status;
    private List<String> errors;
}
