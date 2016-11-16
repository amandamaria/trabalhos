package application.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Font;

public class ApplicationUtil {
	
	private static final Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();

	public static String getStringTempoFormatado(long tempoEmSegundos) {
		String tempoFormatado = "00:00:00";
		if(tempoEmSegundos > 0) {
			long segundo = tempoEmSegundos % 60; 
			long minutos = tempoEmSegundos / 60; 
			long minuto = minutos % 60; 
			long hora = minutos / 60; 
			tempoFormatado = String.format ("%02d:%02d:%02d", hora, minuto, segundo);	
		}		
		return tempoFormatado;
	}

	public static double getLarguraDaTela() {
		return tela.getWidth();
	}
	
	public static double getAlturaDaTela() {
		return tela.getHeight();
	}
	
	public static FXMLLoader getLoader(URL path) {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(path);
        return loader;
	}
	
	public static Font getFontCaviarDreams(int tamanho) {
		return Font.loadFont(Main.class.getResource("/resources/template/chawp.otf").toString(), tamanho);
	}
}
