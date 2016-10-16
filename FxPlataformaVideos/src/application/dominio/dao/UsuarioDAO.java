package application.dominio.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import application.dominio.hibernate.dao.UsuarioHibernateDAO;
import application.model.Usuario;
import arq.dominio.hibernate.dao.GenericDAO;

public class UsuarioDAO extends GenericDAO<Usuario> implements UsuarioHibernateDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Usuario buscarPorEmailESenha(String email, String senha) {
		Criteria criteria = getSession().createCriteria(Usuario.class);
		List<Usuario> usuarios = criteria.add(Restrictions.like("email", email)).add(Restrictions.like("senha", senha)).list();
		if(usuarios != null && !usuarios.isEmpty()) {
			return usuarios.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getAll() {
		Criteria criteria = getSession().createCriteria(Usuario.class);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean verificarExistenciaEmail(String email) {
		boolean emailJaExiste = false;
		Criteria criteria = getSession().createCriteria(Usuario.class);		
		List<Usuario> usuarios = criteria.add(Restrictions.like("email", email)).list();
		if(usuarios != null && !usuarios.isEmpty()) {
			emailJaExiste = true;
		}
		return emailJaExiste;
	}
	
}
