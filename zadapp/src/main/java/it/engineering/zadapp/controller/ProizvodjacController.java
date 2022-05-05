package it.engineering.zadapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.engineering.zadapp.dto.MestoDto;
import it.engineering.zadapp.dto.ProizvodjacDto;
import it.engineering.zadapp.service.MestoService;
import it.engineering.zadapp.service.ProizvodjacService;
import it.engineering.zadapp.status.UserStatusChecker;

@Controller
public class ProizvodjacController {
	@Autowired
	private MestoService mestoService;
	@Autowired
	private ProizvodjacService proizvodjacService;
	@Autowired
	UserStatusChecker userStatusChecker;
	
	
	@RequestMapping(path="/createpro", method = RequestMethod.GET)
	public String getCreatePro(@ModelAttribute("proizvodjacDto") ProizvodjacDto proizvodjacDto, HttpServletRequest request) {
		if(!userStatusChecker.checkUserStatus(request)) {
			request.setAttribute("message", "You are not logged in!");
			return "index";
		}
		List<MestoDto> lista = mestoService.getMesta();
		request.setAttribute("lista", lista);
		return "createpro";
	}
	
	@RequestMapping(path="/addpro", method = RequestMethod.POST)
	public String addPro(@ModelAttribute("proizvodjacDto") ProizvodjacDto proizvodjacDto, RedirectAttributes redirect, HttpServletRequest request) {
		proizvodjacService.addPro(proizvodjacDto);
		redirect.addFlashAttribute("message", "Uspesno sacuvan proizvodjac!");
		return "redirect:/home";
	}
	
	
	@RequestMapping(path="/viewall", method = RequestMethod.GET)
	public String viewAll(HttpServletRequest request) {
		if(!userStatusChecker.checkUserStatus(request)) {
			request.setAttribute("message", "You are not logged in!");
			return "index";
		}
		List<ProizvodjacDto> lista = proizvodjacService.getAll();
		request.setAttribute("lista", lista);
		return "viewall";
	}
	
	@RequestMapping(path="/viewpro", method = RequestMethod.GET)
	public String viewPro(@ModelAttribute("proizvodjacDto") ProizvodjacDto proizvodjacDto, HttpServletRequest request) {
		if(!userStatusChecker.checkUserStatus(request)) {
			request.setAttribute("message", "You are not logged in!");
			return "index";
		}
		List<MestoDto> lista = mestoService.getMesta();
		request.setAttribute("lista", lista);
		return "viewpro";
	}
	
	@RequestMapping(path="/updtordel", method = RequestMethod.POST)
	public String updateOrDelete(@ModelAttribute("proizvodjacDto") ProizvodjacDto proizvodjacDto, RedirectAttributes redirect, HttpServletRequest request) {
		String action = request.getParameter("action");
		redirect.addFlashAttribute("proizvodjacDto", proizvodjacDto);
		
		String fragment = "";
		String path = "";
		if(action.equals("Izmeni")) {
			fragment = " izmenite proizvodjaca?";
			path = "updatepro";
		}else {
			fragment = " obrisete proizvodjaca?";
			path = "deletepro";
		}
		redirect.addFlashAttribute("path", path);
		redirect.addFlashAttribute("conf_message", "Da li ste sigurni da zelite da" + fragment);
		request.getSession().setAttribute("proizvodjacDto", proizvodjacDto);
		return "redirect:/confirm";
	}
	
	@RequestMapping(path="/confirm", method = RequestMethod.GET)
	public String confirm(HttpServletRequest request) {
		if(!userStatusChecker.checkUserStatus(request)) {
			request.setAttribute("message", "You are not logged in!");
			return "index";
		}
		return "confirm";
	}
	
	@RequestMapping(path="/updatepro", method = RequestMethod.POST)
	public String updatePro(RedirectAttributes redirect, HttpServletRequest request) {
		String action = request.getParameter("action");
		if(action.equals("Ponisti")) {
			redirect.addFlashAttribute("message", "Ponistena izmena proizvodjaca!");
		} else {
			ProizvodjacDto proizvodjacDto = (ProizvodjacDto) request.getSession().getAttribute("proizvodjacDto");
			proizvodjacService.updatePro(proizvodjacDto);
			redirect.addFlashAttribute("message", "Uspesna izmena proizvodjaca!");
		}
		return "redirect:/home";
	}
	
	@RequestMapping(path="/deletepro", method = RequestMethod.POST)
	public String deletePro(RedirectAttributes redirect, HttpServletRequest request) {
		String action = request.getParameter("action");
		if(action.equals("Ponisti")) {
			redirect.addFlashAttribute("message", "Ponisteno brisanje proizvodjaca!");
		} else {
			ProizvodjacDto proizvodjacDto = (ProizvodjacDto) request.getSession().getAttribute("proizvodjacDto");
			proizvodjacService.deletePro(proizvodjacDto);
			redirect.addFlashAttribute("message", "Uspesno brisanje proizvodjaca!");
		}
		return "redirect:/home";
	}
}
