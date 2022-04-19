package it.engineering.zadapp.action.proizvodjac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.constants.WebConstants;
import it.engineering.zadapp.domain.Mesto;
import it.engineering.zadapp.domain.Proizvodjac;
import it.engineering.zadapp.repository.MestoRepository;
import it.engineering.zadapp.repository.ProizvodjacRepository;

public class UpdateDeleteProAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String toDo = request.getParameter("action");
		switch(toDo) {
		case "Izmeni":
			Proizvodjac p = new Proizvodjac();
			p.setPib(Integer.parseInt(request.getParameter("pib")));
			p.setMaticniBroj(request.getParameter("maticni"));
			p.setAdresa(request.getParameter("adresa"));
			String naziv = request.getParameter("mesto");
			Mesto m = MestoRepository.findMesto(naziv);
			p.setMesto(m);
			request.setAttribute("pib", p.getPib());
			request.setAttribute("conf_message", "Da li ste sigurni da zelite da izmenite proizvodjaca?");
			request.setAttribute("conf_path", "/zadapp/app/confirmupdate");
			HttpSession session = request.getSession();
			session.setAttribute("updatedPro", p);
			break;
		case "Izbrisi":
			int pib = Integer.parseInt(request.getParameter("pib"));
			request.setAttribute("pib", pib);
			request.setAttribute("conf_message", "Da li ste sigurni da zelite da obrisete proizvodjaca?");
			request.setAttribute("conf_path", "/zadapp/app/confirmdelete");
			break;
		}
		return WebConstants.PAGE_CONFIRM;
	}

}
