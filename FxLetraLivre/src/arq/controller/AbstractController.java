package arq.controller;

import java.io.IOException;
import java.net.URL;

import application.Main;
import application.util.ApplicationUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class AbstractController  {
	
	private MensagemAlerta mensagemAlerta;

	private Stage stage;
	
	private Scene scene;
	
	private FXMLLoader loader;
		
	public abstract void initComponents();
	
	public abstract void initLayout();	

	public abstract void initListeners();
	
	public abstract URL getFxmlUrl();
	
	public AbstractController() {
		loader = ApplicationUtil.getLoader(getFxmlUrl());
		mensagemAlerta = new MensagemAlerta();
	}
	
	@FXML
	public void initialize() {
		initComponents();
		initLayout();
		initListeners();
	}
	
	public void abrirTela() {
		try {			
			AnchorPane pane = (AnchorPane) loader.load();					
			this.setStage(Main.primaryStage);
			getNavegadorTela().irParaTela(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MensagemAlerta getMensagemAlerta() {
		return mensagemAlerta;
	}
	
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public NavegadorTela getNavegadorTela() {
		return NavegadorTela.getInstace();
	}
	
}
