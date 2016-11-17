package arq.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class MensagemAlerta {
	
	public void showMensagemErro(String mensagem) {
		showMensagem(AlertType.ERROR, "ERRO", mensagem);
	}
	
	public void showMensagemAjuda(String mensagem) {
		showMensagem(AlertType.INFORMATION, "AJUDA", mensagem);
	}
	
	public boolean showMensagemOpcoes(String mensagem) {
		Alert alert = showMensagem(AlertType.CONFIRMATION, "DESEJA CONTINUAR?", mensagem);
		return alert.getResult().equals(ButtonType.OK);
	}
	
	private Alert showMensagem(AlertType alertType, String tituloJanela, String mensagem) {
		Alert alert = new Alert(alertType);
		alert.setTitle(tituloJanela);
		alert.setHeaderText(tituloJanela);
		alert.setContentText(mensagem);
		alert.showAndWait();		
		return alert;
	}
}
