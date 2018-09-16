package com.isaac.app1.resources.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
	@JsonIgnore
	@OneToMany(mappedBy="id.produto")
	private Set<ItemPedido> itempedido= new HashSet<>();
	
	
 public Produto() {
	 
 }

public Produto(Integer id, String nome, double preco) {
	super();
	Id = id;
	Nome = nome;
	Preco = preco;
}
@JsonIgnore
public List<Pedido> getPedidos(){
	List<Pedido> lista = new ArrayList<>();
	for(ItemPedido x : itempedido) {
		lista.add(x.getpedido());	
	}
	return lista;
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

public Set<ItemPedido> getItempedido() {
	return itempedido;
}

public void setItempedido(Set<ItemPedido> itempedido) {
	this.itempedido = itempedido;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Id == null) ? 0 : Id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Produto other = (Produto) obj;
	if (Id == null) {
		if (other.Id != null)
			return false;
	} else if (!Id.equals(other.Id))
		return false;
	return true;
}
 
 
}
