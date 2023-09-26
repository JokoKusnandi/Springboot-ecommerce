package com.joko.exception;

//Create a Custom Exception
public class ProductCategoryNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductCategoryNotFoundException(Long productCategoryId) {
        super("Product category not found with ID: " + productCategoryId);
    }
}

