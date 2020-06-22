package model;

import java.util.Date;

public class Carrinho {
	private Date data;
	private Double valorCarrinho;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorCarrinho() {
		return valorCarrinho;
	}

	public void setValorCarrinho(Double valorCarrinho) {
		this.valorCarrinho = valorCarrinho;
	}
}
