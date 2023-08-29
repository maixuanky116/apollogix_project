package com.ecommerce.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AddressException.class)
	public ResponseEntity<MyErrorDetails> AddressExceptionHandler(AddressException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyErrorDetails> CartExceptionHandler(CartException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> CustomerExceptionHandler(CustomerException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorDetails> OrderExceptionHandler(OrderException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> ProductExceptionHandler(ProductException me, WebRequest re) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
}
