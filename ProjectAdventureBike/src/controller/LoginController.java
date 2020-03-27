package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import application.Util;
import factory.JPAFactory;
import model.Usuario;

@Named
@RequestScoped
public class LoginController extends Controller<Usuario> {

	private static final long serialVersionUID = 1466023629247610838L;
	private Usuario usuario;

	public String logar() {

		String hashSenha = Util.hashSHA256(getEntity().getSenha());
		usuario = login(getEntity().getEmail(), hashSenha);
		if (usuario == null) {
			Util.addMessageError("Usuario ou senha incorretos.");
			return null;
			
		}
		Util.addMessageInfo("Login com sucesso.");
		return "usuario.xhtml?faces-redirect=true";
	
	}

	public Usuario login(String email, String senha) {

		try {
			EntityManager em = JPAFactory.getEntityManager();
			Query query = em.createQuery("SELECT a " + "From Usuario a " + "where a.email = :email and a.senha = :senha");
			query.setParameter("email", email);
			query.setParameter("senha", senha);
			usuario = (Usuario) query.getSingleResult();
			return usuario;
		} catch (NoResultException e) {
			Util.addMessageError("nao foi possivel buscar no banco de dados");
			return null;
		}
	}

	public void limpar() {
		entity = new Usuario();
	}

	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}
}
