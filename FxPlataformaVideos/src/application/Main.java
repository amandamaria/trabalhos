package application;


import org.hibernate.Session;
import org.hibernate.Transaction;

import application.model.Perfil;
import arq.dominio.hibernate.Database;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Teste commit
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Database database = Database.getInstance();
		Session session = database.getSession();
		Transaction beginTransaction = session.beginTransaction();
		Perfil perfil = new Perfil();
		perfil.setNome("Teste");
		session.save(perfil);
		beginTransaction.commit();
		session.close();
		launch(args);
	}
}
