package it.engineering.zadapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.engineering.zadapp.dto.KorisnikDto;
import it.engineering.zadapp.storage.KorisnikStorage;


@Controller
public class LogoutController {
	@Autowired
	KorisnikStorage korisnikStorage;

	@RequestMapping(path="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		KorisnikDto k = (KorisnikDto) session.getAttribute("loggedUser");
		korisnikStorage.remove(k);
		session.removeAttribute("loggedUser");
		session.invalidate();
		session = request.getSession(false);
		return "index";
	}
}
