package com.gft.lasthope.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;

public class BotaoSair extends Button {

	public BotaoSair(){
		this.setText("Quit");
		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(Window.confirm("You really want to leave?")){
					Last_Hope.midPanel.clear();
					Menus.habilitaMenu();
				}
			}

		});
	}

}
