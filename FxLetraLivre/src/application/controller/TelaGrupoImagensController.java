package application.controller;

import java.net.URL;

import com.sun.javafx.iio.png.PNGIDATChunkInputStream;

import application.Main;
import arq.controller.AbstractController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class TelaGrupoImagensController extends AbstractController {


    @FXML
    private VBox paneGrupo4;

    @FXML
    private VBox paneGrupo3;

    @FXML
    private VBox paneGrupo2;

    @FXML
    private VBox paneGrupo1;

    @FXML
    private AnchorPane pane;
    
    @FXML
    private Button btnVoltar;
    
    @FXML
    private Button btnAjuda;
       
    private TelaLoginController telaLoginController;
    
    private TelaImagensPorGrupoController telaImagensPorGrupoController;
    
    @FXML
    public void voltar(ActionEvent event) {
    	telaLoginController = new TelaLoginController();
    	telaLoginController.abrirTela();
    }
    
    @FXML
    public void exibirAjuda(ActionEvent event) {
    	getMensagemAlerta().showMensagemAjuda("Clique em um dos grupos de figuras\npara visualizar as imagens do grupo.");
    }
    	
	@Override
	public void initComponents() {
		
	}

	@Override
	public void initLayout() {
		pane.getStyleClass().add("telaGrupoImagens");
		paneGrupo1.getStyleClass().add("paneGrupo");
		paneGrupo2.getStyleClass().add("paneGrupo");
		paneGrupo3.getStyleClass().add("paneGrupo");
		paneGrupo4.getStyleClass().add("paneGrupo");
	}

	@Override
	public void initListeners() {
		paneGrupo1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				telaImagensPorGrupoController = new TelaImagensPorGrupoController();
				telaImagensPorGrupoController.abrirTela();
			}
		});
	}

	@Override
	public URL getFxmlUrl() {		
		return Main.class.getResource("/application/view/TelaGrupoImagens.fxml");
	}

}
