package it.engineering.zadapp.action.navigation;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.engineering.zadapp.action.AbstractAction;
import it.engineering.zadapp.constants.WebConstants;


public class FetchFindPro extends AbstractAction {

	
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		return WebConstants.PAGE_FIND_PRO;
	}

}
