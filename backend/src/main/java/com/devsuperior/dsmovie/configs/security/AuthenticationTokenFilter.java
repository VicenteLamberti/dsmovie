package com.devsuperior.dsmovie.configs.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.UserRepository;

public class AuthenticationTokenFilter extends OncePerRequestFilter{
	
	private DsMovieTokenService dsMovieTokenService;
	
	
	private UserRepository userRepository;
	
	public AuthenticationTokenFilter(DsMovieTokenService dsMovieTokenService, UserRepository userRepository) {
		this.dsMovieTokenService = dsMovieTokenService;
		this.userRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = getToken(request);
		
		boolean tokenIsValid = dsMovieTokenService.validateToken(token);
		if(tokenIsValid){
			authUser(token);
		}
		filterChain.doFilter(request, response);
		
		
	}

	private String getToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");

		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7,token.length());
	}
	
	private void authUser(String token) {
		Long idUser = dsMovieTokenService.getIdUser(token);
		User user = userRepository.findById(idUser).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}
