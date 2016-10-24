package application.dominio.dao;

import java.util.List;

import org.hibernate.Criteria;

import application.dominio.hibernate.dao.VideoHibernateDAO;
import application.model.Video;
import arq.dominio.hibernate.dao.GenericDAO;

public class VideoDAO extends GenericDAO<Video> implements VideoHibernateDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> getAll() {
		Criteria criteria = getSession().createCriteria(Video.class);				
		return criteria.list();
	}

}
