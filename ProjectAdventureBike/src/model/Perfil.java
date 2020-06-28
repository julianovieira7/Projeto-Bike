package model;

public enum Perfil {
	ADMINISTRADOR(1, "Administrador"), USUARIO(2, "Usuario"), FUNCIONARIO(3, "Funcionario");

	private int valuePerfil;
	private String labelPerfil;

	Perfil(int valuePerfil, String labelPerfil) {
		this.valuePerfil = valuePerfil;
		this.labelPerfil = labelPerfil;
	}

	public int getvaluePerfil() {
		return valuePerfil;
	}

	public String getLabelPerfil() {
		return labelPerfil;
	}

	public static Perfil valueOf(int valuePerfil) {

		for (Perfil perfil : Perfil.values()) {
			if (perfil.getvaluePerfil() == valuePerfil)
				return perfil;
		}
		return null;
	}
}
