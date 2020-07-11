package repository;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import application.RepositoryException;
import factory.JPAFactory;
import model.DefaultEntity;

public class Repository<T extends DefaultEntity<T>> {
	
	private EntityManager entityManager;
	
	public Repository() {
		entityManager = JPAFactory.getEntityManager();
	}
	
	public Repository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void beginTransaction() throws RepositoryException {
		try {
			getEntityManager().getTransaction().begin();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Problema ao "
					+ "iniciar uma transacao");
		}
	}
	
	public void commitTransaction() throws RepositoryException {
		try {
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Problema ao "
					+ "comitar uma transacao");
		}
	}
	
	public void rollbackTransaction() {
		try {
			getEntityManager().getTransaction().rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(T entity) throws RepositoryException {
		try {
			getEntityManager().merge(entity);
		} catch (Exception e) {
			System.out.println("Erro no repositorio "
					+ "ao executar o metodo merge.");
			e.printStackTrace();
			throw new RepositoryException("Erro ao salvar.");
		}
	}
	
	public void excluir(T entity) throws RepositoryException {
		try {
			T obj = getEntityManager().merge(entity);
			getEntityManager().remove(obj);
		} catch (Exception e) {
			System.out.println("Erro no repositorio "
					+ "ao executar o metodo merge.");
			e.printStackTrace();
			throw new RepositoryException("Erro ao salvar.");
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	private void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public T findById(Integer id) {
		// obtendo o tipo da classe de forma generica (a classe deve ser publica)
		final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass(); 
		Class<T> theType = (Class<T>) (type).getActualTypeArguments()[0];
		
		// pesquisando pelo id no banco
		T t = (T) getEntityManager().find(theType, id);
		
		return t;
	}

}
