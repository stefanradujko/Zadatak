package it.engineering.zadapp.action.navigation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.constants.WebConstants;
import it.engineering.zadapp.domain.Korisnik;

public class FetchHome extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Korisnik k = (Korisnik) session.getAttribute("loggedUser");
		request.setAttribute("korisnik", k);
		return WebConstants.PAGE_HOME;
	}

}
