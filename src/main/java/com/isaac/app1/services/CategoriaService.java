package com.isaac.app1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaac.app1.repository.categoriaRepository;
import com.isaac.app1.resources.domain.Categoria;

@Service
public class CategoriaService {
	
	@Autowired
	private  categoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.get();
	}

}
