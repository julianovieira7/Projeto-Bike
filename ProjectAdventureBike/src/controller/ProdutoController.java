package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import application.Util;
import controller.listing.ProdutoListing;
import model.TipoProduto;
import model.Marca;
//import controller.listing.MarcaListing;
//import controller.listing.TipoProdutoListing;
//import controller.listing.ProdutoListing;
//import model.Marca;
//import model.TipoProduto;
import model.Produto;
import repository.TipoProdutoRepository;
import repository.MarcaRepository;
import repository.ProdutoRepository;

@Named
@ViewScoped
public class ProdutoController extends Controller<Produto> {

	private static final long serialVersionUID = -4523377191243675875L;
	private String filtro;
	private List<Marca> listaMarca;
	private List<Produto> listaProduto;
	private List<TipoProduto> listaTipoProduto;

	@Override
	public void salvar() {

//		if (getEntity().getMarca().getId() == null) {
//			getEntity().setMarca(null);
//		}
//		if (getEntity().getTipoProduto().getId() == null) {
//			getEntity().setTipoProduto(null);
//		}
		super.salvar();
	}

	public List<String> completeArea(String query) {
		List<String> results = new ArrayList<String>();

		if (query.equals("PrimeFaces")) {
			results.add("PrimeFaces Rocks!!!");
			results.add("PrimeFaces has 100+ components.");
			results.add("PrimeFaces is lightweight.");
			results.add("PrimeFaces is easy to use.");
			results.add("PrimeFaces is developed with passion!");
		} else {
			for (int i = 0; i < 10; i++) {
				results.add(query + i);
			}
		}

		return results;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public void onSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "select", (String) event.getObject()));

	}

	public void pesquisar() {
//		EntityManager em = JPAFactory.getEntityManager();
//		Query query = em.createQuery("Select a " + "From Produto a " + "Where upper(a.nome) like upper(:filtro)");
//		query.setParameter("filtro", "%" + getFiltro() + "%");
//		listaProduto = query.getResultList();

		ProdutoRepository repo = new ProdutoRepository();
		listaProduto = repo.findByNome(getFiltro());
	}

	public void abrirProdutoListing() {
		ProdutoListing listing = new ProdutoListing();
		listing.open();
	}

	public void obterProdutoListing(SelectEvent event) {
		Produto entity = (Produto) event.getObject();
		setEntity(entity);
		if (getEntity().getMarca() == null)
			getEntity().setMarca(new Marca());

		if (getEntity().getTipoProduto() == null)
			getEntity().setTipoProduto(new TipoProduto());
	}

	@Override
	public Produto getEntity() {
		if (entity == null)
			entity = new Produto();
		entity.setMarca(new Marca());
		entity.setTipoProduto(new TipoProduto());

		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
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

	public void atualizarTipoProdutos() {
		listaTipoProduto = null;
	}

	public List<TipoProduto> getListaTipoProduto() {
		if (listaTipoProduto == null) {
			TipoProdutoRepository repo = new TipoProdutoRepository();
			listaTipoProduto = repo.findByNome("");
		}
		return listaTipoProduto;
	}

	public void setListaTipoProduto(List<TipoProduto> listaTipoProduto) {
		this.listaTipoProduto = listaTipoProduto;
	}
}
