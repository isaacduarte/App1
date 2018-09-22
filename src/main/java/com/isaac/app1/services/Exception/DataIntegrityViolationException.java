package com.isaac.app1.services.Exception;

public class DataIntegrityViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public DataIntegrityViolationException(String msg) {
		super(msg);
	}
	public DataIntegrityViolationException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
