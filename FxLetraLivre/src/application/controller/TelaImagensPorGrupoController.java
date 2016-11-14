package application.controller;

import java.net.URL;

import application.Main;
import application.util.GrupoImagensUtil;
import application.view.meuscomponentes.ImagemDoGrupo;
import arq.controller.AbstractController;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class TelaImagensPorGrupoController extends AbstractController {
	
	@FXML 
	private AnchorPane pane;
	
	@FXML
	private GridPane gridImagens;

	@Override
	public void initComponents() {
		int k = 0;
		for(int i=0; i < 5;i++) {
			for(int j=0; j<3; j++) {
				gridImagens.add(new ImagemDoGrupo(GrupoImagensUtil.IMAGENS_GRUPO_1[k]),i, j);
				k++;
			}
		}
	}

	@Override
	public void initLayout() {
		pane.getStyleClass().add("telaSelecaoImagem");
	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/TelaImagensPorGrupo.fxml");
	}

}
