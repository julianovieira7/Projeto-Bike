package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.CartaoCredito;

@Named
@ViewScoped
public class CartaoCreditoController extends Controller<CartaoCredito> {

	private static final long serialVersionUID = -118637159232779482L;

	@Override
	public CartaoCredito getEntity() {
		if (entity == null) {
			entity = new CartaoCredito();
		}
		return entity;
	}

}