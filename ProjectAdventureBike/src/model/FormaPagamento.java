package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.validation.Validation;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class FormaPagamento extends DefaultEntity<FormaPagamento> {

	private static final long serialVersionUID = -1163228351365280278L;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	@Column(nullable = false)
	private String nome;

	private Boleto boleto;
	private CartaoCredito cartaoCredito;

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

	@Override
	public String toString() {
		return "FormaPagamento [dataVencimento=" + dataVencimento + ", nome=" + nome + ", boleto=" + boleto
				+ ", cartaoCredito=" + cartaoCredito + "]";
	}

	@Override
	public Validation<FormaPagamento> getValidation() {
		return null;
	}
}
