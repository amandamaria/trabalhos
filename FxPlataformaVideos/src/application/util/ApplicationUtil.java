package application.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Font;

public class ApplicationUtil {
	private static final Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static final String VIDEO_DEFAULT = "http://dw.convertfiles.com/files/0476697001477779984/ramonadeskflix.mp4";
		
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
	
	public byte[] fileToByteArray(String path) throws IOException{
		File fi = new File(path);
		byte[] fileContent = Files.readAllBytes(fi.toPath());		 
		return fileContent; 	
	}
		
	public static Font getFontCaviarDreams(int tamanho) {
		return Font.loadFont(Main.class.getResource("/resources/layout/font/CaviarDreams.ttf").toString(), tamanho);
	}
		
	public static Date localDateToDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
