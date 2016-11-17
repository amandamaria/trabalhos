package application.controller;

import java.net.URL;

import application.Main;
import arq.controller.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class TelaInicialController extends AbstractController {
	
	@FXML
    private Button btnCreditos;

	@FXML
    private Button btnRanking;

    @FXML
    private AnchorPane pane;

    @FXML
    private Button btnIniciar;
    
    private TelaLoginController telaLoginController;
    
    private TelaCreditosController telaCreditosController;
    
    private TelaRankingController telaRankingController;
    
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
		telaCreditosController = new TelaCreditosController();
		telaCreditosController.abrirTela();
    }
	
	@FXML
    void verRanking(ActionEvent event) {
		telaRankingController = new TelaRankingController();
		telaRankingController.abrirTela();
    }

	@Override
	public void initComponents() {
		getUsuarioLogado().setUsuario(null);
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
