package application.dominio.hibernate.dao;

import java.util.List;

import application.model.Palavra;
import arq.dominio.hibernate.dao.HibernateDAO;

public interface PalavraHibernateDAO extends HibernateDAO<Palavra> {
	
	public List<Palavra> buscarPalavrasPorGrupo(int grupo);
	
}
