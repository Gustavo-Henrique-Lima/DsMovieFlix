package com.gustavonascimento.DsMovieFlix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.DsMovieFlix.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

}