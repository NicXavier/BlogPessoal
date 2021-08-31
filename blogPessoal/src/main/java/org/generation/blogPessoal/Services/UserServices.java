package org.generation.blogPessoal.Services;

import java.util.Optional;

import org.generation.blogPessoal.model.UserModel;
import org.generation.blogPessoal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices{
	
	@Autowired
	private UserRepository repository;
	
	public Optional<Object> registerUser(UserModel newUser){
		return repository.findByEmail(newUser.getEmail()).map(userExisting -> {
			return Optional.empty();
			}).orElseGet(() -> {
				return Optional.ofNullable(repository.save(newUser));
			});
	}
}