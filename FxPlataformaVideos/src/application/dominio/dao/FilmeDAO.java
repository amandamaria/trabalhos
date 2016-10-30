package application.dominio.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import application.dominio.hibernate.dao.FilmeHibernateDAO;
import application.model.Filme;
import arq.dominio.hibernate.dao.GenericDAO;

public class FilmeDAO extends GenericDAO<Filme> implements FilmeHibernateDAO {

	@Override
	public List<Filme> getAll() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Filme> buscarFilmesPorFaixaEtaria(int idade) {
		Criteria criteria = getSession().createCriteria(Filme.class,"filme");
		criteria.createAlias("filme.video", "video");
		List<Filme> filmesEncontrados = criteria.add(Restrictions.le("video.classificacaoEtaria", idade)).list();
		return filmesEncontrados;
	}

	@Override
	public List<Filme> buscarFilmesPorTituloEGenero(String texto) {
		Criteria criteria = getSession().createCriteria(Filme.class,"filme");
		criteria.createAlias("filme.video", "video");
		criteria.createAlias("video.generos", "genero");
		List<Filme> filmesEncontrados = criteria.add(Restrictions.like("video.titulo", "%"+texto+"%")).add(Restrictions.like("genero.nome", "%"+texto+"%")).list();
		return filmesEncontrados;
	}
	
}
