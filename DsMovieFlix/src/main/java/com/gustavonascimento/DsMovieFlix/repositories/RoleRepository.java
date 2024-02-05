package com.gustavonascimento.DsMovieFlix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.DsMovieFlix.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}