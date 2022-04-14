package it.engineering.zadapp.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
	
	public static Proizvodjac findProizvodjac(String maticni) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("SELECT p FROM Proizvodjac p WHERE p.maticni_broj = :m");
		System.out.println("!");
		System.out.println(maticni);
		System.out.println("!!!");
		query.setParameter("m", maticni);
		Proizvodjac p = null;
		try {
			p = (Proizvodjac) query.getSingleResult();
		}catch(NoResultException e) {
			 System.out.println("ERROR");
		 }
		em.close();
		return p;
	}
}
