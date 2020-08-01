package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Fornecedor;
import repository.FornecedorRepository;

@Named
@ViewScoped
public class FornecedorListing extends Listing<Fornecedor> {

	private static final long serialVersionUID = -2853437258107472756L;
	private List<Fornecedor> list;
	private String filtro;
	private Integer filtroIdTelefone = null;

	public FornecedorListing() {
		super(Fornecedor.class);
		// obtendo a informacao da sessao e remover o objeto da sessao
		// filtroIdEstado = (Integer)
		// Session.getInstance().getAttributeAndRemove("idEstado");
		filtroIdTelefone = (Integer) getObjectSession("idTelefone");
	}

	public void open() {
		open(null);
	}

	public void open(Integer idTelefone) {
		if (idTelefone != null) {
			// adicionando o idEstado na sessao
//			Session.getInstance().setAttribute("idEstado", idEstado);
			addObjectSession("idTelefone", idTelefone);
		}

		Map<String, Object> options = new HashMap<String, Object>();
		options.put("resizable", true);
		options.put("draggable", true);
		options.put("modal", true);
		options.put("width", 800);
		options.put("height", 500);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");

		// ligacao com a pagina xhtml
		PrimeFaces.current().dialog().openDynamic("fornecedorlisting", options, null);

	}

	public void pesquisar() {

		FornecedorRepository repo = new FornecedorRepository();
		if (getFiltroIdTelefone() == null)
			setList(repo.findByNome(getFiltro()));
		else
			setList(repo.findByNome(getFiltro(), getFiltroIdTelefone()));
	}

	public List<Fornecedor> getList() {
		if (list == null)
			list = new ArrayList<Fornecedor>();
		return list;
	}

	public void setList(List<Fornecedor> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public Integer getFiltroIdTelefone() {
		return filtroIdTelefone;
	}

	public void setFiltroIdTelefone(Integer filtroIdTelefone) {
		this.filtroIdTelefone = filtroIdTelefone;
	}

}
