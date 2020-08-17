package controller;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Carrinho;
import model.Endereco;
import model.ItemPedido;
import model.Pedido;
import model.Telefone;
import model.Usuario;
import repository.ProdutoRepository;

@Named
@ViewScoped
public class PedidoController extends Controller<Pedido> {

	private static final long serialVersionUID = 8702988121934899052L;
	private Carrinho carrinho;

	public Carrinho getCarrinho() {
		if (carrinho == null) {
			setCarrinho(new Carrinho());
			carrinho.setPedido(new Pedido());
			carrinho.setUsuario(new Usuario());
		}
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public PedidoController() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.keep("carrinhoFlash");
		getCarrinho().setListaItem((List<ItemPedido>) flash.get("carrinhoFlash"));
		getCarrinho().setUsuario((Usuario) Session.getInstance().getAttribute("usuarioLogado"));
		System.out.println("entreiii");
		System.out.println(getCarrinho().toString());
	}

	@Override
	public void salvar() {
		entity.setCarrinho(entity.getCarrinho());
		super.salvar();
	}

	@Override
	public Pedido getEntity() {
		if (entity == null) {
			setEntity(new Pedido());
			entity.setCarrinho(new Carrinho());
		}
		return null;
	}

	public void formaPagamento() {

		Util.redirect("/faces/formapagamento.xhtml?faces-redirect=true");
	}
}
