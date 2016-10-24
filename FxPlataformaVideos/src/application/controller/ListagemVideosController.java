package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import application.dominio.dao.FilmeDAO;
import application.dominio.dao.VideoDAO;
import application.list.InfinityList;
import application.model.Filme;
import application.model.Video;
import application.util.ApplicationUtil;
import application.view.meuscomponentes.ImagemFilme;
import arq.controller.AbstractController;
import arq.dominio.hibernate.dao.GenericDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    private ImageView img2Filme;
    
    @FXML
    private ImageView img3Filme;
    
    @FXML
    private ImageView img4Filme;
    
    @FXML
    private ImageView img5Filme;
    
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
    
    private VideoDAO videoDAO;

	private FilmeDAO filmeDAO;
	
	private List<Filme> filmes;
	
	private InfinityList<ImagemFilme> filmesInfinityList;
	
	private List<ImageView> imagensViewFilmes;
	
	private InformacoesVideoController informacoesVideosController;
	
	private static ImagemFilme filmeSelecionado;

    public ListagemVideosController() {
    	opcoesVisiveis = false;
    	formCadastroVideoController = new FormCadastroVideoController();
    	videoDAO = new VideoDAO();
    	filmeDAO = new FilmeDAO();   
	}
	
	@Override
	public GenericDAO<Video> getDAO() {		
		return videoDAO;
	}

	@Override
	public void initLayout() {
		btnOpcoes.getStyleClass().addAll("button-mouse");
		aplicarFormatacaoFonte();
		addBemVindoUsuario();		
		exibirVideos();
	}

	private void exibirVideos() {
		exibirFilmes();		
	}

	private void exibirFilmes() {
		ObservableList<Node> children = boxFilmes.getChildren();
		InfinityList<ImagemFilme> filmesIterator = filmesInfinityList;
		for (Node node : children) {
			ImageView imagem = (ImageView) node;
			imagem.setImage(filmesIterator.getValor());
			filmesIterator = filmesIterator.getProximo();
		}		
	}

	private void carregarVideos() {
		carregarFilmes();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void carregarFilmes() {
		int idadeUsuario = getUsuarioLogado().getUsuario().getIdadeUsuario();
		filmes = filmeDAO.buscarFilmesPorFaixaEtaria(idadeUsuario);
		if(!filmes.isEmpty()) {
			int PRIMEIRO_ITEM = 0;
			filmesInfinityList = new InfinityList(new ImagemFilme(filmes.get(PRIMEIRO_ITEM)));
			int indice = 1;
			while (indice < filmes.size()) {				
				filmesInfinityList.addNovo(new ImagemFilme(filmes.get(indice)));
				indice++;
			}
			InfinityList<ImagemFilme> filmeIterator = filmesInfinityList;
			while (filmeIterator.getProximo() != null) {
				filmeIterator = filmeIterator.getProximo();				
			}
			filmesInfinityList.setAnterior(filmeIterator);
			filmeIterator.setProximo(filmesInfinityList);
		}		
	}

	private void addBemVindoUsuario() {
		lbNomeUsuario.setText(getUsuarioLogado().getUsuario().getNome().concat("!"));		
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
		iniciarListasImagesView();
		carregarVideos();
	}

	private void iniciarListasImagesView() {
		iniciarListasImagesViewFilmes();
	}

	private void iniciarListasImagesViewFilmes() {
		imagensViewFilmes = new ArrayList<>();
		imagensViewFilmes.add(img1Filme);
		imagensViewFilmes.add(img2Filme);
		imagensViewFilmes.add(img3Filme);
		imagensViewFilmes.add(img4Filme);
		imagensViewFilmes.add(img5Filme);
	}

	private void setVisibidadeOpcoes(boolean visible) {
		opcoesVisiveis = visible;
		if(getUsuarioLogado().getUsuario().isAdministrador()) {
			imgOpcoes.setVisible(visible);
			btnOpcaoSerie.setVisible(visible);
			btnOpcaoFilme.setVisible(visible);
		}
		btnOpcoes.setVisible(getUsuarioLogado().getUsuario().isAdministrador());
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
		
		imagensFilmeListeners();
	}
	
	private void imagensFilmeListeners() {
		img3Filme.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				filmeSelecionado = (ImagemFilme) img3Filme.getImage();
				informacoesVideosController = new InformacoesVideoController();
				informacoesVideosController.abrirTela();				
			}
		});
		
		img4Filme.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
				InfinityList<ImagemFilme> primeiraImagemDireita = filmesInfinityList;
				while (!primeiraImagemDireita.getValor().equals(img1Filme.getImage())) {
					primeiraImagemDireita = primeiraImagemDireita.getProximo();
				}
				
				for (ImageView imageView : imagensViewFilmes) {
					imageView.setImage(primeiraImagemDireita.getProximo().getValor());
					primeiraImagemDireita = primeiraImagemDireita.getProximo();
				}				
			}
		});
		
		img5Filme.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
				InfinityList<ImagemFilme> primeiraImagemEsquerda = filmesInfinityList;
				while (!primeiraImagemEsquerda.getValor().equals(img1Filme.getImage())) {
					primeiraImagemEsquerda = primeiraImagemEsquerda.getProximo();
				}		
				
				for (ImageView imageView : imagensViewFilmes) {
					imageView.setImage(primeiraImagemEsquerda.getProximo().getProximo().getValor());
					primeiraImagemEsquerda = primeiraImagemEsquerda.getProximo();
				}
			}
		});
		
		img2Filme.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
				InfinityList<ImagemFilme> primeiraImagemEsquerda = filmesInfinityList;
				while (!primeiraImagemEsquerda.getValor().equals(img1Filme.getImage())) {
					primeiraImagemEsquerda = primeiraImagemEsquerda.getProximo();
				}
				for (ImageView imageView : imagensViewFilmes) {
					imageView.setImage(primeiraImagemEsquerda.getAnterior().getValor());
					primeiraImagemEsquerda = primeiraImagemEsquerda.getProximo();
				}
			}
		});
		
		img1Filme.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {				
				InfinityList<ImagemFilme> primeiraImagemEsquerda = filmesInfinityList;
				while (!primeiraImagemEsquerda.getValor().equals(img1Filme.getImage())) {
					primeiraImagemEsquerda = primeiraImagemEsquerda.getProximo();
				}
				for (ImageView imageView : imagensViewFilmes) {
					imageView.setImage(primeiraImagemEsquerda.getAnterior().getAnterior().getValor());
					primeiraImagemEsquerda = primeiraImagemEsquerda.getProximo();
				}
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

	public static ImagemFilme getVideoSelecionado() {		
		return filmeSelecionado;
	}
}
