package com.hotelrating.hotelservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelrating.hotelservice.entities.Hotel;
import com.hotelrating.hotelservice.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel createHotel = hotelService.createHotel(hotel);
		return new ResponseEntity<Hotel>(createHotel,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String id){
		Hotel hotelById = hotelService.getHotelById(id);
		return new ResponseEntity<Hotel>(hotelById, HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		
		List<Hotel> allHotel = hotelService.getAllHotel();
		return new ResponseEntity<List<Hotel>>(allHotel, HttpStatus.OK);
		
	}
	

}
