package com.isaac.app1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isaac.app1.resources.domain.Cliente;

@Repository
public interface clienteRepository extends JpaRepository<Cliente, Integer> {

	
	

}
