package application.controller;

import java.net.URL;

import application.Main;
import application.util.GrupoImagensUtil;
import application.view.meuscomponentes.ImagemDoGrupo;
import arq.controller.AbstractController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class TelaImagensPorGrupoController extends AbstractController {
	
	@FXML 
	private AnchorPane pane;
	
	@FXML
	private GridPane gridImagens;
	
	@FXML
    private Button btnVoltar;
    
    @FXML
    private Button btnAjuda;
    
    private TelaGrupoImagensController telaGrupoImagensController;
    
    private TelaJogoController telaJogoController;
    
    @FXML
    public void voltar(ActionEvent event) {
    	telaGrupoImagensController = new TelaGrupoImagensController();
    	telaGrupoImagensController.abrirTela();
    }
    
    @FXML
    public void exibirAjuda(ActionEvent event) {
    	getMensagemAlerta().showMensagemAjuda("Clique em um das figuras para jogar.");
    }

	@Override
	public void initComponents() {
		
	}

	@Override
	public void initLayout() {
		pane.getStyleClass().add("telaSelecaoImagem");
		gerarImagensDoGrupo();
	}

	private void gerarImagensDoGrupo() {
		int k = 0;
		for(int i=0; i < 5;i++) {
			for(int j=0; j < 3; j++) {
				gridImagens.add(new ImagemDoGrupo(GrupoImagensUtil.IMAGENS_GRUPO_1[k], i+1),i, j);
				k++;
			}
		}		
	}

	@Override
	public void initListeners() {
		addClickListenerImagensDoGrupo();		
	}
	
	private void addClickListenerImagensDoGrupo() {
		ObservableList<Node> nodes = gridImagens.getChildren();
		for (final Node node : nodes) {
			node.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					abrirTelaJogo((ImagemDoGrupo) node);
				}
			});
		}
	}

	private void abrirTelaJogo(ImagemDoGrupo imagemDoGrupo) {
		TelaJogoController.imagemSelecionada = imagemDoGrupo.getImagemJogo();
		telaJogoController = new TelaJogoController();
		telaJogoController.abrirTela();
	}
			

	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/TelaImagensPorGrupo.fxml");
	}

}
