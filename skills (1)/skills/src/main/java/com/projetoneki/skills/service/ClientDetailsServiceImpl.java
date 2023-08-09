package com.projetoneki.skills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projetoneki.skills.model.Client;
import com.projetoneki.skills.repositories.ClientRepository;
import com.projetoneki.skills.security.ClientSpringSecurity;

@Service
public class ClientDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private ClientRepository repo;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Client client = repo.findByLogin(login);
		if (client == null) {
			throw new UsernameNotFoundException(login);
		}
		
		return new ClientSpringSecurity(client.getId(), client.getLogin(), client.getPassword(), client.getProfile());
	}

}

