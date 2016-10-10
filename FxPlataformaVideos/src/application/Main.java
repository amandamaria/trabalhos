package application;

import application.controller.LoginController;
import application.model.Usuario;
import arq.controller.NavegadorTela;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Stage primaryStage;
	private NavegadorTela navegadorTela;
	private static Usuario usuarioLogado;
	
	@Override
	public void start(Stage primaryStage) {
		try {			
			Main.primaryStage = primaryStage;			
			navegadorTela = NavegadorTela.getInstace();
			Scene scene = new Scene(navegadorTela.getRootPane());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());	
			navegadorTela.getRootPane().getStyleClass().add("background-login");
			irParaTelaLogin();
			
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irParaTelaLogin() {
		LoginController formLoginController = new LoginController();
		formLoginController.abrirTela();
	}
	
	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public static void main(String[] args) {
		launch(args);
		System.exit(0);
	}
}
