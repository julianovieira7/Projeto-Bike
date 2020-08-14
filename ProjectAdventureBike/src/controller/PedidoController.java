package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

import application.Session;
import application.Util;
import factory.JPAFactory;
import model.Carrinho;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import repository.CarrinhoRepository;
import repository.FornecedorRepository;
import repository.ProdutoRepository;
import repository.Repository;

@Named
@ViewScoped
public class PedidoController extends Controller<Pedido> {

	private static final long serialVersionUID = 8702988121934899052L;
	private String nome;
	private List<Produto> listaProduto = null;

	@Override
	public Pedido getEntity() {
		if (entity == null) {
			setEntity(new Pedido());
			entity.setCarrinho(new Carrinho());
		}
		return null;
	}

	public void pesquisar() {
		ProdutoRepository repo = new ProdutoRepository();
		setListaProduto(repo.findByNome(getNome()));
	}

	public List<Produto> getListaProduto() {
		if (listaProduto == null) {
			ProdutoRepository repo = new ProdutoRepository();
			listaProduto = repo.findByNome(getNome());
			if (listaProduto == null)
				listaProduto = new ArrayList<Produto>();
		}
		return listaProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}



}
