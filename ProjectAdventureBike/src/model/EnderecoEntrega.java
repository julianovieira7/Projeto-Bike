package model;

import javax.persistence.Column;

import model.validation.Validation;

public class EnderecoEntrega extends DefaultEntity<Endereco> {

	private static final long serialVersionUID = 4572945232362466243L;

	@Column(nullable = false)
	private String cep;

	@Column(nullable = false)
	private String numero;

	@Column(nullable = false)
	private String rua;

	private String complemento;
	private String pontoReferencia;
	private Cidade cidade;
	private Estado estado;

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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public Validation<Endereco> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}
}
