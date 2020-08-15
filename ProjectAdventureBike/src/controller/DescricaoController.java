package controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Produto;

@Named
@ViewScoped
public class DescricaoController implements Serializable {

	private static final long serialVersionUID = 6787464323324498154L;
	private Produto produto;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public DescricaoController() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.keep("pacienteFlash");
		setProduto((Produto) flash.get("produtoFlash"));
	}
}
