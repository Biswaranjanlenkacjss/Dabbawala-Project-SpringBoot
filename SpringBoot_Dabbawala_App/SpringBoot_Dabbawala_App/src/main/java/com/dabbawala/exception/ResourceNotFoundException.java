package com.dabbawala.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String str) {
         super(str);
    }

    public ResourceNotFoundException() {
        super("Resource Not Found!!.");
    }
}
