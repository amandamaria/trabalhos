package application.model;

public class UsuarioLogado {
	
	private static Usuario usuario;
	private static UsuarioLogado usuarioLogado = new UsuarioLogado();
	
	private UsuarioLogado() {
		usuario = null;
	}
	
	public static UsuarioLogado getInstance() {
		return usuarioLogado;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Usuario setUsuario(Usuario usuario) {
		return UsuarioLogado.usuario = usuario;
	}
}