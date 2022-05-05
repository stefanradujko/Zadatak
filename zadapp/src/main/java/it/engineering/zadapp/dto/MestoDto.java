package it.engineering.zadapp.dto;

public class MestoDto {
	private int pttBroj;
	private String naziv;
	
	public MestoDto() {
	}

	public MestoDto(int pttBroj, String naziv) {
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
		return "MestoDto [pttBroj=" + pttBroj + ", naziv=" + naziv + "]";
	}
}
