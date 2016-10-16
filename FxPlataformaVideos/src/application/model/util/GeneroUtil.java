package application.model.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.dominio.dao.GeneroDAO;
import application.model.Genero;

public class GeneroUtil {
	public static int QUANTIDADE_DE_GENEROS;
	private static Map<Long, Genero> allGeneros = new HashMap<Long, Genero>();
	private static List<Genero> generos;
	private static GeneroDAO generoDAO;
	
	public GeneroUtil() {
			
	}
	
	static {
		generoDAO = new GeneroDAO();	
		generos = generoDAO.getAll();
		QUANTIDADE_DE_GENEROS = generos.size();
		for (Genero genero : generos) {
			allGeneros.put(genero.getId(), genero);
		}
	}
	
	
	public static Genero getGeneroById(long id) {
		return allGeneros.get(id);
	}

	public static List<Genero> getGeneros() {
		return generos;
	}
}
