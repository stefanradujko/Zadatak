package it.engineering.zadapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.actionfactory.ActionFactory;

public class ApplicationController {
	public String processRequest(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod();
		String path = request.getPathInfo();
		System.out.println("METHOD: " + method);
		System.out.println("PATH: " + path);
		AbstractAction action = ActionFactory.createAction(method, path);
		return action.executeRequest(request, response);
	}
}
