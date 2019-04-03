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
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", length=100, nullable = false) 
	private String nome;
	
	@Column(name="cpf", length=100, nullable = false)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", length=30, nullable = false)
	private StatusCliente status;

	protected Cliente() {}

	public Cliente(String nome, String cpf) {
		Checker.notNull(nome, "nome");
		Checker.notNull(cpf, "cpf");
		Checker.cpf(cpf);
		
		this.nome = nome;
		this.cpf = cpf;
		this.status = StatusCliente.ATIVO;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	public StatusCliente getStatus() {
		return status;
	}

	public void Inativar() {
		if (!StatusCliente.ATIVO.equals(this.status)) {
			throw new RuntimeException("Produto est� " + this.status);
		}
		this.status = StatusCliente.INATIVO;
	}

	public boolean StatusCliente() {

		return StatusCliente.ATIVO.equals(this.status);

	}
}
