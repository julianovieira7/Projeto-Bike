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
		usuario = getUsuario(getEntity().getNome(), hashSenha);
		if (usuario != null) {
			Util.addMessageInfo("Login com sucesso.");
			return "usuario.xhtml?faces-redirect=true";
		}
		Util.addMessageError("Usuario ou senha incorretos.");
		return null;
	}
//	public String envia() {
//        
//	    usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
//	    if (usuario == null) {
//	      usuario = new Usuario();
//	      FacesContext.getCurrentInstance().addMessage(
//	         null,
//	         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usu�rio n�o encontrado!",
//	           "Erro no Login!"));
//	      return null;
//	    } else {
//	          return "/main";
//	    }
//	         

//	  }

	public Usuario getUsuario(String email, String senha) {

		try {
			EntityManager em = JPAFactory.getEntityManager();
			Query query = em.createQuery("SELECT a " + "From Usuario a " + "where a.email = :email and a.senha = :senha");
			query.setParameter("email", email);
			query.setParameter("senha", senha);

			return entity;
		} catch (NoResultException e) {
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
