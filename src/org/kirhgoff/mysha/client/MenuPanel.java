package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.controllers.Action;
import org.kirhgoff.mysha.client.controllers.AuthController;
import org.kirhgoff.mysha.client.controllers.HistoryAction;
import org.kirhgoff.mysha.client.controllers.Hover;
import org.kirhgoff.mysha.client.controllers.Selected;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MenuPanel extends Composite {
    private Label menuTitle;
	private FlowPanel panel;
    private Selected selector;


    public MenuPanel(){
        selector = new Selected();
       
        panel = new FlowPanel();
        menuTitle = new Label ("Menu");
        panel.setStyleName("menuPanel");    
        menuTitle.setStyleName("menuPanel-menuTitle");

        panel.add(menuTitle);
        //TODO use history controller and change active panel directly from it
        panel.add(link("inbox", createInboxAction()));
		panel.add(link("new project", createNewProjectAction()));
		panel.add(link("sandbox", new HistoryAction ("Sandbox")));
		panel.add(link("exit", createExitAction()));
		
        initWidget(panel);
    }

	private HTML link(String text, final Action action){
		HTML menuItem = new HTML(text);
        menuItem.setStyleName("menu-item");

        selector.addItem(menuItem);
        menuItem.addMouseListener(Hover.getHoverMla());
        menuItem.addClickListener(new ClickListener(){
            public void onClick(Widget sender){
            	action.invoke ();
            }
        });

        return menuItem;
    }
	
	private Action createExitAction() {
		return new Action () {
			public void invoke() {
				//1. Send server message that we are logged off
				AuthController.logoffCurentUser ();
				
				//2. hide menu
				hideMenu ();
				
				//3. send message to active console
				new HistoryAction ("Exit").invoke();
			}
		};
	}

	protected void hideMenu() {
		// TODO Auto-generated method stub
		
	}

	private HistoryAction createNewProjectAction() {
		return new HistoryAction ("AddTask");
	}

	private HistoryAction createInboxAction() {
		return new HistoryAction ("Inbox");
	}

}
