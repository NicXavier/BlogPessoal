package org.generation.blogPessoal.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices{
	
	/**
	 * 
	 
	@Autowired
	private UserRepository repository;
	public Optional<User> cadastrarUsuario(User newUser){
		return repository.findAllByEmail(newUser.getEmail()).map(userExisting) -> {
			return Optional.empty();
			}).orElseGet(() -> {
				return Optional.ofNullable(repository.save(newUser));
			});
	}*/
}