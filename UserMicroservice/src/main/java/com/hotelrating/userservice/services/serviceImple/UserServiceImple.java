package com.hotelrating.userservice.services.serviceImple;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelrating.userservice.entities.User;
import com.hotelrating.userservice.exception.ResourceNotFoundException;
import com.hotelrating.userservice.repo.UserRepo;
import com.hotelrating.userservice.services.UserService;

@Service
public class UserServiceImple implements UserService{
	
	@Autowired
	private UserRepo userRepo;

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
		return userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server "+userId));
	}

}
