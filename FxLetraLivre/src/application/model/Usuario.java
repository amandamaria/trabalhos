package application.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import arq.dominio.model.AbstractEntity;

@Table(schema="aplicacao")
@Entity
public class Usuario extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="codigo_avatar")
	private int codigoAvatar;
	
	@OneToMany(mappedBy = "usuario", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<PalavraConcluida> palavrasConcluidas;
	
	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigoAvatar() {
		return codigoAvatar;
	}

	public void setCodigoAvatar(int codigoAvatar) {
		this.codigoAvatar = codigoAvatar;
	}

	public List<PalavraConcluida> getPalavrasConcluidas() {
		return palavrasConcluidas;
	}

	public void setPalavrasConcluidas(List<PalavraConcluida> palavrasConcluidas) {
		this.palavrasConcluidas = palavrasConcluidas;
	}

}
