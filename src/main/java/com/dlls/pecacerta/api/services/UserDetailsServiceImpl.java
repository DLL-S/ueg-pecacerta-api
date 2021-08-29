package com.dlls.pecacerta.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlls.pecacerta.api.model.Funcionario;
import com.dlls.pecacerta.api.model.UserDetailsImpl;
import com.dlls.pecacerta.api.repositories.FuncionarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	FuncionarioRepository repository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Funcionario funcionario = repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));

		return UserDetailsImpl.build(funcionario);
	}

}