package application.dominio.dao;

import java.util.List;

import org.hibernate.Criteria;

import application.dominio.hibernate.dao.UsuarioHibernateDAO;
import application.model.Usuario;
import arq.dominio.hibernate.dao.GenericDAO;

public class UsuarioDAO extends GenericDAO<Usuario> implements UsuarioHibernateDAO {

	@Override
	public Usuario buscarPorEmailESenha(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getAll() {
		Criteria criteria = getSession().createCriteria(Usuario.class);
		return criteria.list();
	}

	@Override
	public void salvar(Usuario t) {
		
	}

}
