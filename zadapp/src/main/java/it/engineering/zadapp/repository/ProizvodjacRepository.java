package it.engineering.zadapp.repository;

import java.util.ArrayList;
import java.util.List;

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
	
	public static void deleteProizvodjac(int pib) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Proizvodjac p WHERE p.pib = :p");
		query.setParameter("p", pib);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}

	public static void updateProizvodjac(Proizvodjac p) {
		deleteProizvodjac(p.getPib());
		addProizvodjac(p);
	}

	@SuppressWarnings("unchecked")
	public static List<Proizvodjac> selectAll() {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("SELECT p FROM Proizvodjac p");
		List<Proizvodjac> lista = null;
		try {
			lista = query.getResultList();
		}catch(NoResultException e) {
			 System.out.println("ERROR");
		 }
		em.close();
		return lista;
	}
}
