package repository;

import java.util.List;

import javax.persistence.Query;

import model.TipoProduto;

public class TipoProdutoRepository extends Repository<TipoProduto> {
	public List<TipoProduto> findByNome(String tipoProduto) {
		return findByNome(tipoProduto, null);
	}

	public List<TipoProduto> findByNome(String tipoProduto, Integer maxResults) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  TipoProduto a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.tipoProduto) like upper(:tipoProduto) ");
		jpql.append("ORDER BY a.tipoProduto ");

		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("tipoProduto", "%" + tipoProduto + "%");
		if (maxResults != null && maxResults > 0)
			query.setMaxResults(maxResults);
		return query.getResultList();
	}
}
