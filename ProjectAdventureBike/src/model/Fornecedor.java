package model;

import model.validation.Validation;

public class Fornecedor extends DefaultEntity<Fornecedor>{

	private static final long serialVersionUID = -3722588257509847716L;
	private String cnpj;
	private String razaoSocial;
	private String nome;
	private Telefone telefone;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	@Override
	public Validation<Fornecedor> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}
}
