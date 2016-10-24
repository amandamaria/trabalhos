package application.view.meuscomponentes;

import application.model.Serie;
import javafx.scene.image.Image;

public class ImagemSeriado extends Image {
	
	private Serie seriado;

	public ImagemSeriado(Serie seriado) {
		super(seriado.getImagemPath());
		this.setSeriado(seriado);
	}

	public Serie getSeriado() {
		return seriado;
	}

	public void setSeriado(Serie seriado) {
		this.seriado = seriado;
	}
	
}
