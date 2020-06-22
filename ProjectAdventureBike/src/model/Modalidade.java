package model;

public enum Modalidade {

	URBANA(1, "Urbana"), ESTRADA(2, "Estrada"), BMX(3, "Bmx"), DOWNHILL(4, "Downhill");

	private int valueModalidade;
	private String labelModalidade;

	Modalidade(int valueModalidade, String labelModalidade) {
		this.valueModalidade = valueModalidade;
		this.labelModalidade = labelModalidade;
	}

	public int getvalueModalidade() {
		return valueModalidade;
	}

	public String getLabelModalidade() {
		return labelModalidade;
	}

	public static Modalidade valueOf(int valueModalidade) {

		for (Modalidade modalidade : Modalidade.values()) {
			if (modalidade.getvalueModalidade() == valueModalidade)
				return modalidade;
		}
		return null;
	}
}
