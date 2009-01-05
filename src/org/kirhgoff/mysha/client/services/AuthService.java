package org.kirhgoff.mysha.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("/service/auth")
public interface AuthService extends RemoteService {
	public boolean authorize (String username, String password);
}
