package it.engineering.zadapp.persistance;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManagerFactory {
	private EntityManagerFactory emf;
	private static MyEntityManagerFactory instance;
	
	private MyEntityManagerFactory() {
		emf = Persistence.createEntityManagerFactory("zadapp");
	}
	
	private EntityManagerFactory getEMF() {
		return emf;
	}
	
	public static void close() {
		if(instance != null) {
			instance.getEMF().close();
		}
	}
	
	public static  EntityManagerFactory getEntityManagerFactory() {
		if(instance == null) {
			instance = new MyEntityManagerFactory();
		}
		return instance.getEMF();
	}
}
