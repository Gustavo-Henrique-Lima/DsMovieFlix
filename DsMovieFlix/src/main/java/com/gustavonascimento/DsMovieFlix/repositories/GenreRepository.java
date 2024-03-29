package com.gustavonascimento.DsMovieFlix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.DsMovieFlix.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}