package com.projetoneki.skills.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id; 
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Size(max = 20)
	@NotNull
	private String login;

	@NotEmpty(message="Preenchimento obrigatório")
	@Size(max = 100)
	@NotNull
	@NotBlank
	private String password;
	
	public ClientDTO() {		
	}

	public ClientDTO(Integer id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
