package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import application.RepositoryException;
import application.Util;
import model.Marca;
import repository.Repository;
import repository.MarcaRepository;

@Named
@ViewScoped
public class MarcaController extends Controller<Marca> {

	private static final long serialVersionUID = 2333039604454379146L;
	private String filtro;
	private List<Marca> listaMarca;

	public void pesquisar() {
		MarcaRepository repo = new MarcaRepository();
		listaMarca = repo.findByNome(getFiltro());
	}

	@Override
	public void salvar() {

		Repository<Marca> r = new Repository<Marca>();
		try {
			r.beginTransaction();
			r.salvar(getEntity());
			r.commitTransaction();
		} catch (RepositoryException e) {
			e.printStackTrace();
			r.rollbackTransaction();
			Util.addMessageError("Problema ao salvar.");
			return;
		}

		Util.addMessageInfo("Inclusao realizada com sucesso.");
		limpar();

	}

	@Override
	public Marca getEntity() {
		if (entity == null)
			entity = new Marca();

		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Marca> getListaMarca() {
		if (listaMarca == null)
			listaMarca = new ArrayList<Marca>();

		return listaMarca;
	}

}
