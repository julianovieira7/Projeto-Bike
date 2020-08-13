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
	private Carrinho carrinho;

	public Carrinho getCarrinho() {
		if (carrinho == null)
			carrinho = new Carrinho();
		List<ItemPedido> carrinhoPedido = (ArrayList<ItemPedido>) Session.getInstance().getAttribute("carrinho");

		// adicionando os itens do carrinho na venda
		if (carrinhoPedido == null)
			carrinhoPedido = new ArrayList<ItemPedido>();
		carrinho.setListaItem(carrinhoPedido);
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public void remover(Integer idProduto) {
		Usuario usuario = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
		if (usuario == null)
			Util.addMessageWarn("É preciso estar logado para realizar uma pedido. Faca o Login!!");
		else {
			List<ItemPedido> carrinho = (List<ItemPedido>) Session.getInstance().getAttribute("carrinho");

			for (ItemPedido itemPedido : carrinho) {
				if (itemPedido.getProduto().getId().equals(idProduto)) {
					carrinho.remove(itemPedido);
					return;
				}
			}
		}
	}

	@Override
	public void salvar() {
		Usuario usuario = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
		if (usuario == null) {
			Util.addMessageWarn("É preciso estar logado para realizar uma venda. Faca o Login!!");
			return;
		}
		Pedido pedido = new Pedido();

		pedido.setNumeroPedido("12345");
		pedido.setValorTotal(carrinho.getValorCarrinho());

		Carrinho carrinho = new Carrinho();
		carrinho.setUsuario(usuario);
		List<ItemPedido> carrinhoPedido = (ArrayList<ItemPedido>) Session.getInstance().getAttribute("carrinho");
		carrinho.setListaItem(carrinhoPedido);
		System.out.println(carrinho);
		super.salvar();
		Util.addMessageInfo("Venda realizada com sucesso.");
		// limpando o carrinho
		Session.getInstance().setAttribute("carrinho", null);
	}

	@Override
	public Carrinho getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
