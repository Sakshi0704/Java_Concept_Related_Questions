package com.masai.exception;

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

	// to handle any generic type of exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler1(Exception ae, WebRequest req){
		
		ErrorDetails err = new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	// to handle found exception...
		@ExceptionHandler(NoHandlerFoundException.class)
		public ResponseEntity<ErrorDetails> exceptionHandler2(NoHandlerFoundException ne, WebRequest req){
			
			ErrorDetails err = new ErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(ne.getMessage());
			err.setDetails(req.getDescription(false));
			
			
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
		}
		
		
	// to handle argument valid exception...
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<ErrorDetails> exceptionHandler4(MethodArgumentNotValidException e, WebRequest w){
			
			ErrorDetails err = new ErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(e.getMessage());
			err.setDetails(w.getDescription(false));
			
			return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		}
		
		
		// user defined exception....
		// to handle if the employee is exist in database...
				@ExceptionHandler(EmployeeNotFoundException.class)
				public ResponseEntity<ErrorDetails> exceptionHandler5(EmployeeNotFoundException ef, WebRequest w){
					
					ErrorDetails err = new ErrorDetails();
					err.setTimestamp(LocalDateTime.now());
					err.setMessage(ef.getMessage());
					err.setDetails(w.getDescription(false));
					
					return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
				}
   
	
	
}
