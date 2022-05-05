package it.engineering.zadapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.engineering.zadapp.dto.KorisnikDto;
import it.engineering.zadapp.service.KorisnikService;
import it.engineering.zadapp.storage.KorisnikStorage;

@Controller
public class LoginController {
	@Autowired
	KorisnikService korisnikService;
	@Autowired
	KorisnikStorage korisnikStorage;
	
	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request){
		KorisnikDto korisnik = korisnikService.login(new KorisnikDto(username, password));
		if(korisnik != null) {
			if(korisnikStorage.exists(korisnik)) {
				request.setAttribute("message", "User is logged in!");
				return "index";
			}
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedUser", korisnik);
			korisnikStorage.add(korisnik);
			return "redirect:/home";
		}
		request.setAttribute("message", "Unsuccessful login!");
		return "index";
	}
}
