package com.hotelrating.apigateway.model;

import java.util.Collection;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {

	private String userId;
	private String accessToken;
	private String refreshToken;
	private Long exoireAt;
	private Collection<String> authorities;
	
}
