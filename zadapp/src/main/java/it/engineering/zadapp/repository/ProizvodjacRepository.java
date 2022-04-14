package it.engineering.zadapp.repository;

import javax.persistence.EntityManager;
import it.engineering.zadapp.domain.Proizvodjac;
import it.engineering.zadapp.persistance.MyEntityManagerFactory;

public class ProizvodjacRepository {
	public static void addProizvodjac(Proizvodjac p) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
}
