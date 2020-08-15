package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import application.Util;
import controller.listing.UsuarioListing;
import model.Endereco;
import model.Perfil;
import model.Telefone;
import model.Usuario;
import repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> {

	private static final long serialVersionUID = 6037007969793097884L;
	private String filtro;
	private List<Usuario> listaUsuario;
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

	public void pesquisar() {

		UsuarioRepository repo = new UsuarioRepository();

		listaUsuario = repo.findByNome(getFiltro());
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

	public void abrirUsuarioListing() {
		UsuarioListing listing = new UsuarioListing();
		listing.open();
	}

	public void obterUsuarioListing(SelectEvent event) {
		Usuario entity = (Usuario) event.getObject();
		setEntity(entity);
		if (getEntity().getEndereco() == null) {
			getEntity().setEndereco(new Endereco());
		}
	}

	public Perfil[] getListaPerfil() {
		return Perfil.values();
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
		super.salvar();
	}

	public String getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(String auxiliar) {
		this.auxiliar = auxiliar;
	}

}
