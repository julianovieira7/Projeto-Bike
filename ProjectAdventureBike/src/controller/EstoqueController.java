package controller;

import java.util.ArrayList;
import java.util.List;

import model.Estoque;
import model.Fornecedor;
import model.Produto;
import repository.FornecedorRepository;

public class EstoqueController extends Controller<Estoque> {

	private static final long serialVersionUID = -6051599150675827361L;
	private String filtro;
	private List<Fornecedor> listaFornecedor;
	public FornecedorController fornecedorController = new FornecedorController();

	@Override
	public Estoque getEntity() {
		if (entity == null) {
			entity = new Estoque();
			entity.setFornecedor(new Fornecedor());
			entity.setProduto(new Produto());
		}
		return null;
	}

	public void pesquisaFornecedor() {

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
