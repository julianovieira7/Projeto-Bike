package model;

import model.validation.Validation;

public class Bicicleta extends DefaultEntity<Produto> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5478233461294270452L;
	private Modalidade modalidade;
	private QuantMarchas quantMarchas;

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public QuantMarchas getQuantMarchas() {
		return quantMarchas;
	}

	public void setQuantMarchas(QuantMarchas quantMarchas) {
		this.quantMarchas = quantMarchas;
	}

	@Override
	public Validation<Produto> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
