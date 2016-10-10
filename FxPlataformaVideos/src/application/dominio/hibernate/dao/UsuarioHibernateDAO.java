package application.dominio.hibernate.dao;

import application.model.Usuario;
import arq.dominio.hibernate.dao.HibernateDAO;

public interface UsuarioHibernateDAO extends HibernateDAO<Usuario> {
	
	public Usuario buscarPorEmailESenha(String email, String senha);
	
	boolean verificarExistenciaEmail(String email);
}
