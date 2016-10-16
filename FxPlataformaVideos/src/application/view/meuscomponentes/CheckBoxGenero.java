package application.view.meuscomponentes;

import application.model.Genero;

public class CheckBoxGenero extends CheckBox {
	
	private Genero genero;
	
	public CheckBoxGenero(Genero genero) {	
		super(genero.getNome());
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
