package com.isaac.app1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.isaac.app1.repository.categoriaRepository;
import com.isaac.app1.resources.domain.Categoria;
import com.isaac.app1.services.Exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private  categoriaRepository repo;
	
	public Categoria Find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto"
				+ "não encontrado! ID" + id+"Tipo:" + Categoria.class.getName()));
	}
	public Categoria Insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria Update(Categoria obj) {
		Find(obj.getId());
		return repo.save(obj);
		
	}
	public void Delete(Integer id) {
		Find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			
			throw new com.isaac.app1.services.Exception.DataIntegrityViolationException("Não é possivel excluir uma categoria que tem produtos");
		}
		
		
	}
}
