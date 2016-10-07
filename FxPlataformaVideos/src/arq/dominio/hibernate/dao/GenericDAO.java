package arq.dominio.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import arq.dominio.hibernate.Database;
import arq.dominio.model.AbstractEntity;

public abstract class GenericDAO<T extends AbstractEntity> {
	
	private Session session;
	private Database database;
	
	public GenericDAO() {
		this.database = Database.getInstance();
		this.session = database.getSession();
	}
	
	protected Session getSession() {
		return session;
	}
	
	public abstract List<T> getAll();
	
	public abstract void salvar(T t);
	
}
