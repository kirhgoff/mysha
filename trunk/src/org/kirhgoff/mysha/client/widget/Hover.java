package org.kirhgoff.mysha.client.widget;

import com.google.gwt.user.client.ui.MouseListenerAdapter;
import com.google.gwt.user.client.ui.Widget;

public class Hover {

    private static MouseListenerAdapter mla;

    public static MouseListenerAdapter getHoverMla(){
        if(mla == null){
            mla = new MouseListenerAdapter(){
                    public void onMouseEnter(Widget hoverableWidget){
                       hoverableWidget.addStyleDependentName("hover");
                       System.out.println("bebebe");
                    }
                    public void onMouseLeave(Widget hoverableWidget){
                        hoverableWidget.removeStyleDependentName("hover");
                    }
                };
        }
        return mla;
    }
}
