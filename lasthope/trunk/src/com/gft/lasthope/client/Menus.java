package com.gft.lasthope.client;

import com.gft.lasthope.shared.Creature;
import com.gft.lasthope.shared.Enemy;
import com.gft.lasthope.shared.Character;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Menus {
	Button batalha = new Button();
	Button loja = new Button();
	Button quest = new Button();
	Button teste = new Button();
	Button atacar = new Button();
	Button defender = new Button();
	Button sair = new Button();
	Button inventario = new Button();
	final TextArea logBattle = new TextArea();
	AbsolutePanel actions = new AbsolutePanel();
	AbsolutePanel battleInfo = new AbsolutePanel();
	AbsolutePanel inimigo = new AbsolutePanel();
	AbsolutePanel perso = new AbsolutePanel();
	final Label nomeInimigo = new Label();
	Label nomePerso = new Label();
	static Label hpAtualInimigo = new Label();
	Label hpMaxInimigo = new Label();
	static Label hpAtualPerso = new Label();
	Label hpMaxPerso = new Label();
	Label hpI = new Label("HP");
	Label hpP = new Label("HP");
	int hpInimigo = 20;
	int hpPerso = 20;
	int dmg = 0;


	Character p = new Character();
	Enemy i = new Enemy();

	public VerticalPanel criaMenuWest() {
		VerticalPanel auxV = new VerticalPanel();

		// botao da batalha
		batalha.setText("Batalha!");
		batalha.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				batalhaMid();
				desabilitaMenu();
			}

		});
		
		inventario.setText("Inventário");
		inventario.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				inventarioMid();
			}

		});
		
		//loja
		loja.setText("Loja");
		loja.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				lojaMid();
				//desabilitaMenu();
			}

		});

		// quest
		quest.setText("Missoes");
		quest.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				questMid();
				//desabilitaMenu();
			}

		});

		// add`s
		auxV.add(batalha);
		auxV.add(loja);
		auxV.add(quest);
		auxV.add(inventario);

		return auxV;
	}

	protected void inventarioMid() {
		Last_Hope.midPanel.clear();
		Last_Hope.midPanel.add(new InventarioPanel());
	}

	public void batalhaMid() {

		Last_Hope.midPanel.clear();
		Last_Hope.midPanel.setStyleName("battle");
		
		
		
		logBattle();
		actionsPanel();
		battleInfo();
		sairMid();
		
	}

	private void lojaMid() {
		Last_Hope.midPanel.clear();
		Last_Hope.midPanel.add(new HTML("lojinha do Abu"));
		
	}

	private void questMid() {
		Last_Hope.midPanel.clear();
		Last_Hope.midPanel.add(new HTML("1 - descer a lenha nos goblin"));
		Last_Hope.midPanel.add(new HTML("2 - ajudar a veia a atravesar a rua"));
		
	}

	private void battleAttack() {
		String l;

		l = logBattle.getText();
		logBattle.setReadOnly(false);

		logBattle.setText(l + "Ataque\n");

		logBattle.getElement().setScrollTop(
				logBattle.getElement().getScrollHeight());
		logBattle.setReadOnly(true);

		dmg = 1;

		//atualizaBattleInfo(dmg);
	}

	private void battleDefend() {
		String l;

		l = logBattle.getText();
		logBattle.setReadOnly(false);

		logBattle.setText(l + "Defesa\n");

		logBattle.getElement().setScrollTop(
				logBattle.getElement().getScrollHeight());
		logBattle.setReadOnly(true);

		dmg = 0;

		//atualizaBattleInfo(dmg);
	}

	static void atualizaBattleInfo(int d, Creature c) {
		int i;
		if (c instanceof Character) {
			i = Integer.valueOf(hpAtualInimigo.getText()) - d;
			hpAtualInimigo.setText(Integer.toString(i));
			
		}else{
			i = Integer.valueOf(hpAtualPerso.getText()) - d;
			hpAtualPerso.setText(Integer.toString(i));
		}
	}

	private void logBattle() {

		logBattle.setTitle("LOG");
		logBattle.setSize("250px", "500px");
		Last_Hope.midPanel.add(new HTML("Log de Batalha"), 10, 0);
		Last_Hope.midPanel.add(logBattle, 10, 30);
	}

	private void actionsPanel() {

		// botao para atacar
		atacar.setText("Atacar!");
		atacar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				battleAttack();
			}

		});

//		// botao para defender
//		defender.setText("Defender!");
//		defender.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				battleDefend();
//			}
//
//		});

		// painel de acoes
		actions.setStyleName("battle");
		actions.add(new HTML("Painel de acoes"), 10, 10);
		actions.setSize("200px", "300px");
		actions.add(atacar, 10, 40);
		//actions.add(defender, 10, 80);

		Last_Hope.midPanel.add(actions, 300, 100);
	}

	private void battleInfo() {

		// informacoes de batalha
		battleInfo.setStyleName("battleInfo");
		battleInfo.add(new HTML("Informacoes de batalha"));
		battleInfo.setSize("300px", "500px");

		// dentro das informacoes de batalha, vai as informacoes do inimigo e do
		// personagem

		inimigo.setStyleName("battleInfo");
		perso.setStyleName("battleInfo");
		inimigo.setSize("293px", "220px");
		perso.setSize("293px", "220px");

		nomeInimigo.setText(p.getName());
		nomePerso.setText(i.getName());

		// hpMaxInimigo.setText(Integer.toString(hpInimigo));
		// hpMaxPerso.setText(Integer.toString(hpPerso));

		hpAtualInimigo.setText(Integer.toString(i.getHp()));
		hpAtualPerso.setText(Integer.toString(p.getHp()));
		hpMaxInimigo.setText(" / " + Integer.toString(i.getHpMax()));
		hpMaxPerso.setText(" / " + Integer.toString(p.getHpMax()));

		inimigo.add(nomeInimigo, 5, 5);
		inimigo.add(hpI, 5, 25);
		inimigo.add(hpAtualInimigo, 25, 25);
		inimigo.add(hpMaxInimigo, 45, 25);

		perso.add(nomePerso, 5, 5);
		perso.add(hpP, 5, 25);
		perso.add(hpAtualPerso, 25, 25);
		perso.add(hpMaxPerso, 45, 25);

		// teste.setText("Teste mudar");
		// teste.addClickHandler(new ClickHandler() {
		// public void onClick(ClickEvent event) {
		// hpInimigo=1;
		// hpAtualInimigo.setText(Integer.toString(hpInimigo));
		// }
		//
		// });

		battleInfo.add(inimigo);
		battleInfo.add(perso);
		// battleInfo.add(teste);

		Last_Hope.midPanel.add(battleInfo, 550, 50);
	}
	
	private void desabilitaMenu(){
		batalha.setEnabled(false);
		loja.setEnabled(false);
		quest.setEnabled(false);
	}
	
	private void habilitaMenu(){
		batalha.setEnabled(true);
		loja.setEnabled(true);
		quest.setEnabled(true);
	}
	
	private void sairMid(){
		sair.setText("Sair");
		sair.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(Window.confirm("Deseja Realmente Sair?")){
					Last_Hope.midPanel.clear();
					habilitaMenu();
				}
			}

		});
		
		Last_Hope.midPanel.add(sair,850,550);
	}

}
