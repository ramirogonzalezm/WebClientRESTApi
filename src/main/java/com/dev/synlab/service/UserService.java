package com.dev.synlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.dev.synlab.model.ResponseBodyRestDTO;

import reactor.core.publisher.Mono;

@Service
public class UserService {
	
	@Autowired
	private WebClient webClient;
	
	@Value("url.mockapi.dev")
	private String addresBaseUrl;
	
	public List<ResponseBodyRestDTO> getUsers() {
		
		List<ResponseBodyRestDTO> responseBodyRestDTOs = webClient.get()
				.uri("https://6787d626c4a42c9161087246.mockapi.io/api/users")
				.retrieve()
				.bodyToMono(List.class)
				.onErrorResume(e -> Mono.empty())
				.block();
		
		return responseBodyRestDTOs;
	}

}
