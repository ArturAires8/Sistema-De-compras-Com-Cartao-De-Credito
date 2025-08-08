package entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito {

	private String numeroCartao;
	private BigDecimal limite;
	private BigDecimal saldoDisponivel;
	List<Compra> compras;

	public CartaoDeCredito(String numeroCartao, double limite) {
		this.numeroCartao = numeroCartao;
		this.limite = BigDecimal.valueOf(limite);
		this.saldoDisponivel = this.limite;
		this.compras = new ArrayList<>();

	}

	public boolean realizarCompra(Compra compra) {
		if (compra.getValor().compareTo(saldoDisponivel) <= 0) {
			saldoDisponivel = saldoDisponivel.subtract(compra.getValor());
			compras.add(compra);
			return true;

		}
		return false;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public BigDecimal getSaldoDisponivel() {
		return saldoDisponivel;
	}

	public List<Compra> getCompras() {
		return compras;
	}




}
