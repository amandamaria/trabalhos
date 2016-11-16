package application.controller;

import java.net.URL;
import java.util.List;

import application.Main;
import application.dominio.dao.PalavraConcluidaDAO;
import application.model.PalavraConcluida;
import application.util.ApplicationUtil;
import application.util.GrupoImagensUtil;
import arq.controller.AbstractController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    
    private PalavraConcluidaDAO palavraConcluidaDAO;
    
    private List<PalavraConcluida> palavrasConcluidas;
        
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
		palavraConcluidaDAO = new PalavraConcluidaDAO();
		palavrasConcluidas = getUsuarioLogado().getUsuario().getPalavrasConcluidas();
	}

	@Override
	public void initLayout() {
		pane.getStyleClass().add("telaGrupoImagens");
		paneGrupo1.getStyleClass().add("paneGrupo");
		paneGrupo2.getStyleClass().add("paneGrupo");
		paneGrupo3.getStyleClass().add("paneGrupo");
		paneGrupo4.getStyleClass().add("paneGrupo");
		mudarTextoLabelsGrupos();
	}

	private void mudarTextoLabelsGrupos() {
		mudarTextoLabelsPorGrupo(paneGrupo1, GrupoImagensUtil.GRUPO_1);
		mudarTextoLabelsPorGrupo(paneGrupo2, GrupoImagensUtil.GRUPO_2);
		mudarTextoLabelsPorGrupo(paneGrupo3, GrupoImagensUtil.GRUPO_3);
		mudarTextoLabelsPorGrupo(paneGrupo4, GrupoImagensUtil.GRUPO_4);
	}

	private void mudarTextoLabelsPorGrupo(VBox panel, int grupo) {
		ObservableList<Node> nodes = panel.getChildren();
		Label lbTotalDePalavras = null;
		Label lbTitulo = null;
		Label lbMelhorTempo = null;
		for (Node node : nodes) {
			if(node instanceof Label) {
				if(lbTitulo == null) {
					lbTitulo = (Label) node;
				} else if(lbTotalDePalavras == null) {
					lbTotalDePalavras = (Label) node;
					int totalDePalavrasConlcuidas = contarPalavrasPorGrupo(grupo);
					lbTotalDePalavras.setText(totalDePalavrasConlcuidas+"/"+GrupoImagensUtil.QTD_IMAGENS_POR_GRUPO);
				} else if (lbMelhorTempo == null) {
					lbTotalDePalavras = (Label) node;
					lbTotalDePalavras.setText(getMelhorTempoDoGrupo(grupo));
				}
			}
		}
	}

	private String getMelhorTempoDoGrupo(int grupo) {
		long idUsuario = getUsuarioLogado().getUsuario().getId();
		long menorTempo = palavraConcluidaDAO.buscarPoMelhorTempoPorUsuarioEGrupo(idUsuario, grupo);		
		return ApplicationUtil.getStringTempoFormatado(menorTempo);
	}

	private int contarPalavrasPorGrupo(int grupo) {
		int total = 0;
		if(palavrasConcluidas != null) {
			for (PalavraConcluida palavraConcluida : palavrasConcluidas) {
				if(palavraConcluida.getPalavra().getGrupo() == grupo) {
					total++;
				}
			}
		}
		return total;
	}

	@Override
	public void initListeners() {
		paneGrupo1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				TelaImagensPorGrupoController.grupo= GrupoImagensUtil.GRUPO_1;
				abrirTelaImagensPorGrupo();
			}
		});
		
		paneGrupo2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				TelaImagensPorGrupoController.grupo= GrupoImagensUtil.GRUPO_2;
				abrirTelaImagensPorGrupo();
			}
		});
		
		paneGrupo3.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				TelaImagensPorGrupoController.grupo= GrupoImagensUtil.GRUPO_3;
				abrirTelaImagensPorGrupo();
			}
		});
		
		paneGrupo4.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				TelaImagensPorGrupoController.grupo= GrupoImagensUtil.GRUPO_4;
				abrirTelaImagensPorGrupo();
			}
		});
	}

	private void abrirTelaImagensPorGrupo() {
		telaImagensPorGrupoController = new TelaImagensPorGrupoController();				
		telaImagensPorGrupoController.abrirTela();
	}

	@Override
	public URL getFxmlUrl() {		
		return Main.class.getResource("/application/view/TelaGrupoImagens.fxml");
	}

}
