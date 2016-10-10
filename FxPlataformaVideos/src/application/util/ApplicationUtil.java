package application.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Font;

public class ApplicationUtil {
	private static final Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static double getLarguraDaTela() {
		return tela.getWidth();
	}
	
	public static double getAlturaDaTela() {
		return tela.getHeight();
	}
	
	public static FXMLLoader getFXMLLoader(URL path) {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(path);
        return loader;
	}
	
	public static Font getFontCaviarDreams(int tamanho) {
		return Font.loadFont(Main.class.getResource("/resources/layout/font/CaviarDreams.ttf").toString(), tamanho);
	}
	
	public static Font getFontCaviarDreamsBold(int tamanho) {
		return Font.loadFont(Main.class.getResource("/resources/layout/font/CaviarDreams_Bold.ttf").toString(), tamanho);
	}
	
	public static Date localDateToDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
