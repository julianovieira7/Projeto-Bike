package model;

public class Estoque {
	private int entrada;
	private Fornecedor fornecedor;
	private int saida;

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
}
