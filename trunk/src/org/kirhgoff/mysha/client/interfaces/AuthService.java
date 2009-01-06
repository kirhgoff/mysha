package org.kirhgoff.mysha.client.interfaces;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("/AuthService")
public interface AuthService extends RemoteService {

	public boolean authorize (String username, String password);
}
