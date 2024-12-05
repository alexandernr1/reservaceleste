package Presentacion;

import javax.swing.JFrame;

public class ListaOpciones extends javax.swing.JFrame {

    public ListaOpciones() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("OPCIONES DE ATAJO");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rdingreso = new javax.swing.JRadioButton();
        rdabonos = new javax.swing.JRadioButton();
        rdsalidas = new javax.swing.JRadioButton();
        rdreservas = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rdingreso.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        rdingreso.setText("Ingreso");
        rdingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdingresoActionPerformed(evt);
            }
        });

        rdabonos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        rdabonos.setText("Abono");
        rdabonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdabonosActionPerformed(evt);
            }
        });

        rdsalidas.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        rdsalidas.setText("Salida");
        rdsalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdsalidasActionPerformed(evt);
            }
        });

        rdreservas.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        rdreservas.setText("Reserva");
        rdreservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdreservasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdingreso)
                    .addComponent(rdabonos)
                    .addComponent(rdsalidas)
                    .addComponent(rdreservas))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(rdingreso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdabonos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdsalidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdreservas)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdingresoActionPerformed
        if (rdingreso.isSelected()) {
//             Llamar al método de consulta de reserva de otra clase
//            Jmenuhotel reserva = new Jmenuhotel();
//            reserva.consultarReserva();
//             Realiza la acción para el radio botón "Ingresos"
            Jingreso ingreso = new Jingreso();
            ingreso.toFront();
            ingreso.requestFocus();
            ingreso.setVisible(true);
        }
        this.dispose();


    }//GEN-LAST:event_rdingresoActionPerformed

    private void rdsalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdsalidasActionPerformed
        // TODO add your handling code here:
        if (rdsalidas.isSelected()) {
            // Realiza la acción para el radio botón "Salidas"
            Jsalidahuesped salidas = new Jsalidahuesped();
            salidas.toFront();
            salidas.requestFocus();
            salidas.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_rdsalidasActionPerformed

    private void rdabonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdabonosActionPerformed
        // TODO add your handling code here:
        if (rdabonos.isSelected()) {
            // Realiza la acción para el radio botón "Abonos"
            Jabono abonos = new Jabono();
            abonos.toFront();
            abonos.requestFocus();
            abonos.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_rdabonosActionPerformed

    private void rdreservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdreservasActionPerformed
        // TODO add your handling code here:
        if (rdreservas.isSelected()) {
            // Realiza la acción para el radio botón "Reservas"
            Jmanejoreservas reservas = new Jmanejoreservas();
            reservas.toFront();
            reservas.requestFocus();
            reservas.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_rdreservasActionPerformed

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
            java.util.logging.Logger.getLogger(ListaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaOpciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rdabonos;
    private javax.swing.JRadioButton rdingreso;
    private javax.swing.JRadioButton rdreservas;
    private javax.swing.JRadioButton rdsalidas;
    // End of variables declaration//GEN-END:variables
}
