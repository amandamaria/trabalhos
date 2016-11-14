package application.view.meuscomponentes;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class SelectOneImage extends ImageView {
	
	private boolean selecionado;
	
	private SelectOneImage imageViewAuxiliar;
	
	private String urlImage;
	
	private String urlImageClick;
	
	private Pane imageGroup;
	
	private List<SelectOneImage> imagensIrmas;
	
	public SelectOneImage(String urlImage, String urlImageClick, Pane imageGroup) {		
		this.urlImage = urlImage;
		this.imageGroup = imageGroup;
		this.urlImageClick = urlImageClick;
		selecionado = false;
		this.setImage(new Image(urlImage));		
		this.imageViewAuxiliar = this;
		configurarComponente();		
		configurarClickNoComponente();	
		configurarMouseHoverNoComponente();
	}

	private void configurarMouseHoverNoComponente() {
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				DropShadow ds = new DropShadow();
		        ds.setOffsetX(2.0f);
		        ds.setOffsetY(2.0f);
		        ds.setColor(Color.LIGHTGRAY);
				imageViewAuxiliar.setEffect(ds);
				imageViewAuxiliar.setCursor(Cursor.HAND);
			}
		});	
		
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				imageViewAuxiliar.setEffect(null);
				imageViewAuxiliar.setCursor(Cursor.DEFAULT);
			}
		});	
	}

	private void configurarClickNoComponente() {
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				setSelecionado(!selecionado);
				setImagensIrmas();
				for (SelectOneImage imageViewAvatar : imagensIrmas) {
					if(!imageViewAvatar.equals(this)) {
						imageViewAvatar.setSelecionado(false);
					}
				}
			}
		});
	}

	protected List<SelectOneImage> setImagensIrmas() {
		imagensIrmas = new ArrayList<SelectOneImage>();
		ObservableList<Node> children = imageGroup.getChildren();
		for (Node node : children) {
			if(node instanceof SelectOneImage) {
				if(!node.equals(this))
					imagensIrmas.add((SelectOneImage)node);
			}
		}
		return imagensIrmas;
	}

	protected void mudarSelecao() {
		if(selecionado) {
			imageViewAuxiliar.setImage(new Image(urlImageClick));
		} else {
			imageViewAuxiliar.setImage(new Image(urlImage));
		}
	}

	private void configurarComponente() {
		this.setFitWidth(100);
		this.setFitHeight(100);
	}

	public boolean isSelecionado() {
		return selecionado;
	}
	
	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
		mudarSelecao();
	}
	
}
