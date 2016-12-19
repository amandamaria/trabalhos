package application.dominio.dao;

import java.nio.charset.Charset;
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
		for (Palavra palavra : list) {
			palavra.setTexto(encondingISO_UTF8(palavra.getTexto()));
		}
		return list;
	}

	private String encondingISO_UTF8(String texto) {
		String retorno = "";
		if(texto != null) {
			retorno = new String(texto.getBytes(Charset.forName("ISO-8859-1")),Charset.forName("UTF-8"));
		}
		return retorno;
	}

}
