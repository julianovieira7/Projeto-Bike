package repository;

import java.util.List;

import javax.persistence.Query;

import model.Marca;

public class MarcaRepository extends Repository<Marca> {
	
	public List<Marca> findByNome(String marca) {
		return findByNome(marca, null);
	}

	public List<Marca> findByNome(String marca, Integer maxResults) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Marca a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.marca) like upper(:marca) ");
		jpql.append("ORDER BY a.marca ");
		
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("marca", "%" + marca + "%");
		if (maxResults != null && maxResults > 0 )
			query.setMaxResults(maxResults);
		return query.getResultList();
	}
}
