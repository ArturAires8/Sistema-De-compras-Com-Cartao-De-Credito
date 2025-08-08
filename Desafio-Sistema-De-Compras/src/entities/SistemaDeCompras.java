package entities;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class SistemaDeCompras {

	public static void cadastrarCartao(Cliente cliente, CartaoDeCredito cartao) {
		cliente.adicionarCartao(cartao);
		System.out.println("\nCartão cadastrado: " + cartao.getNumeroCartao() + " com limite de "
				+ formatarMoeda(cartao.getLimite()));

	}

	public static boolean realizarCompra(CartaoDeCredito cartao, Compra compra) {
		boolean compraRealizada = cartao.realizarCompra(compra);
		if (compraRealizada) {
			System.out.println("Compra realizada: " + compra.getDescricao() + " - " + formatarMoeda(compra.getValor()));
			System.out.println("Saldo disponivel: " + formatarMoeda(cartao.getSaldoDisponivel()));
		} else {
			System.out.println("Compra não realizada: saldo insuficiente para " + compra.getDescricao());
		}
		return compraRealizada;
	}

	public static void listarCompras(CartaoDeCredito cartao) {
		System.out.println("\nCompras realizadas no cartão " + cartao.getNumeroCartao() + ":");
		int i = 1;
		for (Compra compra : cartao.getCompras()) {
			System.out.println(i++ + ". " + compra.getDescricao() + " - " + formatarMoeda(compra.getValor()));
		}
	}

	public static void exibirResumo(Cliente cliente) {
		System.out.println("\nResumo do cliente " + cliente.getNome() + ":");
		for (CartaoDeCredito cartao : cliente.getCartoes()) {
			System.out.println("Cartão: " + cartao.getNumeroCartao());

			BigDecimal totalGasto = cartao.getLimite().subtract(cartao.getSaldoDisponivel());
			System.out.println("Total gasto: " + formatarMoeda(totalGasto));
			System.out.println("Saldo disponível: " + formatarMoeda(cartao.getSaldoDisponivel()));
		}
	}

	public static String formatarMoeda(BigDecimal valor) {
		return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valor);

	}
}
