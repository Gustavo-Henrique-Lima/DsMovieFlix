package com.gustavonascimento.DsMovieFlix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.DsMovieFlix.controllers.exceptions.StandardError;
import com.gustavonascimento.DsMovieFlix.entities.dto.MovieDTO;
import com.gustavonascimento.DsMovieFlix.services.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService service;

	@Operation(description = "Find all a page of movies", summary = "Find all movies", responses = {
			@ApiResponse(description = "Ok", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class, type = "Page<MovieDTO>"))),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\n\"message\": \"Unauthorized\"}"))),
			@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\n\"message\": \"Forbidden\"}")))})
	@PreAuthorize("hasAnyRole('VISITOR','MEMBER')")
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findAll(@RequestParam(value = "genreId", defaultValue = "0") Long genreId,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "title") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<MovieDTO> entity = service.findAll(genreId, pageRequest);
		return ResponseEntity.ok(entity);
	}

	@Operation(description = "Find by id", summary = "Return a movie when id exist", responses = {
			@ApiResponse(description = "Ok", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MovieDTO.class))),
			@ApiResponse(
				    description = "Not Found",
				    responseCode = "404",
				    content = @Content(
				        mediaType = "application/json",
				        examples = @ExampleObject(value = "{\n\"timestamp\": \"2022-01-01T12:00:00Z\",\n\"status\": 404,\n\"error\": \"Recurso não encontrado\",\n\"message\": \"Filme não encontrado\",\n\"path\": \"/movies/{id}\"}"
				        ),
				        schema = @Schema(implementation = StandardError.class)
				    )
				),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\n\"message\": \"Unauthorized\"}"))),
			@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\n\"message\": \"Forbidden\"}"))) })
	@PreAuthorize("hasAnyRole('VISITOR','MEMBER')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
		MovieDTO entity = service.findById(id);
		return ResponseEntity.ok(entity);
	}
}