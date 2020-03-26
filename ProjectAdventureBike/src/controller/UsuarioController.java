package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import application.Util;
import factory.JPAFactory;
import model.Usuario;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> {

	private static final long serialVersionUID = 1224938570870359021L;
	private String filtro;
	private List<Usuario> listaUsuario;

	public void pesquisar() {
		EntityManager em = JPAFactory.getEntityManager();
		Query query = em.createQuery("Select a " + "From Usuario a " + "Where upper(a.nome) like upper(:filtro)");
		query.setParameter("filtro", "%" + getFiltro() + "%");
		listaUsuario = query.getResultList();
	}

	public void incluir() {
		if (validarDados()) {
			EntityManager em = JPAFactory.getEntityManager();
			em.getTransaction().begin();
			getEntity().setSenha(Util.hashSHA256(getEntity().getSenha()));
			
			setEntity(em.merge(getEntity()));
			em.remove(getEntity());

			em.getTransaction().commit();
			
			Util.addMessageInfo("Inclusao realizada com sucesso.");
			limpar();

		}
	}

	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
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

	private boolean validarDados() {
		if (getEntity().getSenha().isBlank()) {
			Util.addMessageWarn("O campo senha deve ser informado.");
			return false;
		}
		return true;
	}

}
