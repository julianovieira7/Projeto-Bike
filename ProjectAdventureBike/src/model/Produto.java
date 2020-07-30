package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.validation.Validation;

//import model.validation.Validation;
@Entity
public class Produto extends DefaultEntity<Produto> {

	private static final long serialVersionUID = 2517369960396705568L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idtipoproduto", nullable = true)
	private TipoProduto tipoProduto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idmarca", nullable = true)
	private Marca marca;
	
	@Column(length = 120, nullable = false)
	private String material;
	
	@Column(length = 400)
	private String descricao;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 100, nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private Double valor;

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public Validation<Produto> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
