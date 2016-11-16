package application.dominio.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import application.dominio.hibernate.dao.PalavraHibernateDAO;
import application.model.Palavra;
import arq.dominio.hibernate.dao.GenericDAO;

@SuppressWarnings("unchecked")
public class PalavraDAO extends GenericDAO<Palavra> implements PalavraHibernateDAO {
	
	@Override
	public List<Palavra> getAll() {
		Criteria criteria = getSession().createCriteria(Palavra.class);
		return criteria.list();
	}

	public List<Palavra> buscarPalavrasPorGrupo(int grupo) {
		Criteria criteria = getSession().createCriteria(Palavra.class);
		List<Palavra> list = criteria.add(Restrictions.eq("grupo", grupo)).list();
		if(list != null) {
			return list;
		}
		return null;
	}

}
