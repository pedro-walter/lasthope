package com.gft.lasthope.client;

import com.gft.lasthope.shared.Resources;
import com.gft.lasthope.shared.Character;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class CreateCharacterPanel extends AbsolutePanel {
	Resources r = GWT.create(Resources.class);
	AbsolutePanel stats = new AbsolutePanel();
	AbsolutePanel a = new AbsolutePanel();
	AbsolutePanel b = new AbsolutePanel();
	ListBox listClass = new ListBox();
	Label strL = new Label();
	Label dexL = new Label();
	Label intL = new Label();
	Label chaL = new Label();
	Character c = new Character();
	Image wImage = new Image(r.warrior());
	Image aImage = new Image(r.ranger());
	Image rImage = new Image(r.rogue());
	Image mImage = new Image(r.mage());
	
	Label tituloA = new Label();
	Label tituloB = new Label();
	Label name = new Label();
	
	TextBox nameT = new TextBox();

	public CreateCharacterPanel() {

		// estilos
		a.setStyleName("dockPanel");
		b.setStyleName("dockPanel");
		tituloA.setStyleName("titleChar");
		tituloB.setStyleName("titleChar");
		strL.setStyleName("textInsideChar");
		dexL.setStyleName("textInsideChar");
		intL.setStyleName("textInsideChar");
		chaL.setStyleName("textInsideChar");
		listClass.setStyleName("textInsideChar");
		name.setStyleName("textInsideChar");
		nameT.setStyleName("textInsideChar");
		
		
		name.setText("Name");
		nameT.setSize("25px", "100px");

		a.setSize("350px", "350px");
		b.setSize("350px", "350px");
		
		
		tituloA.setText("Create new Character");
		tituloB.setText("Stats of the Character");
		
		a.add(tituloA);
		b.add(tituloB);

		listClass.addItem("Warrior");
		listClass.addItem("Mage");
		listClass.addItem("Archer");
		listClass.addItem("Rogue");
		
		changeClass("Human", listClass.getItemText(0));

		listClass.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				changeClass("Human",
						listClass.getItemText(listClass.getSelectedIndex()));

			}

		});

		a.add(name,10,50);
		a.add(nameT,35,50);

		Last_Hope.midPanel.add(a, 10, 10);
		Last_Hope.midPanel.add(b, 370, 10);
	}

	private void changeClass(String race, String classe) {
		switch (classe) {
		case "Warrior":
			b.clear();
			c.criaPersonagem("Human", "Warrior");
			b.add(wImage);
			break;
		case "Mage":
			b.clear();
			c.criaPersonagem("Human", "Mage");
			b.add(mImage);
			break;
		case "Archer":
			b.clear();
			c.criaPersonagem("Human", "Archer");
			b.add(aImage);
			break;
		case "Rogue":
			b.clear();
			c.criaPersonagem("Human", "Rogue");
			b.add(rImage);
			break;
		}

		strL.setText("Strength: " + c.getStrength());
		dexL.setText("Dextrity: " + c.getDexterity());
		intL.setText("Intelect: " + c.getIntellect());
		chaL.setText("Charisma: " + c.getCharisma());

		stats.add(strL);
		stats.add(dexL);
		stats.add(intL);
		stats.add(chaL);

		b.add(stats);
	}

}
