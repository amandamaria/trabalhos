package arq.controller;

import application.util.ApplicationUtil;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class NavegadorTela {
	
	private static NavegadorTela navegadorSingleton = new NavegadorTela();
	private static AnchorPane root;
	
	private NavegadorTela() {
		root = new AnchorPane();
		root.setPrefSize(ApplicationUtil.getLarguraDaTela(), ApplicationUtil.getAlturaDaTela());
	}
	
	public static NavegadorTela getInstace() {
		return navegadorSingleton;
	}
	
	public Pane getRootPane() {
		return root;
	}
		
	public void irParaTela(Pane pane) {
		if(root == null) {
			root = new AnchorPane();
			root.setPrefSize(ApplicationUtil.getLarguraDaTela(), ApplicationUtil.getAlturaDaTela());
		} 
		root.getChildren().clear();
		root.getChildren().add(pane);
		centralizarPane(pane);
		
	}
	
	private void centralizarPane(Pane paneFilho) {
		paneFilho.setLayoutX((root.getPrefWidth() - paneFilho.getPrefWidth())/2);
		paneFilho.setLayoutY((root.getPrefHeight() - paneFilho.getPrefHeight())/2);
	}
}
