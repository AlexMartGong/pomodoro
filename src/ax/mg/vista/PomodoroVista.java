package ax.mg.vista;

import ax.mg.connect.ConnectMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ax.mg.operationsdb.OperationsDB;
import ax.mg.pomodorostiempo.Temporizador;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PomodoroVista extends javax.swing.JFrame {

    ConnectMySql conn = new ConnectMySql();
    java.sql.Connection con = conn.connectMySQL();

    public PomodoroVista() {
        initComponents();
        cargarTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFondo = new javax.swing.JPanel();
        txtTarea = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtPomodoros = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btnAgregar = new javax.swing.JButton();
        btnIniciarTarea = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelNameTarea = new javax.swing.JLabel();
        labelTiempoTarea = new javax.swing.JLabel();
        labelNameTarea1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelSiguienteTarea = new javax.swing.JLabel();
        labelPomodoros = new javax.swing.JLabel();
        labelPomodoConsu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTask = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpFondo.setBackground(new java.awt.Color(255, 255, 255));
        jpFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTarea.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTarea.setBorder(null);
        jpFondo.add(txtTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 210, -1));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setText("Tareas");
        jpFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jpFondo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 210, 10));

        jLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel2.setText("Pomodoros");
        jpFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        txtPomodoros.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtPomodoros.setBorder(null);
        jpFondo.add(txtPomodoros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 130, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jpFondo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 130, 20));

        btnAgregar.setBackground(new java.awt.Color(255, 102, 102));
        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar tarea");
        btnAgregar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jpFondo.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, -1));

        btnIniciarTarea.setBackground(new java.awt.Color(255, 102, 102));
        btnIniciarTarea.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnIniciarTarea.setText("Iniciar tarea");
        btnIniciarTarea.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnIniciarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarTareaActionPerformed(evt);
            }
        });
        jpFondo.add(btnIniciarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelNameTarea.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N

        labelTiempoTarea.setFont(new java.awt.Font("Roboto Light", 1, 36)); // NOI18N
        labelTiempoTarea.setText("00:00");

        labelNameTarea1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelNameTarea1.setText("Task:");

        jLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel5.setText("Pomodores:");

        labelSiguienteTarea.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelSiguienteTarea.setText("Pomodores consumidos:");

        labelPomodoros.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N

        labelPomodoConsu.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTiempoTarea)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelNameTarea1)
                        .addGap(18, 18, 18)
                        .addComponent(labelNameTarea))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelSiguienteTarea)
                                .addGap(18, 18, 18)
                                .addComponent(labelPomodoConsu))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelPomodoros)))))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTiempoTarea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelPomodoros))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSiguienteTarea)
                    .addComponent(labelPomodoConsu))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNameTarea)
                    .addComponent(labelNameTarea1))
                .addContainerGap())
        );

        jpFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 340, 170));

        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel4.setText("Tarea");
        jpFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ax/mg/images/images.png"))); // NOI18N
        jpFondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 200, 170));

        tbTask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Task", "Pomodoros"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbTask);

        jpFondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 200));

        btnUpdate.setBackground(new java.awt.Color(255, 102, 102));
        btnUpdate.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnUpdate.setText("Actualizar tabla");
        btnUpdate.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jpFondo.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        String task = txtTarea.getText();
        String con = txtPomodoros.getText();

        if (!task.isEmpty() && !con.isEmpty()) {

            int cantidad = Integer.parseInt(con);
            OperationsDB operations = new OperationsDB();

            try {
                operations.insertDB(task, cantidad);
                cargarTable();
                limpiar();
            } catch (SQLException ex) {
                Logger.getLogger(PomodoroVista.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Llenar todos los campos");
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnIniciarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarTareaActionPerformed

        int fila = tbTask.getSelectedRow();
        int pomodoros = 0;

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una tarea.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = Integer.parseInt(tbTask.getValueAt(fila, 0).toString());

            try {
                PreparedStatement ps;
                ResultSet rs;
                String sql;

                sql = "SELECT taskname, cantidad FROM tasks WHERE idtask=?";
                ps = con.prepareStatement(sql);

                ps.setInt(1, id);
                rs = ps.executeQuery();

                while (rs.next()) {
                    labelNameTarea.setText(rs.getString("taskname"));
                    pomodoros = rs.getInt("cantidad");
                    labelPomodoros.setText("" + pomodoros);
                }

                Temporizador temporizador = new Temporizador(25, labelTiempoTarea, labelPomodoConsu, labelPomodoros, pomodoros, id);
                cargarTable();

            } catch (SQLException e) {
                System.out.println(e.toString());
            }

        }


    }//GEN-LAST:event_btnIniciarTareaActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        cargarTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PomodoroVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PomodoroVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PomodoroVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PomodoroVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PomodoroVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnIniciarTarea;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jpFondo;
    private javax.swing.JLabel labelNameTarea;
    private javax.swing.JLabel labelNameTarea1;
    private javax.swing.JLabel labelPomodoConsu;
    private javax.swing.JLabel labelPomodoros;
    private javax.swing.JLabel labelSiguienteTarea;
    private javax.swing.JLabel labelTiempoTarea;
    private javax.swing.JTable tbTask;
    private javax.swing.JTextField txtPomodoros;
    private javax.swing.JTextField txtTarea;
    // End of variables declaration//GEN-END:variables

    private void cargarTable() {

        DefaultTableModel modelTable = (DefaultTableModel) tbTask.getModel();
        modelTable.setRowCount(0);

        String sql;
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            sql = "SELECT idtask, taskname, cantidad FROM tasks";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modelTable.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public void limpiar() {
        txtPomodoros.setText("");
        txtTarea.setText("");
    }
}
