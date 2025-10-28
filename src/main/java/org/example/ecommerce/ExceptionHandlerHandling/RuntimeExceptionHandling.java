package org.example.ecommerce.ExceptionHandlerHandling;

public class RuntimeExceptionHandling  extends RuntimeException {
    public RuntimeExceptionHandling(Long id) {
        super("Product not found with id: " + id);
    }

}
