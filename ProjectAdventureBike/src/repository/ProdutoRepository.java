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
//	public boolean containsEmail(Integer id, String email) {
//		StringBuffer jpql = new StringBuffer();
//		jpql.append("SELECT ");
//		jpql.append("  count(*) ");
//		jpql.append("FROM ");
//		jpql.append("  Aluno a ");
//		jpql.append("WHERE ");
//		jpql.append("  upper(a.email) = upper(?) ");
//		jpql.append("  AND a.id <> ? ");
//		//adicionando aqui um comentario so pra upar
//		Query query = getEntityManager().createNativeQuery(jpql.toString());
//
//		query.setParameter(1, email);
//		query.setParameter(2, id == null ? -1 : id);
//		
//		long resultado = (long) query.getSingleResult();
//		
//		return resultado == 0 ? false : true;
//	}
//	public boolean containsCpf(Integer id, String cpf) {
//		StringBuffer jpql = new StringBuffer();
//		jpql.append("SELECT ");
//		jpql.append("  count(*) ");
//		jpql.append("FROM ");
//		jpql.append("  Aluno a ");
//		jpql.append("WHERE ");
//		jpql.append("  upper(a.cpf) = upper(?) ");
//		jpql.append("  AND a.id <> ? ");
//		
//		Query query = getEntityManager().createNativeQuery(jpql.toString());
//
//		query.setParameter(1, cpf);
//		query.setParameter(2, id == null ? -1 : id);
//		
//		long resultado = (long) query.getSingleResult();
//		
//		return resultado == 0 ? false : true;
//	}
}
