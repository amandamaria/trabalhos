package application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import arq.dominio.model.AbstractEntity;

@Table(schema="aplicacao")
@Entity
public class Palavra extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue (strategy = GenerationType.AUTO, generator="default_sequence")
	@SequenceGenerator(name="default_sequence", sequenceName="aplicacao.default_sequence", allocationSize = 0)
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
	
	public Palavra(String mmnemonicPath) {
		
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

}
