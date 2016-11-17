package application.model;

public enum Avatar {
	AVATAR_1(0, "/resources/imagens/avatar/avatar1.png"),
	AVATAR_2(0, "/resources/imagens/avatar/avatar2.png"),
	AVATAR_3(0, "/resources/imagens/avatar/avatar3.png"),
	AVATAR_4(0, "/resources/imagens/avatar/avatar4.png");
	
	private int id;
	private String imagemPath;
	
	private Avatar(int id, String imagemPath) {
		this.id = id;
		this.imagemPath = imagemPath;
	}
	
	public static String getImagemPathAvatarPorId(int id) {
		String imagemPathEncontrada = "";
		switch (id) {
		case 0:
			imagemPathEncontrada = AVATAR_1.getImagemPath();
			break;
		case 1:
			imagemPathEncontrada = AVATAR_2.getImagemPath();
			break;
		case 2:
			imagemPathEncontrada = AVATAR_3.getImagemPath();
			break;
		case 3:
			imagemPathEncontrada = AVATAR_4.getImagemPath();
			break;
		default:
			imagemPathEncontrada = "";
			break;
		}
		return imagemPathEncontrada;
	}
	
	private String getImagemPath() {
		return this.imagemPath;
	}
}
