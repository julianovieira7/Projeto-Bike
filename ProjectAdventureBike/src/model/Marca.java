package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import model.validation.Validation;


@Entity
public class Marca extends DefaultEntity<Marca> {

	private static final long serialVersionUID = -7607211676214204484L;

	@Column(length = 100, nullable = false)
	private String marca;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public Validation<Marca> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}



}
