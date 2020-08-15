package controller;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

	private String auxiliar;

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
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = (Date) formatter.parse(getAuxiliar());
			getEntity().setDataAniversario(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Util.addMessageWarn("Data incorreta");
			e.printStackTrace();

		}
		String hashSenha = Util.hashSHA256(getEntity().getSenha());
		getEntity().setSenha(hashSenha);
		getEntity().setPerfil(Perfil.CLIENTE);
		UsuarioRepository repo = new UsuarioRepository();
		if (repo.containsCpf(entity.getId(), entity.getCpf())) {
			Util.addMessageError("CPF já cadastrado no sistema");
		}

		else if(repo.contains(entity.getId(), entity.getEmail())) {
			Util.addMessageError("Email já cadastrado no sistema");
		}
		else
			super.salvar();
	}

	public String getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(String auxiliar) {
		this.auxiliar = auxiliar;
	}

}
