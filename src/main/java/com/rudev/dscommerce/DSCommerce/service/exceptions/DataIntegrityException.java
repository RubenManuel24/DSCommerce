package com.rudev.dscommerce.DSCommerce.service.exceptions;

public class DataIntegrityException extends  RuntimeException{

    public DataIntegrityException(String message){
        
        super(message);
    }
}
