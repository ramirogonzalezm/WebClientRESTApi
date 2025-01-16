package com.dev.synlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.dev.synlab.model.ResponseBodyRestDTO;
import com.dev.synlab.utils.Constants;

import reactor.core.publisher.Mono;

@Service
public class UserService {
	
	@Autowired
	private WebClient webClient;
	
	@Value("url.mockapi.dev")
	private String addresBaseUrl;
	
	public List<ResponseBodyRestDTO> getUsers() {
		
		List<ResponseBodyRestDTO> responseBodyRestDTOs = webClient.get()
				.uri("/users")
				.retrieve()
				.bodyToMono(List.class)
				.onErrorResume(e -> Mono.empty())
				.block();
		
		return responseBodyRestDTOs;
	}
	
	public ResponseBodyRestDTO getUserById(int id) {
		ResponseBodyRestDTO responseBodyRestDTO = webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/api/users/{id}")
						.build(id))
				.retrieve()
				.bodyToMono(ResponseBodyRestDTO.class)
				.block();
		return responseBodyRestDTO;
	}

}
