package com.hotelrating.ratingservice.services;

import java.util.List;

import com.hotelrating.ratingservice.entities.Rating;

public interface RatingService {

	//create
	Rating cretaeRating(Rating rating);
	
	//get all rating
	List<Rating> getAllRatings();
	
	
	//get all by UserId
	List<Rating> getAllRatingByUserId(String userId);
	
	
	//get all by hotelId
	List<Rating> getAllRatingByHotelId(String hotelId);
}
