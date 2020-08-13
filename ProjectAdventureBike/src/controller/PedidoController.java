package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import application.Session;
import application.Util;
import factory.JPAFactory;
import model.Carrinho;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import repository.FornecedorRepository;
import repository.ProdutoRepository;

@Named
@ViewScoped
public class PedidoController extends Controller<Pedido> {

	private static final long serialVersionUID = 8702988121934899052L;
	private String nome;
	private List<Produto> listaProduto = null;
//	private Carrinho carrinho;

	public void pesquisar() {
		ProdutoRepository repo = new ProdutoRepository();
		setListaProduto(repo.findByNome(getNome()));
	}

//	@Override
//	public void salvar() {
//		super.salvar();
//		EntityManager em = JPAFactory.getEntityManager();
//		em.getTransaction().begin();
////		List<ItemPedido> carrinhoPedido = (ArrayList<ItemPedido>) Session.getInstance().getAttribute("carrinho");
////		carrinho.setListaItem(carrinhoPedido);
//		System.out.println(carrinho.toString());
//		System.out.println(entity.toString());
//		for (ItemPedido itemPedido : carrinho.getListaItem()) {
//			em.persist(itemPedido);
//			em.getTransaction().commit();
//			return;
//		}
////		em.getTransaction().commit();
//		System.out.println("Feito.");
//		Util.addMessageInfo("Venda realizada com sucesso.");
//		// limpando o carrinho
//		Session.getInstance().setAttribute("carrinho", null);
//		super.salvar();
//	}

	public List<Produto> getListaProduto() {
		if (listaProduto == null) {
			ProdutoRepository repo = new ProdutoRepository();
			listaProduto = repo.findByNome(getNome());
			if (listaProduto == null)
				listaProduto = new ArrayList<Produto>();
		}
		return listaProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	@Override
	public Pedido getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
