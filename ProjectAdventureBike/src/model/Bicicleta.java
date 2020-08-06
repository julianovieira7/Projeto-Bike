package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import model.validation.Validation;

@Entity
//@DiscriminatorValue(value = "B")
public class Bicicleta extends DefaultEntity<Bicicleta> {

	private static final long serialVersionUID = -7607211676214204484L;
	@Column(nullable = false)
	private String nome;

	private Modalidade modalidade;

	private QuantMarcha quantMarcha;

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public QuantMarcha getQuantMarcha() {
		return quantMarcha;
	}

	public void setQuantMarcha(QuantMarcha quantMarcha) {
		this.quantMarcha = quantMarcha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public Validation<Bicicleta> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
