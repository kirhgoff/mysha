package org.kirhgoff.mysha.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ConfigurationRemoteAsync
{
	/**
	 * Returns the server configuration
	 */
	public void initServerConfiguration(AsyncCallback callback);
}
