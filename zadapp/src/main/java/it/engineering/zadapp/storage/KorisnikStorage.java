package it.engineering.zadapp.storage;

import java.util.ArrayList;
import java.util.List;

import it.engineering.zadapp.domain.Korisnik;


public class KorisnikStorage {
	private List<Korisnik> users;
	private static KorisnikStorage instance;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public KorisnikStorage() {
		users = new ArrayList();
	}
	
	public static KorisnikStorage getInstance() {
		if (instance == null) instance = new KorisnikStorage();
		return instance;
	}
	
	public void add(Korisnik k) {
		users.add(k);
	}
		
	public boolean exists(Korisnik k) {
		for(Korisnik u : users) {
			if(u.getUsername().equals(k.getUsername()) && u.getPassword().equals(k.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public void remove(Korisnik k) {
		users.remove(k);
	}
}
