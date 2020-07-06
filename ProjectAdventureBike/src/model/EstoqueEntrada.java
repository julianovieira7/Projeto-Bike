package model;

import model.validation.Validation;

public class EstoqueEntrada extends DefaultEntity<EstoqueEntrada>{

	private static final long serialVersionUID = -1436525943395272215L;
	private int entrada;
	private Fornecedor fornecedor;
	private int saida;
	private Produto produto;
	private NotaFiscal notaFiscal;


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getEntrada() {
		return entrada;
	}

	public void setEntrada(int entrada) {
		this.entrada = entrada;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getSaida() {
		return saida;
	}

	public void setSaida(int saida) {
		this.saida = saida;
	}
	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	@Override
	public Validation<EstoqueEntrada> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}
}
