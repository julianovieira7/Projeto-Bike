package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import application.RepositoryException;
import application.Util;
import controller.listing.EnderecoListing;
import controller.listing.TelefoneListing;
import model.Endereco;
import model.Telefone;
import model.Usuario;
import repository.Repository;
import repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> {

	private static final long serialVersionUID = 1224938570870359021L;
	private String filtro;
	private List<Usuario> listaUsuario;

	public void pesquisar() {
//		EntityManager em = JPAFactory.getEntityManager();
//		Query query = em.createQuery("Select a " + "From Usuario a " + "Where upper(a.nome) like upper(:filtro)");
//		query.setParameter("filtro", "%" + getFiltro() + "%");
//		listaUsuario = query.getResultList();

		UsuarioRepository repo = new UsuarioRepository();
		// metodo(string pesquisa)
		// if(get ==
		listaUsuario = repo.findByNome(getFiltro());
	}

	public void abrirEnderecoListing() {
		EnderecoListing listing = new EnderecoListing();
		listing.open();
	}

	public void obterEstadoListing(SelectEvent event) {
		Endereco entity = (Endereco) event.getObject();
		getEntity().setEndereco(entity);
	}

	public void abrirTelefoneListing() {
		TelefoneListing listing = new TelefoneListing();
		listing.open();
	}

	public void obterTelefoneListing(SelectEvent event) {
		Telefone entity = (Telefone) event.getObject();
		getEntity().setTelefone(entity);
	}

	@Override
	public void salvar() {

		Repository<Usuario> r = new Repository<Usuario>();
		try {
			r.beginTransaction();
			getEntity().setSenha(Util.hashSHA256(getEntity().getSenha()));

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
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		entity.setEndereco(new Endereco());
		entity.setTelefone(new Telefone());

		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null)
			listaUsuario = new ArrayList<Usuario>();

		return listaUsuario;
	}

}
