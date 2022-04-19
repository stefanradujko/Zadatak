package it.engineering.zadapp.action.proizvodjac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.constants.WebConstants;
import it.engineering.zadapp.repository.ProizvodjacRepository;

public class ConfirmDeleteAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String toDo = request.getParameter("action");
		switch(toDo) {
		case "Potvrdi":
			int pib = Integer.parseInt(request.getParameter("pib")) ;
			ProizvodjacRepository.deleteProizvodjac(pib);
			request.setAttribute("message", "Uspesno brisanje proizvodjaca !");
			break;
		case "Ponisti":
			request.setAttribute("message", "Ponisteno brisanje proizvodjaca !");
			break;
		}
		return WebConstants.PAGE_HOME;
	}

}
