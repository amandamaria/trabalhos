package application.view.meuscomponentes;

import application.util.GrupoImagensUtil;
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
	
	private int idGrupo;
	
	private String nomeImage;
	
	public ImagemDoGrupo(String nomeImage, int idGrupo) {
		initMouseHoverGrupoListener();
		this.nomeImage = nomeImage;
		this.idGrupo = idGrupo;
		this.imageView = new ImageView(new Image(GrupoImagensUtil.PATH_IMAGENS_GRUPO_TELA_4+nomeImage));	
		this.gridEstrelas = new HBox();
		initLayout();
		this.getChildren().addAll(imageView, gridEstrelas);		
	}

	private void initLayout() {
		this.setHeight(200);
		this.setWidth(200);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setBackground(new Background(new BackgroundFill(Paint.valueOf("#f5f5f5"), new CornerRadii(35), Insets.EMPTY)));
		
		this.imageView.setFitWidth(100);
		this.imageView.setPreserveRatio(true);
		
		gridEstrelas.setSpacing(10);
		gridEstrelas.setAlignment(Pos.CENTER);		
		gridEstrelas.getChildren().addAll(getEstrelasObtidas());		
		
	}

	private ImageView[] getEstrelasObtidas() {
		ImageView estrela1 = new ImageView(new Image(estrelaVazia)); 
		estrela1.setFitHeight(25);
		estrela1.setPreserveRatio(true);
		
		ImageView estrela2 = new ImageView(new Image(estrelaVazia)); 
		estrela2.setFitHeight(25);
		estrela2.setPreserveRatio(true);
		
		ImageView estrela3 = new ImageView(new Image(estrelaVazia)); 
		estrela3.setFitHeight(25);
		estrela3.setPreserveRatio(true);
		
		ImageView[] estrelasObtidas = {estrela1, estrela2, estrela3};
		return estrelasObtidas;
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

	public int getIdGrupo() {
		return idGrupo;
	}

	public Image getImagemJogo() {
		return new Image(GrupoImagensUtil.PATH_IMAGENS_GRUPO_JOGO+nomeImage);
	}
}
