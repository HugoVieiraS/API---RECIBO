package br.com.db1.pedidos.pedidosapi.repositoro;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.db1.pedidos.pedidosapi.domain.Produto;
import br.com.db1.pedidos.pedidosapi.domain.ProdutoStatus;
import br.com.db1.pedidos.pedidosapi.repositorio.ProdutoRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@After
	public void after() {
		produtoRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarUmProdutor() {
		Produto produto = new Produto("123","Produto Test", 10.0);
		produtoRepository.save(produto);
		
		long count = produtoRepository.count();
		
		
		
		Assert.assertEquals(1, count);
	}
	@Test
	public void deveSalvarProdutoAlterado() {
		Produto produto = new Produto("123","Produto Test", 10.0);
		produtoRepository.save(produto);
		
		Produto produtoSalvo = produtoRepository.findByCodigo("123");
		
		produtoSalvo.Inativar();
		produtoRepository.save(produtoSalvo);
		
		Produto produtoAlterado = produtoRepository.findByCodigo("123");
		
		Assert.assertEquals(ProdutoStatus.INATIVO, produtoAlterado.getStatus());
		
	}
	
	
}
