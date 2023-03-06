package com.lcwd.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException() {
        super("Resource Not Found exceptions..!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
