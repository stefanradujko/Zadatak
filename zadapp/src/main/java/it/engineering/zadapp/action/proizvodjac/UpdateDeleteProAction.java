package it.engineering.zadapp.action.proizvodjac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			ProizvodjacRepository.updateProizvodjac(p);
			request.setAttribute("message", "Uspesna izmena proizvodjaca !");
			break;
		case "Izbrisi":
			int pib = Integer.parseInt(request.getParameter("pib"));
			ProizvodjacRepository.deleteProizvodjac(pib);
			request.setAttribute("message", "Uspesno brisanje proizvodjaca !");
			break;
		}
		return WebConstants.PAGE_HOME;
	}

}
