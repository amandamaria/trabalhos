package application.dominio.hibernate.dao;

import java.util.List;

import application.model.PalavraConcluida;
import arq.dominio.hibernate.dao.HibernateDAO;

public interface PalavraConcluidaHibernateDAO extends HibernateDAO<PalavraConcluida> {
	
	public PalavraConcluida buscarPorUsuarioEPalavra(long idUsuario, long idPalavra);
	
	public long buscarPoMelhorTempoPorUsuarioEGrupo(long idUsuario, int grupo);
	
	public List<PalavraConcluida> getPalavrasConcluidasPorUsuario(long idUsuario);
	
}
