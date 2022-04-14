package it.engineering.zadapp.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import it.engineering.zadapp.domain.Korisnik;
import it.engineering.zadapp.persistance.MyEntityManagerFactory;

public class KorisnikRepository{
	
	public static boolean existsKorinsik(Korisnik k) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		 Query query = em.createQuery("SELECT k FROM Korisnik k WHERE k.username = :u AND k.password = :p");
		 query.setParameter("u", k.getUsername());
		 query.setParameter("p", k.getPassword());
		 Korisnik existing = null;
		 try{
			 existing = (Korisnik) query.getSingleResult();
		 }catch(NoResultException e) {
			 System.out.println("ERROR");
		 }
		 return existing != null;
	}
}
