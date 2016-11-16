package application.view.meuscomponentes;

import javafx.application.Platform;
import javafx.concurrent.Task;

public class Relogio extends Task {
	
	private static final int UM_SEGUNDO = 1000;	
	public static int tempoGastoEmSegundos;

	@Override
	protected Object call() throws Exception {
		int segundo = 0;
		int minuto = 0;
		int hora = 0;
		Thread.sleep(UM_SEGUNDO);
//		while (palavraNaoConcluida) {
//            segundo++;
//
//            if (segundo == 60) {
//                minuto++;
//                segundo = 0;
//            }
//
//            if (minuto == 60) {
//                hora++;
//                minuto = 0;
//            }
//            final String hr = hora <= 9 ? "0" + hora : hora + "";
//            final String min = minuto <= 9 ? "0" + minuto : minuto + "";
//            final String seg = segundo <= 9 ? "0" + segundo : segundo + "";
//
//            Platform.runLater(new Runnable() {
//				public void run() {
//				    lbTempo.setText(hr + ":" + min + ":" + seg);
//				}
//			});
//            tempoGastoEmSegundos++;
//            Thread.sleep(UM_SEGUNDO);                    
//        }
        return null;
	}

	public void pause() {
	    this.cancel();
	}
	
	public void resume() {
		try {
			this.call();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
