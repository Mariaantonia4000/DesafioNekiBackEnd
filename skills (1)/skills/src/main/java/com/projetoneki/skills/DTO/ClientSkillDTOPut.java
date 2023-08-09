package com.projetoneki.skills.DTO;

import java.io.Serializable;

import com.projetoneki.skills.model.ClientSkill;

public class ClientSkillDTOPut implements Serializable {	
		private static final long serialVersionUID = 1L;

		private Integer id;
		private Integer knowledgeLevel;
	
		
		public ClientSkillDTOPut() {
		}
		
		public ClientSkillDTOPut(ClientSkill obj) {
			id = obj.getId();
			knowledgeLevel = obj.getKnowledgeLevel();
			
			
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}


		public Integer getKnowledgeLevel() {
			return knowledgeLevel;
		}

		public void setKnowledgeLevel(Integer knowledgeLevel) {
			this.knowledgeLevel = knowledgeLevel;
		}
		
		
	}


