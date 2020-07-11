package repository;

import java.util.List;

import javax.persistence.Query;

import model.Marca;

public class MarcaRepository extends Repository<Marca>{
	public List<Marca> findByNome(String marca) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Usuario a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + marca + "%");

		return query.getResultList();
	}
}
