package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Bandeira;
import model.Boleto;
import model.CartaoCredito;
import model.FormaPagamento;
import model.TipoCartao;

@Named
@ViewScoped
public class FormaPagamentoController extends Controller<FormaPagamento> {

	private static final long serialVersionUID = -3182998839416333203L;



	@Override
	public FormaPagamento getEntity() {
		if (entity == null) {
			entity = new FormaPagamento();
		}
		System.out.println(entity.toString());
		return entity;
	}
}