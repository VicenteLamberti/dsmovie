package com.devsuperior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.dtos.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public Page<MovieDTO> findAll(Pageable pagleable){

		return movieService.findAll(pagleable);
		
	}
	
	@GetMapping(value="/{id}")
	public MovieDTO findAll(@PathVariable Long id){
		return movieService.findById(id);
		
	}
	
	
}
