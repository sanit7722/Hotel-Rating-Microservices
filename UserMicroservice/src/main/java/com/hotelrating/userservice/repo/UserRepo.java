package com.hotelrating.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelrating.userservice.entities.User;

public interface UserRepo extends JpaRepository<User, String>{

}
