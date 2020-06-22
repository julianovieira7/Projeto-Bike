package model;

import model.validation.Validation;

public class Cambio extends DefaultEntity<Produto>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5480548556171035926L;
	private int TamanhoCambio;

	public int getTamanhoCambio() {
		return TamanhoCambio;
	}

	public void setTamanhoCambio(int tamanhoCambio) {
		TamanhoCambio = tamanhoCambio;
	}

	@Override
	public Validation<Produto> getValidation() {
		
		return null;
	}
	
}
