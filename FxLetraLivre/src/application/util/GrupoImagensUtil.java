package application.util;

public class GrupoImagensUtil {
	
	private static final int QTD_GRUPOS = 4;
	
	private static final int QTD_IMAGENS_POR_GRUPO = 15;
	
	public static final String PATH_IMAGENS_GRUPO_TELA_4 = "/resources/template/tela4/";
	
	public static final String PATH_IMAGENS_GRUPO_JOGO = "/resources/imagens/fases/";
	
	public static final String[] IMAGENS_GRUPO_1 = {
			"grupo1/abelha.png",
			"grupo1/anjo.png",
			"grupo1/bicicleta.png",
			"grupo1/bola.png",
			"grupo1/bomba.png",
			"grupo1/caixa.png",
			"grupo1/carro.png",
			"grupo1/chave.png",
			"grupo1/foguete.png",
			"grupo1/galinha.png",
			"grupo1/girafa.png",
			"grupo1/ovo.png",
			"grupo1/policial.png",
			"grupo1/rato.png",
			"grupo1/saci.png",
	};
	public static final String[] IMAGENS_GRUPO_2 = {
			"grupo2/abacaxi.png",
			"grupo2/anel.png",
			"grupo2/aranha.png",
			"grupo2/bolsa.png",
			"grupo2/borracha.png",
			"grupo2/cachimbo.png",
			"grupo2/casa.png",
			"grupo2/elefante.png",
			"grupo2/flauta.png",
			"grupo2/lanterna.png",
			"grupo2/lixeira.png",
			"grupo2/pente.png",
			"grupo2/quadro.png",
			"grupo2/sino.png",
			"grupo2/tesoura.png",
	};
	public static final String[] IMAGENS_GRUPO_3 = {
			"grupo3/astronauta.png",
			"grupo3/cachorro.png",
			"grupo3/esqueleto.png",
			"grupo3/esquilo.png",
			"grupo3/girassol.png",
			"grupo3/guitarra.png",
			"grupo3/helicoptero.png",
			"grupo3/lampada.png",
			"grupo3/palhaço.png",
			"grupo3/professor.png",
			"grupo3/queijo.png",
			"grupo3/relogio.png",
			"grupo3/taxi.png",
			"grupo3/travesseiro.png",
			"grupo3/xicara.png",
	};
	public static final String[] IMAGENS_GRUPO_4 = {
			"grupo4/arvore.png",
			"grupo4/aquario.png",
			"grupo4/bombeiro.png",
			"grupo4/calça.png",
			"grupo4/cenoura.png",
			"grupo4/chapeu.png",
			"grupo4/coracao.png",
			"grupo4/dinheiro.png",
			"grupo4/funil.png",
			"grupo4/garrafa.png",
			"grupo4/hipopotamo.png",
			"grupo4/indio.png",
			"grupo4/polvo.png",
			"grupo4/sanduiche.png",
			"grupo4/violao.png",
	};
	
	public static String[][] TODOS_OS_GRUPOS = new String[QTD_GRUPOS][QTD_IMAGENS_POR_GRUPO];
	
	static {
		TODOS_OS_GRUPOS[0] = IMAGENS_GRUPO_1;
		TODOS_OS_GRUPOS[1] = IMAGENS_GRUPO_2;
		TODOS_OS_GRUPOS[2] = IMAGENS_GRUPO_3;
		TODOS_OS_GRUPOS[3] = IMAGENS_GRUPO_4;
	}
}
