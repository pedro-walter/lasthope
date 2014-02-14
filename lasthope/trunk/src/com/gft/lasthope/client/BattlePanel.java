package com.gft.lasthope.client;

import com.gft.lasthope.shared.Enemy;
import com.gft.lasthope.shared.Resources;
import com.gft.lasthope.shared.Weapon;
import com.gft.lasthope.shared.Item;
import com.gft.lasthope.shared.Character;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;

public class BattlePanel extends AbsolutePanel {

	static Resources r = GWT.create(Resources.class);
	AbsolutePanel actions = new AbsolutePanel();
	AbsolutePanel battleInfo = new AbsolutePanel();
	AbsolutePanel inimigo = new AbsolutePanel();
	AbsolutePanel perso = new AbsolutePanel();
	final static TextArea logBattle = new TextArea();
	final Label nomeInimigo = new Label();
	Label nomePerso = new Label();
	static Label hpAtualInimigo = new Label();
	Label hpMaxInimigo = new Label();
	static Label hpAtualPerso = new Label();
	Label hpMaxPerso = new Label();
	static Label mpAtualInimigo = new Label();
	Label mpMaxInimigo = new Label();
	static Label mpAtualPerso = new Label();
	Label mpMaxPerso = new Label();
	Label strI = new Label();
	Label dexI = new Label();
	Label intI = new Label();
	Label chaI = new Label();
	Label strP = new Label();
	Label dexP = new Label();
	Label intP = new Label();
	Label chaP = new Label();
	Label raceI = new Label();
	Label raceP = new Label();
	Label classI = new Label();
	Label classP = new Label();
	static Label statusI = new Label();
	static Label statusP = new Label();
	Label hpI = new Label("HP");
	Label hpP = new Label("HP");
	Label mpI = new Label("MP");
	Label mpP = new Label("MP");
	Label battleInfoL = new Label("Battle Info");
	static Button sair = new BotaoSair();
	static Button atacar = new Button();
	Button btnLimpaLog = new Button();
	Button defender = new Button();
	static Character p = Last_Hope.getCharacter();
	Enemy e;
	

	Item it = new Item();
	Weapon w;
	Battle b;

	public BattlePanel() {
		
		b = new Battle();
		
		e = Last_Hope.getEnemy();
		
		//e.setModificators(e);
		atacar.setEnabled(true);

		it.updateWeapons();
		p.setWeapon((Weapon)it.listWeapons.get(2));
		e.setWeapon((Weapon)it.listWeapons.get(2));
		
		p.setHp(300);
	
		logBattle();
		actionsPanel();
		battleInfo();
		sairBattle();

	}

	private void battleAttack() {

		b.aBatalhaQueVaiGirando(p, e);

	}


	private void logBattle() {

		logBattle.setTitle("LOG");
		logBattle.setSize("250px", "500px");

		btnLimpaLog.setText("Clean Log");
		btnLimpaLog.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				limpaLog();

			}

		});
		Last_Hope.midPanel.add(new HTML("Battle Log"), 10, 0);
		Last_Hope.midPanel.add(logBattle, 10, 30);
		Last_Hope.midPanel.add(btnLimpaLog, 187, 550);

	}

	private void actionsPanel() {

		// botao para atacar
		atacar.setText("Atack!");
		atacar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				battleAttack();
			}

		});

		// painel de acoes
		actions.setStyleName("battle");
		actions.add(new HTML("Action panel"), 10, 10);
		actions.setSize("200px", "300px");
		actions.add(atacar, 10, 40);
		// actions.add(defender, 10, 80);

		Last_Hope.midPanel.add(actions, 300, 100);
	}

	private void battleInfo() {

		// informacoes de batalha
		battleInfo.setStyleName("battleInfo");
		battleInfo.add(battleInfoL);
		battleInfo.setSize("300px", "490px");

		// dentro das informacoes de batalha, vai as informacoes do inimigo e do
		// personagem

		inimigo.setStyleName("battleInfo");
		perso.setStyleName("battleInfo");
		inimigo.setSize("293px", "220px");
		perso.setSize("293px", "220px");

		nomeInimigo.setText(e.getName());
		nomePerso.setText(p.getName());

		raceI.setText(e.getRace());
		raceP.setText(p.getRace());

		classI.setText(e.getProfession());
		classP.setText(p.getProfession());

		e.setStatus("Normal");
		p.setStatus("Normal");

		statusI.setText("Status: " + e.getStatus());
		statusP.setText("Status: " + p.getStatus());
		
		hpAtualInimigo.setText(Integer.toString(e.getHp()));
		hpAtualPerso.setText(Integer.toString(p.getHp()));
		hpMaxInimigo.setText(" / " + Integer.toString(e.getHpMax()));
		hpMaxPerso.setText(" / " + Integer.toString(p.getHpMax()));

		mpAtualInimigo.setText(Integer.toString(e.getMp()));
		mpAtualPerso.setText(Integer.toString(p.getMp()));
		mpMaxInimigo.setText(" / " + Integer.toString(e.getMpMax()));
		mpMaxPerso.setText(" / " + Integer.toString(p.getMpMax()));

		strI.setText("Strength: " + e.getStrength());
		dexI.setText("Dextrity: " + e.getDexterity());
		intI.setText("Intelect: " + e.getIntellect());
		chaI.setText("Charisma: " + e.getCharisma());

		strP.setText("Strength: " + p.getStrength());
		dexP.setText("Dextrity: " + p.getDexterity());
		intP.setText("Intelect: " + p.getIntellect());
		chaP.setText("Charisma: " + p.getCharisma());

		inimigo.add(nomeInimigo, 5, 5);
		inimigo.add(raceI, 5, 25);
		inimigo.add(classI, 60, 25);
		inimigo.add(statusI, 200, 25);
		inimigo.add(hpI, 5, 65);
		inimigo.add(hpAtualInimigo, 30, 65);
		inimigo.add(hpMaxInimigo, 50, 65);
		inimigo.add(mpI, 5, 85);
		inimigo.add(mpAtualInimigo, 30, 85);
		inimigo.add(mpMaxInimigo, 50, 85);
		inimigo.add(strI, 5, 125);
		inimigo.add(dexI, 5, 145);
		inimigo.add(intI, 5, 165);
		inimigo.add(chaI, 5, 185);

		perso.add(nomePerso, 5, 5);
		perso.add(raceP, 5, 25);
		perso.add(classP, 60, 25);
		perso.add(statusP, 200, 25);
		perso.add(hpP, 5, 65);
		perso.add(hpAtualPerso, 30, 65);
		perso.add(hpMaxPerso, 50, 65);
		perso.add(mpP, 5, 85);
		perso.add(mpAtualPerso, 30, 85);
		perso.add(mpMaxPerso, 50, 85);
		perso.add(strP, 5, 125);
		perso.add(dexP, 5, 145);
		perso.add(intP, 5, 165);
		perso.add(chaP, 5, 185);

		perso.add(setClassImage(), 170, 100);

		battleInfo.add(inimigo);
		battleInfo.add(perso);

		Last_Hope.midPanel.add(battleInfo, 550, 50);
	}

	public static void sairBattle() {

		Last_Hope.midPanel.add(sair, 855, 555);

	}

	public static void setLog(String log) {
		String l;
		l = logBattle.getText();
		logBattle.setReadOnly(false);
		logBattle.setText(l + log + "\n");
		logBattle.getElement().setScrollTop(
				logBattle.getElement().getScrollHeight());
		logBattle.setReadOnly(true);
	}

	private void limpaLog() {
		if (Window.confirm("You really want to clean the LOG?")) {
			logBattle.setText("");

		}

	}

	private Image setClassImage() {

		Image i = new Image();

		if (Last_Hope.p.getProfession().equals("Warrior")) {
			i = new Image(r.warrior());
		} else if (Last_Hope.p.getProfession().equals("Archer")) {
			i = new Image(r.archer());
		} else if (Last_Hope.p.getProfession().equals("Mage")) {
			i = new Image(r.mage());
		} else if (Last_Hope.p.getProfession().equals("Rogue")) {
			i = new Image(r.rogue());
		}

		return i;
	}

}
