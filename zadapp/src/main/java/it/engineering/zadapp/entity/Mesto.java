package it.engineering.zadapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mesto implements it.engineering.zadapp.genericobject.Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int pttBroj;
	private String naziv;
	
	public Mesto() {
		
	}

	public Mesto(int pttBroj, String naziv) {
		super();
		this.pttBroj = pttBroj;
		this.naziv = naziv;
	}

	public int getPttBroj() {
		return pttBroj;
	}

	public void setPttBroj(int pttBroj) {
		this.pttBroj = pttBroj;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Mesto [pttBroj=" + pttBroj + ", naziv=" + naziv + "]";
	}
	
	
}
