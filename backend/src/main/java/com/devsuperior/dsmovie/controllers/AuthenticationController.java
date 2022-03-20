package com.devsuperior.dsmovie.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.configs.security.DsMovieTokenService;
import com.devsuperior.dsmovie.dtos.TokenDTO;
import com.devsuperior.dsmovie.forms.LoginForm;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private DsMovieTokenService dsMovieTokenService;
	
	
	@PostMapping
	public ResponseEntity<TokenDTO> auth(@RequestBody @Valid LoginForm loginForm){

		UsernamePasswordAuthenticationToken loginData = loginForm.loginFormToUsernamePasswordAuthenticationToken();
		try {
			Authentication authentication = authenticationManager.authenticate(loginData);
			String token = dsMovieTokenService.buildToken(authentication);
			return ResponseEntity.ok(new TokenDTO(token,"Bearer"));
		}
		catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
}
