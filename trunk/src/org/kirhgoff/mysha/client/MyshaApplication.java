package org.kirhgoff.mysha.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyshaApplication implements EntryPoint {
	public interface Images extends ImageBundle{
		AbstractImagePrototype logo();
	}

	public void onModuleLoad() {
		MyshaApplication.Images images = GWT.create(MyshaApplication.Images.class);
		
		final Label errorMessage = new Label();
		errorMessage.setStyleName("error-message");
		final Label logo = new Label ("Mysha");
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

		VerticalPanel labelsComposite = new VerticalPanel ();
		labelsComposite.setHorizontalAlignment(HorizontalPanel.ALIGN_RIGHT);
		labelsComposite.add(new Label ("login"));
		labelsComposite.add(new Label ("password"));
		
		VerticalPanel controlsComposite = new VerticalPanel ();
		labelsComposite.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
		controlsComposite.add(loginBox);
		controlsComposite.add(passwordTextBox);

		HorizontalPanel form = new HorizontalPanel ();
		form.setSpacing(5);
		form.add(labelsComposite);
		form.add(controlsComposite);
		
		VerticalPanel panel = new VerticalPanel();
		panel.setWidth("100%");
		panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		panel.add(images.logo().createImage());
		panel.add(logo);
		panel.add(errorMessage);
		panel.add (form);
		panel.add(loginButton);

		RootPanel.get().add(panel);
	}

	private void checkPassword(final Label errorMessage, String name,
			String password) {
		if ("mysha".equals(name) && "password".equals(password)) {
			errorMessage.setVisible(false);
			// Create the dialog box
			final DialogBox dialogBox = new DialogBox();
			dialogBox.setText("Logged in!");
			dialogBox.setAnimationEnabled(true);
			dialogBox.center();
			dialogBox.show();
		} else {
			errorMessage.setText("Password or login are incorrect!");
		}
	}
}
