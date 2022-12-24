package com.hotelrating.hotelservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> resourceNotFoundHandler(ResourceNotFoundException ex){
		Map< String, Object> map=new HashMap<>();
		
		map.put("message",ex.getMessage() );
		map.put("status", HttpStatus.NOT_FOUND);
		map.put("isSuccess", false);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

}
