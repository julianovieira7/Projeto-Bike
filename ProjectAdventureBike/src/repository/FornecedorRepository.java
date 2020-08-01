package repository;

import java.util.List;

import javax.persistence.Query;

import model.Fornecedor;

public class FornecedorRepository extends Repository<Fornecedor> {
	public List<Fornecedor> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Fornecedor a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

	public List<Fornecedor> findByNome(String nome, Integer idTelefone) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  c ");
		jpql.append("FROM ");
		jpql.append("  Fornecedor c ");
		jpql.append("WHERE ");
		jpql.append("  c.telefone.id = :idTelefone ");
		jpql.append("  AND upper(c.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("idEstado", idTelefone);
		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

}
