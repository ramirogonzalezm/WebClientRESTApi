package com.dev.synlab.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class UserConfig {
	
	@Value("url.mockapi.dev")
	private String addresBaseUrl;
	
	@Bean
	public ModelMapper modelMapperBean() {
		return new ModelMapper();
	}
	
	@Bean
	public WebClient webClient() {
		return WebClient.builder().baseUrl(addresBaseUrl).build();
	}

}
