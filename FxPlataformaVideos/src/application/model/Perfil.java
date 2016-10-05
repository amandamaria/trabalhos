package application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import arq.dominio.modelo.AbstractEntity;

@Table(schema="aplicacao")
@Entity
public class Perfil extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue (strategy = GenerationType.AUTO, generator="default_sequence")
	@SequenceGenerator(name="default_sequence", sequenceName="aplicacao.default_sequence", allocationSize = 0)
	private long id;
	
	@Column(name="nome")
	private String nome;

	@Override
	public long getId() {
		return this.id;
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

}
