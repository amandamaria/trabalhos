package application.controller;

import application.Main;
import application.util.ApplicationUtil;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class PopupMenuJogo extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Carregando fxml da tela de menu
		FXMLLoader loader = ApplicationUtil.getLoader(Main.class.getResource("/application/view/TelaMenuJogo.fxml"));
		AnchorPane pane = loader.load();
		TelaMenuJogoController controller = loader.getController();
		
		//Retomando cronômetro do jogo ao fechar menu de pausa.
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {			
			public void handle(WindowEvent event) {
				System.out.println("Retomando cronômetro do jogo.");
				TelaJogoController.threadRelegio.resume();				
			}
		});
		
		//Parando cronômetro do jogo ao abrir menu de pausa.
		primaryStage.setOnShown(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				System.out.println("Parando cronômetro do jogo.");
				TelaJogoController.threadRelegio.suspend();				
			}
		});
		
		//Criando e configurando layout do scene
		Scene scene = new Scene(pane);
		scene.getStylesheets().add("/application/application.css");		
		
		//Abirndo a tela em formato popup
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("MENU");
		controller.setStage(primaryStage);
		
		primaryStage.show();
	}
}
