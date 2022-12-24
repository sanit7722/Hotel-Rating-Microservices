package com.hotelrating.ratingservice.services.imple;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelrating.ratingservice.entities.Rating;
import com.hotelrating.ratingservice.repo.RatingRepo;
import com.hotelrating.ratingservice.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingRepo repo;

	@Override
	public Rating cretaeRating(Rating rating) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString();
		rating.setRatingId(id);
		return repo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Rating> getAllRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return repo.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return repo.findByHotelId(hotelId);
	}

}
