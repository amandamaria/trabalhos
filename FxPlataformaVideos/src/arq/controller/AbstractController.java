package arq.controller;

import javafx.stage.Stage;

public abstract class AbstractController {
	
	private Stage stage;
	
	
	
	public Stage getStage() {
		return stage;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
