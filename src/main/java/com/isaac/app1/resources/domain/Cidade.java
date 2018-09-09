package com.isaac.app1.resources.domain;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;


	private String Nome;


	@ManyToOne
	@JoinColumn(name="estado_id")
	private Estado Estado;

public Cidade() {
	
}

public Cidade(Integer id, String nome, Estado estado) {
	super();
	this.Id = id;
	this.Nome = nome;
	this.Estado = estado;
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


public Estado getEstado() {
	return Estado;
}

public void setEstado(Estado estado) {
	Estado = estado;
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
	Cidade other = (Cidade) obj;
	if (Id == null) {
		if (other.Id != null)
			return false;
	} else if (!Id.equals(other.Id))
		return false;
	return true;
}
 

}
