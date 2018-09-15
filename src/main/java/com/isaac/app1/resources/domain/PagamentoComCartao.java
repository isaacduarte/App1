package com.isaac.app1.resources.domain;

import javax.persistence.Entity;

import com.isaac.app1.Enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	private Integer NumerosDeParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer NumerosDeParcelas) {
		super(id, estado, pedido);
		this.NumerosDeParcelas=NumerosDeParcelas;
		
	}

	public Integer getNumerosDeParcelas() {
		return NumerosDeParcelas;
	}

	public void setNumerosDeParcelas(Integer numerosDeParcelas) {
		NumerosDeParcelas = numerosDeParcelas;
	}
	
	
	
}
