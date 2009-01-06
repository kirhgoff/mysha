package org.kirhgoff.mysha.server.services.gwt;

import org.kirhgoff.mysha.client.interfaces.AuthService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class AuthServiceImpl extends RemoteServiceServlet implements AuthService {

	public boolean authorize(String username, String password) {
		//TODO dao call
		return "mysha".equals(username) && "password".equals(password);
	}

}
