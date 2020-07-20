package repository;

import java.util.List;

import javax.persistence.Query;

import model.Marca;

public class MarcaRepository extends Repository<Marca> {
	
	public List<Marca> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Marca a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.marca) like upper(:marca) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("marca", "%" + nome + "%");

		return query.getResultList();
	}
}
