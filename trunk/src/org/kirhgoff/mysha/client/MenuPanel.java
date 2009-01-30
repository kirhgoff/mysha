package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.widget.Hover;
import org.kirhgoff.mysha.client.widget.Selected;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MenuPanel extends Composite {
    private int lastMenuItemID=1;
    private Selected selector;

    private Label menuTitle = new Label ("Menu");
	private FlowPanel holder;

    public MenuPanel(){

        selector = new Selected();
       
        holder = new FlowPanel();
        holder.setStyleName("menuPanel");    
        holder.add(menuTitle);
        menuTitle.setStyleName("menuPanel-menuTitle");
		
        holder.add(link("Inbox", "Inbox"));
		holder.add(link("Add task", "AddTask"));
		
        initWidget(holder);
    }

	private HTML link(String text, final String location){
		HTML menuItem = new HTML(text);
        menuItem.setStyleName("menu-item");

        selector.addItem(menuItem);
        menuItem.addMouseListener(Hover.getHoverMla());
        menuItem.addClickListener(new ClickListener(){
            public void onClick(Widget sender){
            	History.newItem(location);
            }
        });

        lastMenuItemID++;

        return menuItem;
    }
}
