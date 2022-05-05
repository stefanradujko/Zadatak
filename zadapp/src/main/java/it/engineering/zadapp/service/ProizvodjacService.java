package it.engineering.zadapp.service;

import java.util.List;

import it.engineering.zadapp.dto.ProizvodjacDto;

public interface ProizvodjacService {
	void addPro(ProizvodjacDto proizovdjac);
	List<ProizvodjacDto> getAll();
	void updatePro(ProizvodjacDto proizvodjacDto);
	void deletePro(ProizvodjacDto proizvodjacDto);
}
