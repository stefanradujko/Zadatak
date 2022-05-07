package it.engineering.zadapp.converter;

import it.engineering.zadapp.genericobject.Dto;
import it.engineering.zadapp.genericobject.Entity;

public interface ConverterDtoEntity<DTO extends Dto, E extends Entity>  {
	E toEntity(DTO dto);
	DTO toDto(E e);
}
