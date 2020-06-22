package model;

public class Bicicleta extends Produto {
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

}
