package com.hotelrating.hotelservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelrating.hotelservice.entities.Staff;

@RestController
@RequestMapping("/staffs")
public class StaffController {
	
	@GetMapping
	public ResponseEntity<List<Staff>> getAllStaff() {
		List<Staff> staffs=new ArrayList<>();
		staffs.add(new Staff("abcd"));
		staffs.add(new Staff("xyz"));
		return ResponseEntity.status(HttpStatus.OK).body(staffs);
		
	}

}
