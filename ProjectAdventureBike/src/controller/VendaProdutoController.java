package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.ItemPedido;
import model.Produto;
import model.Usuario;
import repository.ProdutoRepository;

@Named
@ViewScoped
public class VendaProdutoController implements Serializable {

	private static final long serialVersionUID = 2230641043240396866L;
	private String nome;
	private List<Produto> listaProduto = null;
	private Usuario usuario;
	private Produto produto;
	int quant;
	Double valorCarrinho = 0.00;

	private ItemPedido itemPedido;

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void pesquisar() {
		ProdutoRepository repo = new ProdutoRepository();
		setListaProduto(repo.findByNome(getNome()));
	}

	public String carrinho() {
//		if (usuario != null) {
//			// adicionando um ussuario na sessao
//			Session.getInstance().setAttribute("usuarioLogado", usuario);
//			// redirecionando para o template
//			if (usuario.getPerfil().getId() == 0)
		return "carrinho.xhtml?faces-redirect=true";
//			else
//				return "login.xhtml?faces-redirect=true";
//
//		}
//		Util.addMessageError("Login ou Senha inv�lido.");
//		return "";
	}

	public Double adicionar(int idProduto) {
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
		int i = 0;
		for (ItemPedido itemPedido : carrinho) {
			System.out.println(itemPedido.getProduto().toString());

			valorCarrinho = valorCarrinho + carrinho.get(i).getValor();
			quant = quant + carrinho.get(i).getQuantidade();
			i = i + 1;
			System.out.println("carrinho:" + carrinho.toString());
			System.out.println("quant: " + quant);
			System.out.println("valor do carrinho: " + valorCarrinho);

		}

		// atualizando o carrinho na sessao
		Session.getInstance().setAttribute("carrinho", carrinho);
		System.out.println(item.toString());
		Util.addMessageInfo("Produto adicionado no carrinho. " + "Quantidade de Itens: " + carrinho.size());
		return valorCarrinho;

	}

	public List<Produto> getListaProduto() {
		ProdutoRepository repo = new ProdutoRepository();
		if (listaProduto == null) {
			listaProduto = new ArrayList<Produto>();
			listaProduto = repo.findByAll();
			return listaProduto;
		} else {
			listaProduto = repo.findByNome(getNome());
			return listaProduto;
		}
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

//	public void clearMultiViewState() {
//		FacesContext context = FacesContext.getCurrentInstance();
//		String viewId = context.getViewRoot().getViewId();
//		PrimeFaces.current().multiViewState().clearAll(viewId, true, (clientId) -> {
//			showMessage(clientId);
//		});
//	}
//
//	private void showMessage(String clientId) {
//		FacesContext.getCurrentInstance().addMessage(null,
//				new FacesMessage(FacesMessage.SEVERITY_INFO, clientId + " multiview state has been cleared out", null));
//	}
}
