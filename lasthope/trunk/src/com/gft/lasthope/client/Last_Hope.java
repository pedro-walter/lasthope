package com.gft.lasthope.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gft.lasthope.client.LoginInfo;
import com.gft.lasthope.client.LoginService;
import com.gft.lasthope.client.LoginServiceAsync;

public class Last_Hope implements EntryPoint {
	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label("Efetue Login");
	private Anchor signInLink = new Anchor("Login");
	private Anchor signOutLink = new Anchor("Logout");
	AbsolutePanel rootPanel = new AbsolutePanel();
	AbsolutePanel northPanel = new AbsolutePanel();
	AbsolutePanel botPanel = new AbsolutePanel();
	AbsolutePanel midPanel = new AbsolutePanel();
	AbsolutePanel teste = new AbsolutePanel();
	AbsolutePanel westPanel = new AbsolutePanel();
	HorizontalPanel footer = new HorizontalPanel();
	VerticalPanel vWest = new VerticalPanel();
	Image background = new Image();
	Label lblT = new Label();
	Button btnT = new Button();

	public void onModuleLoad() {
		// Check login status using login service.
		LoginServiceAsync loginService = GWT.create(LoginService.class);
		loginService.login(GWT.getHostPageBaseURL(),
				new AsyncCallback<LoginInfo>() {
					public void onFailure(Throwable error) {
					}
					
					public void onSuccess(LoginInfo result) {
						loginInfo = result;
						//somente para desenvolvimento
						loginInfo.setLogoutUrl(loginInfo.getLogoutUrl() + "Last_Hope.html?gwt.codesvr=127.0.0.1:9997");
						if (loginInfo.isLoggedIn()) {
							System.out.println("Load Setup");
							loadSetup();
						} else {
							System.out.println("Load login");
							loadLogin();
						}
					}
				});
	}

	
	private void loadSetup(){
		System.out.println("Load 1");
		
		lblT.setSize("10px", "20px");
		lblT.setText("Teste senha");
		lblT.setVisible(true);

		// usuario.setSize("100px","25px");

		btnT.setSize("50px", "30px");
		btnT.setText("OK");
		btnT.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
			}

		});

		teste.getElement().getStyle().setProperty("border", "3px solid #000000");
		teste.add(lblT, 10, 20);
		teste.add(btnT, 500, 480);
		teste.setSize("600px", "530px");
		
		System.out.println("Load 2");

		background.setUrl(GWT.getModuleBaseURL() + "Images/background.jpg");

		//tab = criaTab();

		signOutLink.setHref(loginInfo.getLogoutUrl());
		
		footer.setSize("900px", "100px");
		footer.add(signOutLink);

		botPanel.add(footer);
		// botPanel.getElement().getStyle().setProperty("border",
		// "3px solid #000000");

		//vWest = CriaVWest.criaVWest();
		westPanel.add(vWest);
		westPanel.setSize("100px", "530px");
		westPanel.getElement().getStyle()
				.setProperty("border", "3px solid #000000");

		northPanel.add(new Image("http://www.jmstatsolutions.com/wp-content/themes/JandM_Statistical_Solutions/images/GFT.jpg"));

		midPanel.add(teste);
		
		System.out.println("Load 3");
		
		rootPanel.add(northPanel, 0, 0);
		rootPanel.add(botPanel, 0, 800);
		rootPanel.add(midPanel, 105, 265);
		rootPanel.add(westPanel, 0, 265);
		// rootPanel.setStyleName("dockpanel");

		RootLayoutPanel.get().add(rootPanel);

		System.out.println("Load ok");
		
		//RootPanel.get().add(signOutLink);
	}
	private void loadLogin() {
		// Assemble login panel.
		signInLink.setHref(loginInfo.getLoginUrl());
		loginPanel.add(loginLabel);
		loginPanel.add(signInLink);
		RootLayoutPanel.get().add(loginPanel);

	}

}
