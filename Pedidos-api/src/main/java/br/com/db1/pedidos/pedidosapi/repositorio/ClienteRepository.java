package br.com.db1.pedidos.pedidosapi.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.db1.pedidos.pedidosapi.domain.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	Cliente findBycpf(String cpf);


}
