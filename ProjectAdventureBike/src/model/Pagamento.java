package model;

import model.validation.Validation;

public class Pagamento extends DefaultEntity<Pagamento>{

	private static final long serialVersionUID = 780279237308232494L;
	private Pedido pedido;
	private BikeRevisao bikeRevisao;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public BikeRevisao getBikeRevisao() {
		return bikeRevisao;
	}

	public void setBikeRevisao(BikeRevisao bikeRevisao) {
		this.bikeRevisao = bikeRevisao;
	}

	@Override
	public Validation<Pagamento> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}
}
