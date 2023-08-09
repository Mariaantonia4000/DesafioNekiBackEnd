package com.projetoneki.skills.DTO;

import com.projetoneki.skills.model.ClientSkill;

public class ClientSkillDTOResponse {
	
	private Integer id;
	private Integer idClient;
	private Integer idSkill;
	private Integer knowledgeLevel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdClient() {
		return idClient;
	}
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
	public Integer getIdSkill() {
		return idSkill;
	}
	public void setIdSkill(Integer idSkill) {
		this.idSkill = idSkill;
	}
	public Integer getKnowledgeLevel() {
		return knowledgeLevel;
	}
	public void setKnowledgeLevel(Integer knowledgeLevel) {
		this.knowledgeLevel = knowledgeLevel;
	}
	public ClientSkillDTOResponse(ClientSkill clientSkill) {
		super();
		this.id = clientSkill.getId();
		this.idClient = clientSkill.getClient().getId();
		this.idSkill = clientSkill.getSkill().getId();
		this.knowledgeLevel = clientSkill.getKnowledgeLevel();
	}
	
	

}

