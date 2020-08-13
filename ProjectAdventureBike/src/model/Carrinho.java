package model;

import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import model.validation.Validation;

public class Carrinho extends DefaultEntity<Carrinho> {

	private static final long serialVersionUID = 131791403543271208L;
	@ManyToOne
	private Usuario usuario;
	@OneToMany
	private List<ItemPedido> listaItem;
	@OneToOne
	private Pedido pedido;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ItemPedido> getListaItem() {
		return listaItem;
	}

	public void setListaItem(List<ItemPedido> listaItem) {
		this.listaItem = listaItem;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public Validation<Carrinho> getValidation() {
		return null;
	}

}
