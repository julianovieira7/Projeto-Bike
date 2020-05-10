package repository;

import java.util.List;

import javax.persistence.Query;

import model.Endereco;

public class EnderecoRepository extends Repository<Endereco>{
	public List<Endereco> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  Endereco e ");
		jpql.append("WHERE ");
		jpql.append("  upper(e.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

}
