package com.hotelrating.userservice.config.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignClientInterceptor implements RequestInterceptor{

	@Autowired
	private OAuth2AuthorizedClientManager manager;
	
	@Override
	public void apply(RequestTemplate template) {
		String tokenValue = manager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("myinternal-client").principal("internal").build()).getAccessToken().getTokenValue();
		
		template.header("Authorization", "Bearer "+tokenValue);
		
		
	}

}
