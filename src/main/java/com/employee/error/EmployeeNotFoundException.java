package com.employee.error;

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message, Throwable arg1) {
		super(message, arg1);

	}

	public EmployeeNotFoundException(String message) {
		super(message);

	}

	public EmployeeNotFoundException(Throwable message) {
		super(message);

	}

}
