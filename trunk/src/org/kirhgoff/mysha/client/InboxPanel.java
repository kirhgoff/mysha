package org.kirhgoff.mysha.client;



import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class InboxPanel extends Composite {
	public InboxPanel() {

		VerticalPanel mainPanel = new VerticalPanel ();
		
		mainPanel.add(new TaskListPanel ());
		initWidget(mainPanel);
		
	}

}
