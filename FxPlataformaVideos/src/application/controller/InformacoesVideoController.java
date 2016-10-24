package application.controller;

import java.net.URL;

import application.Main;
import application.model.Serie;
import application.model.Video;
import application.util.ApplicationUtil;
import application.view.meuscomponentes.ImagemFilme;
import application.view.meuscomponentes.ImagemSeriado;
import arq.controller.AbstractController;
import arq.dominio.hibernate.dao.GenericDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class InformacoesVideoController extends AbstractController<Video> {
	
	@FXML
    private Label lbTituloForm;

    @FXML
    private Button btnAssitir;

    @FXML
    private ImageView imgFolder;

    @FXML
    private Button btForm;

    @FXML
    private VBox boxDetalhes;
    
    private ImagemFilme imagemFilme;
    
    private ImagemSeriado imagemSerie;
    
    private ListagemVideosController listagemVideosController;
 		
	public InformacoesVideoController() {
		this.listagemVideosController = new ListagemVideosController();	
		this.imagemFilme = ListagemVideosController.getVideoSelecionado();
		this.imagemSerie = ListagemVideosController.getSerieSelecionada();
	}

	@Override
	public GenericDAO<Video> getDAO() {
		return null;
	}

	@Override
	public void initLayout() {		
		aplicarFonteLabels();	
		popularInformacoesVideo();
	}
	
	private void popularInformacoesVideo() {
		ObservableList<Node> children = boxDetalhes.getChildren();
		if(imagemFilme != null) {
			imgFolder.setImage(imagemFilme);
			
			Video video = imagemFilme.getFilme().getVideo();
			int indice = -1;
			Label lbTituloFilme = (Label)children.get(++indice);
			lbTituloFilme.setText(lbTituloFilme.getText().concat(video.getTitulo()));
			
			Label lbSinopse = (Label)children.get(++indice);
			lbSinopse.setText(lbSinopse.getText().concat(video.getSinopse()));
			
			Label lbAno = (Label)children.get(++indice);
			lbAno.setText(lbAno.getText().concat(video.getAno()+""));
			
			Label lbGenero = (Label)children.get(++indice);
			lbGenero.setText(lbGenero.getText().concat("Ver isso aqui"));
			
			Label lbAtorPrincipal = (Label)children.get(++indice);
			lbAtorPrincipal.setText(lbAtorPrincipal.getText().concat(video.getNomeAtorPrincipal()));
			
			Label lbDiretor = (Label)children.get(++indice);
			lbDiretor.setText(lbDiretor.getText().concat(video.getDiretor()));
			
			Label lbFaixaEtaria = (Label)children.get(++indice);
			lbFaixaEtaria.setText(lbFaixaEtaria.getText().concat(video.getClassificacaoEtaria()+" anos"));
		} else if (imagemSerie != null) {
			imgFolder.setImage(imagemSerie);
			
			Serie seriado = imagemSerie.getSeriado();
			int indice = -1;
			Label lbTituloFilme = (Label)children.get(++indice);
			lbTituloFilme.setText(lbTituloFilme.getText().concat(seriado.getTitulo()));
			
			Label lbSinopse = (Label)children.get(++indice);
			lbSinopse.setText(lbSinopse.getText().concat(seriado.getSinopse()));
			
			Label lbAno = (Label)children.get(++indice);
			lbAno.setText(lbAno.getText().concat(seriado.getAno()+""));
			
			Label lbGenero = (Label)children.get(++indice);
			lbGenero.setText(lbGenero.getText().concat("Ver isso aqui"));			
			
			Label lbDiretor = (Label)children.get(++indice);
			lbDiretor.setText("Diretor ".concat(seriado.getDiretor()));
			
			Label lbFaixaEtaria = (Label)children.get(++indice);
			lbFaixaEtaria.setText("Classificação indicativa: ".concat(seriado.getClassificacaoEtaria()+" anos"));
			
			Label lbAtorPrincipal = (Label)children.get(++indice);
			lbAtorPrincipal.setText("");
		}
	}

	private void aplicarFonteLabels() {
		lbTituloForm.setFont(ApplicationUtil.getFontCaviarDreams(29));	
		ObservableList<Node> children = boxDetalhes.getChildren();
		for (Node node : children) {
			Label label = (Label) node;
			label.setFont(ApplicationUtil.getFontCaviarDreams(14));
		}
	}

	@Override
	public void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public URL getFxmlUrl() {		
		return Main.class.getResource("/application/view/InformacoesVideo.fxml");
	}


    @FXML
    void cadastrar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
    	listagemVideosController.abrirTela();
    }
	
	@Override
	public void initListeners() {
		// TODO Auto-generated method stub
		
	}

	public ImagemFilme getImagemFilme() {
		return imagemFilme;
	}

	public void setImagemFilme(ImagemFilme imagemFilme) {
		this.imagemFilme = imagemFilme;
		popularInformacoesVideo();
	}

}
