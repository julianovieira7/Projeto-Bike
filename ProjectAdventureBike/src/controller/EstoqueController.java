package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.FornecedorListing;
import model.Estoque;
import model.Fornecedor;
import model.Telefone;

@Named
@ViewScoped
public class EstoqueController extends Controller<Estoque> {

	private static final long serialVersionUID = -6051599150675827361L;
	private Telefone telefone;

	@Override
	public Estoque getEntity() {
		if (entity == null) {
			entity = new Estoque();
			entity.setFornecedor(new Fornecedor());
			entity.getFornecedor().setTelefone(new Telefone());
		}
		return entity;
	}

	public void abrirForncedorListing() {
		FornecedorListing listing = new FornecedorListing();
		listing.open();
	}

	public void obterFornecedorListing(SelectEvent event) {
		Fornecedor entity = (Fornecedor) event.getObject();
		getEntity().setFornecedor(entity);
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
}
