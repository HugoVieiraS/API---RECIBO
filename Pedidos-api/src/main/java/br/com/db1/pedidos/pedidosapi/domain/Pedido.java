package br.com.db1.pedidos.pedidosapi.domain;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import br.com.db1.pedidos.pedidosapi.infraestrutura.Checker;

public class Pedido {
	private static final int QUANTIDADE_MAXIMA_ITENS = 10;
	private String codigo;
	private StatusPedido Status;
	private LocalDateTime dataStatus;
	private Cliente cliente;
	
	private List<PedidoItem> itens = new ArrayList<>();
	@OneToMany(mappedBy="pedido", fetch=FetchType.LAZY, cascade = CascadeType.ALL)  ///estudar mais 
	private List<Historico> historicos = new ArrayList<>();

	public Pedido(String codigo, Cliente cliente) {
		Checker.notNull(codigo, "codigo");
		Checker.notNull(cliente, "cliente");

		this.codigo = codigo;
		this.cliente = cliente;
		this.novoHistoricoStatus();
	}

	public void adicionarItem(Produto produto, Double quantidade) {
		this.verificarStatusPedidoParaAlterar();

		if (this.itens.size() == QUANTIDADE_MAXIMA_ITENS) {
			throw new RuntimeException("Quantidade m�xima de itens excedida: " + QUANTIDADE_MAXIMA_ITENS);
		}
		this.itens.add(new PedidoItem(produto, quantidade));
	}
	 
	public void removerItem(Produto produto) {
		this.verificarStatusPedidoParaAlterar();
		this.itens.removeIf(item -> item.getProduto().getCodigo().equals(produto.getCodigo()));
	}

	public void faturar() {
		if (!StatusPedido.ABERTO.equals(this.Status)) {
			throw new RuntimeException("Pedido est�  " + this.Status);
		}
		if (this.itens.size() == 0 || this.itens.size() > QUANTIDADE_MAXIMA_ITENS) {
			throw new RuntimeException(
					"Pedido deve ter no min�mo 1 item e no m�ximo 10 itens. Quantidade atual: " + this.itens.size());
		}
		this.verificarClienteAtivo();
		this.Status = StatusPedido.FATURADO;
	}

	public void cancelar() {
		this.verificarStatusPedidoParaAlterar();
		this.Status = StatusPedido.CANCELADO;
	}

	public void reabrir() {
		if (!StatusPedido.CANCELADO.equals(this.Status)) {
			throw new RuntimeException("Pedido est� " + this.Status);
		}
		this.Status = StatusPedido.ABERTO;
	}

	public String getCodigo() {
		return codigo;
	}

	public StatusPedido getStatus() {
		return Status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Historico> getHistoricos() {
		return Collections.unmodifiableList(historicos);
	}

	public List<PedidoItem> getItens() {
		return Collections.unmodifiableList(itens);
	}

	public LocalDateTime getDataStatus() {
		return dataStatus;
	}

	private void novoHistoricoStatus() {
		Historico historico = new Historico(this, this.Status);
		this.historicos.add(historico);
		this.dataStatus = historico.getData();
	}

	private void verificarClienteAtivo() {
		if (!cliente.StatusCliente()) {
			throw new RuntimeException("Cliente " + cliente.getNome() + " est� inativo");
		}
	}

	private void verificarStatusPedidoParaAlterar() {
		if (!StatusPedido.ABERTO.equals(this.Status)) {
			throw new RuntimeException("Pedido est�  " + this.Status);
		}
	}
}