package it.engineering.zadapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.engineering.zadapp.dto.KorisnikDto;
import it.engineering.zadapp.status.UserStatusChecker;

@Controller
public class HomeController {
	@Autowired
	UserStatusChecker userStatusChecker;
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request)
	{
		if(!userStatusChecker.checkUserStatus(request)) {
			request.setAttribute("message", "You are not logged in!");
			return "index";
		}
		HttpSession session = request.getSession(true);
		KorisnikDto korisnik = (KorisnikDto) session.getAttribute("loggedUser");
		request.setAttribute("korisnik", korisnik);
		return "home";
	}
}
