package com.gustavonascimento.DsMovieFlix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.DsMovieFlix.entities.Genre;
import com.gustavonascimento.DsMovieFlix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query("SELECT DISTINCT obj FROM Movie obj "
	        + "INNER JOIN obj.genre gen "
	        + "WHERE (:genres IS NULL OR gen IN (:genres))")
	Page<Movie> find(List<Genre> genres, Pageable pageable);
	
	@Query("SELECT obj FROM Movie obj "
	        + "INNER JOIN FETCH obj.genre gen "
	        + "WHERE obj IN :movies")
	List<Movie> findMoviesWithGenre(List<Movie> movies);
}