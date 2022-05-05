package it.engineering.zadapp.dao;

import java.util.List;

import it.engineering.zadapp.entity.Mesto;

public interface MestoDao {
	List<Mesto> getMesta();
	Mesto findById(int pttBroj);
}
