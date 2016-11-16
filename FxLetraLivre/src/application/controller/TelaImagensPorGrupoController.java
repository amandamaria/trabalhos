package application.controller;

import java.net.URL;
import java.util.List;

import application.Main;
import application.dominio.dao.PalavraConcluidaDAO;
import application.dominio.dao.PalavraDAO;
import application.model.Palavra;
import application.model.PalavraConcluida;
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
	
	public List<Palavra> palavras;
	
	public static int grupo;
	
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
    
    private PalavraConcluidaDAO palavraConcluidaDAO;
    
    private PalavraDAO palavraDAO;
    
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
		palavraConcluidaDAO = new PalavraConcluidaDAO();
		palavraDAO = new PalavraDAO();
		buscarImagens();
	}

	private void buscarImagens() {
		switch (grupo) {
		case GrupoImagensUtil.GRUPO_1:
			palavras = getImagensGrupo1();
			break;
		case GrupoImagensUtil.GRUPO_2:
			palavras = getImagensGrupo2();
			break;
		case GrupoImagensUtil.GRUPO_3:
			palavras = getImagensGrupo3();
			break;
		case GrupoImagensUtil.GRUPO_4:
			palavras = getImagensGrupo4();
			break;
		default:
			System.err.println("GRUPO INVÁLIDO");
			break;
		}
	}

	@Override
	public void initLayout() {
		pane.getStyleClass().add("telaSelecaoImagem");
		gerarImagensDoGrupo();
	}

	private void gerarImagensDoGrupo() {
		int k = 0;
		if(palavras != null) {
			for(int i=0; i < 5;i++) {
				for(int j=0; j < 3; j++) {
					gridImagens.add(new ImagemDoGrupo(palavras.get(k)), i, j);
					k++;
				}
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
		TelaJogoController.palavraSelecionada = imagemDoGrupo.getPalavra();
		telaJogoController = new TelaJogoController();
		telaJogoController.abrirTela();
	}
			
	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/TelaImagensPorGrupo.fxml");
	}
	
	public List<Palavra> getImagensGrupo1() {
		return getPalavrarPorGrupo(GrupoImagensUtil.GRUPO_1, GrupoImagensUtil.IMAGENS_GRUPO_1, GrupoImagensUtil.AUDIOS_GRUPO_1);
	}
	
	public List<Palavra> getImagensGrupo2() {
		return getPalavrarPorGrupo(GrupoImagensUtil.GRUPO_2, GrupoImagensUtil.IMAGENS_GRUPO_2, GrupoImagensUtil.AUDIOS_GRUPO_2);
	}
	
	public List<Palavra> getImagensGrupo3() {
		return getPalavrarPorGrupo(GrupoImagensUtil.GRUPO_3, GrupoImagensUtil.IMAGENS_GRUPO_3, GrupoImagensUtil.AUDIOS_GRUPO_1);
	}
	
	public List<Palavra> getImagensGrupo4() {
		return getPalavrarPorGrupo(GrupoImagensUtil.GRUPO_4, GrupoImagensUtil.IMAGENS_GRUPO_4, GrupoImagensUtil.AUDIOS_GRUPO_1);
	}
	
	private List<Palavra> getPalavrarPorGrupo(int grupo1, String[] imagensGrupo1, String[] audiosGrupo1) {
		List<Palavra> palavrasGrupo1 = palavraDAO.buscarPalavrasPorGrupo(grupo1);
		for (int i = 0; i < GrupoImagensUtil.QTD_IMAGENS_POR_GRUPO; i++) {
			palavrasGrupo1.get(i).setMnemonicImagePath(imagensGrupo1[i]);
			palavrasGrupo1.get(i).setMnemonicAudioPath(audiosGrupo1[i]);
		}
		//Popular tempo se palavra concluida pelo usuário
		long idUsuario = getUsuarioLogado().getUsuario().getId();
		List<PalavraConcluida> palavrasConcluidasDoUsuario = palavraConcluidaDAO.getPalavrasConcluidasPorUsuario(idUsuario);
		for (Palavra palavra : palavrasGrupo1) {
			for (PalavraConcluida palavraConcluida : palavrasConcluidasDoUsuario) {
				if(palavra.getId() == palavraConcluida.getPalavra().getId()) {
					palavra.setMelhorTempo((int)palavraConcluida.getTempo());
				}
			}
		}
		return palavrasGrupo1;
	}

}
