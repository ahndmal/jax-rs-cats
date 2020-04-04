package com.anma.jaxrs.exceptions;

public class CatNotFoundException extends RuntimeException {

    public CatNotFoundException(String message) {
        super(message);
    }
}
