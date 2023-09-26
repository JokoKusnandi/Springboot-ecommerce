package com.joko.exception;

//Create a Custom Exception
public class OrderItemNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderItemNotFoundException(Long orderItemId) {
        super("Order item not found with ID: " + orderItemId);
    }
}

