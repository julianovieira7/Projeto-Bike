package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Boleto;

@Named
@ViewScoped
public class BoletoController extends Controller<Boleto> {

	private static final long serialVersionUID = 6383078321255244240L;

	@Override
	public Boleto getEntity() {
		if (entity == null) {
			entity = new Boleto();
		}
		return entity;
	}

}