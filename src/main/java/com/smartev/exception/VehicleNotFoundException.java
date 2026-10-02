package com.smartev.exception;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String message) {
        super(message);
    }
}
