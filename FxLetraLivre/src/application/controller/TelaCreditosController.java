package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import application.util.ApplicationUtil;
import arq.controller.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class TelaCreditosController extends AbstractController {
	
    @FXML
    private Label lbTitulo;

    @FXML
    private AnchorPane pane;

    @FXML
    private VBox boxAutores;
    
    @FXML
    private Button button;
    
    private TelaInicialController telaInicialController;
    
    private List<String[]> informacaoDosAutores;
    
    @FXML
    public void voltar(ActionEvent event) {
    	telaInicialController = new TelaInicialController();
    	telaInicialController.abrirTela();
    }

	@Override
	public void initComponents() {
		informacaoDosAutores = new ArrayList<String[]>();
		popularInformacoesDosAutores();
	}

	private void popularInformacoesDosAutores() {
		String[] sonoplasta = {"Isis Ramona da Cunha", "Sonoplasta / Designer"};
		String[] desenvolvedora1 = {"Amanda Maria Oliveira", "Desenvolvedora / Animadora"};
		String[] desenvolvedora2 = {"Maria Clara Pereira", "Desenvolvedora / Animadora"};
		String[] colaborador = {"Samuel Dantas", "Colaborador"};
		String[] colaboradorVersao1_1 = {"João Batista Carvalho Nunes", "Letra Livre Versão 1"};
		String[] colaboradorVersao1_2 = {"José Veríssimo do Nascimento Filho", "Letra Livre Versão 1"};
		String[] colaboradorVersao1_3 = {"Maria Lucimara Rodrigues da Silva", "Letra Livre Versão 1"};
		String[] colaboradorVersao1_4 = {"Dennys Leite Maia", "Letra Livre Versão 1"};
		String[] colaboradorVersao1_5 = {"Joserlene Lima Pinheiro", "Letra Livre Versão 1"};
		
		informacaoDosAutores.add(desenvolvedora1);
		informacaoDosAutores.add(sonoplasta);
		informacaoDosAutores.add(desenvolvedora2);	
		informacaoDosAutores.add(colaborador);
		informacaoDosAutores.add(colaboradorVersao1_1);
		informacaoDosAutores.add(colaboradorVersao1_2);
		informacaoDosAutores.add(colaboradorVersao1_3);	
		informacaoDosAutores.add(colaboradorVersao1_4);
		informacaoDosAutores.add(colaboradorVersao1_5);	
	}

	@Override
	public void initLayout() {
		pane.getStyleClass().add("telaCreditos");
		lbTitulo.setFont(ApplicationUtil.getFontCaviarDreams(30));
		exibirInformacoesAutores();
	}

	private void exibirInformacoesAutores() {
		int NOME = 0;
		int FUNCAO = 1;
		for (String[] strings : informacaoDosAutores) {
			Label label = new Label(strings[NOME].concat(" - ").concat(strings[FUNCAO]));
			label.setFont(ApplicationUtil.getFontCaviarDreams(18));
			label.setTextFill(Paint.valueOf("#f5f5f5"));
			boxAutores.getChildren().add(label);
		}
	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/TelaCreditos.fxml");
	}

}
