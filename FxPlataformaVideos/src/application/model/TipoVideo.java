package application.model;

import java.util.ArrayList;
import java.util.List;

public enum TipoVideo {
	FILME(1, "Filme"), SERIE(2,"Série"), DESENHO(3,"Desenho");
	
	private int id;
	private String nome;
	
	private TipoVideo(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public static List<TipoVideo> getTipos() {
		List<TipoVideo> tipos = new ArrayList<>();
		tipos.add(TipoVideo.FILME);
		tipos.add(TipoVideo.SERIE);
		tipos.add(TipoVideo.DESENHO);
		return tipos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
