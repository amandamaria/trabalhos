package application.controller;

import java.io.File;
import java.net.URL;
import java.util.List;

import application.Main;
import application.dominio.dao.FilmeDAO;
import application.dominio.dao.VideoDAO;
import application.model.Filme;
import application.model.Genero;
import application.model.Video;
import application.model.util.GeneroUtil;
import application.util.ApplicationUtil;
import arq.controller.AbstractController;
import arq.dominio.hibernate.dao.GenericDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FormCadastroVideoController extends AbstractController<Video> {

    @FXML
    private TextField txtDiretor;

    @FXML
    private Button btSelecionarMidiaVide;

    @FXML
    private ComboBox<Genero> comboCategoria;

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
    private TextField txtPosterFile;
    
    @FXML
    private TextField txtVideoFile;

    private ListagemVideosController listagemVideosController;
    
    private FilmeDAO filmeDAO;
    
    private VideoDAO videoDAO;
    
    private File folderSelecionado;
    
    private File videoSelecionado;
        
    public FormCadastroVideoController() {
    	this.filmeDAO = new FilmeDAO();
    	this.videoDAO = new VideoDAO();
    	this.folderSelecionado = null;
    	this.videoSelecionado = null;
	}
   
    @FXML
    void selecionarVideo(ActionEvent event) {
    	if(buscarVideo()) {
    		txtVideoFile.setText(videoSelecionado.getAbsolutePath());
    	}
    }

   

	private boolean buscarVideo() {
		FileChooser fileChooser = new FileChooser();
		ExtensionFilter extFilter = new ExtensionFilter("Mídia de vídeo", "*.mp4");
	    fileChooser.getExtensionFilters().add(extFilter);
	       
	    videoSelecionado = fileChooser.showOpenDialog(getStage());	        
		return videoSelecionado != null;
	}

	@FXML
    void selecionarFolder(ActionEvent event) {
		if(buscarImagem()) {
    		txtPosterFile.setText(folderSelecionado.getAbsolutePath());
    	} 
    }
	
	private boolean buscarImagem() {
		FileChooser fileChooser = new FileChooser();
		ExtensionFilter extFilter = new ExtensionFilter("Imagens", "*.png", "*.jpg");
	    fileChooser.getExtensionFilters().add(extFilter);
	       
	    folderSelecionado = fileChooser.showOpenDialog(getStage());	        
		return folderSelecionado != null;
	}

    @FXML
    void voltar(ActionEvent event) {
    	listagemVideosController.abrirTela();
    }

    @FXML
    void cadastrar(ActionEvent event) {
    	cadastrarFilme();
    }

	private void cadastrarFilme() {
		if(validarDados(gridCamposInformacoes) && validarDados(gridCamposMidias)) {
			Filme filme = new Filme();
			Video video = new Video();
			video.setTitulo(txtNome.getText().trim());
			video.setAno(Integer.parseInt(txtAno.getText()));
			video.setClassificacaoEtaria(Integer.parseInt(txtFaixaEtaria.getText()));
			video.setDiretor(txtDiretor.getText().trim());
			video.setNomeAtorPrincipal(txtAtorPrincipal.getText().trim());
			video.setSinopse(txtSinopse.getText().trim());
			video.setImagemPath("file:///"+txtPosterFile.getText());	
			video.setVideoPath(txtVideoFile.getText());
			video.getGeneros().add(comboCategoria.getValue());
			filme.setVideo(video);
			filmeDAO.salvar(filme);
		} else {
			showMensagemErro("Verifique se todos os campos estão preenchidos!");
		}
	}

	@SuppressWarnings("unchecked")
	private boolean validarDados(Pane pane) {
		ObservableList<Node> nodes = pane.getChildren();
		boolean todosOsCamposPreenchidos = true;
		for (Node node : nodes) {
			if(node instanceof TextField) {
				TextField textField = (TextField) node;
				if(textField.getText().trim().isEmpty()) {
					todosOsCamposPreenchidos = false;
					break;
				}
			} else if(node instanceof ComboBox) {
				ComboBox<Genero> genero = (ComboBox<Genero>) node;
				if(genero.getSelectionModel().getSelectedItem() == null) {
					todosOsCamposPreenchidos = false;
					break;
				}
			}
		}
		return todosOsCamposPreenchidos;
	}

	@Override
	public GenericDAO<Video> getDAO() {		
		return videoDAO;
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
		lbTitulo.setFont(ApplicationUtil.getFontCaviarDreams(48));
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
		listagemVideosController = new ListagemVideosController();
		iniciarComboGenero();
	}

	private void iniciarComboGenero() {
		List<Genero> generos = GeneroUtil.getGeneros();
		for (Genero genero : generos) {
			comboCategoria.getItems().add(genero);
		}
	}

	@Override
	public URL getFxmlUrl() {		
		return Main.class.getResource("/application/view/FormCadastroVideo.fxml");
	}

	@Override
	public void initListeners() {
		txtAno.textProperty().addListener(campoNumerico(txtAno));
		txtFaixaEtaria.textProperty().addListener(campoNumerico(txtFaixaEtaria));
	}
	
	private ChangeListener<String> campoNumerico(TextField textField) {
		return new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	            if (!newValue.matches("\\d*")) {
	                textField.setText(newValue.replaceAll("[^\\d]", ""));
	            }
	        }
		};
	}

}
