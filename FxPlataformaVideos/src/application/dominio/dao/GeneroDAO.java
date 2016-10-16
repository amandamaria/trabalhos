package application.dominio.dao;

import java.util.List;

import org.hibernate.Criteria;

import application.dominio.hibernate.dao.GeneroHibernateDAO;
import application.model.Genero;
import arq.dominio.hibernate.dao.GenericDAO;

public class GeneroDAO extends GenericDAO<Genero> implements GeneroHibernateDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Genero> getAll() {
		Criteria criteria = getSession().createCriteria(Genero.class);
		return criteria.list();
	}

}
