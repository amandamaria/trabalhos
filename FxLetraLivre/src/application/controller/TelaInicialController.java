package application.controller;

import java.net.URL;

import application.Main;
import arq.controller.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class TelaInicialController extends AbstractController {
	
	@FXML
    private Button btnCreditos;

    @FXML
    private AnchorPane pane;

    @FXML
    private Button btnIniciar;
    
    private TelaLoginController telaLoginController;
    
    @FXML
    void iniciar(ActionEvent event) {
    	abrirTelaLogin();
    }

    private void abrirTelaLogin() {
    	telaLoginController = new TelaLoginController();
    	telaLoginController.abrirTela();		
	}

	@FXML
    void verCreditos(ActionEvent event) {
		
    }

	@Override
	public void initComponents() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void initLayout() {
		pane.getStyleClass().add("telaInicio");
	}
	
	@Override
	public void initListeners() {
		// TODO Auto-generated method stub		
	}

	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/TelaInicial.fxml");
	}

	
	
}
