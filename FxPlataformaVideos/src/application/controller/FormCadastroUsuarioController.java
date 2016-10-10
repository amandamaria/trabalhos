package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import application.dominio.dao.UsuarioDAO;
import application.model.Usuario;
import application.util.ApplicationUtil;
import application.view.meuscomponentes.CheckBox;
import arq.controller.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private GridPane gridCategorias;
    
    @FXML
    private GridPane gridInteresseTipo;

    @FXML
    private Button btnCadastrar;

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
    
    private List<CheckBox> checkCategorias;

    private UsuarioDAO usuarioDAO;
    
    private Usuario usuario;
    
    public FormCadastroUsuarioController() {
    	checkCategorias = new ArrayList<CheckBox>();
    	usuarioDAO = new UsuarioDAO();
	}

	@Override
	public UsuarioDAO getDAO() {
		return usuarioDAO;
	}

	@Override
	public void initLayout() {
		aplicarFonteLabels();	
		aplicarFonteTextFields();	
	}

	private void aplicarFonteTextFields() {
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
		aplicarFonteEmLote(gridCategorias);
		aplicarFonteEmLote(gridDadosPessoais);
		aplicarFonteEmLote(gridInteresseTipo);
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
		System.out.println(usuario.getDataNascimento());
		usuario.setSenha(txtSenha.getText());
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
 		return !contemErro;
	}

	@Override
	public void initComponents() {
		initCheckBoxes(gridCategorias);
		initCheckBoxes(gridInteresseTipo);
	}

	private void initCheckBoxes(GridPane gridContainer) {
		int index = 0;
		for (Node node : gridContainer.getChildren()) {			
			if(node instanceof ImageView) {
				CheckBox checkBox = new CheckBox((ImageView) node, "");
				checkCategorias.add(checkBox);
			} else if(node instanceof Label) {
				Label labelCheck = (Label) node;
				checkCategorias.get(index).setNome(labelCheck.getText());
				index++;
			}
		}
	}

	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/FormCadastroUsuario.fxml");
	}

}

