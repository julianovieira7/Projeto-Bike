package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Telefone extends DefaultEntity<Telefone> {

	private static final long serialVersionUID = 6651617821652381339L;
	@Column(nullable = false)
	private Integer codigoArea;
	@Column(nullable = false)
	private String numero;

	public Integer getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(Integer codigoArea) {
		this.codigoArea = codigoArea;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
