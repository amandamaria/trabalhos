package application.controller;

import java.net.URL;

import application.Main;
import application.model.Video;
import arq.controller.AbstractController;
import arq.dominio.hibernate.dao.GenericDAO;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class ListagemVideosController extends AbstractController<Video> {
	
	public ListagemVideosController() {
	}


	@FXML
    private AnchorPane pane;

	@Override
	public GenericDAO<Video> getDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initLayout() {

	}

	@Override
	public void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/ListagemVideos.fxml");
	}

}
