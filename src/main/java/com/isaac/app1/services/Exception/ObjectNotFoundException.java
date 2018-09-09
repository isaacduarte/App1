package com.isaac.app1.services.Exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
