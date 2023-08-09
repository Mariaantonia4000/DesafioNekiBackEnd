package com.projetoneki.skills.DTO;

import com.projetoneki.skills.model.ClientSkill;

public class ClientSkillDTORequest {
	
		private Integer idClient;
		private Integer idSkill;
		private Integer knowledgeLevel;
		
		public ClientSkillDTORequest() {
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
		public ClientSkillDTORequest(ClientSkill clientSkill) {
			super();
			this.idClient = clientSkill.getClient().getId();
			this.idSkill = clientSkill.getSkill().getId();
			this.knowledgeLevel = clientSkill.getKnowledgeLevel();
		}
		
		

	}

