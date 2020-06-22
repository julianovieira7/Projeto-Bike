package model;

public enum TamanhoCambio {
	OITOV(1, "OitoV"), NOVEV(2, "Novev"), DEZV(3, "DezV"), ONZEV(4, "OnzeV"), DOZEV(5, "DozeV");

	private int valueTamanhoCambio;
	private String labelTamanhoCambio;

	TamanhoCambio(int valueTamanhoCambio, String labelTamanhoCambio) {
		this.valueTamanhoCambio = valueTamanhoCambio;
		this.labelTamanhoCambio = labelTamanhoCambio;
	}

	public int getvalueTamanhoCambio() {
		return valueTamanhoCambio;
	}

	public String getLabelTamanhoCambio() {
		return labelTamanhoCambio;
	}

	public static TamanhoCambio valueOf(int valueTamanhoCambio) {

		for (TamanhoCambio tamanhoCambio : TamanhoCambio.values()) {
			if (tamanhoCambio.getvalueTamanhoCambio() == valueTamanhoCambio)
				return tamanhoCambio;
		}
		return null;
	}
}
