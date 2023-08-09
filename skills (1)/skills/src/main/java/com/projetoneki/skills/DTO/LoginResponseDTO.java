package com.projetoneki.skills.DTO;

import com.projetoneki.skills.model.Client;

public class LoginResponseDTO {

	private String token;

	private Client client;

	public LoginResponseDTO(String token, Client client) {
		super();
		this.token = token;
		this.client = client;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

}

