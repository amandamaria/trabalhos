package application.view.meuscomponentes;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class GrupoImagens extends VBox {
	
	private Label lbPalavrasConcluidas;
	
	private Label lbMelhorTempo;
	
	private String[] imagensGrupo;
	
	public GrupoImagens() {
		initLabels();
		initMouseHoverGrupoListener();
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

	private void initLabels() {
		ObservableList<Node> children = this.getChildren();
		for (Node node : children) {
			if(node instanceof Label) {
				if(lbPalavrasConcluidas == null) {
					lbPalavrasConcluidas = (Label) node;
					lbPalavrasConcluidas.setText("XXX");
				} else if(lbMelhorTempo == null) {
					lbMelhorTempo = (Label) node;
				}
			}
		}
	}
}
