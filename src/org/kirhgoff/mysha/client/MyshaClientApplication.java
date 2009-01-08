package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.controllers.HistoryController;
import org.kirhgoff.mysha.client.interfaces.InitialDataLoaderService;
import org.kirhgoff.mysha.client.interfaces.InitialDataLoaderServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyshaClientApplication implements EntryPoint, HistoryListener {
	public static MyshaClientApplication.Images IMAGES;
	public interface Images extends ImageBundle {AbstractImagePrototype logo();}
	public DeckPanel layout;
	private HistoryController historyController;
	
	private MyshaClientApplication () {};

	//============
	//M=A=I=N M=E=T=H=O=D
	// [  @|   @_\\
	//\\   . .      ||
	// \\==============
	//-------------------	
	public void onModuleLoad() {
		IMAGES = GWT.create(MyshaClientApplication.Images.class);
		loadSampleData();
	
		layout = new DeckPanel ();
//		LoginPanel loginPanel = new LoginPanel ();
//		InboxPanel inboxPanel = new InboxPanel ();
//
//		layout.add(loginPanel);
//		layout.add(inboxPanel);

		historyController = new HistoryController (layout);
		
		RootPanel.get().add(layout);
		History.addHistoryListener(this);
		History.newItem("Login");
	}

	private void loadSampleData() {
		InitialDataLoaderServiceAsync configurationService = GWT.create(InitialDataLoaderService.class);
		
		//TODO why this is needed
		ServiceDefTarget target = (ServiceDefTarget) configurationService;
		target.setServiceEntryPoint(GWT.getModuleBaseURL() + "/InitialDataLoaderService");

		System.out.println("Uploading sample data ...");
		configurationService.loadSampleData(new AsyncCallback<String>() {
			public void onSuccess(String result) {
				//displayMessage((String) result);
				System.out.println("Sample data uploaded.");
			}

			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}
		});
	}

	//TODO NavigationController
	public void onHistoryChanged(String historyToken) {
		historyController.onHistoryChanged (historyToken);
	}

}
