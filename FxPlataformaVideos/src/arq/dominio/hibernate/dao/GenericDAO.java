package arq.dominio.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
	
	public void salvar(T t) {
		Transaction transaction = getSession().beginTransaction();
		getSession().saveOrUpdate(t);
		transaction.commit();
		getSession().close();	
	}
	
}
