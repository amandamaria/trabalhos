package application.controller;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Timer;

import application.Main;
import application.dominio.dao.PalavraConcluidaDAO;
import application.model.Palavra;
import application.model.PalavraConcluida;
import application.util.ApplicationUtil;
import application.util.GrupoPalavrasUtil;
import arq.controller.AbstractController;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TelaJogoController extends AbstractController {
	
	private static final int UM_SEGUNDO = 1000;
	
	public static Palavra palavraSelecionada;
	
	@FXML
	private AnchorPane pane;
	
	@FXML
    private VBox gridTentativas;

    @FXML
    private TextField txtPalavra;

    @FXML
    private Button btnVoltar;

    @FXML
    private ImageView imagem;

    @FXML
    private Button btnPause;

    @FXML
    private Button btnReplay;

    @FXML
    private Button btnAjuda;

    @FXML
    private Label lbTempo;

    private TelaImagensPorGrupoController telaImagensPorGrupoController;
    
    private Task taskRelogio;
    
    public static Thread threadRelegio;
    
    public static boolean palavraNaoConcluida;
    
    private int tempoGastoEmSegundos;
    
    private PopupMenuJogo popupMenuJogo;
    
    private PalavraConcluidaDAO palavraConcluidaDAO;
    
    private PalavraConcluida palavraConcluida;
    
    private Stage stageMenu;

    @FXML
    void exibirAjuda(ActionEvent event) {    	
    	getMensagemAlerta().showMensagemAjuda("Digite a palavra referente à figura.\nClique no botão de som para ouvir a palavra novamente.");    	
    }
    
    @FXML
    void pausarJogo(ActionEvent event) {    	
    	try {
    		stageMenu = new Stage();
			popupMenuJogo.start(stageMenu);			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void repetirAudio(ActionEvent event) {
    	reproduzirAudio();
    }

    private void reproduzirAudio() {    	
		try {
			Media hit = new Media(Main.class.getResource(GrupoPalavrasUtil.PATH_AUDIOS_GRUPO_JOGO+palavraSelecionada.getMnemonicAudioPath()).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(hit);
			mediaPlayer.play();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@FXML
    void voltar(ActionEvent event) {
    	telaImagensPorGrupoController = new TelaImagensPorGrupoController();
    	telaImagensPorGrupoController.abrirTela();
    }

	@Override
	public void initComponents() {
		popupMenuJogo = new PopupMenuJogo();
		palavraConcluidaDAO = new PalavraConcluidaDAO();
		palavraNaoConcluida = true;
		tempoGastoEmSegundos = 0;
	}

	@Override
	public void initLayout() {
		pane.getStyleClass().add("telaJogo");
		txtPalavra.setFont(ApplicationUtil.getFontCaviarDreams(24));		
		carregarImagem();
		reproduzirAudio();
	}

	private void carregarImagem() {
		if(palavraSelecionada != null) {
			Image imagemPalavra = new Image(GrupoPalavrasUtil.PATH_IMAGENS_GRUPO_JOGO+palavraSelecionada.getMnemonicImagePath());			
			imagem.setImage(imagemPalavra);
			imagem.setFitHeight(460);
			imagem.setPreserveRatio(true);
		}
	}

	@Override
	public void initListeners() {
		iniciarRelogio();
		txtPalavra.setOnKeyPressed(new javafx.event.EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER || txtPalavra.getText().length() == GrupoPalavrasUtil.TAMANHO_MAIOR_PALAVRA) {
					if(txtPalavra.getText().trim().equalsIgnoreCase(palavraSelecionada.getTexto())) {
		        		finalizarJogo();
		        	} else {	        		
		        		finalizarTentativa();
		        	}
				}
			}
		});
	}

	private void finalizarTentativa() {
		Label lbTentativa = new Label(txtPalavra.getText().trim());
		lbTentativa.setFont(Font.font("arial", 18));
		gridTentativas.getChildren().add(lbTentativa);
		txtPalavra.clear();
	}
	
    private void finalizarJogo() {
		try {
			palavraNaoConcluida = false;
			cadastrarPalavraConcluida();
			popupMenuJogo.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		taskRelogio.cancel();
	}

    private void cadastrarPalavraConcluida() {
		palavraConcluida = palavraJaConcluida();
		if(palavraConcluida != null) {
			alterarTempoSeMelhor();
		} else {
			palavraConcluida = new PalavraConcluida();
			palavraConcluida.setUsuario(getUsuarioLogado().getUsuario());
			palavraConcluida.setPalavra(palavraSelecionada);
			palavraConcluida.setTempo(tempoGastoEmSegundos);
	    	palavraConcluidaDAO.salvar(palavraConcluida);	
		}		
	}

	private void alterarTempoSeMelhor() {
		if(palavraConcluida.getTempo() > tempoGastoEmSegundos) {
			palavraConcluida.setTempo(tempoGastoEmSegundos);
			palavraConcluidaDAO.salvar(palavraConcluida);
		}
	}

	private PalavraConcluida palavraJaConcluida() {
		long idUsuario = getUsuarioLogado().getUsuario().getId();
		long idPalavra = palavraSelecionada.getId();
		PalavraConcluida palavraConcluida = palavraConcluidaDAO.buscarPorUsuarioEPalavra(idUsuario, idPalavra);
		return palavraConcluida;
	}

	
	private void iniciarRelogio() {
		taskRelogio = new Task() {					
			@Override
			protected Object call() throws Exception {
				Thread.sleep(UM_SEGUNDO);
				int segundo = 0;
				int minuto = 0;
				int hora = 0;
				while (palavraNaoConcluida) {
	                segundo++;
	                
	                if (segundo == 60) {
	                    minuto++;
	                    segundo = 0;
	                }

	                if (minuto == 60) {
	                    hora++;
	                    minuto = 0;
	                }
	                final String hr = hora <= 9 ? "0" + hora : hora + "";
	                final String min = minuto <= 9 ? "0" + minuto : minuto + "";
	                final String seg = segundo <= 9 ? "0" + segundo : segundo + "";

	                Platform.runLater(new Runnable() {
						public void run() {
						    lbTempo.setText(hr + ":" + min + ":" + seg);
						}
					});
	                tempoGastoEmSegundos++;		
	                Thread.sleep(UM_SEGUNDO);
				}
				return null;
			}
		};
		threadRelegio = new Thread(taskRelogio);
		threadRelegio.start();
	}

	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/TelaJogo.fxml");
	}

}
