package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.pages.CustomerList;
import org.kirhgoff.mysha.client.pages.LoginPage;
import org.kirhgoff.mysha.client.services.ConfigurationRemote;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyshaApplication implements EntryPoint {
	public static MyshaApplication.Images IMAGES;
	private LoginPage loginPage;
	private CustomerList customerList;

	public interface Images extends ImageBundle {
		AbstractImagePrototype logo();
	}

	public void onModuleLoad() {
		IMAGES = GWT.create(MyshaApplication.Images.class);

		loginPage = new LoginPage();
		loginPage.setCallback(new Runnable() {
			public void run() {
				RootPanel.get().remove(loginPage);
				customerList = new CustomerList();
				RootPanel.get().add(customerList);
			}
		});
		RootPanel.get().add(loginPage);

		displayMessage("Server initialization...");
		ConfigurationRemote.Util.getInstance().initServerConfiguration(new DefaultCallback() {
			public void onSuccess(Object result) {
				displayMessage((String) result);
			}

		});
	}

	public void displayMessage(String status) {
		loginPage.displayMessage("<i>" + status + "</i>");
	}

}
