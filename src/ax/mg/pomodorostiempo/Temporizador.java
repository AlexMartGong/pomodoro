package ax.mg.pomodorostiempo;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Temporizador {

    Timer timer;
    int segundosTranscurridos = 0;
    JLabel label;
    JLabel consumidos;
    JLabel restantes;
    int repeticiones;
    static int ciclo = 1;
    static String estado = "Enfoque";

    public Temporizador(int segundos, JLabel label, JLabel consumidos, JLabel restantes, int repeticiones) {
        this.label = label;
        this.consumidos = consumidos;
        this.repeticiones = repeticiones;
        this.restantes = restantes;
        timer = new Timer();
        timer.schedule(new TareaTemporizador(), 0, 1000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
                if ((repeticiones + 1) > 1) {

                    if (segundos == 25 && ciclo % 4 != 0) {

                        estado = "Descanso";
                        new Temporizador(5, label, consumidos, restantes, repeticiones - 1);
                        ciclo++;

                    } else if (segundos == 5 || segundos == 15) {

                        estado = "Enfoque";
                        new Temporizador(25, label, consumidos, restantes, repeticiones);

                    } else if (ciclo % 4 == 0 && segundos == 25) {

                        estado = "Descanso";
                        new Temporizador(15, label, consumidos, restantes, repeticiones - 1);
                        ciclo++;

                    }
                }
            }
        }, segundos * 1000L);
    }

    class TareaTemporizador extends TimerTask {

        public void run() {
            segundosTranscurridos++;
            label.setText(estado + ": " + segundosTranscurridos);
            consumidos.setText("" + (ciclo - 1));
            restantes.setText("" + repeticiones);
            
        }
    }
}
