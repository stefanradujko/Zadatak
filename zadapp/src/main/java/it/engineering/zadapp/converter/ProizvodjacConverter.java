package it.engineering.zadapp.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.zadapp.dto.ProizvodjacDto;
import it.engineering.zadapp.entity.Proizvodjac;

@Component
public class ProizvodjacConverter implements ConverterDtoEntity<ProizvodjacDto, Proizvodjac> {
	@Autowired
	private MestoConverter mestoConverter;
	
	@Override
	public Proizvodjac toEntity(ProizvodjacDto dto) {
		return new Proizvodjac(dto.getPib(), dto.getAdresa(), dto.getAdresa(), mestoConverter.toEntity(dto.getMestoDto()));
	}

	@Override
	public ProizvodjacDto toDto(Proizvodjac e) {
		return new ProizvodjacDto(e.getPib(), e.getMaticniBroj(), e.getAdresa(), mestoConverter.toDto(e.getMesto()));
	}

}
