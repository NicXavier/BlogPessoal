package org.generation.blogPessoal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_user")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size (min = 5)
	private String password;
	
	@OneToMany (mappedBy = "name", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties ({"creator"})
	private List<PostagemModel> myposts = new ArrayList<>();

			
	public UserModel(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Size(min = 5) String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserModel(long l, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PostagemModel> getMyposts() {
		return myposts;
	}

	public void setMyposts(List<PostagemModel> myposts) {
		this.myposts = myposts;
	}
	
	
}
