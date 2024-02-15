package ax.mg.pomodorostiempo;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Temporizador {

    Timer timer;
    private int segundosTranscurridos = 0;
    JLabel label;

    public Temporizador(int segundos, JLabel label) {
        this.label = label;
        timer = new Timer();
        timer.schedule(new TareaTemporizador(), 0, 1000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
                if (segundos == 25) {
                    new Temporizador(5, label);
                }
            }
        }, segundos * 1000);
    }

    class TareaTemporizador extends TimerTask {

        public void run() {
            segundosTranscurridos++;
            label.setText("Tiempo: " + segundosTranscurridos);
        }
    }
}
