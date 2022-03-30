package com.springboot.file.springfiles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.file.springfiles.model.Movie;
import com.springboot.file.springfiles.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired 
	private MovieService springReadFileService;
	
	@GetMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("movie", new Movie());
		List<Movie> movies = springReadFileService.findAll();
		model.addAttribute("movies", movies);
		
		return "view/movies";
	}
	
	@PostMapping(value = "/fileupload")
	public String uploadFile(@ModelAttribute Movie movie, RedirectAttributes redirectAttributes ) {
		boolean isFlag = springReadFileService.saveDataFromUploadfile(movie.getFile());
		if(isFlag) {
			redirectAttributes.addFlashAttribute("sucessmessage","File upload Successfuly!");
		}else {
			redirectAttributes.addFlashAttribute("errormessage","File upload not done, please try again!");
		}
		return "redirect:/";
	}
		
	@GetMapping(value = "/produtorMaiorIntervalo")
	public String getProdutorMaiorIntervalo(Model model) {
		model.addAttribute("movie", new Movie());
		List<Movie> movies = springReadFileService.getProdutorMaiorIntervalo();
		model.addAttribute("movies", movies);
		
		return "view/movies";
	}
	
	@GetMapping(value = "/produtorObteveDoisPremiosRapido")
	public String getProdutorPremioRapido(Model model) {
		model.addAttribute("movie", new Movie());
		List<Movie> movies = springReadFileService.getProdutorPremioRapido();
		model.addAttribute("movies", movies);
		
		return "view/movies";
	}

}
