package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Fornecedor;
import model.Telefone;
import repository.FornecedorRepository;

@Named
@ViewScoped
public class FornecedorController extends Controller<Fornecedor> {

	private static final long serialVersionUID = 7168594880484364032L;
	private String filtro;
	private List<Fornecedor> listaFornecedor;

	@Override
	public Fornecedor getEntity() {
		if (entity == null) {
			entity = new Fornecedor();
			entity.setTelefone(new Telefone());
		}
		return entity;
	}

	public void pesquisar() {

		FornecedorRepository repo = new FornecedorRepository();

		listaFornecedor = repo.findByNome(getFiltro());
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Fornecedor> getListaFornecedor() {
		if (listaFornecedor == null)
			listaFornecedor = new ArrayList<Fornecedor>();
		return listaFornecedor;
	}

}
