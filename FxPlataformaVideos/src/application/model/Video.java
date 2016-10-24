package application.model;

import java.beans.Transient;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import arq.dominio.model.AbstractEntity;
import javafx.scene.image.Image;

@Table(schema="aplicacao")
@Entity
public class Video extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue (strategy = GenerationType.AUTO, generator="default_sequence")
	@SequenceGenerator(name="default_sequence", sequenceName="aplicacao.default_sequence", allocationSize = 0)
	private long id;
	
	private String titulo;
	
	private String sinopse;
	
	private int ano;
	
	@Column(name="imagem_path")
	private String imagemPath;
	
	@Column(name="nome_ator_principal")
	private String nomeAtorPrincipal;
	
	@Column(name="nome_diretor")
	private String diretor;
	
	@Column(name="classificacao_etaria")
	private int classificacaoEtaria; 
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="genero_video", joinColumns= {@JoinColumn(name="id_video")}, inverseJoinColumns={@JoinColumn(name="id_genero")})
	private List<Genero> generos;
	
	
	@Override
	public long getId() {
		return this.id;
	}	

	public void setId(long id) {
		this.id = id;
	}

	public int getClassificacaoEtaria() {
		return classificacaoEtaria;
	}

	public void setClassificacaoEtaria(int classificacaoEtaria) {
		this.classificacaoEtaria = classificacaoEtaria;
	}

	public String getNomeAtorPrincipal() {
		return nomeAtorPrincipal;
	}

	public void setNomeAtorPrincipal(String nomeAtorPrincipal) {
		this.nomeAtorPrincipal = nomeAtorPrincipal;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getImagemPath() {
		return imagemPath;
	}

	public void setImagemPath(String imagemPath) {
		this.imagemPath = imagemPath;
	}
	
	@Transient
	public Image getFolder() {
		Image folder  = new Image(imagemPath);
		return folder;
	}

}
