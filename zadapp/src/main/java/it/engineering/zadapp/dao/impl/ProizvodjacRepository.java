package it.engineering.zadapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.zadapp.dao.ProizvodajcDao;
import it.engineering.zadapp.entity.Proizvodjac;

@Repository
@Transactional
public class ProizvodjacRepository implements ProizvodajcDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void addPro(Proizvodjac p) {
		entityManager.persist(p);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Proizvodjac> getAll() {
		Query query = entityManager.createQuery("SELECT p FROM Proizvodjac p");
		List<Proizvodjac> lista = null;
		try {
			lista = query.getResultList();
		}catch(NoResultException e) {
			 System.out.println("ERROR");
		 }
		entityManager.close();
		return lista;
	}


	@Override
	public void updatePro(Proizvodjac proizvodjac) {
		entityManager.merge(proizvodjac);
		
	}


	@Override
	public void deletePro(Proizvodjac proizvodjac) {
		Query query = entityManager.createQuery("DELETE FROM Proizvodjac p WHERE p.pib = :p");
		query.setParameter("p", proizvodjac.getPib());
		query.executeUpdate();
	}
	
}
