package com.projetoneki.skills.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetoneki.skills.DTO.ClientSkillDTOPut;
import com.projetoneki.skills.DTO.ClientSkillDTORequest;
import com.projetoneki.skills.DTO.ClientSkillDTOResponse;
import com.projetoneki.skills.model.ClientSkill;
import com.projetoneki.skills.service.ClientSkillService;

@RestController
@RequestMapping(value = "/client-skills")
public class ClientSkillController {

	@Autowired
	private ClientSkillService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClientSkillDTOResponse> find(@PathVariable Integer id) {
		ClientSkill obj = service.find(id);
		return ResponseEntity.ok().body(new ClientSkillDTOResponse(obj));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientSkill>> findAll() {
		List<ClientSkill> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ClientSkillDTORequest objDto) {
		ClientSkill obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
//	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
//	public ResponseEntity<Void> update(@RequestBody ClientSkillDTO obj, @PathVariable Integer id) {
//		obj.setId(id);
//		obj = service.update(obj);
//		return ResponseEntity.noContent().build();		
//	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClientSkillDTOPut objDto, @PathVariable Integer id) {
		ClientSkill obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
