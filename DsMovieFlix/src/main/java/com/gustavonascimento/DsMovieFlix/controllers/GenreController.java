package com.gustavonascimento.DsMovieFlix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.DsMovieFlix.entities.dto.GenreDTO;
import com.gustavonascimento.DsMovieFlix.services.GenreService;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {

	@Autowired
	private GenreService service;
	
	@PreAuthorize("hasAnyRole('VISITOR','MEMBER')")
	@GetMapping
	public ResponseEntity<List<GenreDTO>> findAll(){
		List<GenreDTO> entities = service.findAll();
		return ResponseEntity.ok(entities);
	}
}