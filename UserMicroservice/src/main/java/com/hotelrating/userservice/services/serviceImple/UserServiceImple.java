package com.hotelrating.userservice.services.serviceImple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotelrating.userservice.entities.Hotel;
import com.hotelrating.userservice.entities.Rating;
import com.hotelrating.userservice.entities.User;
import com.hotelrating.userservice.exception.ResourceNotFoundException;
import com.hotelrating.userservice.external.services.HotelService;
import com.hotelrating.userservice.repo.UserRepo;
import com.hotelrating.userservice.services.UserService;

@Service
public class UserServiceImple implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RestTemplate restTemplate;
	private Logger logger=LoggerFactory.getLogger(UserServiceImple.class);

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		String randmonUserID = UUID.randomUUID().toString();
		user.setUserId(randmonUserID);
		return userRepo.save(user);
		
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server "+userId));
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		//logger.info("{}",ratingsOfUser);
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		List<Rating> list = ratings.stream().map(rating->{
			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(list);
		return user;
	}

}
