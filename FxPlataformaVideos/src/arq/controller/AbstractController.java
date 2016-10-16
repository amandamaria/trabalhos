package arq.controller;


import java.io.IOException;
import java.net.URL;

import application.Main;
import application.model.UsuarioLogado;
import application.util.ApplicationUtil;
import application.view.MensagemAlerta;
import arq.dominio.hibernate.dao.GenericDAO;
import arq.dominio.model.AbstractEntity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class AbstractController<T extends AbstractEntity> extends MensagemAlerta {
	
	private Stage stage;
	
	private FXMLLoader loader;
	
	public abstract GenericDAO<T> getDAO();
	
	public abstract void initLayout();
	
	public abstract void initComponents();
	
	public abstract URL getFxmlUrl();
	
	public abstract void initListeners();
	
	public AbstractController() {
		loader = ApplicationUtil.getFXMLLoader(getFxmlUrl());
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

	@FXML
	public void initialize() {
		initComponents();
		initLayout();
		initListeners();
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public NavegadorTela getNavegadorTela() {
		return NavegadorTela.getInstace();
	}
	
	public UsuarioLogado getUsuarioLogado() {
		return UsuarioLogado.getInstance();
	}
}
