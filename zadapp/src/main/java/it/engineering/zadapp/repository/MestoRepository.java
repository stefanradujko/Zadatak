package it.engineering.zadapp.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import it.engineering.zadapp.domain.Mesto;
import it.engineering.zadapp.persistance.MyEntityManagerFactory;

public class MestoRepository {
	public static Mesto findMesto(String naziv) {
		System.out.println("Naziv:");
		System.out.println(naziv);
		System.out.println("!!!");
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("SELECT m FROM Mesto m WHERE m.naziv = :n");
		query.setParameter("n", naziv);
		Mesto m = null;
		try {
			m = (Mesto) query.getSingleResult();
		}catch(NoResultException e) {
			 System.out.println("ERROR");
		 }
		em.close();
		return m;
	}
}
