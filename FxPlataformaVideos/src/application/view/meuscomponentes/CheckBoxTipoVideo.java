package application.view.meuscomponentes;

import application.model.TipoVideo;

public class CheckBoxTipoVideo extends CheckBox {
	private TipoVideo tipoVideo;
	
	public CheckBoxTipoVideo(TipoVideo tipo) {
		super(tipo.getNome());
	}

	public TipoVideo getTipoVideo() {
		return tipoVideo;
	}

	public void setTipoVideo(TipoVideo tipoVideo) {
		this.tipoVideo = tipoVideo;
	}
}
