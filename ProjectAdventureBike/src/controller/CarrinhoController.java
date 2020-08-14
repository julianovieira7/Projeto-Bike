package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Carrinho;
import model.ItemPedido;
import model.Pedido;
import model.Usuario;

@Named
@ViewScoped
public class CarrinhoController extends Controller<Carrinho> {

	private static final long serialVersionUID = -7303558665258909306L;

	@Override
	public Carrinho getEntity() {
		if (entity == null) {
			entity = new Carrinho();
//			entity.setPedido(new Pedido());
//			entity.setUsuario(new Usuario());

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
			Util.addMessageWarn("� preciso estar logado para realizar uma pedido. Faca o Login!!");
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

}