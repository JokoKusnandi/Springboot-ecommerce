package com.joko.exception;

//Create a Custom Exception
public class CustomerNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(Long customerId) {
        super("Customer not found with ID: " + customerId);
    }
}

