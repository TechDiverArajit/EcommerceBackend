package com.springbootprojects.ecommerce.Ecommerce.Backend.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
