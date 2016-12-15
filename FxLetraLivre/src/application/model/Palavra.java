package application.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import arq.dominio.model.AbstractEntity;

@Table(schema="aplicacao")
@Entity
public class Palavra extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="grupo")
	private int grupo;
	
	@Column(name="texto")
	private String texto;

	@Transient
	private String mnemonicImagePath;
	
	@Transient
	private String mnemonicAudioPath;
	
	@Transient
	private int melhorTempo;
	
	public Palavra() {
	}
	
	
	
	public Palavra(long id, int grupo, String texto) {
		super();
		this.id = id;
		this.grupo = grupo;
		this.texto = texto;
	}



	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public String getMnemonicImagePath() {
		return mnemonicImagePath;
	}

	public void setMnemonicImagePath(String mnemonicImagePath) {
		this.mnemonicImagePath = mnemonicImagePath;
	}

	public int getMelhorTempo() {
		return melhorTempo;
	}

	public void setMelhorTempo(int melhorTempo) {
		this.melhorTempo = melhorTempo;
	}

	public String getMnemonicAudioPath() {
		return mnemonicAudioPath;
	}

	public void setMnemonicAudioPath(String mnemonicAudioPath) {
		this.mnemonicAudioPath = mnemonicAudioPath;
	}
	
	public static List<Palavra> getPalavrasPorGrupo(int grupo) {
		List<Palavra> todasAsPalavras = new ArrayList<Palavra>();
		int id = 0;
		int grupo1 = 1;
		int grupo2 = 2;
		int grupo3 = 3;
		int grupo4 = 4;
		if(grupo == grupo1) {
			todasAsPalavras.add(new Palavra(id++,grupo1,"abelha"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"anjo"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"bicicleta"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"bola"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"bomba"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"caixa"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"carro"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"chave"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"foguete"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"galinha"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"girafa"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"ovo"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"policial"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"rato"));
			todasAsPalavras.add(new Palavra(id++,grupo1,"saci"));
		} else if(grupo == grupo2) {
			todasAsPalavras.add(new Palavra(id++,grupo2,"abacaxi"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"anel"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"aranha"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"bolsa"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"borracha"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"cachimbo"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"casa"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"elefante"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"flauta"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"lanterna"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"lixeira"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"pente"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"quadro"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"sino"));
			todasAsPalavras.add(new Palavra(id++,grupo2,"tesoura"));
		} else if(grupo == grupo3) {
			todasAsPalavras.add(new Palavra(id++,grupo3,"astronauta"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"cachorro"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"esqueleto"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"esquilo"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"girassol"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"guitarra"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"helicptero"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"lâmpada"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"palhaço"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"professora"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"queijo"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"relógio"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"taxi"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"travesseiro"));
			todasAsPalavras.add(new Palavra(id++,grupo3,"xícara"));
		} else if(grupo == grupo4) {
			todasAsPalavras.add(new Palavra(id++,grupo4,"árvore"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"aquário"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"bombeiro"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"calça"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"cenoura"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"chapéu"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"coração"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"dinheiro"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"funil"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"garrafa"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"hipopótamo"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"índio"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"polvo"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"sanduíche"));
			todasAsPalavras.add(new Palavra(id++,grupo4,"violão"));
		}
		return todasAsPalavras;
	}

}
