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
import model.Endereco;
import repository.EnderecoRepository;


@Named
@ViewScoped
public class EnderecoListing extends Listing<Endereco> {

	private static final long serialVersionUID = 9153322617511078414L;
	private List<Endereco> list;
	private String filtro;

	public EnderecoListing() {
		super(Endereco.class);
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
		PrimeFaces.current().dialog().openDynamic("enderecolisting", options, null);
	}

	public void pesquisar() {
		EnderecoRepository repo = new EnderecoRepository();
		setList(repo.findByRua(getFiltro()));
	}

	public List<Endereco> getList() {
		if (list == null)
			list = new ArrayList<Endereco>();
		return list;
	}

	public void setList(List<Endereco> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
