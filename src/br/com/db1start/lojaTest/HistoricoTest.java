package br.com.db1start.lojaTest;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1start.loja.Historico;
import br.com.db1start.loja.StatusPedido;

public class HistoricoTest {
	
	@Test
	public void deveRetornarStatusEObrigatorio() {
		try {
			new Historico(null, null);
		} catch (Exception e) {
			Assert.assertEquals("Campo status é obrigatório.", e.getMessage());
		}
	}
	@Test
	public void deveCriarUmHistorico() {
		Historico historico = new Historico(null, StatusPedido.ABERTO);
		Assert.assertEquals(StatusPedido.ABERTO, historico.getStatus());
		Assert.assertNotNull(historico.getData());
	}
}


