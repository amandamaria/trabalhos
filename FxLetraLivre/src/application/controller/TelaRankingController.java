package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import application.dominio.dao.PalavraConcluidaDAO;
import application.model.Avatar;
import application.model.PalavraConcluida;
import application.util.ApplicationUtil;
import arq.controller.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

public class TelaRankingController extends AbstractController {

    @FXML
    private Label lbMelhorTempo;
    
    @FXML
    private AnchorPane pane;

    @FXML
    private GridPane gridRanking;

    @FXML
    private Label lbTitulo;

    @FXML
    private Label lbNome;
    
    private TelaInicialController telaInicialController;
    
    private PalavraConcluidaDAO palavraConcluidaDAO;
    
    private List<PalavraConcluida> melhoresPontuacoes;

    @FXML
    void voltar(ActionEvent event) {
    	telaInicialController = new TelaInicialController();
    	telaInicialController.abrirTela();
    }

	@Override
	public void initComponents() {
		palavraConcluidaDAO = new PalavraConcluidaDAO();
		popularListaMelhoresPontuacoes();
	}

	private void popularListaMelhoresPontuacoes() {
		melhoresPontuacoes = palavraConcluidaDAO.buscar10MelhoresPontuacoes(5);
	}

	@Override
	public void initLayout() {
		pane.getStyleClass().add("telaRanking");
		lbTitulo.setFont(ApplicationUtil.getFontCaviarDreams(30));
		lbMelhorTempo.setFont(ApplicationUtil.getFontCaviarDreams(22));
		lbNome.setFont(ApplicationUtil.getFontCaviarDreams(22));
		gerarRankingPontuacoes();
	}

	private void gerarRankingPontuacoes() {
		int COLUNA_AVATAR = 0;
		int COLUNA_NOME = 1;
		int COLUNA_TEMPO = 2;
		int linha = 1;
		if(melhoresPontuacoes != null) {
			for (PalavraConcluida palavraConcluida : melhoresPontuacoes) {
				int codigoAvatar = palavraConcluida.getUsuario().getCodigoAvatar();
				ImageView avatar = gerarImagemAvatar(codigoAvatar);
				String nomeUsuario = palavraConcluida.getUsuario().getNome();
				Label labelNome = gerarLabel(nomeUsuario);
				String tempo = ApplicationUtil.getStringTempoFormatado(palavraConcluida.getTempo());
				Label labelTempo = gerarLabel(tempo);
				gridRanking.add(avatar, COLUNA_AVATAR, linha);
				gridRanking.add(labelNome, COLUNA_NOME, linha);
				gridRanking.add(labelTempo, COLUNA_TEMPO, linha);
				linha++;
			}
		}
	}

	private Label gerarLabel(String nomeUsuario) {
		Label label = new Label(nomeUsuario);
		label.setWrapText(true);
		label.setFont(ApplicationUtil.getFontCaviarDreams(20));
		label.setTextFill(Paint.valueOf("#f5f5f5"));
		return label;
	}

	private ImageView gerarImagemAvatar(int codigoAvatar) {
		ImageView imageView = new ImageView(new Image(Avatar.getImagemPathAvatarPorId(codigoAvatar)));
		imageView.setFitHeight(40);
		imageView.setPreserveRatio(true);
		return imageView;
	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub		
	}

	@Override
	public URL getFxmlUrl() {
		return Main.class.getResource("/application/view/TelaRanking.fxml");
	}

}
