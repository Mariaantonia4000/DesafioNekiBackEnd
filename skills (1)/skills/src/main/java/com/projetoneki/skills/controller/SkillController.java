package com.projetoneki.skills.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetoneki.skills.model.Skill;
import com.projetoneki.skills.service.SkillService;

@RestController
@RequestMapping(value="/skills")
public class SkillController {
	
	@Autowired
	private SkillService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Skill> find(@PathVariable Integer id) {
		Skill obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Skill>> findAll() {
		List<Skill> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
