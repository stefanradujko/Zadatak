package it.engineering.zadapp.converter;

import org.springframework.stereotype.Component;

import it.engineering.zadapp.dto.MestoDto;
import it.engineering.zadapp.entity.Mesto;

@Component
public class MestoConverter implements ConverterDtoEntity<MestoDto, Mesto> {

	@Override
	public Mesto toEntity(MestoDto dto) {
		return new Mesto(dto.getPttBroj(), dto.getNaziv());
	}

	@Override
	public MestoDto toDto(Mesto e) {
		return new MestoDto(e.getPttBroj(), e.getNaziv());
	}
	
}
