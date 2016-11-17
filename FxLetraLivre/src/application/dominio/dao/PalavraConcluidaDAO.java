package application.dominio.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import application.dominio.hibernate.dao.PalavraConcluidaHibernateDAO;
import application.model.PalavraConcluida;
import arq.dominio.hibernate.dao.GenericDAO;

@SuppressWarnings("unchecked")
public class PalavraConcluidaDAO extends GenericDAO<PalavraConcluida> implements PalavraConcluidaHibernateDAO {


	@Override
	public List<PalavraConcluida> getAll() {
		Criteria criteria = getSession().createCriteria(PalavraConcluidaHibernateDAO.class);
		return criteria.list();
	}

	public PalavraConcluida buscarPorUsuarioEPalavra(long idUsuario, long idPalavra) {
		Criteria criteria = getSession().createCriteria(PalavraConcluida.class)
				.createAlias("usuario", "u")
				.createAlias("palavra", "p")
				.add(Restrictions.eq("u.id", idUsuario))
				.add(Restrictions.eq("p.id", idPalavra));
		List<PalavraConcluida> list = criteria.list();
		if(list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	public long buscarPoMelhorTempoPorUsuarioEGrupo(long idUsuario, int grupo) {
		Criteria criteria = getSession().createCriteria(PalavraConcluida.class)
				.createAlias("usuario", "u")
				.createAlias("palavra", "p")
				.add(Restrictions.eq("u.id", idUsuario))
				.add(Restrictions.eq("p.grupo", grupo))
				.setProjection(Projections.min("tempo"));
			Object result = criteria.uniqueResult();
			if(result != null) {
				return (Long) result;
			}
		return 0;
	}

	public List<PalavraConcluida> getPalavrasConcluidasPorUsuario(long idUsuario) {
		List<PalavraConcluida> list = new ArrayList<PalavraConcluida>();
		Criteria criteria = getSession().createCriteria(PalavraConcluida.class)
				.add(Restrictions.eq("usuario.id", idUsuario));
		list = criteria.list();
		return list;
	}
	
	public List<PalavraConcluida> buscar10MelhoresPontuacoes(int maximoDeResultados) {
		List<PalavraConcluida> list = new ArrayList<PalavraConcluida>();
		Criteria criteria = getSession().createCriteria(PalavraConcluida.class)
				.addOrder(Order.asc("tempo"))
				.setMaxResults(maximoDeResultados);
		list = criteria.list();
		return list;
	}
	
}
