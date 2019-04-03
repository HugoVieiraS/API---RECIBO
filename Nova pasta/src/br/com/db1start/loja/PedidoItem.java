package br.com.db1start.loja;

import java.io.ObjectInputFilter.Status;
import java.util.List;

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