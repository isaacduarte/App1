package com.isaac.app1.resources.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.isaac.app1.Enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{
	
	private static final long serialVersionUID = 1L;
	
	private Date DataVencimento;
	private Date DataPagamento;
	
	public PagamentoComBoleto () {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date DataVencimento, Date DataPagamento) {
		super(id, estado, pedido);
		this.DataPagamento=DataPagamento;
		this.DataVencimento=DataVencimento;

	}

	public Date getDataVencimento() {
		return DataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		DataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return DataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		DataPagamento = dataPagamento;
	}
	
	
	
}
