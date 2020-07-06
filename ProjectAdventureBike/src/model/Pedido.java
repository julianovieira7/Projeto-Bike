package model;

import model.validation.Validation;

public class Pedido extends DefaultEntity<Pedido> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3152982914801710554L;
	private String numerpPedido;
	private Double valorToral;

	public String getNumerpPedido() {
		return numerpPedido;
	}

	public void setNumerpPedido(String numerpPedido) {
		this.numerpPedido = numerpPedido;
	}

	public Double getValorToral() {
		return valorToral;
	}

	public void setValorToral(Double valorToral) {
		this.valorToral = valorToral;
	}

	@Override
	public Validation<Pedido> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
