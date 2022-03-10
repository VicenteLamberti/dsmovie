package com.devsuperior.dsmovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dtos.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> movies = movieRepository.findAll(pageable);
		
		Page<MovieDTO> page = movies.map(x -> new MovieDTO(x));
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id ) {
		Movie movie = movieRepository.findById(id).get();
		return new MovieDTO(movie);
	}
}
