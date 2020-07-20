package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

//import controller.listing.EnderecoListing;
//import controller.listing.TelefoneListing;
//import controller.listing.ProdutoListing;
//import model.Endereco;
//import model.Telefone;
import model.Produto;
import repository.ProdutoRepository;

@Named
@ViewScoped
public class ProdutoController extends Controller<Produto> {

	private static final long serialVersionUID = -4523377191243675875L;
	private String filtro;
	private List<Produto> listaProduto;

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

	public List<Produto> getListaProduto() {
		if (listaProduto == null)
			listaProduto = new ArrayList<Produto>();

		return listaProduto;
	}

}
