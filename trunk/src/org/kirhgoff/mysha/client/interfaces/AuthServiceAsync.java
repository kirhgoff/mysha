package org.kirhgoff.mysha.client.interfaces;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AuthServiceAsync {
	
	public void authorize (String username, String password, AsyncCallback<Boolean> callback);
}
