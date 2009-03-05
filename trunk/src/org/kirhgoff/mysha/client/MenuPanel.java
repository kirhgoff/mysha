package org.kirhgoff.mysha.client;

import java.util.Collection;

import org.kirhgoff.mysha.client.controllers.ActionListController;
import org.kirhgoff.mysha.client.controllers.Controller;
import org.kirhgoff.mysha.client.controllers.Hover;
import org.kirhgoff.mysha.client.controllers.Selected;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

public class MenuPanel extends Composite {

    
    public MenuPanel(Controller actionSource){
    	Selected selector = new Selected();
       
    	FlowPanel panel = new FlowPanel();
    	Label menuTitle = new Label ("Menu");
        panel.setStyleName("menuPanel");    
        menuTitle.setStyleName("menuPanel-menuTitle");

        panel.add(menuTitle);
        
        ActionListController menuController  = new ActionListController ();
        menuController.getActionsFromTheSource (actionSource);
        
        Collection<String> actionNames = menuController.getActionNames ();
        for (String actionName : actionNames) {
    		HTML menuItem = new HTML(actionName);
            menuItem.setStyleName("menu-item");

            selector.addItem(menuItem);
            menuItem.addMouseListener(Hover.getHoverMouseListener());
            menuController.createTriggerForClick (actionName, menuItem);
            panel.add(menuItem);
		}
		
        initWidget(panel);
    }
}
