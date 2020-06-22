package model;

public enum Status {
	AGUARDANDO_APROVACAO(1, "Aguardando Aprovacao"), APROVADO(2, "Aprovado"), AGUARDANDO_PECAS(3, "Aguardando Pecas"), REALIZANDO_SERVICO(4, "Realizando Servico"), SERVICO_CONCLUIDO(5, "Servico Concluido"), FINALIZADO(6, "Finalizado");

	private int valueStatus;
	private String labelStatus;

	Status(int valueStatus, String labelStatus) {
		this.valueStatus = valueStatus;
		this.labelStatus = labelStatus;
	}

	public int getvalueStatus() {
		return valueStatus;
	}

	public String getLabelStatus() {
		return labelStatus;
	}

	public static Status valueOf(int valueStatus) {

		for (Status status : Status.values()) {
			if (status.getvalueStatus() == valueStatus)
				return status;
		}
		return null;
	}
}
