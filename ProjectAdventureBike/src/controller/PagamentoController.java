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
public class PagamentoController extends Controller<Pagamento> {

	private static final long serialVersionUID = -7162310066105698526L;

	@Override
	public Pagamento getEntity() {
		if (entity == null) {
			entity.setFormaPagamento(new FormaPagamento());
		}
		return entity;
	}

}