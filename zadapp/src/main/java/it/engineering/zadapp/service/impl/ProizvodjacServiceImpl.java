package it.engineering.zadapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.engineering.zadapp.converter.ProizvodjacConverter;
import it.engineering.zadapp.dao.ProizvodajcDao;
import it.engineering.zadapp.dto.ProizvodjacDto;
import it.engineering.zadapp.entity.Proizvodjac;
import it.engineering.zadapp.service.ProizvodjacService;

@Service
public class ProizvodjacServiceImpl implements ProizvodjacService {
	@Autowired
	private ProizvodajcDao proizvodjacDao;
	@Autowired
	private ProizvodjacConverter proizvodjacConverter;

	@Override
	public void addPro(ProizvodjacDto p) {
		proizvodjacDao.addPro(proizvodjacConverter.toEntity(p));
	}

	@Override
	public List<ProizvodjacDto> getAll() {
		List<Proizvodjac> proizvodjaci = proizvodjacDao.getAll();
		List<ProizvodjacDto> lista = new ArrayList<ProizvodjacDto>();
		for(Proizvodjac p : proizvodjaci) {
			lista.add(proizvodjacConverter.toDto(p));
		}
		return lista;
	}

	@Override
	public void updatePro(ProizvodjacDto p) {
		proizvodjacDao.updatePro(proizvodjacConverter.toEntity(p));
		
	}

	@Override
	public void deletePro(ProizvodjacDto p) {
		Proizvodjac pro = new Proizvodjac();
		pro.setPib(p.getPib());
		proizvodjacDao.deletePro(pro);
		
	}

}
