package model;

import javax.persistence.Entity;

import model.validation.TelefoneValidation;
import model.validation.Validation;

@Entity
public class Telefone extends DefaultEntity<Telefone> {

	private static final long serialVersionUID = 6651617821652381339L;

	private Integer codigoArea;

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

	@Override
	public Validation<Telefone> getValidation() {

		return new TelefoneValidation();
	}

}
