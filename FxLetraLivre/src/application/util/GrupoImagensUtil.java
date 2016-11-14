package application.util;

public class GrupoImagensUtil {
	
	private static final int QTD_GRUPOS = 4;
	
	private static final int QTD_IMAGENS_POR_GRUPO = 15;
	
	public static final String[] IMAGENS_GRUPO_1 = {
			"/resources/imagens/fases/grupo1/abelha.png",
			"/resources/imagens/fases/grupo1/anjo.png",
			"/resources/imagens/fases/grupo1/bicicleta.png",
			"/resources/imagens/fases/grupo1/bola.png",
			"/resources/imagens/fases/grupo1/bomba.png",
			"/resources/imagens/fases/grupo1/caixa.png",
			"/resources/imagens/fases/grupo1/carro.png",
			"/resources/imagens/fases/grupo1/chave.png",
			"/resources/imagens/fases/grupo1/foguete.png",
			"/resources/imagens/fases/grupo1/galinha.png",
			"/resources/imagens/fases/grupo1/girafa.png",
			"/resources/imagens/fases/grupo1/ovo.png",
			"/resources/imagens/fases/grupo1/policial.png",
			"/resources/imagens/fases/grupo1/rato.png",
			"/resources/imagens/fases/grupo1/saci.jpg",
	};
	public static final String[] IMAGENS_GRUPO_2 = {
			"/resources/imagens/fases/grupo2/abacaxi.png",
			"/resources/imagens/fases/grupo2/anel.png",
			"/resources/imagens/fases/grupo2/aranha.png",
			"/resources/imagens/fases/grupo2/bolsa.png",
			"/resources/imagens/fases/grupo2/borracha.png",
			"/resources/imagens/fases/grupo2/cachimbo.png",
			"/resources/imagens/fases/grupo2/casa.png",
			"/resources/imagens/fases/grupo2/elefante.png",
			"/resources/imagens/fases/grupo2/flauta.png",
			"/resources/imagens/fases/grupo2/lanterna.png",
			"/resources/imagens/fases/grupo2/lixeira.png",
			"/resources/imagens/fases/grupo2/pente.png",
			"/resources/imagens/fases/grupo2/quadro.png",
			"/resources/imagens/fases/grupo2/sino.png",
			"/resources/imagens/fases/grupo2/tesoura.png",
	};
	public static final String[] IMAGENS_GRUPO_3 = {
			"/resources/imagens/fases/grupo3/astronauta.png",
			"/resources/imagens/fases/grupo3/cachorro.png",
			"/resources/imagens/fases/grupo3/esqueleto.png",
			"/resources/imagens/fases/grupo3/esquilo.png",
			"/resources/imagens/fases/grupo3/girassol.png",
			"/resources/imagens/fases/grupo3/guitarra.png",
			"/resources/imagens/fases/grupo3/helicptero.png",
			"/resources/imagens/fases/grupo3/lampada.png",
			"/resources/imagens/fases/grupo3/palhaço.png",
			"/resources/imagens/fases/grupo3/professora.png",
			"/resources/imagens/fases/grupo3/queijo.png",
			"/resources/imagens/fases/grupo3/relogio.png",
			"/resources/imagens/fases/grupo3/taxi.png",
			"/resources/imagens/fases/grupo3/travesseiro.jpg",
			"/resources/imagens/fases/grupo3/xicara.png",
	};
	public static final String[] IMAGENS_GRUPO_4 = {
			"/resources/imagens/fases/grupo4/arvore.png",
			"/resources/imagens/fases/grupo4/aquario.png",
			"/resources/imagens/fases/grupo4/bombeiro.png",
			"/resources/imagens/fases/grupo4/calça.png",
			"/resources/imagens/fases/grupo4/cenoura.png",
			"/resources/imagens/fases/grupo4/chapeu.png",
			"/resources/imagens/fases/grupo4/coração.png",
			"/resources/imagens/fases/grupo4/dinheiro.png",
			"/resources/imagens/fases/grupo4/funil.png",
			"/resources/imagens/fases/grupo4/garrafa.png",
			"/resources/imagens/fases/grupo4/hipopotamo.png",
			"/resources/imagens/fases/grupo4/indio.png",
			"/resources/imagens/fases/grupo4/polvo.png",
			"/resources/imagens/fases/grupo4/sanduiche.png",
			"/resources/imagens/fases/grupo4/violao.png",
	};
	
	public static String[][] TODOS_OS_GRUPOS = new String[QTD_GRUPOS][QTD_IMAGENS_POR_GRUPO];
	
	static {
		TODOS_OS_GRUPOS[0] = IMAGENS_GRUPO_1;
		TODOS_OS_GRUPOS[1] = IMAGENS_GRUPO_2;
		TODOS_OS_GRUPOS[2] = IMAGENS_GRUPO_3;
		TODOS_OS_GRUPOS[3] = IMAGENS_GRUPO_4;
	}
}
