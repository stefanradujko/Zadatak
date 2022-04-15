package it.engineering.zadapp.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.constants.WebConstants;
import it.engineering.zadapp.domain.Korisnik;
import it.engineering.zadapp.repository.KorisnikRepository;
import it.engineering.zadapp.storage.KorisnikStorage;


public class LoginAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		Korisnik k = new Korisnik();
		k.setUsername(request.getParameter("username"));
		k.setPassword(request.getParameter("password"));
		if(!KorisnikStorage.getInstance().exists(k)) {
			if(KorisnikRepository.existsKorinsik(k)) {
				KorisnikStorage.getInstance().add(k);
				HttpSession session = request.getSession(true);
				session.setAttribute("loggedUser", k);
				request.setAttribute("korisnik", k);
				return WebConstants.PAGE_HOME;
			}
		}
		return WebConstants.PAGE_INDEX;
	}
	
}
