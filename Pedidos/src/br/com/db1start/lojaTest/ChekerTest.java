package br.com.db1start.lojaTest;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1start.loja.Checker;

//Checando se os checker estão funcionando. Usados no nome e cpf do cliente
//Os checker devem proibir a entrada de valores nulos, enviando mensagem que está errado.

public class ChekerTest {
	@Test
	public void naoDeveRetornarNuloAmem() {
		Checker.notNull("500 dols", "vitor");
	}

	@Test(expected = RuntimeException.class)
	public void deveRetornarCampoObrigatorio() {
		Checker.notNull("Hugo", "nome");
	}

	@Test(expected = RuntimeException.class)
	public void deveRetornarMensagem() {
		try {
			Checker.notNull("Vitor", "nome");
		} catch (RuntimeException verificar) {
			Assert.assertEquals("Campo nome é obrigatorio", verificar.getMessage());
		}

	}
}
