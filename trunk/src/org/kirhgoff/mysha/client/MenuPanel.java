package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.controllers.Hover;
import org.kirhgoff.mysha.client.controllers.Selected;
import org.kirhgoff.mysha.client.controllers.StatefulPanelController;

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
    //TODO use another controller - stateful controller should be a part of this
    private StatefulPanelController controller = null;
    
    public MenuPanel(StatefulPanelController controller){
    	this.controller = controller;
        selector = new Selected();
       
        panel = new FlowPanel();
        menuTitle = new Label ("Menu");
        panel.setStyleName("menuPanel");    
        menuTitle.setStyleName("menuPanel-menuTitle");

        panel.add(menuTitle);
        //TODO get available actions from controller
        panel.add(link("inbox"));
		panel.add(link("new project"));
		panel.add(link("sandbox"));
		panel.add(link("exit"));
		
        initWidget(panel);
    }

	private HTML link(final String text){
		HTML menuItem = new HTML(text);
        menuItem.setStyleName("menu-item");

        selector.addItem(menuItem);
        menuItem.addMouseListener(Hover.getHoverMla());
        menuItem.addClickListener(new ClickListener(){
            public void onClick(Widget sender){
            	controller.setState (text);
            }
        });

        return menuItem;
    }
}
