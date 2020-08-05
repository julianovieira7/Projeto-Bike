package model;

import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Endereco extends DefaultEntity<Endereco>{

	private static final long serialVersionUID = 4989928930162461941L;
	private Integer id;
	private String cep;
	private String numero;
	private String rua;
	private String complemento;
	private String pontoReferencia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	@Override
	public Validation<Endereco> getValidation() {
		return null;
	}
}
