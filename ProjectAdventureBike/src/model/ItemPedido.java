package model;

import model.validation.Validation;

public class ItemPedido extends DefaultEntity<ItemPedido>{

	private static final long serialVersionUID = 9197057785061628327L;
	private int quantidade;
	private Double valorTotal;
	private Produto produto;

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

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

	public Produto getProduto() {
		return produto;
	}

	@Override
	public Validation<ItemPedido> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
