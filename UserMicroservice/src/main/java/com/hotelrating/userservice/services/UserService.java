package com.hotelrating.userservice.services;

import java.util.List;

import com.hotelrating.userservice.entities.User;

public interface UserService {

	User saveUser(User user);
	List<User> getAllUser();
	User getUserById(String userId);
	
}
