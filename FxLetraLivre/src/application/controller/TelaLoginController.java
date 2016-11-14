package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import application.util.ApplicationUtil;
import application.util.LoginUtil;
import application.view.meuscomponentes.SelectOneImage;
import arq.controller.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class TelaLoginController extends AbstractController {
	
	@FXML
    private GridPane gridAvatar;

    @FXML
    private TextField txtNome;

    @FXML
    private Button btnAvancar;

    @FXML
    private Button btnVoltar;
    
    @FXML
    private Label lbNome;
    
    @FXML
    private Label lbAvatar;
    
    @FXML
    private AnchorPane pane;
    
    private TelaInicialController telaInicialController;
    
    private TelaGrupoImagensController telaGrupoImagensController;
    
    private List<SelectOneImage> imagensAvatar;

    @FXML
    void avancar(ActionEvent event) {
    	if(verificarNome() && verificarAvatar()) {
    		irParaTelaDeGrupos();
    	} else {
    		getMensagemAlerta().showMensagemErro("Digite seu nome e selecione um avatar!");
    	}
    }

    private void irParaTelaDeGrupos() {
    	telaGrupoImagensController = new TelaGrupoImagensController();
    	telaGrupoImagensController.abrirTela();
	}

	private boolean verificarAvatar() {
		boolean avatarSelecionado = false;
		for (SelectOneImage selectOneImage : imagensAvatar) {
			if(selectOneImage.isSelecionado()) {
				avatarSelecionado = true;
				break;
			}
		}
		return avatarSelecionado;
	}

	private boolean verificarNome() {
		boolean nomeValido = true;
		if(txtNome.getText().trim().isEmpty()) {
			nomeValido = false;
		}
		return nomeValido;
	}

	@FXML
    void voltar(ActionEvent event) {
    	voltarParaTelaInicial();
    }

	private void voltarParaTelaInicial() {
		telaInicialController = new TelaInicialController();
    	telaInicialController.abrirTela();
	}

	@Override
	public void initComponents() {
		initImagensAvatar();
	}

	private void initImagensAvatar() {
		gridAvatar.getChildren().clear();
		imagensAvatar = new ArrayList<SelectOneImage>();
		int k = 0;
		for(int i= 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				SelectOneImage imageViewAvatar = new SelectOneImage(LoginUtil.URL_IMAGENS_AVATAR[k], 
										LoginUtil.URL_IMAGENS_AVATAR_SELECIONADO[k], gridAvatar);				
				k++;
				gridAvatar.add(imageViewAvatar, i, j);
				imagensAvatar.add(imageViewAvatar);				
			}
		}
	}

	@Override
	public void initLayout() {	
		pane.getStyleClass().add("telaLogin");
		lbAvatar.setFont(ApplicationUtil.getFontCaviarDreams(20));
		lbNome.setFont(ApplicationUtil.getFontCaviarDreams(20));
		txtNome.setFont(ApplicationUtil.getFontCaviarDreams(24));
	}

	@Override
	public void initListeners() {
		
	}


	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/TelaLogin.fxml");
	}

}
