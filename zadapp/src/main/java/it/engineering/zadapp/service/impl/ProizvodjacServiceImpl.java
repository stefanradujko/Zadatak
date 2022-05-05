package it.engineering.zadapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.engineering.zadapp.dao.ProizvodajcDao;
import it.engineering.zadapp.dto.MestoDto;
import it.engineering.zadapp.dto.ProizvodjacDto;
import it.engineering.zadapp.entity.Mesto;
import it.engineering.zadapp.entity.Proizvodjac;
import it.engineering.zadapp.service.ProizvodjacService;

@Service
public class ProizvodjacServiceImpl implements ProizvodjacService {
	@Autowired
	private ProizvodajcDao proizvodjacDao;

	@Override
	public void addPro(ProizvodjacDto p) {
		Mesto m = new Mesto(p.getMestoDto().getPttBroj(), p.getMestoDto().getNaziv());
		proizvodjacDao.addPro(new Proizvodjac(p.getPib(), p.getMaticniBroj(), p.getAdresa(), m));
	}

	@Override
	public List<ProizvodjacDto> getAll() {
		List<Proizvodjac> proizvodjaci = proizvodjacDao.getAll();
		List<ProizvodjacDto> lista = new ArrayList<ProizvodjacDto>();
		for(Proizvodjac p : proizvodjaci) {
			MestoDto mesto = new MestoDto(p.getMesto().getPttBroj(), p.getMesto().getNaziv());
			lista.add(new ProizvodjacDto(p.getPib(), p.getMaticniBroj(), p.getAdresa(), mesto));
		}
		return lista;
	}

	@Override
	public void updatePro(ProizvodjacDto p) {
		Mesto m = new Mesto(p.getMestoDto().getPttBroj(), p.getMestoDto().getNaziv());
		proizvodjacDao.updatePro(new Proizvodjac(p.getPib(), p.getMaticniBroj(), p.getAdresa(), m));
		
	}

	@Override
	public void deletePro(ProizvodjacDto p) {
		Proizvodjac pro = new Proizvodjac();
		pro.setPib(p.getPib());
		proizvodjacDao.deletePro(pro);
		
	}

}
