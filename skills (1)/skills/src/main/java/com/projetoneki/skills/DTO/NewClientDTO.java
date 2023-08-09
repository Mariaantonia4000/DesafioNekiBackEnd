package com.projetoneki.skills.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	

	@NotEmpty(message="Preenchimento obrigatório")
	@NotNull
	@Size(max = 20)
	private String login;

	@NotEmpty(message="Preenchimento obrigatório")
	@Size(max = 100, min = 1)
	@NotBlank
	private String password;
	
	public NewClientDTO() {		
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

