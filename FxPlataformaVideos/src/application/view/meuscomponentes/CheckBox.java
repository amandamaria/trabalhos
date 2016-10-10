package application.view.meuscomponentes;

import application.Main;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CheckBox {
	
	private ImageView imageView;
	private boolean checked;
	private String nome;
	
	public CheckBox(ImageView imageView, String nome) {
		this.imageView = imageView;
		this.checked = false;
		this.nome = nome;
		addImageListener();
	}
	
	private void addImageListener() {
		imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageView.setStyle("-fx-cursor: hand;");
			}
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
			};
		});	
	}

	public CheckBox() {
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
