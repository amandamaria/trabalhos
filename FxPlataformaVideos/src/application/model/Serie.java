package application.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import arq.dominio.model.AbstractEntity;

@Table(schema="aplicacao")
@Entity(name="serie_novela")
public class Serie extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue (strategy = GenerationType.AUTO, generator="default_sequence")
	@SequenceGenerator(name="default_sequence", sequenceName="aplicacao.default_sequence", allocationSize = 0)
	private long id;
	
	private String titulo;
	
	private String descricao;
	
	@Column(name="classificacao_etaria")
	private int classificacaoEtaria;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="video_serie_novela", joinColumns={@JoinColumn(name="id_serie_novela", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="id_video", referencedColumnName="id")})
	private List<Video> videos;
	
	@Override
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
}
