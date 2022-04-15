package it.engineering.zadapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.actionfactory.ActionFactory;
import it.engineering.zadapp.constants.WebConstants;

public class ApplicationController {
	public String processRequest(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod();
		String path = request.getPathInfo();
		System.out.println("METHOD: " + method);
		System.out.println("PATH: " + path);
		if(!path.equals(WebConstants.PATH_LOGIN)) {
			HttpSession session = request.getSession();
			if(session.getAttribute("loggedUser") == null) {
				return WebConstants.PAGE_INDEX;
			}
		}
		AbstractAction action = ActionFactory.createAction(method, path);
		return action.executeRequest(request, response);
	}
}
