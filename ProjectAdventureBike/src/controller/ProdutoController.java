package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import application.Util;
import model.TipoProduto;
import model.Marca;
//import controller.listing.EnderecoListing;
//import controller.listing.TelefoneListing;
//import controller.listing.ProdutoListing;
//import model.Endereco;
//import model.Telefone;
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
		// metodo(string pesquisa)
		// if(get ==
		listaProduto = repo.findByNome(getFiltro());
	}

//	public void abrirProdutoListing() {
//		ProdutoListing listing = new ProdutoListing();
//		listing.open();
//	}
//
//	public void obterProdutoListing(SelectEvent event) {
//		Produto entity = (Produto) event.getObject();
//		setEntity(entity);
//		if (getEntity().getEndereco() == null)
//			getEntity().setEndereco(new Endereco());
//
//		if (getEntity().getTelefone() == null)
//			getEntity().setTelefone(new Telefone());
//	}

//	public void abrirEnderecoListing() {
////		EnderecoListing listing = new EnderecoListing();
//		listing.open();
//	}

//	public void obterEnderecoListing(SelectEvent event) {
//		Endereco entity = (Endereco) event.getObject();
//		getEntity().setEndereco(entity);
//	}

//	public void abrirTelefoneListing() {
//		TelefoneListing listing = new TelefoneListing();
//		listing.open();
//	}
//
//	public void obterTelefoneListing(SelectEvent event) {
//		Telefone entity = (Telefone) event.getObject();
//		getEntity().setTelefone(entity);
//	}

	@Override
	public Produto getEntity() {
		if (entity == null)
			entity = new Produto();
//		entity.setEndereco(new Endereco());
//		entity.setTelefone(new Telefone());

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
