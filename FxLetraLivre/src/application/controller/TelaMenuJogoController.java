package application.controller;

import java.net.URL;

import application.Main;
import arq.controller.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class TelaMenuJogoController extends AbstractController {
	
	@FXML
	private AnchorPane pane;
	
	@FXML
    private Button btnReiniciar;

    @FXML
    private Button btnContinuar;

    @FXML
    private Button btnMudarPalavra;

    @FXML
    private Button btnIrParaInicio;

    @FXML
    private ImageView imgEstrela2;

    @FXML
    private ImageView imgEstrela1;

    @FXML
    private ImageView imgEstrela3;

    @FXML
    private Label lbTempo;
    
    private TelaJogoController telaJogoController;
    
    private TelaInicialController telaInicialController;
        
    private TelaImagensPorGrupoController telaImagensPorGrupoController;

    @FXML
    void reiniciarJogo(ActionEvent event) {
    	irParaTelaDoJogo();
    	fecharEstaJanela();
    }

    private void fecharEstaJanela() {
		this.getStage().close();
	}

	private void irParaTelaDoJogo() {
		telaJogoController = new TelaJogoController();
		telaJogoController.abrirTela();
	}

	@FXML
    void voltarListaPalavras(ActionEvent event) {
    	irParaTelaImagensPorGrupo();
    	fecharEstaJanela();
    }

    private void irParaTelaImagensPorGrupo() {
    	telaImagensPorGrupoController = new TelaImagensPorGrupoController();
    	telaImagensPorGrupoController.abrirTela();
	}

	@FXML
    void btnContinuar(ActionEvent event) {
		fecharEstaJanela();
    }

    private void irParaTelaInicial() {
    	telaInicialController = new TelaInicialController();
    	telaInicialController.abrirTela();
	}

	@FXML
    void irParaInicio(ActionEvent event) {
		irParaTelaInicial();
		fecharEstaJanela();
    }
    
	public void initComponents() {
	}
	
	public void initListeners() {
		
	}
	
	public void initLayout() {
		pane.getStyleClass().add("telaMenuJogo");
	}

	@Override
	public URL getFxmlUrl() {		
		return Main.class.getResource("/application/view/TelaMenuJogo.fxml");
	}
	
}
