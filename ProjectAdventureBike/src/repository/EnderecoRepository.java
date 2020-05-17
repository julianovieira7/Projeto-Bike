package repository;

import java.util.List;

import javax.persistence.Query;

import model.Endereco;

public class EnderecoRepository extends Repository<Endereco>{
	public List<Endereco> findByRua(String rua) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Endereco a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.rua) like upper(:rua) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("rua", "%" + rua + "%");

		return query.getResultList();
	}

}
