package application.view.meuscomponentes;

import java.awt.GridLayout;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class ImagemDoGrupo extends VBox {
	
	private static final String estrelaVazia = "/resources/template/tela4/starcinza.png";
	
	private ImageView imageView;
	
	private HBox gridEstrelas;
	
	public ImagemDoGrupo(String urlImage) {
		initMouseHoverGrupoListener();
		imageView = new ImageView(new Image(urlImage));	
		this.gridEstrelas = new HBox();
		initLayout();
		this.getChildren().addAll(imageView, gridEstrelas);
		
	}

	private void initLayout() {
		this.setHeight(150);
		this.setWidth(150);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setBackground(new Background(new BackgroundFill(Paint.valueOf("#f5f5f5"), new CornerRadii(35), Insets.EMPTY)));
		
		this.imageView.setFitWidth(65);
		this.imageView.setPreserveRatio(true);
		
		gridEstrelas.setSpacing(10);
		gridEstrelas.setAlignment(Pos.CENTER);		
		gridEstrelas.getChildren().addAll(new ImageView(new Image(estrelaVazia)), 
				new ImageView(new Image(estrelaVazia)), 
				new ImageView(new Image(estrelaVazia)));		
		
	}

	private void initMouseHoverGrupoListener() {
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				setCursor(Cursor.HAND);
			}
		});
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				setCursor(Cursor.DEFAULT);
			}
		});
	}

}
