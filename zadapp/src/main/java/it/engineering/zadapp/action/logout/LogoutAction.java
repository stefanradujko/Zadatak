package it.engineering.zadapp.action.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.constants.WebConstants;
import it.engineering.zadapp.domain.Korisnik;
import it.engineering.zadapp.storage.KorisnikStorage;

public class LogoutAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Korisnik k = (Korisnik) session.getAttribute("loggedUser");
		KorisnikStorage.getInstance().remove(k);
		session.removeAttribute("loggedUser");
		session.invalidate();
		session = request.getSession(false);
		return WebConstants.PAGE_INDEX;
	}
	
}
