package model;

import model.validation.Validation;

public class Estado extends DefaultEntity<Estado>{

	private static final long serialVersionUID = -7221869022537424068L;
	private String nome;
	private String sigla;

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

	@Override
	public Validation<Estado> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}


}
