package it.engineering.zadapp.service;

import java.util.List;

import it.engineering.zadapp.dto.MestoDto;

public interface MestoService {
	List<MestoDto> getMesta();
	MestoDto findById(int pttBroj);
}
