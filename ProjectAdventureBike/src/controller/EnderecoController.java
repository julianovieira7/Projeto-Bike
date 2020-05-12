package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.EnderecoListing;
import model.Endereco;

@Named
@ViewScoped
public class EnderecoController extends Controller<Endereco> {

	private static final long serialVersionUID = 8308631606824671090L;

	@Override
	public Endereco getEntity() {
		if (entity == null) {
			entity = new Endereco();
		}
		return entity;
	}

	public void abrirEnderecoListing() {
		EnderecoListing listing = new EnderecoListing();
		listing.open();
	}

	public void obterEnderecoListing(SelectEvent event) {
		Endereco entity = (Endereco) event.getObject();
		setEntity(entity);
	}

}
