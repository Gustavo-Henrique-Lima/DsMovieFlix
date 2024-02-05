package com.gustavonascimento.DsMovieFlix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.DsMovieFlix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}