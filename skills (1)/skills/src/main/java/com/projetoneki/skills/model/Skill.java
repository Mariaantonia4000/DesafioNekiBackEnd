package com.projetoneki.skills.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "SKILL")
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private Integer id;
	
	
	@Column(name = "skill_name")
	private String name;
	
	
	@Column(name = "skilll_version")
	private String version;
	
	
	@Column(name = "skill_description")
	private String description;
	
	
	@Column(name = "skill_image")
	private String imageUrl;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "skill", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("clientSkill")
	private Set<ClientSkill> clientSkill;

	public Skill() {

	}

	public Skill(Integer id, String name, String version, String description, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
		Skill other = (Skill) obj;
		return Objects.equals(id, other.id);
	}

}


