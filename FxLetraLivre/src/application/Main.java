package application;
	
import application.controller.TelaInicialController;
import application.model.UsuarioLogado;
import arq.controller.NavegadorTela;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static Stage primaryStage;
	
	private NavegadorTela navegadorTela;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Main.primaryStage = primaryStage;			
			navegadorTela = NavegadorTela.getInstace();
			Scene scene = new Scene(navegadorTela.getRootPane());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());	
			navegadorTela.getRootPane().getStyleClass().add("rootPainel");
			irParaTelaInicial();
			
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.setTitle("Letra Livre 2.0");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void irParaTelaInicial() {
		TelaInicialController telaInicialController = new TelaInicialController();
		telaInicialController.abrirTela();
	}
	
	public static void main(String[] args) {
		launch(args);
		System.exit(0);
	}
	
	public static UsuarioLogado getUsuarioLogado() {
		return UsuarioLogado.getInstance();
	}
}
