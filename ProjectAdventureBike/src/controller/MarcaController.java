package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Marca;
import repository.MarcaRepository;

@Named
@ViewScoped
public class MarcaController extends Controller<Marca> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6037007969793097884L;
	private String filtro;
	private List<Marca> listaMarca;

	public void pesquisar() {
//		EntityManager em = JPAFactory.getEntityManager();
//		Query query = em.createQuery("Select a " + "From Marca a " + "Where upper(a.nome) like upper(:filtro)");
//		query.setParameter("filtro", "%" + getFiltro() + "%");
//		listaMarca = query.getResultList();

		MarcaRepository repo = new MarcaRepository();
		listaMarca = repo.findByNome(getFiltro());
	}


	@Override
	public Marca getEntity() {
		if (entity == null)
			entity = new Marca();
		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Marca> getListaMarca() {
		if (listaMarca == null)
			listaMarca = new ArrayList<Marca>();

		return listaMarca;
	}

}
