package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.validation.Validation;

@Entity
public class FormaPagamento extends DefaultEntity<FormaPagamento> {

	private static final long serialVersionUID = 2309310836012369586L;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	@Column(nullable = false)
	private String nome;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idboleto", unique = true)
	private Boleto boleto;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcartaocredito", unique = true)
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
