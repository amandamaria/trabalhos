package application.model.util;

import java.util.Calendar;

import application.model.Usuario;

public class UsuarioUtil {
	public static int getIdadeUsuario(Usuario usuario) {
		
		Calendar hoje = Calendar.getInstance();
		Calendar dataNascimento = Calendar.getInstance();
	    dataNascimento.setTime(usuario.getDataNascimento());
	    
	    int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR); 	    
	    dataNascimento.set(Calendar.YEAR, hoje.get(Calendar.YEAR));
	    
	    if (hoje.before(dataNascimento)) {
	      idade--;  
	    }

	    return idade;
	}
}
