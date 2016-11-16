package application.view.meuscomponentes;

import application.model.Palavra;
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
	
	private static final String ESTRELA_CINZA = "/resources/template/tela4/starcinza.png";
	private static final String ESTRELA_AMARELA = "/resources/template/tela4/staramarela.png";
	
	private ImageView imageView;
	
	private HBox gridEstrelas;
			
	private Palavra palavra;
	
	public ImagemDoGrupo(Palavra palavra) {
		initMouseHoverGrupoListener();
		this.palavra = palavra;
		this.imageView = new ImageView(new Image(GrupoImagensUtil.PATH_IMAGENS_GRUPO_TELA_4+palavra.getMnemonicImagePath()));	
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
		ImageView[] estrelasObtidas = new ImageView[3];
		if(palavra.getMelhorTempo() == 0) {
			estrelasObtidas[0] = criarImagemEstrela(ESTRELA_CINZA);
			estrelasObtidas[1] = criarImagemEstrela(ESTRELA_CINZA);
			estrelasObtidas[2] = criarImagemEstrela(ESTRELA_CINZA);
			
		} else if(palavra.getMelhorTempo() > 0 && palavra.getMelhorTempo() <= 30) {			
			estrelasObtidas[0] = criarImagemEstrela(ESTRELA_AMARELA);
			estrelasObtidas[1] = criarImagemEstrela(ESTRELA_AMARELA);
			estrelasObtidas[2] = criarImagemEstrela(ESTRELA_AMARELA);
			
		} else if(palavra.getMelhorTempo() > 30 && palavra.getMelhorTempo() <= 90) {
			estrelasObtidas[0] = criarImagemEstrela(ESTRELA_AMARELA);
			estrelasObtidas[1] = criarImagemEstrela(ESTRELA_AMARELA);
			estrelasObtidas[2] = criarImagemEstrela(ESTRELA_CINZA);
			
		} else {			
			estrelasObtidas[0] = criarImagemEstrela(ESTRELA_AMARELA);
			estrelasObtidas[1] = criarImagemEstrela(ESTRELA_CINZA);
			estrelasObtidas[2] = criarImagemEstrela(ESTRELA_CINZA);
			
		}		
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
	
	private ImageView criarImagemEstrela(String path) {
		ImageView estrela = new ImageView(new Image(path)); 
		estrela.setFitHeight(25);
		estrela.setPreserveRatio(true);		
		return estrela;
	}

	public Image getImagemJogo() {
		return new Image(GrupoImagensUtil.PATH_IMAGENS_GRUPO_JOGO+palavra.getMnemonicImagePath());
	}

	public Palavra getPalavra() {
		return palavra;
	}

	public void setPalavra(Palavra palavra) {
		this.palavra = palavra;
	}
}
