package com.projetoneki.skills.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoneki.skills.model.Client;



/*Acessa dados e salva um objeto*/

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	@Transactional
	Client findByLogin(String login);

}