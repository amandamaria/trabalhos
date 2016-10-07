package application.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Perfil perfil;
	
	@Column(name="data_nascimento")
	private Date dataNascimento;

	@Override
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isAdministrador() {
		return this.perfil.getId() == Perfil.ID_PERFIL_ADMINISTRADOR;
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

}
