package com.example.DemoRestServices.DemoRestServices.Error;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Could Not Find employee "+ id);
    }
}
