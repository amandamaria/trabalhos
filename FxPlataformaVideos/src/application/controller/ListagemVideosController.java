package application.controller;

import java.net.URL;

import application.Main;
import application.model.Video;
import application.util.ApplicationUtil;
import arq.controller.AbstractController;
import arq.dominio.hibernate.dao.GenericDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class ListagemVideosController extends AbstractController<Video> {

	@FXML
    private Button btnOpcaoFilme;

    @FXML
    private HBox boxDesenhos;

    @FXML
    private ImageView imgOpcoes;

    @FXML
    private HBox boxSeries;

    @FXML
    private Button btnOpcoes;

    @FXML
    private Button btnOpcaoSerie;

    @FXML
    private TextField txtBuscar;

    @FXML
    private Label lbFilme;

    @FXML
    private ImageView img1Desenho;

    @FXML
    private ImageView img1Filme;

    @FXML
    private HBox boxFilmes;

    @FXML
    private Label lbSerie;

    @FXML
    private Label lbDesenho;
    
    @FXML
    private Label lbNomeUsuario;
    
    @FXML
    private AnchorPane pane;

    @FXML
    private ImageView img1Serie;

    @FXML
    private Button btnBuscar;
    
    @FXML
    private Label lbBemVindo;
    
    private boolean opcoesVisiveis;
    
    private FormCadastroVideoController formCadastroVideoController;

    public ListagemVideosController() {
    	opcoesVisiveis = false;
    	formCadastroVideoController = new FormCadastroVideoController();
	}
	
	@Override
	public GenericDAO<Video> getDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initLayout() {
		btnOpcoes.getStyleClass().addAll("button-mouse");
		aplicarFormatacaoFonte();
		addBemVindoUsuario();
	}

	private void addBemVindoUsuario() {
		lbNomeUsuario.setText(getUsuarioLogado().getUsuarioLogado().getNome().concat("!"));		
	}

	private void aplicarFormatacaoFonte() {
		lbNomeUsuario.setFont(ApplicationUtil.getFontCaviarDreams(16));
		lbBemVindo.setFont(ApplicationUtil.getFontCaviarDreams(16));
		txtBuscar.setFont(ApplicationUtil.getFontCaviarDreams(14));
		txtBuscar.getStyleClass().add("campo-de-busca");
		lbSerie.setFont(ApplicationUtil.getFontCaviarDreams(22));
		lbFilme.setFont(ApplicationUtil.getFontCaviarDreams(22));
		lbDesenho.setFont(ApplicationUtil.getFontCaviarDreams(22));
		btnOpcoes.setFont(ApplicationUtil.getFontCaviarDreams(12));
	}

	@Override
	public void initComponents() {
		setVisibidadeOpcoes(opcoesVisiveis);	
	}

	private void setVisibidadeOpcoes(boolean visible) {
		opcoesVisiveis = visible;
		if(getUsuarioLogado().getUsuarioLogado().isAdministrador()) {
			imgOpcoes.setVisible(visible);
			btnOpcaoSerie.setVisible(visible);
			btnOpcaoFilme.setVisible(visible);
		}
		btnOpcoes.setVisible(getUsuarioLogado().getUsuarioLogado().isAdministrador());
	}

	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/ListagemVideos.fxml");
	}

	@Override
	public void initListeners() {	
		btnOpcaoFilme.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				irParaTelaCadastroFilme();				
			}
		});
	}
	
	public void irParaTelaCadastroFilme() {
		formCadastroVideoController.abrirTela();
	}

	@FXML
	public void exibirOpcoes(ActionEvent event) {
		if(opcoesVisiveis) {
			setVisibidadeOpcoes(false);
		} else {
			setVisibidadeOpcoes(true);
		}
	}

}
