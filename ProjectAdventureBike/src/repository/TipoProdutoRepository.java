package repository;

import java.util.List;

import javax.persistence.Query;

import model.TipoProduto;


public class TipoProdutoRepository extends Repository<TipoProduto>{
	
	public List<TipoProduto> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  TipoProduto a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.tipoProduto) like upper(:tipoProduto) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("tipoProduto", "%" + nome + "%");

		return query.getResultList();
	}
}
