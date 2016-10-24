package application.dominio.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import application.dominio.hibernate.dao.SerieHibernateDAO;
import application.model.Serie;
import arq.dominio.hibernate.dao.GenericDAO;

public class SerieDAO extends GenericDAO<Serie> implements SerieHibernateDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Serie> getAll() {
		Criteria criteria = getSession().createCriteria(Serie.class);
		List<Serie> series = criteria.add(Restrictions.eq("desenho", false)).list();
		return series;
	}
	
	@SuppressWarnings("unchecked")
	public List<Serie> buscarSeriePorClassificacaoEtaria(int idade) {
		Criteria criteria = getSession().createCriteria(Serie.class);
		List<Serie> series = criteria.add(Restrictions.eq("desenho", false)).
				add(Restrictions.le("classificacaoEtaria", idade)).list();
		return series;
	}

}
