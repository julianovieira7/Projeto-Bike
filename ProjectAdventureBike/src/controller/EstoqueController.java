package controller;

import java.util.ArrayList;
import java.util.List;

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
	private List<Estoque> listaEstoque;
	private Telefone telefone;

	@Override
	public Estoque getEntity() {
		if (entity == null) {
			entity = new Estoque();
			entity.setFornecedor(new Fornecedor());
			entity.getFornecedor().setTelefone(new Telefone());
//			entity.setProduto(new Produto());
		}
		return null;
	}

	public void abrirFornecedorListing() {
		FornecedorListing listing = new FornecedorListing();
		listing.open(getEntity().getFornecedor().getTelefone().getId());
	}

	public void obterFornecedorListing(SelectEvent event) {
		Fornecedor entity = (Fornecedor) event.getObject();
		getEntity().setFornecedor(entity);
	}

	public List<Estoque> getListaEstoque() {
		if (listaEstoque == null)
			listaEstoque = new ArrayList<Estoque>();
		return listaEstoque;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public void setListaEstoque(List<Estoque> listaEstoque) {
		this.listaEstoque = listaEstoque;
	}

//	public static void main(String[] args) {
//		FornecedorController fornecedor1 = new FornecedorController();
//		fornecedor1.getEntity();
//
//		EstoqueController estoque = new EstoqueController();
//
//		estoque.getEntity().setFornecedor(fornecedor1.getEntity());
//		estoque.getEntity().setNotaFiscal("1234");
//		estoque.getEntity().setPrecoCompra(50.0);
//		estoque.getEntity().setQuantidade(5);
//		estoque.salvar();
//	}

}
