package model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import model.validation.Validation;

@Entity
public abstract class Pagamento extends DefaultEntity<Pagamento> {

	private static final long serialVersionUID = 645702574565914835L;
	@OneToOne
	@JoinColumn(name = "formapagamento", unique = true)
	private FormaPagamento formaPagamento;
	
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public Validation<Pagamento> getValidation() {
		return null;
	}

	@Override
	public String toString() {
		return "Pagamento [formaPagamento=" + formaPagamento + "]";
	}
	
}
