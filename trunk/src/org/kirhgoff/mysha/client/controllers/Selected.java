package org.kirhgoff.mysha.client.controllers;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class Selected {

    private List<HTML> itemList;

    private ClickListener cl;
   
    public Selected(){

        itemList = new ArrayList<HTML>();

        cl = new ClickListener(){
            public void onClick(Widget selectedItem) {
                for(HTML item : itemList){
                    if(item.equals(selectedItem)){
                        item.addStyleDependentName("selected");
                    }
                    else{
                        item.removeStyleDependentName("selected");
                    }
                }
            }
        };
       
    }
   
    public ClickListener getSelectedCL(){
        return cl;
    }
   
    public void addItem(HTML item){
        itemList.add(item);
        item.addClickListener(cl);
    }
   
    public void removeItem(HTML item){
        itemList.remove(item);
        item.removeClickListener(cl);
    }
   
}
