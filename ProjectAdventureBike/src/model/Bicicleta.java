package model;

import javax.persistence.Entity;

@Entity
public class Bicicleta extends Produto {

	private static final long serialVersionUID = -7607211676214204484L;

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

}
