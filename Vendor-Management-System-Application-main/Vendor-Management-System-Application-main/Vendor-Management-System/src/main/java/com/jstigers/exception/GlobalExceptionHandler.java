package com.jstigers.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalExceptionHandler {

	

//	Exception Handler for Exception class
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionClassHandler(Exception exception,WebRequest request){
		
		
		ErrorDetails details=new ErrorDetails(exception.getMessage(),request.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 
	   
	
	}
	
	

//	Data validation exception handler
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> exceptionClassHandler(MethodArgumentNotValidException exception,WebRequest request){
		
		
		ErrorDetails details = new ErrorDetails(exception.getBindingResult().getFieldError().getDefaultMessage(),request.getDescription(false),LocalDateTime.now());
	
		  return new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 

	}
	
	


	
//	Exception handler for VendorException
	@ExceptionHandler(VendorException.class)
	public ResponseEntity<ErrorDetails> VendorExceptionClassHandler(VendorException exception,WebRequest request){
		
		
		ErrorDetails details=new ErrorDetails(exception.getMessage(),request.getDescription(false),LocalDateTime.now());
		ResponseEntity<ErrorDetails> entity=new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 
	   
		return entity;
	}	
	

}
