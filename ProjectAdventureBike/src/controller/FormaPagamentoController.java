package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Bandeira;
import model.Boleto;
import model.CartaoCredito;
import model.FormaPagamento;
import model.Pagamento;
import model.Pedido;
import model.TipoCartao;

@Named
@ViewScoped
public class FormaPagamentoController extends Controller<FormaPagamento> {

	private static final long serialVersionUID = -2366975003335403351L;
	private Pedido pedido;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void CartaoCredito() {

	}

	@Override
	public FormaPagamento getEntity() {
		if (entity == null) {
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