package org.generation.blogPessoal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity	
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordenceoder()
	{
		return new BCryptPasswordEncoder();
	} 

	@Override
	protected void configure (HttpSecurity http) throws	Exception {
		http
		.authorizeRequests()
		  	.antMatchers(HttpMethod.POST, "/user/save").permitAll()
		  	.antMatchers(HttpMethod.PUT, "/user/credentials").permitAll()
		  	.anyRequest().authenticated()
		  	.and().httpBasic()
		  	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		  	.and().cors()
		  	.and().csrf().disable();
		  	
	}
	
}
