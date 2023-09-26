package com.joko.exception;

//Create a Custom Exception
public class CategoryNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CategoryNotFoundException(Long categoryId) {
        super("Category not found with ID: " + categoryId);
    }
}
