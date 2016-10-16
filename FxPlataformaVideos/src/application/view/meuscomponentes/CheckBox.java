package application.view.meuscomponentes;

import application.Main;
import application.util.ApplicationUtil;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public abstract class CheckBox {
	
	private ImageView imageView;
	private boolean checked;
	private Label label;
	private HBox hBox;
	
	public CheckBox() {
	}
			
	public CheckBox(String labelText) {
		this.imageView = new ImageView(new Image(Main.class.getResource("/resources/layout/imagens/checkbox.png").toString()));
		this.setLabel(new Label(labelText));		
		this.hBox = new HBox(this.imageView, getLabel());
		this.checked = false;
		addListener();
		addLayout();
	}
	
	private void addLayout() {
		this.getLabel().setWrapText(true);
		this.getLabel().setMaxWidth(100);
		this.getLabel().setPrefWidth(100);
		this.getLabel().setMaxHeight(100);	
		this.getLabel().setFont(ApplicationUtil.getFontCaviarDreams(16));

		this.imageView.setFitWidth(21);
		this.imageView.setFitHeight(21);
		
		this.hBox.setSpacing(7);
		this.hBox.setAlignment(Pos.CENTER_LEFT);
		
		this.label.getStyleClass().add("check-box-text");
		this.imageView.getStyleClass().add("button-mouse");
	}

	private void addListener() {
				
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if(isChecked()) {
					imageView.setImage(new Image(Main.class.getResource("/resources/layout/imagens/checkbox.png").toString()));
					setChecked(false);
				} else {
					imageView.setImage(new Image(Main.class.getResource("/resources/layout/imagens/ok.png").toString()));
					setChecked(true);
				}
				imageView.setFitWidth(21);
				imageView.setFitHeight(21);
			};
		});			
		
		imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if(isChecked()) {
					imageView.setImage(new Image(Main.class.getResource("/resources/layout/imagens/checkbox.png").toString()));
					setChecked(false);
				} else {
					imageView.setImage(new Image(Main.class.getResource("/resources/layout/imagens/ok.png").toString()));
					setChecked(true);
				}
				imageView.setFitWidth(21);
				imageView.setFitHeight(21);
			};
		});	
	}

	
	public ImageView getImageView() {
		return imageView;
	}
	
	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}
	
	public boolean isChecked() {
		return checked;
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public HBox getVisibleElement() {
		return hBox;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
}
