package it.engineering.zadapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.engineering.zadapp.converter.KorisnikConverter;
import it.engineering.zadapp.dao.KorisnikDao;
import it.engineering.zadapp.dto.KorisnikDto;
import it.engineering.zadapp.entity.Korisnik;
import it.engineering.zadapp.service.KorisnikService;

@Service
public class KorisnikServiceImpl implements KorisnikService {
	@Autowired
	private KorisnikDao korisnikDao;
	@Autowired
	private KorisnikConverter korisnikConverter;
	
	
	@Override
	public KorisnikDto login(KorisnikDto korisnik) {
		Korisnik k = korisnikDao.login(korisnikConverter.toEntity(korisnik));
		if(k != null) {
			korisnik.setPassword(null);
		} else {
			korisnik = null;
		}
		return korisnik;
	}

}
