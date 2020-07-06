package model;

import java.util.Date;

import model.validation.Validation;

public class NotaFiscal extends DefaultEntity<NotaFiscal>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1898183264842098482L;
	private EstoqueEntrada produto;
	private String nomeEmpresa;
	private String endereco;
	private Date dataOperacao;
	private String cnpj;


	public EstoqueEntrada getProduto() {
		return produto;
	}

	public void setProduto(EstoqueEntrada produto) {
		this.produto = produto;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	private Double valorTotal;


	@Override
	public Validation<NotaFiscal> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}
}
