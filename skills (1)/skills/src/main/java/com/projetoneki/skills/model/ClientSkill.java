package com.projetoneki.skills.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@EnableJpaAuditing 
@Table(name = "CLIENT_SKILL")
public class ClientSkill implements Serializable {;
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client_skill")
	private Integer id;
	

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")	
	private Client client;
	

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "skill_id")
	private Skill skill;

	// Campos adicionais
	@NotBlank(message = "Adicione o nível de conhecimento de 1 a 10")
	@Column(name = "knowledge_level")
	private Integer KnowledgeLevel;
	
	@CreationTimestamp
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	@Column(name = "created_at")
	private LocalDateTime CreatedAt;
	
	@UpdateTimestamp
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	@Column(name = "updated_at")
	private LocalDateTime UpdatedAt;

	public ClientSkill() {
	}

	public ClientSkill(Integer id, Client client, Skill skill, Integer knowledgeLevel) {
		super();
		this.id = id;
		this.client = client;
		this.skill = skill;
		KnowledgeLevel = knowledgeLevel;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Integer getKnowledgeLevel() {
		return KnowledgeLevel;
	}

	public void setKnowledgeLevel(Integer knowledgeLevel) {
		KnowledgeLevel = knowledgeLevel;
	}

	public LocalDateTime getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		CreatedAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return UpdatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		UpdatedAt = updatedAt;
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
		ClientSkill other = (ClientSkill) obj;
		return Objects.equals(id, other.id);
	}

}


