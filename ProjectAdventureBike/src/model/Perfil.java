package model;

import java.util.ArrayList;
import java.util.List;

public enum Perfil {

	FUNCIONARIO(0, "Funcionario"), CLIENTE(1, "Cliente");

	private int id;
	private String label;
	private List<String> paginasAcesso = null;

	private Perfil(int id, String label) {
		this.id = id;
		this.label = label;
		paginasAcesso = new ArrayList<String>();
		if (id == 0) {
			paginasAcesso.add("usuario.xhtml");
			paginasAcesso.add("usuariolisting.xhtml");
			paginasAcesso.add("fornecedor.xhtml");
			paginasAcesso.add("fornecedorlisting.xhtml");
			paginasAcesso.add("marcalisting.xhtml");
			paginasAcesso.add("tiporevisao.xhtml");
			paginasAcesso.add("tipoprodutolisting.xhtml");	
			paginasAcesso.add("tipoproduto.xhtml");
			paginasAcesso.add("produto.xhtml");
  		} else {
			paginasAcesso.add("estoque.xhtml");
			paginasAcesso.add("hello.xhtml");

		}

	}

	public List<String> getPaginasAcesso() {
		return paginasAcesso;
	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public static Perfil valueOf(int valor) {
		for (Perfil perfil : Perfil.values()) {
			if (valor == perfil.getId())
				return perfil;
		}
		return null;
	}

}
