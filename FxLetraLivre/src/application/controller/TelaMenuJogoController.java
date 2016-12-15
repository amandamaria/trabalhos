package application.controller;

import java.net.URL;
import java.util.Timer;

import application.Main;
import application.dominio.dao.PalavraConcluidaDAO;
import application.model.Palavra;
import application.model.PalavraConcluida;
import application.util.ApplicationUtil;
import arq.controller.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class TelaMenuJogoController extends TelaJogoController {
	
	private static final String ESTRELA_CINZA_PATH = "/resources/template/tela5/starcinza.png";
	private static final String ESTRELA_AMARELA_PATH = "/resources/template/tela5/staramarela.png";
	
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
    
    private Palavra palavra;
    
    private PalavraConcluidaDAO palavraConcluidaDAO;
    
    @FXML
    void reiniciarJogo(ActionEvent event) {
    	this.palavraNaoConcluida = true;
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
		palavraConcluidaDAO = new PalavraConcluidaDAO();
		carregarPalavra();
	}
	
	private void carregarPalavra() {
		long idUsuario = getUsuarioLogado().getUsuario().getId();
		long idPalavra = TelaJogoController.palavraSelecionada.getId();
		PalavraConcluida palavraConcluida = palavraConcluidaDAO.buscarPorUsuarioEPalavra(idUsuario, idPalavra);
		if(palavraConcluida != null) {
			palavra = palavraConcluida.getPalavra();
			palavra.setMelhorTempo((int)palavraConcluida.getTempo());
		}
	}

	public void initListeners() {
		
	}
	
	public void initLayout() {
		pane.getStyleClass().add("telaMenuJogo");
		btnContinuar.setDisable(!palavraNaoConcluida);
		popularEstrelas();
		mudarLabelTempo();
	}

	private void mudarLabelTempo() {
		if(palavra != null) {
			lbTempo.setText(ApplicationUtil.getStringTempoFormatado(palavra.getMelhorTempo()));
		}
	}

	private void popularEstrelas() {
		if(palavra != null) {
			if(palavra.getMelhorTempo() > 0 && palavra.getMelhorTempo() <= 30) {
				imgEstrela1.setImage(gerarImagem(ESTRELA_AMARELA_PATH));
				imgEstrela2.setImage(gerarImagem(ESTRELA_AMARELA_PATH));
				imgEstrela3.setImage(gerarImagem(ESTRELA_AMARELA_PATH));
			} else if(palavra.getMelhorTempo() > 30 && palavra.getMelhorTempo() <= 90) {
				imgEstrela1.setImage(gerarImagem(ESTRELA_AMARELA_PATH));
				imgEstrela2.setImage(gerarImagem(ESTRELA_AMARELA_PATH));
				imgEstrela3.setImage(gerarImagem(ESTRELA_CINZA_PATH));
			}
		}		
	}

	private Image gerarImagem(String path) {		
		return new Image(path);
	}

	@Override
	public URL getFxmlUrl() {		
		return Main.class.getResource("/application/view/TelaMenuJogo.fxml");
	}
	
}
