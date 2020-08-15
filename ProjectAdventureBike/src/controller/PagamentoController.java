package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Bandeira;
import model.Pagamento;
import model.Pedido;
import model.QuantMarcha;

@Named
@ViewScoped
public class PagamentoController extends Controller<Pagamento> {

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
	public Pagamento getEntity() {
		return null;
	}
	public Bandeira[] getListaBandeira() {
		return Bandeira.values();
	}

	public QuantMarcha[] getListaQuantMarcha() {
		return QuantMarcha.values();
	}
}