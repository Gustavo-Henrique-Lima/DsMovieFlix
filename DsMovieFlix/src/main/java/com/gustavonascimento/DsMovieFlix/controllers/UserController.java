package com.gustavonascimento.DsMovieFlix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.DsMovieFlix.entities.dto.UserDTO;
import com.gustavonascimento.DsMovieFlix.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;

	@PreAuthorize("hasAnyRole('VISITOR','MEMBER')")
	@GetMapping("/profile")
	public ResponseEntity<UserDTO> findCurrentUser() {
		UserDTO entity = service.findCurrentUser();
		return ResponseEntity.ok(entity);
	}
}