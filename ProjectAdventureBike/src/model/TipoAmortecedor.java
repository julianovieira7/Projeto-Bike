package model;

public enum TipoAmortecedor {
	HIDRAULICO(1, "Hidraulico"), MOLAS(2, "Molas");

	private int valueTipoAmortecedor;
	private String labelTipoAmortecedor;

	TipoAmortecedor(int valueTipoAmortecedor, String labelTipoAmortecedor) {
		this.valueTipoAmortecedor = valueTipoAmortecedor;
		this.labelTipoAmortecedor = labelTipoAmortecedor;
	}

	public int getvalueTipoAmortecedor() {
		return valueTipoAmortecedor;
	}

	public String getLabelTipoAmortecedor() {
		return labelTipoAmortecedor;
	}

	public static TipoAmortecedor valueOf(int valueTipoAmortecedor) {

		for (TipoAmortecedor tipoAmortecedor : TipoAmortecedor.values()) {
			if (tipoAmortecedor.getvalueTipoAmortecedor() == valueTipoAmortecedor)
				return tipoAmortecedor;
		}
		return null;
	}
}
