package it.engineering.zadapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import it.engineering.zadapp.genericobject.Dto;


public class ProizvodjacDto implements Dto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pib;
	@NotEmpty
	private String maticniBroj;
	@NotEmpty
	private String adresa;
	@NotNull
	private MestoDto mestoDto;
	
	public ProizvodjacDto() {
	}

	public ProizvodjacDto(int pib, String maticniBroj, String adresa, MestoDto mestoDto) {
		super();
		this.pib = pib;
		this.maticniBroj = maticniBroj;
		this.adresa = adresa;
		this.mestoDto = mestoDto;
	}

	public int getPib() {
		return pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

	public String getMaticniBroj() {
		return maticniBroj;
	}

	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public MestoDto getMestoDto() {
		return mestoDto;
	}

	public void setMestoDto(MestoDto mestoDto) {
		this.mestoDto = mestoDto;
	}

	@Override
	public String toString() {
		return "ProizvodjacDto [pib=" + pib + ", maticniBroj=" + maticniBroj + ", adresa=" + adresa + ", mestoDto="
				+ mestoDto + "]";
	}

	
}
