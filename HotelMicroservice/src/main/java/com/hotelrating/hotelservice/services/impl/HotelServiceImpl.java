package com.hotelrating.hotelservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelrating.hotelservice.entities.Hotel;
import com.hotelrating.hotelservice.exception.ResourceNotFoundException;
import com.hotelrating.hotelservice.repo.HotelRepo;
import com.hotelrating.hotelservice.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {

		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return hotelRepo.save(hotel);
	}

	@Override
	public Hotel getHotelById(String id) {
		
		return hotelRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with given id not found "+id));
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepo.findAll();
		
	}

}
