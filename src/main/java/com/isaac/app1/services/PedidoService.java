package com.isaac.app1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaac.app1.repository.PedidoRepository;
import com.isaac.app1.resources.domain.Pedido;
import com.isaac.app1.services.Exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private  PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto"
				+ "não encontrado! ID" + id+"Tipo:" + Pedido.class.getName()));
	}

}
