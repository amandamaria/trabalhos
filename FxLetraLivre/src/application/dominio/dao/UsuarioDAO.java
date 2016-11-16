package application.dominio.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import application.dominio.hibernate.dao.UsuarioHibernateDAO;
import application.model.Usuario;
import arq.dominio.hibernate.dao.GenericDAO;

@SuppressWarnings("unchecked")
public class UsuarioDAO extends GenericDAO<Usuario> implements UsuarioHibernateDAO {

	public Usuario buscarPorNome(String nome) {
		Criteria criteria = getSession().createCriteria(Usuario.class);
		List<Usuario> usuariosEncontrados = criteria.add(Restrictions.ilike("nome", nome)).list();
		if(usuariosEncontrados != null && !usuariosEncontrados.isEmpty()) {
			return usuariosEncontrados.get(0);
		}
		return null;
	}

	@Override
	public List<Usuario> getAll() {
		Criteria criteria = getSession().createCriteria(Usuario.class);
		return criteria.list();
	}
	
}
