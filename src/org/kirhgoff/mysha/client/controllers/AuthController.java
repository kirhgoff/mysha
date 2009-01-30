package org.kirhgoff.mysha.client.controllers;


import org.kirhgoff.mysha.client.interfaces.AuthService;
import org.kirhgoff.mysha.client.interfaces.AuthServiceAsync;
import org.kirhgoff.mysha.domain.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;

public class AuthController  {

	public static void checkUserIsAlreadyLogged() {
		AuthServiceAsync authService = GWT.create(AuthService.class);
		authService.getUser(new AsyncCallback<User>() {
			public void onSuccess(User result) {
				System.out.println("AuthController: getUser: " + result);
				if (result != null)
					History.fireCurrentHistoryState();
				else
					History.newItem("Login", true);
			}
		
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				History.newItem("Login");
			}
		});
	}

	public static void addUserNameToHeader(final Label label) {
		AuthServiceAsync authService = GWT.create(AuthService.class);
		authService.getUser(new AsyncCallback<User>() {
			public void onSuccess(User result) {
				label.setText("Hello, " + result.getLogin());
			}
	
			public void onFailure(Throwable caught) {
				label.setText("Cannot access customers service:" + caught.getMessage());
			}			
		});
		
	}	


}
