package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import model.validation.Validation;

@Entity
public class Pedido extends DefaultEntity<Pedido> {

	private static final long serialVersionUID = 8178659409930742984L;
	private String numeroPedido;
	private Double valorTotal;
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	@JoinColumn(name = "idcarrinho", unique = true)
	private Carrinho carrinho;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pagamento", unique = true)
	private Pagamento pagamento;

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public Validation<Pedido> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
