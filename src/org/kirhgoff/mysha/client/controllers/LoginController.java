package org.kirhgoff.mysha.client.controllers;

import org.kirhgoff.mysha.client.MyshaClientApplication;
import org.kirhgoff.mysha.client.interfaces.AuthService;
import org.kirhgoff.mysha.client.interfaces.AuthServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginController {

	//TODO yak
	public void registerLoginButton(Button loginButton, final TextBox loginBox, final PasswordTextBox passwordTextBox, final Label errorMessage) {
		loginButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				AuthServiceAsync authService = GWT.create(AuthService.class);
				authService.authorize(loginBox.getText(), passwordTextBox.getText(), new AsyncCallback<Boolean>() {
					public void onSuccess(Boolean result) {
						if (result) {
							History.newItem("Inbox");
						} else {
							MyshaClientApplication.setStatus("ERROR: Password or login are incorrect!");
						}
					}
			
					public void onFailure(Throwable caught) {
						MyshaClientApplication.setStatus("ERROR: Cannot access auth service: " + caught.getMessage());
						History.newItem("Login");
					}
				});
			}
		});
	}
}
