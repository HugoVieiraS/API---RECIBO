package br.com.db1.pedidos.pedidosapi.domain;

import br.com.db1.pedidos.pedidosapi.infraestrutura.Checker;

public class PedidoItem {
	private Produto produto;
	private Double quantidade;
	private Double valor;

	public PedidoItem(Produto produto, Double quantidade) {
		Checker.notNull(produto, "produto");
		Checker.notNull(quantidade,"quantidade");
		Checker.maiorQueZero(quantidade, "quantidade");

		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = produto.getValor();
	}

	public Produto getProduto() {
		return produto;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public Double getValorTotal() {
		return this.quantidade * this.valor;
	}

}