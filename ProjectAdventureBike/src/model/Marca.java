package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Marca extends DefaultEntity<Marca> {

	private static final long serialVersionUID = -7569741804479393964L;

	@Column(length = 100, nullable = false)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public Validation<Marca> getValidation() {

		return null;
	}

}
