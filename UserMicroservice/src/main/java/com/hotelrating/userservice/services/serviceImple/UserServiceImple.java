package com.hotelrating.userservice.services.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.LogFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotelrating.userservice.entities.Rating;
import com.hotelrating.userservice.entities.User;
import com.hotelrating.userservice.exception.ResourceNotFoundException;
import com.hotelrating.userservice.repo.UserRepo;
import com.hotelrating.userservice.services.UserService;

@Service
public class UserServiceImple implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
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
		ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
		logger.info("{}",ratingsOfUser);
		user.setRatings(ratingsOfUser);
		return user;
	}

}
