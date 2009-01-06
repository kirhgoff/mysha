package org.kirhgoff.mysha.client.interfaces;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Loads initial sample data for testing purposes
 */
//Why its work without this annotation
//@RemoteServiceRelativePath("/InitialDataLoaderService")
public interface InitialDataLoaderServiceAsync {

	public void loadSampleData(AsyncCallback<String> callback);
}
