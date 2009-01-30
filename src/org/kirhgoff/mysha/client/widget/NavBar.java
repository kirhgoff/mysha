package org.kirhgoff.mysha.client.widget;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class NavBar extends Composite{

    public static String BLOG_HOME="http://blog.studyblue.com/";
   
    private int ID=1;
    private Selected selector;

	private FlowPanel holder;

    public NavBar(){
        super();

        selector = new Selected();
       
        holder = new FlowPanel();
        holder.setStyleName("NavBar-Holder");    
       
        initWidget(holder);
    }

	public void addNavItem(String text, String location) {
		holder.add(link(text,location));
	}

    
    private HTML link(String text, String location){
        HTML ret = new HTML(text);
        ret.setStyleName("nav-item-"+ID);
        ret.addStyleName("nav-item");

        selector.addItem(ret);
        ret.addMouseListener(Hover.getHoverMla());
        ret.addClickListener(new ClickListener(){
            public void onClick(Widget sender){
               ///Open popup with blog page location
            }
        });

        ID++;

        return ret;
    }

}
