package model;

import model.validation.Validation;

public class TipoProduto extends DefaultEntity<TipoProduto>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoProduto;

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	@Override
	public Validation<TipoProduto> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
