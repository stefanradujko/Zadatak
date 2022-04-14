package it.engineering.zadapp.action.proizvodjac;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.constants.WebConstants;
import it.engineering.zadapp.domain.Proizvodjac;
import it.engineering.zadapp.repository.ProizvodjacRepository;

public class ViewAllProAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		List<Proizvodjac> l = ProizvodjacRepository.selectAll();
		request.setAttribute("lista", l);
		return WebConstants.PAGE_VIEW_ALL;
	}

}
