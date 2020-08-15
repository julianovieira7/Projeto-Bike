package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Carrinho;
import model.Estoque;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import model.Usuario;
import repository.CarrinhoRepository;

@Named
@ViewScoped
public class CarrinhoController extends Controller<Carrinho> {

	private static final long serialVersionUID = -7303558665258909306L;
	private Estoque estoque;
	

	@Override
	public Carrinho getEntity() {
		if (entity == null) {
			entity = new Carrinho();
			entity.setPedido(new Pedido());
			entity.setUsuario(new Usuario());

		}
		List<ItemPedido> carrinhoPedido = (ArrayList<ItemPedido>) Session.getInstance().getAttribute("carrinho");

		// adicionando os itens do carrinho na venda
		if (carrinhoPedido == null)
			carrinhoPedido = new ArrayList<ItemPedido>();
		entity.setListaItem(carrinhoPedido);
		return entity;
	}

	public void remover(Integer idProduto) {
		Usuario usuario = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
		if (usuario == null)
			Util.addMessageWarn("Eh preciso estar logado para realizar uma pedido. Faca o Login!!");
		else {
			List<ItemPedido> carrinho = (List<ItemPedido>) Session.getInstance().getAttribute("carrinho");

			for (ItemPedido itemPedido : carrinho) {
				System.out.println(itemPedido.getProduto().toString());
				System.out.println(idProduto);
				if (itemPedido.getProduto().getId().equals(idProduto)) {
					System.out.println("entreii");
					carrinho.remove(itemPedido);
					return;
				}
			}

		}
	}

	public String finalizar() {
//		Usuario usuario = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
//		if (usuario == null)
//			Util.addMessageWarn("Eh preciso estar logado para realizar uma pedido. Faca o Login!!");
//		else {
//		List<ItemPedido> carrinho = (List<ItemPedido>) Session.getInstance().getAttribute("carrinho");
	
//		}
//		if (usuario != null) {
//			// adicionando um ussuario na sessao
//			Session.getInstance().setAttribute("usuarioLogado", usuario);
//			// redirecionando para o template
//			if (usuario.getPerfil().getId() == 0)
		return "pedido.xhtml?faces-redirect=true";

//			else
//				return "login.xhtml?faces-redirect=true";
//
//		}
//		Util.addMessageError("Login ou Senha inv�lido.");
//		return "";
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

}