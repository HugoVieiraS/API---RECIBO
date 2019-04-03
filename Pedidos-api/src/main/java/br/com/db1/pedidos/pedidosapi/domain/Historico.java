package br.com.db1.pedidos.pedidosapi.domain;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.db1.pedidos.pedidosapi.infraestrutura.Checker;

@Entity
@Table(name="historico")
public class Historico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private LocalDateTime Data;
	private StatusPedido Status;

	@ManyToOne
	@JoinColumn(name="id_pedido", referencedColumnName = "id")
	private Pedido pedido;
	
	public Historico(Pedido pedido, StatusPedido Status) {
		Checker.notNull(Status, "status");
		this.Status = Status;
		this.pedido = pedido;
	}

	public void setData(LocalDateTime Data) {
		this.Data = Data;
	}

	public LocalDateTime getData() {

		return Data;
	}

	public StatusPedido getStatus() {
		return Status;
	}

	public void setStatus(StatusPedido Status) {
		this.Status = Status;

	}
}
