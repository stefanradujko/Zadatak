package it.engineering.zadapp.dto;

import it.engineering.zadapp.genericobject.Dto;

public class KorisnikDto implements Dto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public KorisnikDto() {
	}

	public KorisnikDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
		return "KorisnikDto [username=" + username + ", password=" + password + "]";
	}

	
}
