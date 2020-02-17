package org.casadocodigo.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Preco {
	
	private BigDecimal preco;
	private TipoPrecoEnum tipo;
	
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public TipoPrecoEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoPrecoEnum tipo) {
		this.tipo = tipo;
	}
}
