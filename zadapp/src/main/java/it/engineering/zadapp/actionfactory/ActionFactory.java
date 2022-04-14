package it.engineering.zadapp.actionfactory;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.action.login.LoginAction;
import it.engineering.zadapp.constants.WebConstants;

public class ActionFactory {
	public static AbstractAction createAction(String method, String path) {
		AbstractAction action = null;
		switch(path) {
		case WebConstants.PATH_LOGIN:
			action = new LoginAction();
			break;
		default:
			break;
		}
		return action;
	}
}
