package com.gft.lasthope.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RadioButton;

public class CreateCharacterPanel extends AbsolutePanel {
	AbsolutePanel root = new AbsolutePanel();
	AbsolutePanel a = new AbsolutePanel();
	AbsolutePanel b = new AbsolutePanel();
	RadioButton warrior = new RadioButton("class","Warrior");
	RadioButton mage = new RadioButton("class","Mage");
	RadioButton ranger = new RadioButton("class","Ranger");
	RadioButton rogue = new RadioButton("class","Rogue");
	Image cImage = new Image();
	
	public CreateCharacterPanel(){
		
		//estilos
		a.setStyleName("dockPanel");
		b.setStyleName("dockPanel");
		
		a.setSize("350px", "350px");
		b.setSize("350px", "350px");
		
		a.add(warrior);
		a.add(mage);
		a.add(ranger);
		a.add(rogue);
		
		warrior.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				b.clear();
				cImage.setUrl(GWT.getModuleBaseURL() + "images/warrior.png");
				b.add(cImage);

			}

		});
		
		mage.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				b.clear();
				cImage.setUrl(GWT.getModuleBaseURL() + "images/mage.png");
				b.add(cImage);

			}

		});
		
		rogue.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				b.clear();
				cImage.setUrl(GWT.getModuleBaseURL() + "images/rogue.png");
				b.add(cImage);

			}

		});
		
		ranger.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				b.clear();
				cImage.setUrl(GWT.getModuleBaseURL() + "images/ranger.png");
				b.add(cImage);

			}

		});
		
		Last_Hope.midPanel.add(a,10,10);
		Last_Hope.midPanel.add(b,370,10);
	}

}
