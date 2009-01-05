package org.kirhgoff.mysha.client.pages;

import org.kirhgoff.mysha.client.MyshaApplication;
import org.kirhgoff.mysha.client.services.AuthService;
import org.kirhgoff.mysha.client.services.AuthServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class LoginPage extends Composite {
	private Runnable succesfulLoginCallback;
	
	public LoginPage() {
		final Label errorMessage = new Label();
		errorMessage.setStyleName("error-message");
		final Label logo = new Label("Mysha");
		logo.setStyleName("logo-label");

		final TextBox loginBox = new TextBox();
		final PasswordTextBox passwordTextBox = new PasswordTextBox();

		Button loginButton = new Button("Login");
		loginButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				checkPassword(errorMessage, loginBox.getText(), passwordTextBox.getText());
			}
		});

		loginBox.setFocus(true);
		loginBox.setTabIndex(1);
		passwordTextBox.setTabIndex(2);
		loginButton.setTabIndex(3);

		VerticalPanel labelsComposite = new VerticalPanel();
		labelsComposite.setHorizontalAlignment(HorizontalPanel.ALIGN_RIGHT);
		labelsComposite.add(new Label("login"));
		labelsComposite.add(new Label("password"));

		VerticalPanel controlsComposite = new VerticalPanel();
		labelsComposite.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
		controlsComposite.add(loginBox);
		controlsComposite.add(passwordTextBox);

		HorizontalPanel form = new HorizontalPanel();
		form.setSpacing(5);
		form.add(labelsComposite);
		form.add(controlsComposite);

		VerticalPanel panel = new VerticalPanel();
		panel.setWidth("100%");
		panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		panel.add(MyshaApplication.IMAGES.logo().createImage());
		panel.add(logo);
		panel.add(errorMessage);
		panel.add(form);
		panel.add(loginButton);
		
		initWidget(panel);
	}

	private void checkPassword(final Label errorMessage, String name, String password) {
		AuthServiceAsync authService = GWT.create(AuthService.class);
		authService.authorize(name, password, new AsyncCallback<Boolean>() {
			public void onSuccess(Boolean result) {
				if (result) {
					succesfulLoginCallback.run();
				} else {
					errorMessage.setText("Password or login are incorrect!");
				}
			}

			public void onFailure(Throwable caught) {
				errorMessage.setText("Cannot access auth service: " + caught.getMessage());
			}
		});
	}

	public void setCallback(Runnable runnable) {
		succesfulLoginCallback = runnable;
	}

}
