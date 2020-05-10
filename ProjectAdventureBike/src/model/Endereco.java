package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Endereco extends DefaultEntity<Endereco> {

	private static final long serialVersionUID = -5694392091322912401L;

	@Column(nullable = false)
	private String cep;

	@Column(nullable = false)
	private String numero;

	@Column(nullable = false)
	private String rua;

	private String complemento;
	private String pontoReferencia;

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
}
