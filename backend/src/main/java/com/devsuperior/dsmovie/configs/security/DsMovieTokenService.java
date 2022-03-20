package com.devsuperior.dsmovie.configs.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmovie.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class DsMovieTokenService {
	
	@Value("${dsmovie.jwt.expiration}")
	private String expiration;
	
	@Value("${dsmovie.jwt.secret}")
	private String secret;
	
	
	public String buildToken (Authentication authentication) {
		
		User user = (User)authentication.getPrincipal();

		Date today = new Date();
		
		Date dateExpiration = new Date(today.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
				.setIssuer("dsmovie")
				.setSubject(user.getId().toString())
				.setIssuedAt(today)
				.setExpiration(dateExpiration)
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}


	public boolean validateToken(String token) {
		try {
			Jwts.parser()
			.setSigningKey(this.secret)
			.parseClaimsJws(token);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}


	public Long getIdUser(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}
	

}
