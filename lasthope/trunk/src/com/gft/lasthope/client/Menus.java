package com.gft.lasthope.client;

import com.gft.lasthope.shared.Enemy;
import com.gft.lasthope.shared.Character;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Menus {
	static Button batalha = new Button();
	static Button loja = new Button();
	static Button quest = new Button();
	//static Button teste = new Button();
	static Button inventario = new Button();
	
	
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
		Last_Hope.midPanel.add(new BatalhaPanel());
		
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

	
	
	void desabilitaMenu(){
		batalha.setEnabled(false);
		loja.setEnabled(false);
		quest.setEnabled(false);
		inventario.setEnabled(false);
	}
	
	static void habilitaMenu(){
		batalha.setEnabled(true);
		loja.setEnabled(true);
		quest.setEnabled(true);
		inventario.setEnabled(true);
	}
	
	
}