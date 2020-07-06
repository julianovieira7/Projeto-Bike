package model;

import model.validation.Validation;

public class Cidade extends DefaultEntity<Cidade>{
	
	
	private static final long serialVersionUID = 8967240851927495370L;
	private String nome;
	private String sigla;
	
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public Validation<Cidade> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
