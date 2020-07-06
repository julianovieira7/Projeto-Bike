package model;

import java.util.Date;

import model.validation.Validation;

public class Carrinho extends DefaultEntity<Carrinho>{

	private static final long serialVersionUID = 6019061330890073471L;
	private Date data;
	private Double valorCarrinho;
	private Usuario usuario;
	private Pedido pedido;
	private ItemPedido itemPedido;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

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

	@Override
	public Validation<Carrinho> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}
}
