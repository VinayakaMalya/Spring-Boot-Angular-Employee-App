package com.employee.error;

public class InvalidEmploeeIDFormatException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmploeeIDFormatException(String message, Throwable arg1) {
		super(message, arg1);

	}

	public InvalidEmploeeIDFormatException(String message) {
		super(message);

	}

	public InvalidEmploeeIDFormatException(Throwable message) {
		super(message);

	}
	
}
