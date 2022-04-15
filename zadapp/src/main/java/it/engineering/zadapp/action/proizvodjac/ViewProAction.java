package it.engineering.zadapp.action.proizvodjac;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.constants.WebConstants;
import it.engineering.zadapp.domain.Mesto;
import it.engineering.zadapp.domain.Proizvodjac;
import it.engineering.zadapp.repository.ProizvodjacRepository;

public class ViewProAction extends AbstractAction{

	@SuppressWarnings("unchecked")
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String maticni = request.getParameter("maticni");
		Proizvodjac p = ProizvodjacRepository.findProizvodjac(maticni);
		if(p == null) {
			return WebConstants.PAGE_FIND_PRO;
		}
		request.setAttribute("proizvodjac", p);
		HttpSession session = request.getSession(true);
		List<Mesto> lista = (List<Mesto>) session.getAttribute("mesta");
		request.setAttribute("lista", lista);
		return WebConstants.PAGE_VIEW_PRO;
	}

}
