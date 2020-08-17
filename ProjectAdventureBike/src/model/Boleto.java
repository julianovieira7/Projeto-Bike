package model;

import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Boleto extends DefaultEntity<Boleto> {

	private static final long serialVersionUID = 2949634004019128300L;
	private String codigoBoleto;


	public String getCodigoBoleto() {
		return codigoBoleto;
	}

	public void setCodigoBoleto(String codigoBoleto) {
		this.codigoBoleto = codigoBoleto;
	}

	@Override
	public Validation<Boleto> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}


}
