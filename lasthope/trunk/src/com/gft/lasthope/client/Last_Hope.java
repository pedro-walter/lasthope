package com.gft.lasthope.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gft.lasthope.client.LoginInfo;
import com.gft.lasthope.client.LoginService;
import com.gft.lasthope.client.LoginServiceAsync;
import com.gft.lasthope.shared.Character;
import com.gft.lasthope.shared.Enemy;

public class Last_Hope implements EntryPoint {
	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label("Efetue Login");
	private Anchor signInLink = new Anchor("Login");
	private Anchor signOutLink = new Anchor("Logout");
	static AbsolutePanel northPanel = new AbsolutePanel();
	static AbsolutePanel botPanel = new AbsolutePanel();
	static AbsolutePanel midPanel = new AbsolutePanel();
	static AbsolutePanel westPanel = new AbsolutePanel();
	static HorizontalPanel footer = new HorizontalPanel();
	VerticalPanel vWest = new VerticalPanel();
	AbsolutePanel rootPanel = new AbsolutePanel();
	Button logout = new Button();

	static Character p;
	static Enemy e = new Enemy();
	
	public void onModuleLoad() {
		// Check login status using login service.
		LoginServiceAsync loginService = GWT.create(LoginService.class);
		loginService.login(GWT.getHostPageBaseURL(),
				new AsyncCallback<LoginInfo>() {
					public void onFailure(Throwable error) {
					}

					public void onSuccess(LoginInfo result) {
						loginInfo = result;
						// somente para desenvolvimento
						loginInfo.setLogoutUrl(loginInfo.getLogoutUrl()
								+ "Last_Hope.html?gwt.codesvr=127.0.0.1:9997");
						// System.out.println(loginInfo.getLoginUrl()+
						// "Last_Hope.html?gwt.codesvr=127.0.0.1:9997");
						if (loginInfo.isLoggedIn()) {
							//debug
							//System.out.println("Load Setup");
							loadSetup();
						} else {
							//debug
							//System.out.println("Load login");
							loadLogin();
						}
					}
				});
	}

	private void loadSetup() {
		//debug
		//System.out.println("Load 1");
		Menus west = new Menus();

		//estilos
		northPanel.setStyleName("header");
		midPanel.setStyleName("dockPanel");
		westPanel.setStyleName("dockPanel");
		botPanel.setStyleName("dockPanel");

		//tamanhos
		northPanel.setSize("1000px","200px");
		midPanel.setSize("893px","586px");
		footer.setSize("1000px", "100px");
		westPanel.setSize("100px", "586px");

		//debug
		//System.out.println("Load 2");

		signOutLink.setHref(loginInfo.getLogoutUrl());

		vWest=west.criaMenuWest();

		//add nos paineis
		northPanel.add(new HTML("LastHope"));
		footer.add(signOutLink);
		botPanel.add(footer);
		westPanel.add(vWest);

		//debug
		//System.out.println("Load 3");

		//add os paineis no root
		rootPanel.add(northPanel, 0, 0);
		rootPanel.add(botPanel, 0, 800);
		rootPanel.add(midPanel, 107, 207);
		rootPanel.add(westPanel, 0, 207);
		// rootPanel.setStyleName("dockpanel");

		RootLayoutPanel.get().add(rootPanel);
		
		characterCreator();

		//debug
		//System.out.println("Load ok");

		// RootPanel.get().add(signOutLink);
	}

	private void loadLogin() {
		// Assemble login panel.
		//debug
		//System.out.println("loadLogin");
		// loginInfo.setLogoutUrl(loginInfo.getLogoutUrl() +
		// "Last_Hope.html?gwt.codesvr=127.0.0.1:9997");
		// apenas para desenvolvimento
		signInLink.setHref(loginInfo.getLoginUrl()
				+ "Last_Hope.html?gwt.codesvr=127.0.0.1:9997");
		loginPanel.add(loginLabel);
		loginPanel.add(signInLink);
		RootLayoutPanel.get().add(loginPanel);

	}
	
	private void characterCreator(){
		Menus.desabilitaMenu();
		midPanel.add(new CreateCharacterPanel());
	}
	
	public static void setCharacter(Character c){
		p = c;
	}
	
	public static Character getCharacter(){
		return p;
	}
	
	public static void setEnemy(Enemy i){
		e = i;
	}
	
	public static Enemy getEnemy(){
		return e;
	}
	
}
