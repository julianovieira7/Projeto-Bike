package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import factory.JPAFactory;
import model.Bandeira;
import model.Boleto;
import model.CartaoCredito;
import model.FormaPagamento;
import model.Pedido;
import model.TipoCartao;

@Named
@ViewScoped
public class FormaPagamentoController extends Controller<FormaPagamento> {

	private static final long serialVersionUID = -3182998839416333203L;

	@Override
	public void salvar() {
//		PedidoController pedido = new PedidoController();
//		CarrinhoController carrinho = new CarrinhoController();
//		pedido.salvar();
//		carrinho.salvar();
		super.salvar();
	}

	@Override
	public FormaPagamento getEntity() {
		if (entity == null) {
			entity = new FormaPagamento();
			entity.setBoleto(new Boleto());
			entity.setCartaoCredito(new CartaoCredito());
		}
		System.out.println(entity.toString());
		return entity;
	}

	public Bandeira[] getListaBandeira() {
		return Bandeira.values();
	}

	public TipoCartao[] getListaTipoCartao() {
		return TipoCartao.values();
	}
}