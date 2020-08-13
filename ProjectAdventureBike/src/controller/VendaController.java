package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import repository.ProdutoRepository;

@Named
@ViewScoped
public class VendaController implements Serializable {

	private static final long serialVersionUID = 2230641043240396866L;
	private String nome;
	private List<Produto> listaProduto = null;

	public void pesquisar() {
		ProdutoRepository repo = new ProdutoRepository();
		setListaProduto(repo.findByNome(getNome()));
	}

	public void adicionar(int idProduto) {
		ProdutoRepository repo = new ProdutoRepository();
		Produto produto = repo.findById(idProduto);
		// verifica se existe um carrinho na sessao
		if (Session.getInstance().getAttribute("carrinho") == null) {
			// adiciona um carrinho (de itens de venda) na sessao
			Session.getInstance().setAttribute("carrinho", new ArrayList<ItemPedido>());
		}

		// obtendo o carrinho da sessao
		List<ItemPedido> carrinho = (ArrayList<ItemPedido>) Session.getInstance().getAttribute("carrinho");

		// criando um item de venda para adicionar no carrinho
		ItemPedido item = new ItemPedido();
		item.setProduto(produto);
		item.setValor(produto.getValor());

		// adicionando o item no carrinho (variavel local)
		carrinho.add(item);

		// atualizando o carrinho na sessao
		Session.getInstance().setAttribute("carrinho", carrinho);

		Util.addMessageInfo("Produto adicionado no carrinho. " + "Quantidade de Itens: " + carrinho.size());

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
