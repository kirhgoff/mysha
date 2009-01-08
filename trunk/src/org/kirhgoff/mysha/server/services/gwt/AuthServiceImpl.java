package org.kirhgoff.mysha.server.services.gwt;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.kirhgoff.mysha.client.interfaces.AuthService;
import org.kirhgoff.mysha.domain.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class AuthServiceImpl extends RemoteServiceServlet implements AuthService {

	private static final Logger log = Logger.getLogger(AuthServiceImpl.class);
	private static final String USER_SESSION = "gwtMyshaSession";

	private void setUserInSession(User user) {
		log.debug ("Set user: " + user);
		HttpSession session = getThreadLocalRequest().getSession();
		session.setAttribute(USER_SESSION, user);
	}

	private User getUserFromSession() {
		HttpSession session = getThreadLocalRequest().getSession();
		User user = (User) session.getAttribute(USER_SESSION);
		log.debug ("Get user: " + user);
		return user;
	}

	public boolean authorize(String username, String password) {
		log.debug("Authorize: login=" + username + ", logged user=" + getUser ());
		if (getUserFromSession() != null && getUserFromSession().getLogin().equals(username)) {
			log.debug("Already logged in, user=" + username);
			return true;
		}
		
		boolean isOK = username.equals(password);
		if (isOK) {
			User user = new User ();
			user.setLogin (username);
			setUserInSession(user);
		}
		return isOK;
	}
	
	public User getUser () {
		return getUserFromSession();
	}

}
