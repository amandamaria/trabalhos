package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import application.dominio.dao.UsuarioDAO;
import application.model.Usuario;
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
    
    private UsuarioDAO usuarioDAO;
    
    private Usuario usuario;

    @FXML
    void avancar(ActionEvent event) {
    	if(verificarNome() && verificarAvatar()) {
    		if(verificarExistenciaDoNome()) {
    			if(getMensagemAlerta().showMensagemOpcoes("Já existe alguém com esse nome.")) {
    				getUsuarioLogado().setUsuario(usuario);
    				atualizarAvatar();
    				irParaTelaDeGrupos();
    			} else {
    				txtNome.requestFocus();
    			}
    		} else {
    			cadastrarUsuario();
    			getUsuarioLogado().setUsuario(usuario);
    			irParaTelaDeGrupos();
    		}        		
    	} else {
    		getMensagemAlerta().showMensagemErro("Informe seu nome e selecione um avatar!");
    	}
    }

    private void atualizarAvatar() {
    	for (SelectOneImage selectOneImage : imagensAvatar) {
			if(selectOneImage.isSelecionado()) {
				usuario.setCodigoAvatar(selectOneImage.getCodigoImagem());
			}
		}
		usuarioDAO.salvar(getUsuarioLogado().getUsuario());
	}

	private void cadastrarUsuario() {
    	popularInformacoesUsuario();
		usuarioDAO.salvar(usuario);
	}

	private boolean verificarExistenciaDoNome() {
    	boolean nomeDeUsuarioJaExiste = false;
		Usuario usuarioEncontrado = usuarioDAO.buscarPorNome(txtNome.getText());
		if(usuarioEncontrado != null) {
			usuario = usuarioEncontrado;
			nomeDeUsuarioJaExiste = true;
		}
		return nomeDeUsuarioJaExiste;
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
			popularInformacoesUsuario();
			nomeValido = false;
		}
		return nomeValido;
	}

	private void popularInformacoesUsuario() {
		usuario.setNome(txtNome.getText());
		for (SelectOneImage selectOneImage : imagensAvatar) {
			if(selectOneImage.isSelecionado()) {
				usuario.setCodigoAvatar(selectOneImage.getCodigoImagem());
			}				
		}		
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
		usuario = new Usuario();
		usuarioDAO = new UsuarioDAO();
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
				imageViewAvatar.setCodigoImagem(k);
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
