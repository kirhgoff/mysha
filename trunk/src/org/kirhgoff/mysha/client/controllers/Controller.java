package org.kirhgoff.mysha.client.controllers;

import java.util.Map;

public interface Controller {
	Map<String, Action> getActions ();
	Action getActionByName (String name);
}
