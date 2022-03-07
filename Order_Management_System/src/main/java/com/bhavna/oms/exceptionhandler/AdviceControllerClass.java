package com.bhavna.oms.exceptionhandler;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceControllerClass {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException){
		return new ResponseEntity<String>(noSuchElementException.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException){
		return new ResponseEntity<String>("please check the details that you are entering are must be presentin db..",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNullPointerException(NullPointerException nullPointerException){
		return new ResponseEntity<String>("All required fields shold be present and it shouldn't null",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyException.class)
	public ResponseEntity<String> handleEmptyException(EmptyException emptyException){
		return new ResponseEntity<String>("quantity should be 1 or greater than 1 only ",HttpStatus.BAD_REQUEST);
	}
	
}
