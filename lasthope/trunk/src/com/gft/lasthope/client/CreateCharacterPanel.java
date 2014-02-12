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
	Label classL = new Label();

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
		classL.setStyleName("textInsideChar");

		name.setText("Name");
		nameT.setSize("150px", "20px");

		classL.setText("Class");

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

		stats.add(strL, 10, 200);
		stats.add(dexL, 10, 220);
		stats.add(intL, 10, 240);
		stats.add(chaL, 10, 260);

		b.add(stats);

		listClass.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				changeClass("Human",
						listClass.getItemText(listClass.getSelectedIndex()));

			}

		});

		a.add(name, 10, 90);
		a.add(nameT, 50, 90);

		a.add(classL, 10, 130);
		a.add(listClass, 50, 130);

		Last_Hope.midPanel.add(a, 10, 10);
		Last_Hope.midPanel.add(b, 370, 10);

	}

	private void changeClass(String race, String classe) {
		b.clear();
		if (classe.equals("Warrior")){
			c.criaPersonagem("Human", "Warrior");
			b.add(wImage, 110, 40);
		}
		else if (classe.equals("Mage")){
			c.criaPersonagem("Human", "Mage");
			b.add(mImage, 110, 40);
		}
		else if (classe.equals("Archer")){
			c.criaPersonagem("Human", "Archer");
			b.add(aImage, 110, 40);
		}
		else if (classe.equals("Rogue")){
			c.criaPersonagem("Human", "Rogue");
			b.add(rImage, 110, 40);
		}
		else {
			b.clear();
			stats.clear();
			b.add(tituloB);
		}

		// criar metodo para popular o stats e a imagem
		// pois assim esta ficando em branco apos o primeiro click em ---

		System.out.println("Isso deveria acontecer");

		strL.setText("Strength: " + c.getStrength());
		dexL.setText("Dextrity: " + c.getDexterity());
		intL.setText("Intelect: " + c.getIntellect());
		chaL.setText("Charisma: " + c.getCharisma());

		System.out.println(strL);
		System.out.println(dexL);
		System.out.println(intL);
		System.out.println(chaL);

		System.out.println(stats);

		b.add(tituloB);
		b.add(stats);

	}

}
