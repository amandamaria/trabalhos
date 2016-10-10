package application.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MensagemAlerta {
	
	public void showMensagemErro(String mensagem) {
		showMensagem(AlertType.ERROR, "ERRO", mensagem);
	}
	
	private void showMensagem(AlertType alertType, String tituloJanela, String mensagem) {
		Alert alert = new Alert(alertType);
		alert.setTitle(tituloJanela);
		alert.setHeaderText(tituloJanela);
		alert.setContentText(mensagem);
		alert.showAndWait();
	}
}
