package org.kirhgoff.mysha.client.controllers;

import org.kirhgoff.mysha.client.interfaces.AuthService;
import org.kirhgoff.mysha.client.interfaces.AuthServiceAsync;
import org.kirhgoff.mysha.domain.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AuthController  {

	public static void checkUserIsAlreadyLogged() {
		AuthServiceAsync authService = GWT.create(AuthService.class);
		authService.getUser(new AsyncCallback<User>() {
			public void onSuccess(User result) {
				if (result != null)
					History.newItem("Inbox");
			}
		
			public void onFailure(Throwable caught) {
				History.newItem("Login");
			}
		});
		
	}

}
