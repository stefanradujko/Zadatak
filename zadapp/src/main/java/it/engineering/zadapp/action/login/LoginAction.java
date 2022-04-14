package it.engineering.zadapp.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.constants.WebConstants;
import it.engineering.zadapp.domain.Korisnik;
import it.engineering.zadapp.repository.KorisnikRepository;


public class LoginAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		Korisnik k = new Korisnik();
		k.setUsername(request.getParameter("username"));
		k.setPassword(request.getParameter("password"));
		if(KorisnikRepository.existsKorinsik(k)) {
			return WebConstants.PAGE_HOME;
		}
		return WebConstants.PAGE_INDEX;
	}
	
}
