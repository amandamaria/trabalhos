package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import application.view.meuscomponentes.GrupoImagens;
import arq.controller.AbstractController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
    
    private List<GrupoImagens> grupos;
    
    private TelaLoginController telaLoginController;
    
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
		initGruposDeImagens();
	}

	private void initGruposDeImagens() {
		ObservableList<Node> children = pane.getChildren();	
		ObservableList<Node> auxiliar = FXCollections.observableArrayList();
		grupos = new ArrayList<GrupoImagens>();
		for (Node node : children) {
			if(node instanceof VBox) {
				auxiliar.add(node);
				GrupoImagens grupoImagens = (GrupoImagens) node;
				grupos.add(grupoImagens);
			}
		}
		children.removeAll(auxiliar);
		children.addAll(grupos);
	}

	@Override
	public void initLayout() {
		pane.getStyleClass().add("telaGrupoImagens");
	}

	@Override
	public void initListeners() {
		
	}

	@Override
	public URL getFxmlUrl() {		
		return Main.class.getResource("/application/view/TelaGrupoImagens.fxml");
	}

}
