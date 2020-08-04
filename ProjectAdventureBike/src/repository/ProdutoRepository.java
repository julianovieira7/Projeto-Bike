package repository;

import java.util.List;

import javax.persistence.Query;

import model.Produto;

public class ProdutoRepository extends Repository<Produto> {

	public List<Produto> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Produto a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}
}
