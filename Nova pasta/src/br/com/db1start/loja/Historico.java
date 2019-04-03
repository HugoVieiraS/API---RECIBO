package br.com.db1start.loja;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDateTime;

public class Historico {
	private LocalDateTime Data;
	private StatusPedido Status;

	public Historico(LocalDateTime data, StatusPedido Status) {
		Checker.notNull(Status, "status");
		this.Data = data;
		this.Status = Status;
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
