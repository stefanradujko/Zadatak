package it.engineering.zadapp.dao;

import java.util.List;

import it.engineering.zadapp.entity.Proizvodjac;

public interface ProizvodajcDao {
	void addPro(Proizvodjac proizvodjac);
	List<Proizvodjac> getAll();
	void updatePro(Proizvodjac proizvodjac);
	void deletePro(Proizvodjac proizvodjac);
}
