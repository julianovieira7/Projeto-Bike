package repository;

import java.util.List;

import javax.persistence.Query;

import model.Estoque;

public class EstoqueRepository extends Repository<Estoque> {

	public List<Estoque> findByNome(String nome, Integer idFornecedor) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  c ");
		jpql.append("FROM ");
		jpql.append("  Estoque c ");
		jpql.append("WHERE ");
		jpql.append("  c.fornecedor.id = :idFornecedor ");
		jpql.append("  AND upper(c.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("idEstado", idFornecedor);
		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}	
}
