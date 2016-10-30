package application.controller;

import java.net.URL;

import application.Main;
import application.model.Video;
import application.util.ApplicationUtil;
import application.view.meuscomponentes.OverlayMediaPlay;
import arq.controller.AbstractController;
import arq.dominio.hibernate.dao.GenericDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class PlayerVideoController extends AbstractController<Video> {
	
    @FXML
    private AnchorPane pane;
    
    @FXML
    private AnchorPane paneVideo;
    
    @FXML
    private Button btnVoltar;
    
    private InformacoesVideoController informacoesVideoController;

    private String urlVideo;
    
    private Video video;
    
    OverlayMediaPlay mediaPlay;
    
    public PlayerVideoController() {
    	video = ListagemVideosController.getVideoSelecionado().getFilme().getVideo();
    	if(video != null && video.getId() > 0 ) {
    		this.urlVideo = "file:///"+video.getVideoPath().replaceAll("\\\\", "/");
    	} else {
        	this.urlVideo = ApplicationUtil.VIDEO_DEFAULT;
    	}
	}

	@Override
	public GenericDAO<Video> getDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initLayout() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void initComponents() {
		mediaPlay = new OverlayMediaPlay(urlVideo);
		paneVideo.getChildren().clear();
		paneVideo.getChildren().add(mediaPlay.getRoot());
		mediaPlay.play();
	}

	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/PlayerVideo.fxml");
	}

	@Override
	public void initListeners() {
		btnVoltar.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				informacoesVideoController = new InformacoesVideoController();
				mediaPlay.stop();
				informacoesVideoController.abrirTela();
			}
		});
	}
	
	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

}
