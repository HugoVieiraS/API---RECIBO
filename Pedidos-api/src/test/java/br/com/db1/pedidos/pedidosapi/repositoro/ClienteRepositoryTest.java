package br.com.db1.pedidos.pedidosapi.repositoro;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.db1.pedidos.pedidosapi.domain.Cliente;
import br.com.db1.pedidos.pedidosapi.domain.StatusCliente;
import br.com.db1.pedidos.pedidosapi.repositorio.ClienteRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTest {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@After
	public void after() {
		clienteRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarUmCliente() {
		Cliente cliente = new Cliente("Vitor","12200890958");
		clienteRepository.save(cliente);
		long count = clienteRepository.count();
		
		
		
		Assert.assertEquals(1, count);
	}
	@Test
	public void deveSalvaroClienteAlterado() {
		Cliente cliente = new Cliente("Fabio Juchem", "12200890954");
		clienteRepository.save(cliente);
		
		Cliente clienteSalvo = clienteRepository.findBycpf("12200890954");
		
		clienteSalvo.Inativar();
		
		clienteRepository.save(clienteSalvo);
		
		Cliente clienteAlterado = clienteRepository.findBycpf("12200890954");
		
		Assert.assertEquals(StatusCliente.INATIVO, clienteAlterado.getStatus());
		
	}


}
