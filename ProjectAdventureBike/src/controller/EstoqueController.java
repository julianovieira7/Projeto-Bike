package controller;

import org.primefaces.event.SelectEvent;

import controller.listing.FornecedorListing;
import model.Estoque;
import model.Fornecedor;

public class EstoqueController extends Controller<Estoque> {

	private static final long serialVersionUID = -6051599150675827361L;

	@Override
	public Estoque getEntity() {
		if (entity == null) {
			entity = new Estoque();
			entity.setFornecedor(new Fornecedor());
//			entity.setProduto(new Produto());
		}
		return null;
	}

	public void abrirFornecedorListing() {
		FornecedorListing listing = new FornecedorListing();
		listing.open();
	}

	public void obterFornecedorListing(SelectEvent event) {
		entity = (Estoque) event.getObject();
		if (getEntity().getFornecedor() == null) {
			getEntity().setFornecedor(new Fornecedor());
		}
		setEntity(entity);
	}

}
