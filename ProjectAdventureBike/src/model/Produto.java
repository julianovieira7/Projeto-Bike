package model;

import javax.persistence.Entity;

//import model.validation.Validation;
@Entity
public class Produto extends DefaultEntity<Produto> {

	private static final long serialVersionUID = 2517369960396705568L;
	private String material;
	private Marca marca;
	private String descricao;
	private String nome;
	private String modelo;
	private TipoProduto tipoProduto;
	private Integer quantidade;

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

//	@Override
//	public Validation<Produto> getValidation() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
