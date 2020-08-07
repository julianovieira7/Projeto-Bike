package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import application.Session;
import application.Util;
import factory.JPAFactory;
import model.Usuario;
import repository.UsuarioRepository;

@Named
@RequestScoped
public class LoginController {

	private Usuario usuario;

//	public String logar() {
//
//		String hashSenha = Util.hashSHA256(getUsuario().getSenha());
//		usuario = getUsuario(getUsuario().getNome(), hashSenha);
//
//		if (usuario != null) {
//			// adicionando um ussuario na sessao
//			Session.getInstance().setAttribute("usuarioLogado", usuario);
//			// redirecionando para o template
//			return "professor.xhtml?faces-redirect=true";
//		}
//		Util.addMessageError("Usuario ou senha incorretos.");
//		return null;
//	}

	public String logar() {
		String hashSenha = Util.hashSHA256(getUsuario().getSenha());
		UsuarioRepository repo = new UsuarioRepository();
		Usuario usuarioLogin = repo.verificarLoginSenha(getUsuario().getEmail(), getUsuario().getSenha());

		if (usuario != null) {
			if ( usuarioLogin.equals(hashSenha)) {
			// adicionando um ussuario na sessao
			Session.getInstance().setAttribute("usuarioLogado", usuario);
			// redirecionando para o template
			return "professor.xhtml?faces-redirect=true";
			}
		}
		Util.addMessageError("Login ou Senha inválido.");
		return "";
	}

	public Usuario getUsuario(String email, String senha) {

		try {
			EntityManager em = JPAFactory.getEntityManager();
			Query query = em
					.createQuery("SELECT a " + "From Usuario a " + "where a.email = :email and a.senha = :senha");
			query.setParameter("email", email);
			query.setParameter("senha", senha);

			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}

	public void limpar() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}
}
