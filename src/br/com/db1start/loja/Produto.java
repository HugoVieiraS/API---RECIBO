package br.com.db1start.loja;

import java.io.ObjectInputFilter.Status;

public class Produto {
	private String codigo;
	private String nome;
	private Double valor;
	private ProdutoStatus Status;

	public Produto(String codigo, String nome, Double valor) {
		Checker.notNull(codigo, "codigo produto");
		Checker.notNull(nome, "nome produto");
		Checker.notNull(valor, "valor do produto");

		this.codigo = codigo;
		this.nome = nome;
		this.setValor(valor);
		this.Status = ProdutoStatus.ATIVO;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}

	public ProdutoStatus getStatus() {
		return Status;
	}

	public boolean StatusPedido() {
		return ProdutoStatus.ATIVO.equals(this.Status);
	}

	public void inativar() {
		if (ProdutoStatus.ATIVO.equals(this.Status)) {
			throw new RuntimeException("Produto está " + this.Status);
		}
		this.Status = ProdutoStatus.INATIVO;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
