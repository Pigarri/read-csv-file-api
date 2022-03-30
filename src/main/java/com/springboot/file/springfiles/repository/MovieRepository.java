package com.springboot.file.springfiles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.file.springfiles.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
	@Query(nativeQuery = true, value = "select * from movie m "
										+ "where m.producers = "
										+ "select producers   from ( "
										+ "select max(resultado), producers  from ( "
										+ "select ROUNDMAGIC(max(m.year)) - ROUNDMAGIC(min(m.year)) resultado, m.producers from movie m "
										+ "where m.winner = 'yes' "
										+ "group by m.producers)d "
										+ "where resultado > 0 "
										+ "and rownum <=1) dados")
	public List<Movie> getProdutorMaiorIntervalo();
	
	@Query(nativeQuery = true, value = "select * from movie m "
										+ "where m.producers = "
										+ "select producers   from ( "
										+ "select min(resultado), producers  from ( "
										+ "select ROUNDMAGIC(max(m.year)) - ROUNDMAGIC(min(m.year)) resultado, m.producers from movie m "
										+ "where m.winner = 'yes' "
										+ "group by m.producers)d "
										+ "where resultado > 0 "
										+ "and rownum <=1) dados")
	public List<Movie> getProdutorPremioRapido();
}
