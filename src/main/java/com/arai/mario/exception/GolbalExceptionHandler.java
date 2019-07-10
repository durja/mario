package com.arai.mario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GolbalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<DTOErrorResponse> handleFieldValidationException(DTOValidationException ex) {
		DTOErrorResponse response = new DTOErrorResponse(ex, HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleSQLExceotions(org.hibernate.exception.ConstraintViolationException ex) {
		CustomErrorResponse response = new CustomErrorResponse(ex, HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleAllOtherExceptions(Exception ex) {
		CustomErrorResponse response = new CustomErrorResponse(ex, HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
}
