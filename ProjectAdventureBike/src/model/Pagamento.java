package model;

public class Pagamento {
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
}
