package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.interfaces.AuthService;
import org.kirhgoff.mysha.client.interfaces.AuthServiceAsync;

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

public class LoginPanel extends Composite {
	private Runnable succesfulLoginCallback;
	
	//TODO create MainPanel and extract status bar there
	private Label errorMessage;

	public LoginPanel() {
		errorMessage = new Label();
		errorMessage.setStyleName("error-message");
		final Label logo = new Label("Mysha");
		logo.setStyleName("loginPanel-title");

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
		panel.add(MyshaClientApplication.IMAGES.logo().createImage());
		panel.add(logo);
		panel.add(errorMessage);
		panel.add(form);
		panel.add(loginButton);
		
		//TODO understand
		initWidget(panel);
	}

	private void checkPassword(final Label errorMessage, String name, String password) {
		AuthServiceAsync authService = GWT.create(AuthService.class);
		authService.authorize(name, password, new AsyncCallback<Boolean>() {
			public void onSuccess(Boolean result) {
				if (result) {
					succesfulLoginCallback.run();
				} else {
					displayMessage("Password or login are incorrect!");
				}
			}

			public void onFailure(Throwable caught) {
				displayMessage("Cannot access auth service: " + caught.getMessage());
			}
		});
	}

	public void displayMessage (String message) {
		errorMessage.setText(message);
	}
	
	public void setCallback(Runnable runnable) {
		succesfulLoginCallback = runnable;
	}	
	

}
