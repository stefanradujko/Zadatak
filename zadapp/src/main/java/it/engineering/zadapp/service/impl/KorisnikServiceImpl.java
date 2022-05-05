package it.engineering.zadapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.engineering.zadapp.dao.KorisnikDao;
import it.engineering.zadapp.dto.KorisnikDto;
import it.engineering.zadapp.entity.Korisnik;
import it.engineering.zadapp.service.KorisnikService;

@Service
public class KorisnikServiceImpl implements KorisnikService {
	@Autowired
	KorisnikDao korisnikDao;
	
	
	@Override
	public KorisnikDto login(KorisnikDto korisnik) {
		Korisnik k = korisnikDao.login(new Korisnik(0, korisnik.getUsername(), korisnik.getPassword()));
		if(k != null) {
			korisnik.setPassword(null);
		} else {
			korisnik = null;
		}
		return korisnik;
	}

}
