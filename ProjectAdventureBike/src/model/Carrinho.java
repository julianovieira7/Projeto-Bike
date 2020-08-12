package model;

import java.util.List;

import javax.persistence.OneToMany;

import model.validation.Validation;

public class Carrinho extends DefaultEntity<Carrinho> {

	private static final long serialVersionUID = 131791403543271208L;
	private Usuario usuario;
	@OneToMany
	private List<ItemPedido> listaItem;

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

	@Override
	public Validation<Carrinho> getValidation() {
		return null;
	}

}
