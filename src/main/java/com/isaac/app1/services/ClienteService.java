package com.isaac.app1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaac.app1.repository.clienteRepository;
import com.isaac.app1.resources.domain.Cliente;
import com.isaac.app1.services.Exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private  clienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto"
				+ "não encontrado! ID" + id+"Tipo:" + Cliente.class.getName()));
	}

}
