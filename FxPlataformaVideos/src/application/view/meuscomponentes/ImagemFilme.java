package application.view.meuscomponentes;

import application.model.Filme;
import javafx.scene.image.Image;

public class ImagemFilme extends Image {
	
	private Filme filme;

	public ImagemFilme(Filme filme) {
		super(filme.getVideo().getImagemPath());
		this.filme = filme;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
}
