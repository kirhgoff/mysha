package org.kirhgoff.mysha.domain;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -868814075433277533L;
	private String login;

	public void setLogin(String username) {
		this.login = username;
	}
	
	public String getLogin () {
		return login;
	}
	
	@Override
	public String toString() {
		return "User [" + login + "]";
	}

}
