package it.engineering.zadapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Korisnik {
	@Id
	private int id;
	private String username;
	private String password;
	
	public Korisnik() {
		
	}

	public Korisnik(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
