package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.validation.Validation;

@Entity
public class Estoque extends DefaultEntity<Estoque> {

	private static final long serialVersionUID = 7046042711462419030L;
	@Column(nullable = false)
	private int quantidade;
	@Column(nullable = false)
	private Double valorTotal;
	@Column(nullable = false)
	private Double precoCompra;

	@ManyToOne
	@JoinColumn(name = "idfornecedor")
	private Fornecedor fornecedor;

//	@ManyToOne
//	@JoinColumn(name = "idproduto")
//	private Produto produto;

	@Column(nullable = false)
	private String notaFiscal;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

//	public Produto getProduto() {
//		return produto;
//	}
//
//	public void setProduto(Produto produto) {
//		this.produto = produto;
//	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	@Override
	public Validation<Estoque> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}
}
