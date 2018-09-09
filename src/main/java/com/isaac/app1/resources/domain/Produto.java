package com.isaac.app1.resources.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	private String Nome;
	private double Preco;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name= "PRODUTO_CATEGORIA", 
	joinColumns= @JoinColumn(name = "produto_id"),
	inverseJoinColumns= @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categoria = new ArrayList<>();
	
	
 public Produto() {
	 
 }

public Produto(Integer id, String nome, double preco) {
	super();
	Id = id;
	Nome = nome;
	Preco = preco;
}

public Integer getId() {
	return Id;
}

public void setId(Integer id) {
	Id = id;
}

public String getNome() {
	return Nome;
}

public void setNome(String nome) {
	Nome = nome;
}

public double getPreco() {
	return Preco;
}

public void setPreco(double preco) {
	Preco = preco;
}

public List<Categoria> getCategoria() {
	return categoria;
}

public void setCategoria(List<Categoria> categoria) {
	this.categoria = categoria;
}
 
 
}
