package application.dominio.hibernate.dao;

import java.util.List;

import application.model.Filme;
import arq.dominio.hibernate.dao.HibernateDAO;

public interface FilmeHibernateDAO extends HibernateDAO<Filme> {
	public List<Filme> buscarFilmesPorFaixaEtaria(int idade);
	
	public List<Filme> buscarFilmesPorTituloEGenero(String texto);
}
