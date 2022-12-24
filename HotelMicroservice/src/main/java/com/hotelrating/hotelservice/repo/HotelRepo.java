package com.hotelrating.hotelservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelrating.hotelservice.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{
	

}
