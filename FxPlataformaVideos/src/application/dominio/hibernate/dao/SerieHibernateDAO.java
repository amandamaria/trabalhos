package application.dominio.hibernate.dao;

import java.util.List;

import application.model.Serie;
import arq.dominio.hibernate.dao.HibernateDAO;

public interface SerieHibernateDAO extends HibernateDAO<Serie>{

	public List<Serie> buscarSeriePorClassificacaoEtaria(int idade);
}
