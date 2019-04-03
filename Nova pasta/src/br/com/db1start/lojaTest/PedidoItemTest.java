package br.com.db1start.lojaTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.db1start.loja.Cliente;
import br.com.db1start.loja.Pedido;
import br.com.db1start.loja.PedidoItem;
import br.com.db1start.loja.Produto;
import br.com.db1start.loja.ProdutoStatus;
import br.com.db1start.loja.StatusCliente;
import br.com.db1start.loja.StatusPedido;

public class PedidoItemTest {
	
	
	private Produto produtos;

	@Before
	public void init() {
	produtos = new Produto("1","Carro",10000.00);
	}
	
	@Test
	public void deveRetornarProdutosObrigatorio() {
		try {
			new PedidoItem(null, 8.0);
		}catch(Exception e) {
			Assert.assertEquals("Campo produto é obrigatório.", e.getMessage());
		}
	}
	@Test
	public void deveRetornarQuantidadeEObrigatorio() {
		try {
			new PedidoItem(produtos, null);
		}catch(Exception e) {
			Assert.assertEquals("Campo quantidade é obrigatório.", e.getMessage());
		}
	}
	@Test
	public void deveRetornarQuantidadeDeveSerMaiorQueZero() {
		try {
			new PedidoItem(produtos, 0.0);
		}catch(Exception e) {
			Assert.assertEquals("Campo quantidade deve ser maior que zero.", e.getMessage());
		}
	}
	@Test
	public void deveCriarUmPedidoItem() {
		PedidoItem item = new PedidoItem(produtos, 2.0);
		Assert.assertEquals(produtos, item.getProduto());
		Assert.assertEquals(2.0, item.getQuantidade(),  0);
		Assert.assertEquals(produtos.getValor(), item.getValor(), 0);
		Assert.assertEquals(20000.0, item.getValorTotal(), 0);	}
}
