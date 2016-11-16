package arq.dominio.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

//TODO Import hibernate libraries
//import org.hibernate.Session;
//import org.hibernate.Transaction;

import arq.dominio.hibernate.Database;
import arq.dominio.model.AbstractEntity;

public abstract class GenericDAO<T extends AbstractEntity> {
	
	private Database database;
	private Session session;
	
	public GenericDAO() {
		this.database = Database.getInstance();
		this.session = database.getSession();
	}
	
	protected Session getSession() {
		if(!session.isOpen()) {
			session = database.getSession();
		}
		return session;
	}
	
	public abstract List<T> getAll();
	
	public void salvar(T t) {		
		Transaction transaction = getSession().beginTransaction();
		if(t.getId() > 0) {
			getSession().merge(t);
		} else {
			getSession().persist(t);	
		}		
		transaction.commit();
		getSession().close();	
	}
	
}
