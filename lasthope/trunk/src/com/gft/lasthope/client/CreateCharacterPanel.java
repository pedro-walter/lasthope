package com.gft.lasthope.client;

import com.gft.lasthope.shared.Resources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RadioButton;

public class CreateCharacterPanel extends AbsolutePanel {
	Resources r = GWT.create(Resources.class);
	AbsolutePanel root = new AbsolutePanel();
	AbsolutePanel a = new AbsolutePanel();
	AbsolutePanel b = new AbsolutePanel();
	RadioButton warrior = new RadioButton("class","Warrior");
	RadioButton mage = new RadioButton("class","Mage");
	RadioButton ranger = new RadioButton("class","Ranger");
	RadioButton rogue = new RadioButton("class","Rogue");
	
	Character c;
	
	
	Image wImage = new Image(r.warrior());
	Image raImage = new Image(r.ranger());
	Image roImage = new Image(r.rogue());
	Image mImage = new Image(r.mage());
	
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
				b.add(wImage);

			}

		});
		
		mage.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				b.clear();
				b.add(mImage);
				
			}

		});
		
		rogue.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				b.clear();
				b.add(roImage);

			}

		});
		
		ranger.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				b.clear();
				b.add(raImage);

			}

		});
		
		Last_Hope.midPanel.add(a,10,10);
		Last_Hope.midPanel.add(b,370,10);
	}

}
