package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import model.validation.Validation;
@Entity
public class EstoqueEntrada extends DefaultEntity<EstoqueEntrada> {

	
	private static final long serialVersionUID = 7046042711462419030L;
	@Column(nullable = false)
	private int entrada;
	@Column(nullable = false)
	@OneToMany(mappedBy="estoqueEntrada")
	private List<Fornecedor> listaFornecedor;
	
	private int saida;
	@OneToMany(mappedBy="estoqueEntrada")
	private List<Fornecedor> listaProduto;
	private Produto produto;
	private String notaFiscal;

	public List<Fornecedor> getListaFornecedor() {
		return listaFornecedor;
	}

	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}

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



	public int getSaida() {
		return saida;
	}

	public void setSaida(int saida) {
		this.saida = saida;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	@Override
	public Validation<EstoqueEntrada> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}
}
