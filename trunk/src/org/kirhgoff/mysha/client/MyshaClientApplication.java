package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.controllers.AuthController;
import org.kirhgoff.mysha.client.interfaces.InitialDataLoaderService;
import org.kirhgoff.mysha.client.interfaces.InitialDataLoaderServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyshaClientApplication implements EntryPoint {
	public static MyshaClientApplication.Images IMAGES;
	public interface Images extends ImageBundle {AbstractImagePrototype logo();}
	private MainPanel mainPanel;
	
	private MyshaClientApplication () {};
	private static MyshaClientApplication INSTANCE = null;
	//============
	//M=A=I=N M=E=T=H=O=D
	// [  @|   @_\\
	//\\   . .      ||
	// \\==============
	//-------------------	
	public void onModuleLoad() {
		if (INSTANCE == null) INSTANCE = this;
		IMAGES = GWT.create(MyshaClientApplication.Images.class);

		mainPanel = new MainPanel ();
		RootPanel.get().add(mainPanel);

		loadSampleData();
		AuthController.checkUserIsAlreadyLogged ();	
	}

	private void loadSampleData() {
		InitialDataLoaderServiceAsync configurationService = GWT.create(InitialDataLoaderService.class);
		
		//TODO why this is needed
		ServiceDefTarget target = (ServiceDefTarget) configurationService;
		target.setServiceEntryPoint(GWT.getModuleBaseURL() + "/InitialDataLoaderService");

		setStatus("Uploading sample data ...");
		configurationService.loadSampleData(new AsyncCallback<String>() {
			public void onSuccess(String result) {
				//displayMessage((String) result);
				setStatus("Sample data uploaded.");
			}

			public void onFailure(Throwable caught) {
				setStatus(caught);
			}
		});
	}
	
	public static void setStatus (String text) {
		System.out.println(text);
		Label messageLabel = INSTANCE.mainPanel.getMessageLabel();
		messageLabel.setText("System: " + text);
	}
	
	public static void setStatus (Throwable e) {
		e.printStackTrace();
		Label messageLabel = INSTANCE.mainPanel.getMessageLabel();
		messageLabel.setText("ERROR: " + e.getMessage());
	}
}
