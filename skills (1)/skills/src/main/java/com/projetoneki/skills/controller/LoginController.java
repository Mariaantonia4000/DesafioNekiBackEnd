package com.projetoneki.skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  com.projetoneki.skills.DTO.LoginRequestDTO;
import  com.projetoneki.skills.DTO.LoginResponseDTO;
import  com.projetoneki.skills.service.ClientService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private ClientService clientService;
	
		
	@PostMapping
	public LoginResponseDTO login (@RequestBody LoginRequestDTO request) {		
		return clientService.handleLogin(request.getLogin(), request.getPassword());
	}
		
}

