package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.interfaces.InitialDataLoaderService;
import org.kirhgoff.mysha.client.interfaces.InitialDataLoaderServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyshaServerApplication implements EntryPoint {
	
	public static MyshaServerApplication.Images IMAGES;
	private LoginPanel loginPage;
	private InboxPanel customerList;

	public interface Images extends ImageBundle {AbstractImagePrototype logo();}
	private MyshaServerApplication () {};

	//============
	//M=A=I=N M=E=T=H=O=D
	// [  @|   @_\\
	//\\   . .      ||
	// \\==============
	//-------------------	
	public void onModuleLoad() {
		IMAGES = GWT.create(MyshaServerApplication.Images.class);
		
		//TODO provide nice way to manipulate with with windows
		//choose some solution
		loginPage = new LoginPanel();
		loginPage.setCallback(new Runnable() {
			public void run() {
				RootPanel.get().remove(loginPage);
				customerList = new InboxPanel();
				RootPanel.get().add(customerList);
			}
		});
		
		RootPanel.get().add(loginPage);
		
		loadSampleData();
	}

	private void loadSampleData() {
		InitialDataLoaderServiceAsync configurationService = GWT.create(InitialDataLoaderService.class);
		
		//TODO why this is needed
		ServiceDefTarget target = (ServiceDefTarget) configurationService;
		target.setServiceEntryPoint(GWT.getModuleBaseURL() + "/InitialDataLoaderService");

		displayMessage("Server initialization...");
		configurationService.loadSampleData(new AsyncCallback<String>() {
			public void onSuccess(String result) {
				displayMessage((String) result);
			}

			public void onFailure(Throwable caught) {
				displayMessage("Failure: " + caught);
				
			}
		});
	}
	
	public void displayMessage(String status) {
		//TODO move display errorMessage label to MainPanel
		loginPage.displayMessage(status);
	}
	
	

}
