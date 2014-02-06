package com.gft.lasthope.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Menus {
	Button batalha = new Button();
	Button loja = new Button();
	Button quest = new Button();

	public VerticalPanel criaMenuWest() {
		VerticalPanel auxV = new VerticalPanel();
		
		//botao da batalha
		batalha.setText("Batalha!");
		batalha.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				batalhaMid();
			}

		});
		
		//loja
		loja.setText("Loja");
		loja.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				lojaMid();
			}

		});
		
		//quest
		quest.setText("Missoes");
		quest.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				questMid();
			}

		});
		
		//add`s
		auxV.add(batalha);
		auxV.add(loja);
		auxV.add(quest);
		
		return auxV;
	}

	private void batalhaMid() {
		final TextArea logBattle = new TextArea();
		Button atacar = new Button();
		
		//log 
		//logBattle.setReadOnly(true);
		logBattle.setTitle("LOG");
		logBattle.setSize("250px", "500px");
		
		//botao para atacar
		atacar.setText("Atacar!");
		atacar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String l,t,log;
				l="";
				t="Ataque\n";
				
				l=logBattle.getText();
				logBattle.setReadOnly(false);
				
				logBattle.setText(l+"Ataque\n");
				log=logBattle.getText();
				
				logBattle.getElement().getFirstChildElement().setScrollTop(logBattle.getElement().getFirstChildElement().getScrollHeight());
				
				//logBattle.setCursorPos(log.length()-1);
				//logBattle.setReadOnly(true);
				//logBattle.getElement().
				//logBattle.getElement().setScrollTop(logBattle.getElement().getScrollHeight());
				//
				//logBattle.setCursorPos(log.length());
				
				
			}

		});
		
		//add`s
		Last_Hope.midPanel.clear();
		Last_Hope.midPanel.add(new HTML("batalha em progesso"));
		Last_Hope.midPanel.add(logBattle);
		Last_Hope.midPanel.add(atacar);
		
		
	}
	
	private void lojaMid(){
		Last_Hope.midPanel.clear();
		Last_Hope.midPanel.add(new HTML("lojinha do Abu"));
	}
	
	private void questMid(){
		Last_Hope.midPanel.clear();
		Last_Hope.midPanel.add(new HTML("1 - descer a lenha nos goblin"));
		Last_Hope.midPanel.add(new HTML("2 - ajudar a veia a atravesar a rua"));
	}

}
