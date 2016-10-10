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
	
	public Usuario getUsuarioLogado() {
		return usuario;
	}
	
	public Usuario setUsuarioLogado(Usuario usuario) {
		return UsuarioLogado.usuario = usuario;
	}
}
