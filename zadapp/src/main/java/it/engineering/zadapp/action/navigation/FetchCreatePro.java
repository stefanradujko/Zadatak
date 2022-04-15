package it.engineering.zadapp.action.navigation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.constants.WebConstants;
import it.engineering.zadapp.domain.Mesto;

public class FetchCreatePro extends AbstractAction{

	@SuppressWarnings("unchecked")
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		List<Mesto> lista = (List<Mesto>) session.getAttribute("mesta");
		request.setAttribute("lista", lista);
		return WebConstants.PAGE_CREATE_PRO;
	}

}
