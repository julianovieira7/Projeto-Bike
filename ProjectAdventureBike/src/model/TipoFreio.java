package model;

public enum TipoFreio {
	DISCO(1, "Disco"), HIDRAULICO(2, "Hidraulico"), VBRAKE(3, "VBrake"), CANTILEVER(4, "Cantilever");

	private int valueTipoFreio;
	private String labelTipoFreio;

	TipoFreio(int valueTipoFreio, String labelTipoFreio) {
		this.valueTipoFreio = valueTipoFreio;
		this.labelTipoFreio = labelTipoFreio;
	}

	public int getvalueTipoFreio() {
		return valueTipoFreio;
	}

	public String getLabelTipoFreio() {
		return labelTipoFreio;
	}

	public static TipoFreio valueOf(int valueTipoFreio) {

		for (TipoFreio tipoFreio : TipoFreio.values()) {
			if (tipoFreio.getvalueTipoFreio() == valueTipoFreio)
				return tipoFreio;
		}
		return null;
	}
}
