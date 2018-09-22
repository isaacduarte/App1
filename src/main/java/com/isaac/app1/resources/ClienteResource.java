package com.isaac.app1.resources;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.isaac.app1.resources.domain.Cliente;
import com.isaac.app1.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Cliente obj = service.Find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> Insert(@RequestBody Cliente obj){
		obj = service.Insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	} 
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> Upadate(@RequestBody Cliente obj, @PathVariable Integer id){
		obj.setId(id);
		obj= service.Update(obj);
		return ResponseEntity.noContent().build();	
		
	}
	
}
