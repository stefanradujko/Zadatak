package it.engineering.zadapp.actionfactory;

import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.action.login.LoginAction;
import it.engineering.zadapp.action.logout.LogoutAction;
import it.engineering.zadapp.action.navigation.FetchCreatePro;
import it.engineering.zadapp.action.navigation.FetchFindPro;
import it.engineering.zadapp.action.navigation.FetchHome;
import it.engineering.zadapp.action.proizvodjac.AddProAction;
import it.engineering.zadapp.action.proizvodjac.ConfirmDeleteAction;
import it.engineering.zadapp.action.proizvodjac.ConfirmUpdateAction;
import it.engineering.zadapp.action.proizvodjac.UpdateDeleteProAction;
import it.engineering.zadapp.action.proizvodjac.ViewAllProAction;
import it.engineering.zadapp.action.proizvodjac.ViewProAction;
import it.engineering.zadapp.constants.WebConstants;

public class ActionFactory {
	public static AbstractAction createAction(String method, String path) {
		AbstractAction action = null;
		switch(path) {
		case WebConstants.PATH_LOGIN:
			action = new LoginAction();
			break;
		case WebConstants.PATH_CREATE_PRO:
			action = new FetchCreatePro();
			break;
		case WebConstants.PATH_SAVE_PRO:
			action = new AddProAction();
			break;
		case WebConstants.PATH_FIND_PRO:
			action = new FetchFindPro();
			break;
		case WebConstants.PATH_VIEW_PRO:
			action = new ViewProAction();
			break;
		case WebConstants.PATH_LOGOUT:
			action = new LogoutAction();
			break;
		case WebConstants.PATH_UP_DEL:
			action = new UpdateDeleteProAction();
			break;
		case WebConstants.PATH_VIEW_ALL:
			action = new ViewAllProAction();
			break;
		case WebConstants.PATH_HOME:
			action = new FetchHome();
			break;
		case WebConstants.PATH_CONFIRM_DELETE:
			action = new ConfirmDeleteAction();
			break;
		case WebConstants.PATH_CONFIRM_UPDATE:
			action = new ConfirmUpdateAction();
			break;
		default:
			break;
		}
		return action;
	}
}
