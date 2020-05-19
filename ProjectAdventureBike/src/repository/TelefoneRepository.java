package repository;

import java.util.List;

import javax.persistence.Query;

import model.Telefone;

public class TelefoneRepository extends Repository<Telefone> {
	public List<Telefone> findByCodigoArea(Integer codigoArea) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  Telefone e ");
		jpql.append("WHERE ");
		jpql.append("  e.codigoArea = ? ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("codigoArea", "%" + codigoArea + "%");

		return query.getResultList();
	}

	public boolean containsTelefone(Integer id, Integer codigoArea, String numero) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  count(*) ");
		jpql.append("FROM ");
		jpql.append("  Telefone a ");
		jpql.append("WHERE ");
		jpql.append("  a.codigoArea = ? ");
		jpql.append(" AND .numero = ? ");
		jpql.append("  AND a.id <> ? ");

		Query query = getEntityManager().createNativeQuery(jpql.toString());

		query.setParameter(1, codigoArea);
		query.setParameter(2, numero);
		query.setParameter(3, id == null ? -1 : id);

		long resultado = (long) query.getSingleResult();

		return resultado == 0 ? false : true;
	}
}
