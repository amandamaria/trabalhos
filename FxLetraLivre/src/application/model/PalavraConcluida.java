package application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import arq.dominio.model.AbstractEntity;

@Table(schema="aplicacao")
@Entity(name="pontuacao")
public class PalavraConcluida extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue (strategy = GenerationType.AUTO, generator="default_sequence")
	@SequenceGenerator(name="default_sequence", sequenceName="aplicacao.default_sequence", allocationSize = 0)
	private long id;

	@Column(name="tempo_milisegundos")
	private long tempo;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_palavra")
	private Palavra palavra;
	
	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Palavra getPalavra() {
		return palavra;
	}

	public void setPalavra(Palavra palavra) {
		this.palavra = palavra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getTempo() {
		return tempo;
	}

	public void setTempo(long tempo) {
		this.tempo = tempo;
	}

}
