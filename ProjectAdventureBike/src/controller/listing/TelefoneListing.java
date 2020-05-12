package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.PrimeFaces;

import factory.JPAFactory;
import model.Telefone;
import repository.TelefoneRepository;

@Named
@ViewScoped
public class TelefoneListing extends Listing<Telefone> {

	private static final long serialVersionUID = -7887976623545341109L;
	private List<Telefone> list;
	private String filtro;

	@Override
	public Telefone getEntity() {
		if (entity == null)
			entity = new Telefone();
		return entity;
	}

	public void open() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("resizable", true);
		options.put("draggable", true);
		options.put("modal", true);
		options.put("width", 800);
		options.put("height", 500);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		// ligacao com a pagina xhtml
		PrimeFaces.current().dialog().openDynamic("telefonelisting", options, null);
	}

	public void pesquisar() {
		TelefoneRepository repo = new TelefoneRepository();
		setList(repo.findByCodigoArea(getFiltro()));
	}

	public void select(int id) {
		EntityManager em = JPAFactory.getEntityManager();
		setEntity((Telefone) em.find(Telefone.class, id));

		// retorna o objeto via dialogreturn e finaliza o dialog
		PrimeFaces.current().dialog().closeDynamic(getEntity());
	}

	public List<Telefone> getList() {
		if (list == null)
			list = new ArrayList<Telefone>();
		return list;
	}

	public void setList(List<Telefone> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
