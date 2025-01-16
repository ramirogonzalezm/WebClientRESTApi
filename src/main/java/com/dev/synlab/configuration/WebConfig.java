package com.dev.synlab.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {
	
	@Value("url.mockapi.dev")
	private String addresBaseUrl;
	
	@Bean
	public WebClient webClient() {
		return WebClient.builder()
				.baseUrl("https://6787d626c4a42c9161087246.mockapi.io")
				.defaultCookie("cookie-name", "cookie-value")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

}
