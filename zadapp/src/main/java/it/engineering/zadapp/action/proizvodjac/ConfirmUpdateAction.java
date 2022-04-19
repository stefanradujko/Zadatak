package it.engineering.zadapp.action.proizvodjac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.constants.WebConstants;
import it.engineering.zadapp.domain.Proizvodjac;
import it.engineering.zadapp.repository.ProizvodjacRepository;

public class ConfirmUpdateAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String toDo = request.getParameter("action");
		switch(toDo) {
		case "Potvrdi":
			HttpSession session = request.getSession();
			Proizvodjac p = (Proizvodjac) session.getAttribute("updatedPro");
			ProizvodjacRepository.updateProizvodjac(p);
			request.setAttribute("message", "Uspesna izmena proizvodjaca!");
			break;
		case "Ponisti":
			request.setAttribute("message", "Ponistena izmena proizvodjaca!");
			break;
		}
		return WebConstants.PAGE_HOME;
	}

}
