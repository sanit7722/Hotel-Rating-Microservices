package com.hotelrating.hotelservice.exception;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Resource not found on server");
		
	}
	public ResourceNotFoundException(String msg){
		super(msg);
	}

}
