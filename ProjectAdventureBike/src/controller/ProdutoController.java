package controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.MarcaListing;
import controller.listing.ProdutoListing;
import controller.listing.TipoProdutoListing;
import model.Produto;
import model.TipoProduto;
import model.Marca;
import repository.MarcaRepository;

@Named
@ViewScoped
public class ProdutoController extends Controller<Produto> {

	private static final long serialVersionUID = 6787464323324498154L;
	private String filtro;

	@Override
	public Produto getEntity() {
		if (entity == null) {
			entity = new Produto();
			entity.setMarca(new Marca());
		}
		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public void abrirProdutoListing() {
		ProdutoListing listing = new ProdutoListing();
		listing.open();
	}

	public void obterProdutoListing(SelectEvent event) {
		Produto entity = (Produto) event.getObject();
		setEntity(entity);
		if (getEntity().getMarca() == null) {
			getEntity().setMarca(new Marca());
		}
	}

	public void abrirMarcaListing() {
		MarcaListing listing = new MarcaListing();
		listing.open();
	}

	public void obterMarcaListing(SelectEvent event) {
		Marca entity = (Marca) event.getObject();
		getEntity().setMarca(entity);
	}

	public void abrirTipoProdutoListing() {
		TipoProdutoListing listing = new TipoProdutoListing();
		listing.open();
	}

	public void obterTipoProdutoListing(SelectEvent event) {
		TipoProduto entity = (TipoProduto) event.getObject();
		getEntity().setTipoProduto(entity);
	}
}
