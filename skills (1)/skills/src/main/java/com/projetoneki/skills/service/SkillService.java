package com.projetoneki.skills.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoneki.skills.model.Skill;
import com.projetoneki.skills.repositories.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository repo;
	
	public Skill find(Integer id) {
		Optional<Skill> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Skill.class.getName(), null));
		}

	public List<Skill> findAll() {
		return repo.findAll();
	}
	}


