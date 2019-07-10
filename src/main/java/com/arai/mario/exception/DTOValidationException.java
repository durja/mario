package com.arai.mario.exception;

public class DTOValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DTOValidationException(String message) {
        super(message);
    }
}
