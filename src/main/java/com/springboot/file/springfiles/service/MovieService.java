package com.springboot.file.springfiles.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.file.springfiles.model.Movie;

public interface MovieService {

	List<Movie> findAll();

	boolean saveDataFromUploadfile(MultipartFile file);

	List<Movie> getProdutorMaiorIntervalo();
	
	List<Movie> getProdutorPremioRapido();

}
