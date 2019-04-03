package br.com.db1.pedidos.pedidosapi.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.db1.pedidos.pedidosapi.domain.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
	Produto findByCodigo(String codigo);

}
