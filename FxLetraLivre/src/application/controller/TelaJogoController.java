package application.controller;

import java.net.URL;

import application.Main;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class TelaJogoController extends AbstractController {
	
	private static final int UM_SEGUNDO = 1000;
	
	public static Image imagemSelecionada;
	
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
    
    private Thread threadRelegio;
    
    private boolean palavraNaoConcluida;
    
    private int tempoGastoEmSegundos;

    @FXML
    void exibirAjuda(ActionEvent event) {    	
    	getMensagemAlerta().showMensagemAjuda("Digite a palavra referente à figura.\nClique no botão de som para ouvir a palavra novamente.");    	
    }
    
    @FXML
    void pausarJogo(ActionEvent event) {
    	
    }

    @FXML
    void repetirAudio(ActionEvent event) {
    	reproduzirAudio();
    }

    private void reproduzirAudio() {
		
	}

	@FXML
    void voltar(ActionEvent event) {
    	telaImagensPorGrupoController = new TelaImagensPorGrupoController();
    	telaImagensPorGrupoController.abrirTela();
    }

	@Override
	public void initComponents() {
		palavraNaoConcluida = true;
		tempoGastoEmSegundos = 0;
	}

	@Override
	public void initLayout() {
		pane.getStyleClass().add("telaJogo");
		carregarImagem();
		reproduzirAudio();
	}

	private void carregarImagem() {
		if(imagemSelecionada != null) {
			imagem.setImage(imagemSelecionada);
			imagem.setFitHeight(460);
			imagem.setPreserveRatio(true);
		}
	}

	@Override
	public void initListeners() {
		iniciarRelogio();		
	}

	private void iniciarRelogio() {
		taskRelogio = new Task() {
			@Override
			protected Object call() throws Exception {
				int segundo = 0;
				int minuto = 0;
				int hora = 0;
				Thread.sleep(UM_SEGUNDO);
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
                    Thread.sleep(UM_SEGUNDO);
                    tempoGastoEmSegundos++;
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
