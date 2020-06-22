package model;

public enum TipoCartao {
	CREDITO(1, "Cedito"), DEBITO(2, "Debito");

	private int valueTipoCartao;
	private String labelTipoCartao;

	TipoCartao(int valueTipoCartao, String labelTipoCartao) {
		this.valueTipoCartao = valueTipoCartao;
		this.labelTipoCartao = labelTipoCartao;
	}

	public int getvalueTipoCartao() {
		return valueTipoCartao;
	}

	public String getLabelTipoCartao() {
		return labelTipoCartao;
	}

	public static TipoCartao valueOf(int valueTipoCartao) {

		for (TipoCartao tipoCartao : TipoCartao.values()) {
			if (tipoCartao.getvalueTipoCartao() == valueTipoCartao)
				return tipoCartao;
		}
		return null;
	}
}
