package entities;

import java.math.BigDecimal;

public class Compra {

	private String descricao;
	private BigDecimal valor;

	public Compra(String descricao, BigDecimal valor) {

		this.descricao = descricao;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	

}
