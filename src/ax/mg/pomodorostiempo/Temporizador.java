package ax.mg.pomodorostiempo;

import ax.mg.operationsdb.OperationsDB;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Temporizador {

    Timer timer;
    int segundosTranscurridos = 0;
    int id = 0;
    JLabel label;
    JLabel consumidos;
    JLabel restantes;
    int repeticiones;
    static int ciclo = 1;
    static String estado = "Enfoque";

    public Temporizador(int segundos, JLabel label, JLabel consumidos, JLabel restantes, int repeticiones, int id) {
        this.label = label;
        this.consumidos = consumidos;
        this.repeticiones = repeticiones;
        this.restantes = restantes;
        this.id = id;
        timer = new Timer();
        timer.schedule(new TareaTemporizador(), 0, 1000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
                if ((repeticiones + 1) > 1) {

                    if (segundos == 25 && ciclo % 4 != 0) {

                        estado = "Descanso";
                        new Temporizador(5, label, consumidos, restantes, repeticiones - 1, id);
                        ciclo++;

                    } else if (segundos == 5 || segundos == 15) {

                        estado = "Enfoque";
                        new Temporizador(25, label, consumidos, restantes, repeticiones, id);

                    } else if (ciclo % 4 == 0 && segundos == 25) {

                        estado = "Descanso";
                        new Temporizador(15, label, consumidos, restantes, repeticiones - 1, id);
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

            if (repeticiones == 0) {
                OperationsDB operacionesDB = new OperationsDB();
                try {
                    operacionesDB.deleteTasks(id);
                } catch (SQLException ex) {
                    Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}