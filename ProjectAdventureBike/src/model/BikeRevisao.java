package model;

import java.util.Date;

public class BikeRevisao {
	private Integer numeroSerie;
	private String modelo;
	private String marca;
	private Date dataRevisao;
	private String DescricaoProblema;
	private String DescricaoTecnica;
	private Double valorRevisao;

	public Integer getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(Integer numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getDataRevisao() {
		return dataRevisao;
	}

	public void setDataRevisao(Date dataRevisao) {
		this.dataRevisao = dataRevisao;
	}

	public String getDescricaoProblema() {
		return DescricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		DescricaoProblema = descricaoProblema;
	}

	public String getDescricaoTecnica() {
		return DescricaoTecnica;
	}

	public void setDescricaoTecnica(String descricaoTecnica) {
		DescricaoTecnica = descricaoTecnica;
	}

	public Double getValorRevisao() {
		return valorRevisao;
	}

	public void setValorRevisao(Double valorRevisao) {
		this.valorRevisao = valorRevisao;
	}

}
