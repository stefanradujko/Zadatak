package it.engineering.zadapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.engineering.zadapp.converter.MestoConverter;
import it.engineering.zadapp.dao.MestoDao;
import it.engineering.zadapp.dto.MestoDto;
import it.engineering.zadapp.entity.Mesto;
import it.engineering.zadapp.service.MestoService;

@Service
public class MestoServiceImpl implements MestoService {
	@Autowired
	private MestoDao mestoDao;
	@Autowired
	private MestoConverter mestoConverter;
	
	@Override
	public List<MestoDto> getMesta() {
		List<Mesto> mesta = mestoDao.getMesta();
		List<MestoDto> lista = new ArrayList<MestoDto>();
		for(Mesto m : mesta) {
			lista.add(mestoConverter.toDto(m));
		}
		return lista;
	}

	@Override
	public MestoDto findById(int pttBroj) {
		Mesto mesto = mestoDao.findById(pttBroj);
		MestoDto mestoDto = null;
		if(mesto != null) {
			mestoDto = mestoConverter.toDto(mesto);
		}
		return mestoDto;
	}

}
