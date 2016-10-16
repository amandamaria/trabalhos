package application.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import arq.dominio.model.AbstractEntity;

@Table(schema="aplicacao")
@Entity
public class Usuario extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue (strategy = GenerationType.AUTO, generator="default_sequence")
	@SequenceGenerator(name="default_sequence", sequenceName="aplicacao.default_sequence", allocationSize = 0)
	private long id;
	
	private String nome;
	
	private String sobrenome;
	
	private String email;
	
	private String senha;
	
	private boolean administrador;	
	
	@ManyToMany
	@JoinTable(name = "preferencia_genero_usuario", joinColumns = {@JoinColumn(name = "id_usuario", referencedColumnName="id")},
			inverseJoinColumns = { @JoinColumn(name = "id_genero", referencedColumnName = "id") })
	private List<Genero> generosFavoritos;
	
	@Column(name="data_nascimento")
	private Date dataNascimento;
	
	public Usuario() {
		generosFavoritos = new ArrayList<>();
	}
	
	@Override
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isAdministrador() {
		return administrador;
	}
	
	public boolean setAdministrador(boolean administrador) {
		return this.administrador = administrador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Genero> getGenerosFavoritos() {
		return generosFavoritos;
	}

	public void setGenerosFavoritos(List<Genero> generosFavoritos) {
		this.generosFavoritos = generosFavoritos;
	}

}
