package repository;

import java.util.List;

import javax.persistence.Query;

import model.Telefone;

public class TelefoneRepository extends Repository<Telefone> {
	public List<Telefone> findByCodigoArea(String codigoArea) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  Telefone e ");
		jpql.append("WHERE ");
		jpql.append("  upper(e.codigoArea) like upper(:codigoArea) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("codigoArea", "%" + codigoArea + "%");

		return query.getResultList();
	}
}
