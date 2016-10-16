package application.controller;

import java.net.URL;

import application.Main;
import application.model.Video;
import application.util.ApplicationUtil;
import arq.controller.AbstractController;
import arq.dominio.hibernate.dao.GenericDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FormCadastroVideoController extends AbstractController<Video> {

    @FXML
    private TextField txtDiretor;

    @FXML
    private Button btSelecionarMidiaVide;

    @FXML
    private ComboBox<?> comboCategoria;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtAtorPrincipal;

    @FXML
    private TextField txtSinopse;

    @FXML
    private GridPane gridCamposMidias;

    @FXML
    private TextField txtAno;

    @FXML
    private TextField txtFaixaEtaria;

    @FXML
    private TextField txtDuaracao;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btSelecionarMidiaFolder;

    @FXML
    private Label lbTitulo;

    @FXML
    private GridPane gridCamposInformacoes;

    @FXML
    private Button btCadastrar;

    @FXML
    private AnchorPane pane;

   
    @FXML
    void selecionarVideo(ActionEvent event) {

    }

    @FXML
    void selecionarFolder(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }

    @FXML
    void cadastrar(ActionEvent event) {

    }

	@Override
	public GenericDAO<Video> getDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initLayout() {
		aplicarFonte(gridCamposInformacoes);
		aplicarFonte(gridCamposMidias);
		aplicarFonteBotoes();
	}

	private void aplicarFonteBotoes() {
		btCadastrar.setFont(ApplicationUtil.getFontCaviarDreams(14));
		btVoltar.setFont(ApplicationUtil.getFontCaviarDreams(14));
		btSelecionarMidiaFolder.setFont(ApplicationUtil.getFontCaviarDreams(14));
		btSelecionarMidiaVide.setFont(ApplicationUtil.getFontCaviarDreams(14));
	}

	private void aplicarFonte(Pane panel) {
		ObservableList<Node> campos = panel.getChildren();
		for (Node node : campos) {
			if(node instanceof TextField) {
				TextField textField = (TextField) node;
				textField.setFont(ApplicationUtil.getFontCaviarDreams(14));
			} else if (node instanceof Label) {
				Label label = (Label) node;
				label.setFont(ApplicationUtil.getFontCaviarDreams(14));
			}
		}
	}

	@Override
	public void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public URL getFxmlUrl() {		
		return Main.class.getResource("/application/view/FormCadastroVideo.fxml");
	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub
		
	}

}
