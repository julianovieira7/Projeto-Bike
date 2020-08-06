package model;

public enum Modalidade {

	URBANA(0, "Urbana"), BMX(0, "BMX"), ESTRADA(0, "Estrada"), DOWNHILL(1, "Downhill");

	private int id;
	private String modalidade;

	private Modalidade(int id, String modalidade) {
		this.id = id;
		this.modalidade = modalidade;

	}

	public int getId() {
		return id;
	}

	public String modalidade() {
		return modalidade;
	}

	public static Modalidade valueOf(int valor) {
		for (Modalidade bicicleta : Modalidade.values()) {
			if (valor == bicicleta.getId())
				return bicicleta;
		}
		return null;
	}

}
