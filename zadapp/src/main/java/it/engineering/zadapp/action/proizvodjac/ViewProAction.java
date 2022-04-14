package it.engineering.zadapp.action.proizvodjac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.constants.WebConstants;
import it.engineering.zadapp.domain.Proizvodjac;
import it.engineering.zadapp.repository.ProizvodjacRepository;

public class ViewProAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String maticni = request.getParameter("maticni");
		Proizvodjac p = ProizvodjacRepository.findProizvodjac(maticni);
		if(p == null) {
			return WebConstants.PAGE_FIND_PRO;
		}
		request.setAttribute("proizvodjac", p);
		return WebConstants.PAGE_VIEW_PRO;
	}

}
