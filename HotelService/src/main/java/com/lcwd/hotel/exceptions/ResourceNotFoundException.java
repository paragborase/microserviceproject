package com.lcwd.hotel.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String a){
        super(a);
    }

    public ResourceNotFoundException(){
        super("Resource Not Found..");
    }

}
