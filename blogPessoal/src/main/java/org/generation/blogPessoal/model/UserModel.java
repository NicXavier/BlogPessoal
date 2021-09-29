package org.generation.blogPessoal.model;

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
	
	private String photo;
	
	private String type;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("user")
	private List<PostModel> postagem;
				
	public UserModel(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Size(min = 5) String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserModel() {
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<PostModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostModel> postagem) {
		this.postagem = postagem;
	}

	
	
}
