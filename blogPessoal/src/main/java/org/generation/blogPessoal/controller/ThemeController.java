package org.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.Services.ThemeServices;
import org.generation.blogPessoal.model.Theme;
import org.generation.blogPessoal.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping("/theme")
public class ThemeController {
	
	@Autowired 
	private ThemeRepository repository;
	@Autowired
	private ThemeServices services;
	
	@GetMapping
	public ResponseEntity<List<Theme>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Theme> getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				 .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Optional<Theme>> getByName(@PathVariable String name){
		ResponseEntity<Optional<Theme>> Obj = services.getByTheme(name);
		return Obj;
	}
	
	@PostMapping
	public ResponseEntity<Theme> post(@RequestBody Theme theme){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(theme));
	}
	
	@PutMapping
	public ResponseEntity<Theme> put (@RequestBody Theme theme){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(theme));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
