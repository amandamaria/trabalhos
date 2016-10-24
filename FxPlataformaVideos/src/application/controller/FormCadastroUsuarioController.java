package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import application.dominio.dao.UsuarioDAO;
import application.model.Genero;
import application.model.TipoVideo;
import application.model.Usuario;
import application.model.util.GeneroUtil;
import application.util.ApplicationUtil;
import application.view.meuscomponentes.CheckBoxGenero;
import application.view.meuscomponentes.CheckBoxTipoVideo;
import arq.controller.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FormCadastroUsuarioController extends AbstractController<Usuario>{

    @FXML
    private AnchorPane pane;
    
    @FXML
    private DatePicker txtDataNascimento;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private PasswordField txtConfSenha;

    @FXML
    private GridPane gridDadosPessoais;

    @FXML
    private GridPane gridGenerosInteresse;
    
    @FXML
    private GridPane gridInteresseTipo;

    @FXML
    private Button btnCadastrar;
    
    @FXML
    private Button btnVoltar;

    @FXML
    private TextField txtSobrenome;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;
    
    @FXML
    private Label lbCategorias;
    
    @FXML
    private Label lbInteresseTipo;
    
    @FXML
    private Label lbTitulo;
    
    private List<CheckBoxGenero> checkGeneros;

    private List<CheckBoxTipoVideo> checkTiposVideo;
    
    private UsuarioDAO usuarioDAO;
            
    private Usuario usuario;
    
    private LoginController loginController;
    
    public FormCadastroUsuarioController() {
    	checkGeneros = new ArrayList<>();
    	checkTiposVideo = new ArrayList<>();
    	usuarioDAO = new UsuarioDAO();    	
	}

	@Override
	public UsuarioDAO getDAO() {
		return usuarioDAO;
	}

	@Override
	public void initLayout() {
		aplicarFonteLabels();	
		aplicarFonte();	
	}

	private void aplicarFonte() {
		btnCadastrar.setFont(ApplicationUtil.getFontCaviarDreams(14));
		btnVoltar.setFont(ApplicationUtil.getFontCaviarDreams(14));
		List<Node> children = gridDadosPessoais.getChildren();
		for (Node node : children) {
			if(node instanceof TextField) {
				TextField textField = (TextField) node;
				textField.setFont(ApplicationUtil.getFontCaviarDreams(14));
			} else if (node instanceof PasswordField) {
				PasswordField passwordField = (PasswordField) node;
				passwordField.setFont(ApplicationUtil.getFontCaviarDreams(14));
			}
		}	
	}

	private void aplicarFonteLabels() {
		lbCategorias.setFont(ApplicationUtil.getFontCaviarDreams(16));
		lbInteresseTipo.setFont(ApplicationUtil.getFontCaviarDreams(16));
		lbTitulo.setFont(ApplicationUtil.getFontCaviarDreams(48));
		aplicarFonteEmLote(gridDadosPessoais);
	}
	
    private void aplicarFonteEmLote(Pane componentPai) {
	   List<Node> children = componentPai.getChildren();
		for (Node node : children) {
			if(node instanceof Label) {
				Label label = (Label) node;
				label.setFont(ApplicationUtil.getFontCaviarDreams(16));
			}
		}
	}

   	@FXML
    void cadastrar(ActionEvent event) {   		
	   if(validarDadosCadastro()) {
		   popularDadosUsuario();		   
		   usuarioDAO.salvar(usuario);
		   entrarTelaInicial();
	   }
    }
   	
	@FXML
    void voltar(ActionEvent event) {   		
		loginController = new LoginController();
		loginController.abrirTela();
    }

	private boolean verificarExistenciaEmail() {
		return usuarioDAO.verificarExistenciaEmail(txtEmail.getText());
	}

	private void entrarTelaInicial() {
		
	}

	private void popularDadosUsuario() {
		usuario = new Usuario();
		usuario.setNome(txtNome.getText());
		usuario.setSobrenome(txtSobrenome.getText());
		usuario.setAdministrador(false);
		usuario.setEmail(txtEmail.getText());
		usuario.setDataNascimento(ApplicationUtil.localDateToDate(txtDataNascimento.getValue()));
		popularGenerosUsuario();
		usuario.setSenha(txtSenha.getText());
	}

	private void popularGenerosUsuario() {
		for (CheckBoxGenero checkBoxGenero : checkGeneros) {
			if(checkBoxGenero.isChecked()) {
				usuario.getGenerosFavoritos().add(checkBoxGenero.getGenero());
			}
		}		
	}

	private boolean validarDadosCadastro() {
		boolean contemErro = false;
		List<Node> dadosPessoais = gridDadosPessoais.getChildren();
		for (Node node : dadosPessoais) {
			if(node instanceof TextField) {
				TextField textField = (TextField) node;
				if(textField.getText().trim().isEmpty()) {
					contemErro = true;
				}
			} else if (node instanceof PasswordField) {
				PasswordField passField = (PasswordField) node;
				if(passField.getText().trim().isEmpty()) {
					contemErro = true;
				}
			} else if (node instanceof DatePicker) {
				DatePicker dateField = (DatePicker) node;
				if(dateField.getValue() == null) {
					contemErro = true;
				}
			}
		}
		if(!txtSenha.getText().equals(txtConfSenha.getText())) {
			contemErro = true;
		}
		if(verificarExistenciaEmail()) {
			contemErro = true;
		}
		if(!selecionouGeneroFavorito()) {
			contemErro = true;
		}		
		if(!tipoVideoFavorito()) {
			contemErro = true;
		}
 		return !contemErro;
	}

	private boolean tipoVideoFavorito() {
		boolean existeTipoSelecionado = false;
		for (CheckBoxTipoVideo checkBoxTipoVideo : checkTiposVideo) {
			if(checkBoxTipoVideo.isChecked()) {
				existeTipoSelecionado = true;
				break;
			}
		}
		return existeTipoSelecionado;
	}

	private boolean selecionouGeneroFavorito() {
		boolean existeGeneroSelecionado = false;
		for (CheckBoxGenero checkBoxGenero : checkGeneros) {
			if(checkBoxGenero.isChecked()) {
				existeGeneroSelecionado = true;
				break;
			}
		}
		return existeGeneroSelecionado;
	}

	@Override
	public void initComponents() {
		initCheckBoxesGenero(gridGenerosInteresse);
		initCheckBoxesTipo(gridInteresseTipo);
	}

	private void initCheckBoxesTipo(GridPane gridContainer) {
		List<TipoVideo> tiposVideo = TipoVideo.getTipos();
		int col = 0;
		for (TipoVideo tipo : tiposVideo) {
			CheckBoxTipoVideo checkBoxTipoVideo = new CheckBoxTipoVideo(tipo);
			checkTiposVideo.add(checkBoxTipoVideo);
			gridContainer.add(checkBoxTipoVideo.getVisibleElement(), col, 0);
			col++;
		}				
	}

	private void initCheckBoxesGenero(GridPane gridContainer) {
		List<Genero> generos = GeneroUtil.getGeneros();
		int col = 0;
		int linha = 0;
		for (Genero genero : generos) {
			CheckBoxGenero checkBoxGenero = new CheckBoxGenero(genero);
			checkGeneros.add(checkBoxGenero);
			gridContainer.add(checkBoxGenero.getVisibleElement(), col, linha);
			if(linha == 2) {
				col++;
				linha = 0;
			} else {
				linha++;
			}
		}				
	}

	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/FormCadastroUsuario.fxml");
	}

	@Override
	public void initListeners() {
	}
	
}

