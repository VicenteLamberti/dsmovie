package com.devsuperior.dsmovie.dtos;

public class TokenDTO {
	
	private String token;
	private String type;
	
	public TokenDTO() {
		
	}
	
	

	public TokenDTO(String token, String type) {
		this.token = token;
		this.type = type;
	}



	public String getToken() {
		return token;
	}

	public String getType() {
		return type;
	}


	
	

}
