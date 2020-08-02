package model;

import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Telefone extends DefaultEntity<Telefone> {

	private static final long serialVersionUID = 4368844581125273114L;
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
		// TODO Auto-generated method stub
		return null;
	}

}
