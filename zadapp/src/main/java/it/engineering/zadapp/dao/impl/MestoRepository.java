package it.engineering.zadapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.zadapp.dao.MestoDao;
import it.engineering.zadapp.entity.Mesto;

@Repository
@Transactional
public class MestoRepository implements MestoDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Mesto> getMesta(){
		Query query = entityManager.createQuery("SELECT m FROM Mesto m");
		List<Mesto> lista = null;
		try {
			lista = (List<Mesto>) query.getResultList();
		}catch(NoResultException e) {
			 System.out.println("ERROR");
		 }
		entityManager.close();
		return lista;
	}

	@Override
	public Mesto findById(int pttBroj) {
		return entityManager.find(Mesto.class, pttBroj);
	}
}
