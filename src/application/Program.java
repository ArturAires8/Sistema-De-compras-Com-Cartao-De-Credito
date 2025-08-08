package application;

import java.math.BigDecimal;

import entities.CartaoDeCredito;
import entities.Cliente;
import entities.Compra;
import entities.SistemaDeCompras;

public class Program {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("João", "123445678900");
		System.out.println("Cadastro do cliente: " + cliente.getNome() +
				" (CPF:"  + cliente.getCpf() + ")");
		
		CartaoDeCredito cartao = new CartaoDeCredito("1234-5678-9876-5432", 5000.0);
		SistemaDeCompras.cadastrarCartao(cliente, cartao);
		
		System.out.println();
		
		Compra compra1 = new Compra("Notebook", new BigDecimal("2500.00"));
		Compra compra2 = new Compra("Mouse", new BigDecimal("150.00"));
		Compra compra3 = new Compra("Teclado", new BigDecimal("200.00"));
		Compra compra4 = new Compra("Monitor", new BigDecimal("3000.00"));

		SistemaDeCompras.realizarCompra(cartao, compra1);
		SistemaDeCompras.realizarCompra(cartao, compra2);
		SistemaDeCompras.realizarCompra(cartao, compra3);
		SistemaDeCompras.realizarCompra(cartao, compra4);
		
		SistemaDeCompras.listarCompras(cartao);
		SistemaDeCompras.exibirResumo(cliente);
		
	}

}
