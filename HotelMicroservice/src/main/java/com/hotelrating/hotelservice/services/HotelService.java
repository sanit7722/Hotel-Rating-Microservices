package com.hotelrating.hotelservice.services;

import java.util.List;

import com.hotelrating.hotelservice.entities.Hotel;

public interface HotelService {
	
	public Hotel createHotel(Hotel hotel);
	
	public Hotel getHotelById(String id);
	
	public List<Hotel> getAllHotel();

}
