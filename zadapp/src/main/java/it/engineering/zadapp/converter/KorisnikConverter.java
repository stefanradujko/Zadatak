package it.engineering.zadapp.converter;

import org.springframework.stereotype.Component;

import it.engineering.zadapp.dto.KorisnikDto;
import it.engineering.zadapp.entity.Korisnik;

@Component
public class KorisnikConverter implements ConverterDtoEntity<KorisnikDto, Korisnik> {

	@Override
	public Korisnik toEntity(KorisnikDto dto) {
		return new Korisnik(0, dto.getUsername(), dto.getPassword());
	}

	@Override
	public KorisnikDto toDto(Korisnik e) {
		return new KorisnikDto(e.getUsername(), e.getPassword());
	}

}
