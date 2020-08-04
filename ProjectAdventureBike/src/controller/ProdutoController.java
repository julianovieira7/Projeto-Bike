package controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import model.Produto;
import model.Marca;
import repository.MarcaRepository;

@Named
@ViewScoped
public class ProdutoController extends Controller<Produto> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6787464323324498154L;
	private String filtro;
	private List<Marca> listaMarca;
	
	
//	public void abrirProdutoListing() {
//		ProdutoListing listing = new ProdutoListing();
//		listing.open();
//	}
//	
//	public void obterProdutoListing(SelectEvent event) {
//        Produto entity = (Produto) event.getObject();
//        setEntity(entity);
//    	if (getEntity().getMarca() == null) {
//			getEntity().setMarca(new Marca());
//    		getEntity().getMarca().setEstado(new Estado());
//    	}
//    }
	
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

		public void atualizarMarcas() {
		listaMarca = null;
	}

	public List<Marca> getListaMarca() {
		if (listaMarca == null) {
			MarcaRepository repo = new MarcaRepository();
			listaMarca = repo.findByNome("");
		}
		return listaMarca;
	}

	public void setListaMarca(List<Marca> listaMarca) {
		this.listaMarca = listaMarca;
	}
	
}
