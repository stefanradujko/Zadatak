package it.engineering.zadapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Proizvodjac {
	@Id
	private int pib;
	
	private String maticni_broj;
	private String adresa;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "pttBroj")
	private Mesto mesto;
	
	public Proizvodjac() {
	}

	public Proizvodjac(int pib, String maticniBroj, String adresa, Mesto mesto) {
		super();
		this.pib = pib;
		this.maticni_broj = maticniBroj;
		this.adresa = adresa;
		this.mesto = mesto;
	}

	public int getPib() {
		return pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

	public String getMaticniBroj() {
		return maticni_broj;
	}

	public void setMaticniBroj(String maticniBroj) {
		this.maticni_broj = maticniBroj;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	@Override
	public String toString() {
		return "Proizvodjac [pib=" + pib + ", maticniBroj=" + maticni_broj + ", adresa=" + adresa + ", mesto=" + mesto
				+ "]";
	}
	
	
}
