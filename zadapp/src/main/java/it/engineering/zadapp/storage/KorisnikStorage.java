package it.engineering.zadapp.storage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.engineering.zadapp.dto.KorisnikDto;

@Component
public class KorisnikStorage {
	private List<KorisnikDto> users;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public KorisnikStorage() {
		users = new ArrayList();
	}
		
	public void add(KorisnikDto korisnik) {
		users.add(korisnik);
	}
		
	public boolean exists(KorisnikDto k) {
		for(KorisnikDto u : users) {
			if(u.getUsername().equals(k.getUsername())) {
				return true;
			}
		}
		return false;
	}

	public void remove(KorisnikDto k) {
		users.remove(k);
	}
}
