package model;

import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class TipoProduto extends DefaultEntity<TipoProduto> {
	
	private static final long serialVersionUID = -2359731594073401155L;
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
