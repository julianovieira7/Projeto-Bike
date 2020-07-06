package model;

public class ItemRevisao extends BikeRevisao{

	private static final long serialVersionUID = 8702882077561727083L;
	private String itemRevisao;
	private BikeRevisao bikeRevisao;

	public String getItemRevisao() {
		return itemRevisao;
	}

	public void setItemRevisao(String itemRevisao) {
		this.itemRevisao = itemRevisao;
	}

	public BikeRevisao getBikeRevisao() {
		return bikeRevisao;
	}

	public void setBikeRevisao(BikeRevisao bikeRevisao) {
		this.bikeRevisao = bikeRevisao;
	}

}
