package com.gft.lasthope.client;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class InventarioPanel extends AbsolutePanel {
	
	Label lblNomeItem = new Label();
	ListBox listaInventario = new ListBox();
	
	public InventarioPanel(){
		this.add(new HTML("Inventário"));
		
		// Painel com os componentes do Inventário
		HorizontalPanel panelInv = new HorizontalPanel();
		this.add(panelInv);
		panelInv.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);

		// Listbox com os items que estão no inventário
		
		listaInventario.setVisibleItemCount(20);
		
		listaInventario.addItem("Adaga");
		listaInventario.addItem("Espada");
		listaInventario.addItem("Escudo");
		listaInventario.addItem("Elmo");
		listaInventario.addItem("Poção");
		
		panelInv.add(listaInventario);
		
		// Bot�es de controle (Adicionar, Excluir, Mover)
		
		VerticalPanel invBotoes = new VerticalPanel();
		panelInv.add(invBotoes);
		
		Button invAdd = new Button();
		invAdd.setText("Adicionar");
		invBotoes.add(invAdd);
		
		Button invChange = new Button();
		invChange.setText("Mudar Quantidade");
		invBotoes.add(invChange);
		
		Button invRemove = new Button();
		invRemove.setText("Remover");
		invBotoes.add(invRemove);
		
		Button invMoveUp = new Button();
		invMoveUp.setText("Mover para Cima");
		invBotoes.add(invMoveUp);
		
		Button invMoveDown = new Button();
		invMoveDown.setText("Mover para Baixo");
		invBotoes.add(invMoveDown);
		
		// Painel de Informações do item
		
		VerticalPanel invInfoItem = new VerticalPanel();
		panelInv.add(invInfoItem);
		
		HorizontalPanel pNomeItem = new HorizontalPanel();
		pNomeItem.add(new Label("Nome:"));
		pNomeItem.add(lblNomeItem);
		invInfoItem.add(pNomeItem);
		
		// Adiciona evento ao listaInventario, 
		// para atualizar as informações do item quando o mesmo é selecionado
		listaInventario.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				lblNomeItem.setText(listaInventario.getItemText(listaInventario.getSelectedIndex()));
				
			}
		});
		
		// Finalmente, adiciona o painel do Inventário no MidPanel
		
	}
}
