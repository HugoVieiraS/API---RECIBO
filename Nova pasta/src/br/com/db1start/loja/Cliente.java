package br.com.db1start.loja;

public class Cliente {
	private String nome;
	private String cpf;
	private StatusCliente status;


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

	public boolean StatusCliente() {
		return StatusCliente.ATIVO.equals(this.status);
	}

}
