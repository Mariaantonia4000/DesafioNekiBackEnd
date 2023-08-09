package com.projetoneki.skills.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projetoneki.skills.model.enums.Profile;

@Entity
@Table(name = "CLIENT")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", nullable = false)
	private Integer id;

	@NotBlank(message = "O login do usuário não pode ser vazio")
	@Size(max = 20)
	@Column(name = "client_login")
	private String login;

	@NotBlank(message = "A senha do usuário não pode ser vazia")
	@Size(max = 100)
	@Column(name = "client_password", nullable = false)
	@JsonIgnore
	private String password;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PROFILE")
	private Set<Integer> profiles = new HashSet<>();
	
	

	@Column(name = "client_last_login_date")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date lastLoginDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("client")
	private Set<ClientSkill> clientSkill;

	public Client() {
		addProfile(Profile.USER);
	}

	
	public Client(Integer id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		addProfile(Profile.USER);
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
	
	public Set<Profile> getProfile(){
		return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addProfile(Profile profile) {
		profiles.add(profile.getCod());
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Set<ClientSkill> getClientSkill() {
		return clientSkill;
	}

	public void setClientSkill(Set<ClientSkill> clientSkill) {
		this.clientSkill = clientSkill;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}

}

