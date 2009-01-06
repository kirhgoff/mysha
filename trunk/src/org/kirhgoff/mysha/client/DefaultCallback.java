package org.kirhgoff.mysha.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class DefaultCallback implements AsyncCallback {

	public void onFailure(Throwable caught) {
		String message = caught.getMessage();
		if ((message == null) || (message.length() == 0)) {
			message = caught.toString();
		}
		ApplicationParameters.getInstance().getApplication().displayMessage(message);
	}
}
