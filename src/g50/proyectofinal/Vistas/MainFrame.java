/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package g50.proyectofinal.Vistas;

/**
 *
 * @author whatu
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMenuCambiarPrecios = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        JMConsultarHabitaciones = new javax.swing.JMenuItem();
        JMCalcularMontoEstadia = new javax.swing.JMenuItem();
        JMCrearReserva = new javax.swing.JMenuItem();
        JMBuscaReserva = new javax.swing.JMenuItem();
        JMInformeHuesped = new javax.swing.JMenuItem();
        JMFinalizarReserva = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        JMInformeHuespedExtra = new javax.swing.JMenuItem();
        JMAcercaDe = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 847, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jMenu1.setText("Habitaciones");

        JMenuCambiarPrecios.setText("Cambiar Precios ");
        JMenuCambiarPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuCambiarPreciosActionPerformed(evt);
            }
        });
        jMenu1.add(JMenuCambiarPrecios);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reservas");

        JMConsultarHabitaciones.setText("Consultar Habitaciones");
        JMConsultarHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMConsultarHabitacionesActionPerformed(evt);
            }
        });
        jMenu2.add(JMConsultarHabitaciones);

        JMCalcularMontoEstadia.setText("Calcular Monto Estadia");
        JMCalcularMontoEstadia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMCalcularMontoEstadiaActionPerformed(evt);
            }
        });
        jMenu2.add(JMCalcularMontoEstadia);

        JMCrearReserva.setText("Crear Reserva");
        JMCrearReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMCrearReservaActionPerformed(evt);
            }
        });
        jMenu2.add(JMCrearReserva);

        JMBuscaReserva.setText("Busca Reservas");
        JMBuscaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMBuscaReservaActionPerformed(evt);
            }
        });
        jMenu2.add(JMBuscaReserva);

        JMInformeHuesped.setText("Informe Huesped");
        JMInformeHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMInformeHuespedActionPerformed(evt);
            }
        });
        jMenu2.add(JMInformeHuesped);

        JMFinalizarReserva.setText("Finalizar Reserva");
        JMFinalizarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMFinalizarReservaActionPerformed(evt);
            }
        });
        jMenu2.add(JMFinalizarReserva);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Huespedes");

        JMInformeHuespedExtra.setText("Informe Huesped");
        JMInformeHuespedExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMInformeHuespedExtraActionPerformed(evt);
            }
        });
        jMenu3.add(JMInformeHuespedExtra);

        jMenuBar1.add(jMenu3);

        JMAcercaDe.setText("Acerca De");

        jMenuItem1.setText("Acerca ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        JMAcercaDe.add(jMenuItem1);

        jMenuBar1.add(JMAcercaDe);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        AcercaDeFrame acerca = new AcercaDeFrame();
        jDesktopPane1.add(acerca);
        acerca.setVisible(true);


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void JMenuCambiarPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuCambiarPreciosActionPerformed
        // TODO add your handling code here:
        CambiarPreciosHabFrame cambiar = new CambiarPreciosHabFrame();
        jDesktopPane1.add(cambiar);
        cambiar.setVisible(true);
    }//GEN-LAST:event_JMenuCambiarPreciosActionPerformed

    private void JMConsultarHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMConsultarHabitacionesActionPerformed
        // TODO add your handling code here:
        HabitacionesClasificadasFrame cambiar = new HabitacionesClasificadasFrame();
        jDesktopPane1.add(cambiar);
        cambiar.setVisible(true);
    }//GEN-LAST:event_JMConsultarHabitacionesActionPerformed

    private void JMInformeHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMInformeHuespedActionPerformed
        // TODO add your handling code here:
        InformeHuespedesFrame cambiar = new InformeHuespedesFrame();
        jDesktopPane1.add(cambiar);
        cambiar.setVisible(true);
    }//GEN-LAST:event_JMInformeHuespedActionPerformed

    private void JMCalcularMontoEstadiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMCalcularMontoEstadiaActionPerformed
        // TODO add your handling code here:
        CalcularMontoFrame cambiar = new CalcularMontoFrame();
        jDesktopPane1.add(cambiar);
        cambiar.setVisible(true);
    }//GEN-LAST:event_JMCalcularMontoEstadiaActionPerformed

    private void JMCrearReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMCrearReservaActionPerformed
        // TODO add your handling code here:
        CrearReservaFrame cambiar = new CrearReservaFrame();
        jDesktopPane1.add(cambiar);
        cambiar.setVisible(true);
    }//GEN-LAST:event_JMCrearReservaActionPerformed

    private void JMBuscaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMBuscaReservaActionPerformed
        // TODO add your handling code here:
        BusquedaReservasFrame cambiar = new BusquedaReservasFrame();
        jDesktopPane1.add(cambiar);
        cambiar.setVisible(true);
    }//GEN-LAST:event_JMBuscaReservaActionPerformed

    private void JMFinalizarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMFinalizarReservaActionPerformed
        // TODO add your handling code here:
        FinReservaFrame cambiar = new FinReservaFrame();
        jDesktopPane1.add(cambiar);
        cambiar.setVisible(true);
    }//GEN-LAST:event_JMFinalizarReservaActionPerformed

    private void JMInformeHuespedExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMInformeHuespedExtraActionPerformed
        // TODO add your handling code here:
          InformeHuespedesFrame cambiar = new InformeHuespedesFrame();
        jDesktopPane1.add(cambiar);
        cambiar.setVisible(true);
    }//GEN-LAST:event_JMInformeHuespedExtraActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMAcercaDe;
    private javax.swing.JMenuItem JMBuscaReserva;
    private javax.swing.JMenuItem JMCalcularMontoEstadia;
    private javax.swing.JMenuItem JMConsultarHabitaciones;
    private javax.swing.JMenuItem JMCrearReserva;
    private javax.swing.JMenuItem JMFinalizarReserva;
    private javax.swing.JMenuItem JMInformeHuesped;
    private javax.swing.JMenuItem JMInformeHuespedExtra;
    private javax.swing.JMenuItem JMenuCambiarPrecios;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
