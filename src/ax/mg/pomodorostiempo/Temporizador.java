package ax.mg.pomodorostiempo;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Temporizador {

    Timer timer;
    int segundosTranscurridos = 0;
    JLabel label;
    int repeticiones;
    static int ciclo = 1;

    public Temporizador(int segundos, JLabel label, int repeticiones) {
        this.label = label;
        this.repeticiones = repeticiones;
        timer = new Timer();
        timer.schedule(new TareaTemporizador(), 0, 1000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
                if ((repeticiones + 1) > 1) {

                    if (segundos == 25 && ciclo % 4 != 0) {

                        new Temporizador(5, label, repeticiones - 1);
                        ciclo++;

                    } else if (segundos == 5 || segundos == 15) {

                        new Temporizador(25, label, repeticiones);

                    } else if (ciclo % 4 == 0 && segundos == 25) {

                        new Temporizador(15, label, repeticiones - 1);
                        ciclo++;

                    }
                }
            }
        }, segundos * 1000L);
    }

    class TareaTemporizador extends TimerTask {

        public void run() {
            segundosTranscurridos++;
            label.setText("" + segundosTranscurridos);
        }
    }
}
