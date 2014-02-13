package com.gft.lasthope.client;

import com.gft.lasthope.shared.Resources;
import com.gft.lasthope.shared.Character;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
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
	ListBox listRace = new ListBox();
	Label strL = new Label();
	Label dexL = new Label();
	Label intL = new Label();
	Label chaL = new Label();
	Label hpL = new Label();
	Label mpL = new Label();
	Character c;
	Image wImage = new Image(r.warrior());
	Image aImage = new Image(r.archer());
	Image rImage = new Image(r.rogue());
	Image mImage = new Image(r.mage());

	Label tituloA = new Label();
	Label tituloB = new Label();
	Label name = new Label();
	Label classL = new Label();
	Label raceL = new Label();

	Button create = new Button();

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
		listRace.setStyleName("textInsideChar");
		name.setStyleName("textInsideChar");
		nameT.setStyleName("textInsideChar");
		classL.setStyleName("textInsideChar");
		raceL.setStyleName("textInsideChar");
		// create.setStyleName("textInsideChar");

		name.setText("Name");
		nameT.setSize("150px", "20px");

		classL.setText("Class");
		raceL.setText("Race");
		create.setText("Create");

		a.setSize("350px", "350px");
		b.setSize("350px", "350px");

		tituloA.setText("Create new Character");
		tituloB.setText("Stats of the Character");

		a.add(tituloA);
		b.add(tituloB);

		listClass.addItem("---");
		listClass.addItem("Warrior");
		listClass.addItem("Mage");
		listClass.addItem("Archer");
		listClass.addItem("Rogue");

		listRace.addItem("---");
		listRace.addItem("Human");
		listRace.addItem("Dwarf");
		listRace.addItem("Half-Orc");
		listRace.addItem("Elf");

		b.add(stats);

		listClass.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				changeClass(listRace.getItemText(listRace.getSelectedIndex()),
						listClass.getItemText(listClass.getSelectedIndex()));

			}

		});

		listRace.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				changeClass(listRace.getItemText(listRace.getSelectedIndex()),
						listClass.getItemText(listClass.getSelectedIndex()));
			}

		});

		create.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				create();

			}

		});

		a.add(name, 10, 90);
		a.add(nameT, 50, 90);

		a.add(classL, 10, 130);
		a.add(listClass, 50, 130);

		a.add(raceL, 10, 160);
		a.add(listRace, 50, 160);

		a.add(create, 290, 315);

		Last_Hope.midPanel.add(a, 10, 10);
		Last_Hope.midPanel.add(b, 370, 10);

	}

	private void changeClass(String race, String classe) {
		b.clear();

		if (race.equals("---")) {
			race = "Human";
		}

		if (classe.equals("Warrior")) {
			populateStats(race, classe, wImage);
		} else if (classe.equals("Mage")) {
			populateStats(race, classe, mImage);
		} else if (classe.equals("Archer")) {
			populateStats(race, classe, aImage);
		} else if (classe.equals("Rogue")) {
			populateStats(race, classe, rImage);
		} else {
			populateStatsEmpty();
		}

		b.add(tituloB);
		b.add(stats);

	}

	private void populateStats(String race, String classe, Image i) {

		c = new Character(race, classe);
		c.setModificators(c);

		System.out.println(race);
		System.out.println(classe);

		b.add(tituloB);
		// c.criaPersonagem(race, classe);
		b.add(i, 110, 40);

		strL.setText("Strength: " + c.getStrength());
		dexL.setText("Dextrity: " + c.getDexterity());
		intL.setText("Intelect: " + c.getIntellect());
		chaL.setText("Charisma: " + c.getCharisma());

		hpL.setText("HP: " + c.getHpMax());
		mpL.setText("MP: " + c.getMpMax());


		stats.add(strL, 10, 200);
		stats.add(dexL, 10, 220);
		stats.add(intL, 10, 240);
		stats.add(chaL, 10, 260);
		stats.add(hpL, 10, 280);
		stats.add(mpL, 10, 300);

	}

	private void populateStatsEmpty() {
		b.clear();
		stats.clear();
		b.add(tituloB);
	}


	private void create() {

		if(nameT.getText().equals("")){
			Window.alert("Enter a name");
		}else if(listClass.getItemText(listClass.getSelectedIndex()).equals("---")){
			Window.alert("Select a Class");
		}else if(listClass.getItemText(listRace.getSelectedIndex()).equals("---")){
			Window.alert("Select a Race");
		}else{
			c.setName(nameT.getText());
			Last_Hope.setCharacter(c);
			Last_Hope.midPanel.clear();
			Menus.habilitaMenu();
		}

	}

}
