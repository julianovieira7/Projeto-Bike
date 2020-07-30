package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.TipoProduto;
import repository.TipoProdutoRepository;

@Named
@ViewScoped
public class TipoProdutoController extends Controller<TipoProduto>{
	private static final long serialVersionUID = 3203549533394358170L;
	private String filtro;
	private List<TipoProduto> listaTipoProduto;

	public void pesquisar() {
//		EntityManager em = JPAFactory.getEntityManager();
//		Query query = em.createQuery("Select a " + "From TipoProduto a " + "Where upper(a.nome) like upper(:filtro)");
//		query.setParameter("filtro", "%" + getFiltro() + "%");
//		listaTipoProduto = query.getResultList();

		TipoProdutoRepository repo = new TipoProdutoRepository();
		listaTipoProduto = repo.findByNome(getFiltro());
	}

	@Override
	public TipoProduto getEntity() {
		if (entity == null)
			entity = new TipoProduto();
		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<TipoProduto> getListaTipoProduto() {
		if (listaTipoProduto == null)
			listaTipoProduto = new ArrayList<TipoProduto>();

		return listaTipoProduto;
	}

}
