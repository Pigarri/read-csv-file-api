package com.springboot.file.springfiles.service;

import java.io.InputStreamReader;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.springboot.file.springfiles.model.Movie;
import com.springboot.file.springfiles.repository.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository springReadFileRepository;

	@Override
	public List<Movie> findAll() {
		return (List<Movie>) springReadFileRepository.findAll();

	}

	@Override
	public boolean saveDataFromUploadfile(MultipartFile file) {
		boolean isFlag = false;
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());

		if(extension.equalsIgnoreCase("csv")) {
			isFlag = readDataFromCsv(file);
		}

		return false;
	}
	
	// for CSV file
	private boolean readDataFromCsv(MultipartFile file) {
		try {
			InputStreamReader reader = new InputStreamReader(file.getInputStream());
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
			List<String[]> rows = csvReader.readAll();
			for (String[] row : rows) {
				springReadFileRepository.save(new Movie(row[0], row[1], row[2], row[3],row[4],FilenameUtils.getExtension(file.getOriginalFilename())));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
		
		//Produtor com maior intervalo entre dois prêmios consecutivos
		public List<Movie> getProdutorMaiorIntervalo(){
			var resultado = springReadFileRepository.getProdutorMaiorIntervalo();
			return resultado;
		}
		
		//Produtor que obteve dois prêmios mais rápido
		public List<Movie> getProdutorPremioRapido(){
			var resultado = springReadFileRepository.getProdutorPremioRapido();
			return resultado;
				}
}
