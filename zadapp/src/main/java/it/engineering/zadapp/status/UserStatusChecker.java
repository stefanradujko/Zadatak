package it.engineering.zadapp.status;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import it.engineering.zadapp.dto.KorisnikDto;

@Component
public class UserStatusChecker {
	public boolean checkUserStatus(HttpServletRequest request) {
		HttpSession session = request.getSession();
		try{
			KorisnikDto k = (KorisnikDto) session.getAttribute("loggedUser");
			if(k == null) {
				return false;
			}
		} catch(Exception e){
			return false;
		}
		return true;
	}
}
