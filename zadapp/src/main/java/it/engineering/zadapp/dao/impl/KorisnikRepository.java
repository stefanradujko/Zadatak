package it.engineering.zadapp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import it.engineering.zadapp.dao.KorisnikDao;
import it.engineering.zadapp.entity.Korisnik;

@Repository
@Transactional
public class KorisnikRepository implements KorisnikDao{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Korisnik login(Korisnik korisnik) {
		Query query = entityManager.createQuery("SELECT k FROM Korisnik k WHERE k.username = :u AND k.password = :p");
		query.setParameter("u", korisnik.getUsername());
		query.setParameter("p", korisnik.getPassword());
		Korisnik existing = null;
		try{
			 existing = (Korisnik) query.getSingleResult();
		 }catch(NoResultException e) {
			 System.out.println("ERROR");
		 }
		return existing;
	}
}
