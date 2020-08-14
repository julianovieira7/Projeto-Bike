package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Boleto extends FormaPagamento {

	private static final long serialVersionUID = 2949634004019128300L;
	@Column(nullable = false)
	private String cpf;
	@Column(nullable = false)
	private String codigoBoleto;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCodigoBoleto() {
		return codigoBoleto;
	}

	public void setCodigoBoleto(String codigoBoleto) {
		this.codigoBoleto = codigoBoleto;
	}

}
