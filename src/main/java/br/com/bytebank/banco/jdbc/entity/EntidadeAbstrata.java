package br.com.bytebank.banco.jdbc.entity;

import java.io.Serializable;

public abstract class EntidadeAbstrata<ID extends Serializable> {

	private ID id;
	private String status;
	
	public EntidadeAbstrata() {
		super();
		this.setStatus("ATIVO");
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntidadeAbstrata<?> other = (EntidadeAbstrata<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
