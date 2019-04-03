package br.com.db1start.lojaTest;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1start.loja.Cliente;
import br.com.db1start.loja.StatusCliente;

public class ClienteTest {
	@Test

	public void deveRetornarNomeEObrigatorio() {
		try {
			new Cliente(null, "123");
		} catch (Exception e) {
			Assert.assertEquals("Campo nome do cliente é obrigatório.", e.getMessage());
		}
	}
	@Test
	public void deveRetornarCpfEObrigatorio() {
		try {
			new Cliente("João", null);
		} catch (Exception e) {
			Assert.assertEquals("Campo CPF do cliente é obrigatório.", e.getMessage());
		}
	}
	@Test
	public void deveRetornarCpfEInvalido() {
		try {
			new Cliente("João", "098");
		} catch (Exception e) {
			Assert.assertEquals("CPF 098 é inválido.", e.getMessage());
		}
	}
	@Test
	public void deveCriarUmCliente() {
		Cliente cliente = new Cliente("João", "99999999999");
		Assert.assertEquals("João", cliente.getNome());
		Assert.assertEquals("99999999999", cliente.getCpf());
		Assert.assertEquals(StatusCliente.ATIVO, cliente.getStatus());
	}
	@Test
	public void deveRetornarClienteAtivo() {
		Cliente cliente = new Cliente("João", "99999999999");
		Assert.assertTrue(cliente.StatusCliente());
	}
}