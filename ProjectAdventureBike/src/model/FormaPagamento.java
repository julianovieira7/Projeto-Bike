package model;

import java.util.Date;

import model.validation.Validation;

public class FormaPagamento extends DefaultEntity<FormaPagamento>{

	private static final long serialVersionUID = 7095644545810509642L;
	private Date dataVencimento;
	private String nome;
	private Boleto boleto;
	private CartaoCredito cartaoCredito;
	
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	@Override
	public Validation<FormaPagamento> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
