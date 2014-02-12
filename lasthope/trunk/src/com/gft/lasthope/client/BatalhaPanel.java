package com.gft.lasthope.client;

import com.gft.lasthope.shared.Resources;
import com.gft.lasthope.shared.Weapon;
import com.gft.lasthope.shared.Creature;
import com.gft.lasthope.shared.Enemy;
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

public class BatalhaPanel extends AbsolutePanel {

	Resources r = GWT.create(Resources.class);
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
	Label hpI = new Label("HP");
	Label hpP = new Label("HP");
	Label mpI = new Label("MP");
	Label mpP = new Label("MP");
	static Button sair = new BotaoSair();
	static Button atacar = new Button();
	Button btnLimpaLog = new Button();
	Button defender = new Button();
	int hpInimigo = 20;
	int hpPerso = 20;

	Character p = Last_Hope.getCharacter();
	Enemy i = new Enemy();
	Item it = new Item();
	Weapon w;

	public BatalhaPanel() {

		it.updateWeapons();

		// p.setName("Character");
		i.setName("Goblin");

		// p.setHp(30);
		// i.setHp(30);

		// p.setControladorTempo(1);
		i.setControladorTempo(1);

		p.setWeapon((Weapon) it.listWeapons.get(2));
		i.setWeapon((Weapon) it.listWeapons.get(2));

		logBattle();
		actionsPanel();
		battleInfo();
		sairBattle();

	}

	private void battleAttack() {

		Battle.aBatalhaQueVaiGirando(p, i);

	}


	static void atualizaBattleInfo(int d, Creature c, boolean crit) {
		int i;
		String log;

		if (c instanceof Character) {

			i = Integer.valueOf(hpAtualPerso.getText()) - d;
			hpAtualPerso.setText(Integer.toString(i));

			if (crit) {
				log = "Critical Strike! The enemy dealt " + Integer.toString(d)
						+ " damage!";
			} else {
				log = "The enemy dealt " + Integer.toString(d) + " damage!";
			}
			setLog(log);

			System.out.println("Chegou ate atualizaBattleInfo e entrou em c");

		} else {

			i = Integer.valueOf(hpAtualInimigo.getText()) - d;
			hpAtualInimigo.setText(Integer.toString(i));

			if (crit) {
				log = "Critical strike! You dealt " + Integer.toString(d)
						+ " damage!";
			} else {
				log = "You dealt " + Integer.toString(d) + " damage!";
			}

			System.out.println("Chegou ate atualizaBattleInfo e entrou em i");

			setLog(log);

		}
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

		// // botao para defender
		// defender.setText("Defender!");
		// defender.addClickHandler(new ClickHandler() {
		// public void onClick(ClickEvent event) {
		// battleDefend();
		// }
		//
		// });

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
		battleInfo.add(new HTML("Battle Info"));
		battleInfo.setSize("300px", "490px");

		// dentro das informacoes de batalha, vai as informacoes do inimigo e do
		// personagem

		inimigo.setStyleName("battleInfo");
		perso.setStyleName("battleInfo");
		inimigo.setSize("293px", "220px");
		perso.setSize("293px", "220px");

		nomeInimigo.setText(i.getName());
		nomePerso.setText(p.getName());

		// hpMaxInimigo.setText(Integer.toString(hpInimigo));
		// hpMaxPerso.setText(Integer.toString(hpPerso));

		hpAtualInimigo.setText(Integer.toString(i.getHp()));
		hpAtualPerso.setText(Integer.toString(p.getHp()));
		hpMaxInimigo.setText(" / " + Integer.toString(i.getHpMax()));
		hpMaxPerso.setText(" / " + Integer.toString(p.getHpMax()));
		
		mpAtualInimigo.setText(Integer.toString(i.getMp()));
		mpAtualPerso.setText(Integer.toString(p.getMp()));
		mpMaxInimigo.setText(" / " + Integer.toString(i.getMpMax()));
		mpMaxPerso.setText(" / " + Integer.toString(p.getMpMax()));

		inimigo.add(nomeInimigo, 5, 5);
		inimigo.add(hpI, 5, 25);
		inimigo.add(hpAtualInimigo, 30, 25);
		inimigo.add(hpMaxInimigo, 50, 25);
		inimigo.add(mpI, 5, 45);
		inimigo.add(mpAtualInimigo, 30, 45);
		inimigo.add(mpMaxInimigo, 50, 45);

		perso.add(nomePerso, 5, 5);
		perso.add(hpP, 5, 25);
		perso.add(hpAtualPerso, 30, 25);
		perso.add(hpMaxPerso, 50, 25);
		perso.add(mpP, 5, 45);
		perso.add(mpAtualPerso, 30, 45);
		perso.add(mpMaxPerso, 50, 45);
		
		//perso.add(setClassImage(), 150, 150);
		setClassImage();
		
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

	private void setClassImage() {
		
		//Last_Hope.p.setProfession("Warrior");
		//Last_Hope.p.setRace("Human");
		
		System.out.println(Last_Hope.p.getProfession());
		System.out.println(Last_Hope.p.getRace());
//		Image i = new Image();
//
//		if (Last_Hope.p.getProfession().equals("Warrior")) {
//			i = new Image(r.warrior());
//		} else if (Last_Hope.p.getProfession().equals("Archer")) {
//			i = new Image(r.archer());
//		} else if (Last_Hope.p.getProfession().equals("Mage")) {
//			i = new Image(r.mage());
//		} else if (Last_Hope.p.getProfession().equals("Rogue")) {
//			i = new Image(r.rogue());
//		}
//
//		return i;
	}

}
