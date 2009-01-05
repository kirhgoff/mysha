package org.kirhgoff.mysha.server;

import org.kirhgoff.mysha.client.services.AuthService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class AuthServiceImpl extends RemoteServiceServlet implements AuthService {

	public boolean authorize(String username, String password) {
		return "mysha".equals(username) && "password".equals(password);
	}

}
