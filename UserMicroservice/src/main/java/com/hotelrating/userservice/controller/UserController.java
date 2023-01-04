package com.hotelrating.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelrating.userservice.entities.User;
import com.hotelrating.userservice.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User saveUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "RATING-HOTEL-BREAKER", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		User userById = userService.getUserById(userId);
		return new ResponseEntity<User>(userById,HttpStatus.OK);
	}
	
	
	//fallback method for circuit breaker
	
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
		log.info("Fallback is executed bcause service is down",ex.getMessage());
		User user = User.builder()
					.email("dummy@dummy.com")
					.about("dummy user")
					.name("dummy")
					.userId("1234")
					.build();
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	

}
