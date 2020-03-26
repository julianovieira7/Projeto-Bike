package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {
	
	private JPAFactory() {
		// garante que a classe nao pode ser instanciada
	}
	
	private static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("ProjectAdventureBike");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
