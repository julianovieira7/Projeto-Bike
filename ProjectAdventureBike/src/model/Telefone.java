package model;

import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Telefone extends DefaultEntity<Telefone> {
	private Integer id;
	private Integer codigoArea;
	private String numero;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
