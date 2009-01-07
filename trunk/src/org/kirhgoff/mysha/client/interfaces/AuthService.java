package org.kirhgoff.mysha.client.interfaces;

import org.kirhgoff.mysha.domain.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("/AuthService")
public interface AuthService extends RemoteService {

	boolean authorize (String username, String password);
	User getUser ();
}
