package application.controller;

import java.net.URL;

import application.Main;
import application.dominio.dao.UsuarioDAO;
import application.model.Usuario;
import application.util.ApplicationUtil;
import arq.controller.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class LoginController extends AbstractController<Usuario> {
	

    @FXML
    private ImageView imgLogo;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Hyperlink linkCadastrese;

    @FXML
    private AnchorPane panel;

    @FXML
    private Button btnEntrar;

    @FXML
    private TextField txtUsuario;
    
    @FXML
    private Label labelCadastro;
    
    @FXML
    private Button btnCadastrar;

    
    private UsuarioDAO usuarioDAO;
    
    private ListagemVideosController listagemVideosController;
    
    private FormCadastroUsuarioController formCadastroUsuarioController;
    
    public LoginController() {
    	usuarioDAO = new UsuarioDAO();
    	listagemVideosController = new ListagemVideosController();
    	formCadastroUsuarioController = new FormCadastroUsuarioController();
    }

    @FXML
    void entrar(ActionEvent event) {
		if (usuarioEncotrado()) {
			listagemVideosController.abrirTela();
		} else {
			showMensagemErro("Usuário ou senha estão incorretos.");
		}
    }

    private boolean usuarioEncotrado() {
    	String loginUsuario = txtUsuario.getText().trim();
    	String senhaUsuario = txtSenha.getText();
    	boolean usuarioEncontrado = false;
    	if(!senhaUsuario.isEmpty() && !loginUsuario.isEmpty()) {
    		Usuario usuario = usuarioDAO.buscarPorEmailESenha(loginUsuario, senhaUsuario);
    		if(usuario != null) {    			
    			getUsuarioLogado().setUsuario(usuario);
    			usuarioEncontrado = true;
    		}
    	}
		return usuarioEncontrado;
	}

	@FXML
    void abrirTelaCadastro(ActionEvent event) {
		formCadastroUsuarioController.abrirTela();
    }

	@Override
	public UsuarioDAO getDAO() {
		return this.usuarioDAO;
	}

	@Override
	public void initLayout() {		
		btnEntrar.setFont(ApplicationUtil.getFontCaviarDreams(13));
		btnCadastrar.setFont(ApplicationUtil.getFontCaviarDreams(13));
		labelCadastro.setFont(ApplicationUtil.getFontCaviarDreams(14));
		txtSenha.setFont(ApplicationUtil.getFontCaviarDreams(14));
		txtUsuario.setFont(ApplicationUtil.getFontCaviarDreams(14));		
	}

	@Override
	public void initComponents() {		
	}

	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/FormLogin.fxml");
	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub
		
	}

}
