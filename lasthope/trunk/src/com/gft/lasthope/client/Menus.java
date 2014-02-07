package com.gft.lasthope.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Menus {
	Button batalha = new Button();
	Button loja = new Button();
	Button quest = new Button();
	final TextArea logBattle = new TextArea();
	AbsolutePanel actions = new AbsolutePanel();
	AbsolutePanel battleInfo = new AbsolutePanel();
	AbsolutePanel inimigo = new AbsolutePanel();
	AbsolutePanel perso = new AbsolutePanel();
	final Label nomeInimigo = new Label();
	Label nomePerso = new Label();
	Label hpAtualInimigo = new Label();
	Label hpMaxInimigo = new Label();
	Label hpAtualPerso = new Label();
	Label hpMaxPerso = new Label();
	Label hp = new Label("HP");
	int hpInimigo=20;
	int hpPerso=20;
	int dmg=0;
	Button teste = new Button();
	Button atacar = new Button();
	Button defender = new Button();
	
	
	public VerticalPanel criaMenuWest() {
		VerticalPanel auxV = new VerticalPanel();

		// botao da batalha
		batalha.setText("Batalha!");
		batalha.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				batalhaMid();
			}

		});

		// loja
		loja.setText("Loja");
		loja.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				lojaMid();
			}

		});

		// quest
		quest.setText("Missoes");
		quest.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				questMid();
			}

		});

		// add`s
		auxV.add(batalha);
		auxV.add(loja);
		auxV.add(quest);

		return auxV;
	}

	public void batalhaMid() {

		// log
		// logBattle.setReadOnly(true);
		logBattle.setTitle("LOG");
		logBattle.setSize("250px", "500px");

		// botao para atacar
		atacar.setText("Atacar!");
		atacar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				battleAttack();
			}

		});

		// botao para defender
		defender.setText("Defender!");
		defender.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				battleDefend();
			}

		});

		// painel de acoes
		actions.setStyleName("battle");
		actions.add(new HTML("Painel de acoes"), 10, 10);
		actions.setSize("200px", "300px");
		actions.add(atacar, 10, 40);
		actions.add(defender, 10, 80);
		
		//informacoes de batalha
		battleInfo.setStyleName("battleInfo");
		battleInfo.add(new HTML("Informacoes de batalha"));
		battleInfo.setSize("300px", "500px");
		
		//dentro das informacoes de batalha, vai as informacoes do inimigo e do personagem
		
		inimigo.setStyleName("battleInfo");
		perso.setStyleName("battleInfo");
		nomeInimigo.setText("Inimigo Teste");
		nomePerso.setText("Vinicius Teste");
		
//		hpMaxInimigo.setText(Integer.toString(hpInimigo));
//		hpMaxPerso.setText(Integer.toString(hpPerso));
		
		hpMaxInimigo.setText(" / "+Integer.toString(hpInimigo));
		hpMaxPerso.setText(" / "+Integer.toString(hpPerso));
		inimigo.add(nomeInimigo,10,10);
		inimigo.add(hp,30,30);
		inimigo.add(hpMaxInimigo,50,50);
		perso.add(nomePerso,10,10);
		perso.add(hp,30,30);
		perso.add(hpMaxPerso,50,50);
		
		teste.setText("Teste mudar");
		teste.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				nomeInimigo.setText("");
				nomeInimigo.setText("TESTEEEEE");
			}

		});
		
		battleInfo.add(inimigo);
		battleInfo.add(perso);
		//battleInfo.add(teste);
		
		

		// add`s
		Last_Hope.midPanel.clear();
		Last_Hope.midPanel.setStyleName("battle");
		Last_Hope.midPanel.add(new HTML("Log de Batalha"), 10, 0);
		Last_Hope.midPanel.add(logBattle, 10, 30);
		Last_Hope.midPanel.add(actions, 300, 100);
		Last_Hope.midPanel.add(battleInfo,550,50);

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
		
		dmg=1;
		
		atualizaBattleInfo();
	}
	
	private void battleDefend(){
		String l;

		l = logBattle.getText();
		logBattle.setReadOnly(false);

		logBattle.setText(l + "Defesa\n");

		logBattle.getElement().setScrollTop(
				logBattle.getElement().getScrollHeight());
		logBattle.setReadOnly(true);
		
		dmg=0;
		
		atualizaBattleInfo();
	}
	
	private void atualizaBattleInfo(){
		
	}

}
