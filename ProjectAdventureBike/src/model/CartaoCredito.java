package model;

import model.validation.Validation;

public class CartaoCredito extends DefaultEntity<CartaoCredito> {

	private static final long serialVersionUID = 1476836220541665515L;
	private Integer numeroCartao;
	private Integer codigoSeguranca;
	private TipoCartao tipoCartao;

	public Integer getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Integer numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Integer getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(Integer codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public TipoCartao getTipoCartao() {
		return tipoCartao;
	}

	public void setTipoCartao(TipoCartao tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

	@Override
	public Validation<CartaoCredito> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}
}
