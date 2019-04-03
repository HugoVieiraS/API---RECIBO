package br.com.db1.pedidos.pedidosapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.db1.pedidos.pedidosapi.infraestrutura.Checker;
@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="codigo", length=50, nullable = false, unique = true) 
	private String codigo;
	
	@Column(name="nome", length=100, nullable = false) 
	private String nome;
	
	@Column(name="valor", precision=16, nullable = false) 
	private Double valor;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", length=30, nullable = false) 
	private ProdutoStatus Status;

	protected Produto() {}
	
	
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

	public void Inativar() {
		if (!ProdutoStatus.ATIVO.equals(this.Status)) {
			throw new RuntimeException("Produto est� " + this.Status);
		}
		this.Status = ProdutoStatus.INATIVO;
	}

	public void setValor(Double valor) {
		this.valor = valor;	}



}
