package com.dev.synlab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.synlab.model.ResponseBodyRestDTO;
import com.dev.synlab.model.ResponseDTO;
import com.dev.synlab.service.UserService;


@RestController
@RequestMapping("/api")
public class InvoqueRestApiController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/users", produces = "application/json")
	public ResponseDTO getUsers() {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setCode(1);
		responseDTO.setMessage("Consumo correcto");
		
		return responseDTO;
	}
	
	@GetMapping(value = "/version" , produces = "application/json")
	public ResponseDTO getNumberVersion() {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setCode(1);
		responseDTO.setMessage("1.0.1");
		return responseDTO;
	}
	
	@GetMapping(value = "/allUser" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ResponseBodyRestDTO> getAllUser() {
		return userService.getUsers();
	}
	
	@GetMapping(value = "/userById/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBodyRestDTO getUserById(@PathVariable(required = true) int id) {
		return userService.getUserById(id);
	}

}
