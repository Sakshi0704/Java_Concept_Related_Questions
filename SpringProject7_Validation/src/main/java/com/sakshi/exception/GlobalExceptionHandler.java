package com.sakshi.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	// to handle Specific exception
		@ExceptionHandler(InvalidNumberException.class)
		public ResponseEntity<MyErrorDetails> exceptionHandler(InvalidNumberException ae, WebRequest req){
			
			MyErrorDetails err = new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(ae.getMessage());
			err.setDetails(req.getDescription(false));
			
			
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
		}
		
		
		
		// to handle any generic type of exception
		@ExceptionHandler(Exception.class)
		public ResponseEntity<MyErrorDetails> exceptionHandler2(Exception ae, WebRequest req){
			
			MyErrorDetails err = new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(ae.getMessage());
			err.setDetails(req.getDescription(false));
			
			
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
		}
		
		
		// to handle found exception...
		@ExceptionHandler(NoHandlerFoundException.class)
		public ResponseEntity<MyErrorDetails> exceptionHandler3(NoHandlerFoundException ne, WebRequest req){
			
			MyErrorDetails err = new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(ne.getMessage());
			err.setDetails(req.getDescription(false));
			
			
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
		}
		
		
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<MyErrorDetails> exceptionHandler4(MethodArgumentNotValidException me){
			
			MyErrorDetails err = new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage("Validation Error");
			err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage()); // this way can get first invalid details message...
			
			
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
		}
		
		
	
}
