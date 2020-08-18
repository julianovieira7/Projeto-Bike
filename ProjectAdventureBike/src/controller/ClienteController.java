package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Util;
import model.Endereco;
import model.Perfil;
import model.Telefone;
import model.Usuario;
import repository.UsuarioRepository;

@Named
@ViewScoped
public class ClienteController extends Controller<Usuario> {

	private static final long serialVersionUID = 8472571017501862875L;

	@Override
	public Usuario getEntity() {
		if (entity == null) {
			entity = new Usuario();
			entity.setEndereco(new Endereco());
			entity.setTelefone(new Telefone());
		}
		return entity;
	}

	@Override
	public void salvar() {

		String hashSenha = Util.hashSHA256(getEntity().getSenha());
		getEntity().setSenha(hashSenha);
		getEntity().setPerfil(Perfil.CLIENTE);
		UsuarioRepository repo = new UsuarioRepository();
		if (repo.containsCpf(entity.getId(), entity.getCpf())) {
			Util.addMessageError("CPF ja cadastrado no sistema");
		}

		else if (repo.contains(entity.getId(), entity.getEmail())) {
			Util.addMessageError("Email ja cadastrado no sistema");
		} else
			super.salvar();
	}

}
