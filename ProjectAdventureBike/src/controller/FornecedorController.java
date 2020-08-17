package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import application.Util;
import controller.listing.FornecedorListing;
import model.Fornecedor;
import model.Telefone;
import repository.FornecedorRepository;

@Named
@ViewScoped
public class FornecedorController extends Controller<Fornecedor> {

	private static final long serialVersionUID = -7045218033418684119L;
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

	@Override
	public void salvar() {
		FornecedorRepository repo = new FornecedorRepository();
		if (repo.containsCnpj(entity.getId(), entity.getCnpj()))
			Util.addMessageWarn("CNPJ j� cadastrado no sistema");
		else
		super.salvar();

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

	public void abrirFornecedorListing() {
		FornecedorListing listing = new FornecedorListing();
		listing.open();
	}

	public void obterFornecedorListing(SelectEvent event) {
		Fornecedor entity = (Fornecedor) event.getObject();
		setEntity(entity);
		if (getEntity().getTelefone() == null) {
			getEntity().setTelefone(new Telefone());
		}
	}

}
