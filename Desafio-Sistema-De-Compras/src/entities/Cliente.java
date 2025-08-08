package entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nome;
	private String cpf;
	List<CartaoDeCredito> cartoes;

	public Cliente(String nome, String cpf) {

		this.nome = nome;
		this.cpf = cpf;
		this.cartoes = new ArrayList<>();

	}

	public void adicionarCartao(CartaoDeCredito cartao) {

		cartoes.add(cartao);
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public List<CartaoDeCredito> getCartoes() {
		return cartoes;
	}

}