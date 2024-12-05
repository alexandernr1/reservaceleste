package Presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Javanzado extends javax.swing.JFrame {

    public Javanzado() {
        initComponents();
        setTitle("AVANZADO");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnempleados = new javax.swing.JButton();
        btnhabitaciones = new javax.swing.JButton();
        btnproducto = new javax.swing.JButton();
        lblacceso = new javax.swing.JLabel();
        btnCongelado = new javax.swing.JButton();
        btnInformes = new javax.swing.JButton();
        btnReportes2 = new javax.swing.JButton();
        jdmenu = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        btnempleados.setBackground(new java.awt.Color(0, 204, 204));
        btnempleados.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnempleados.setForeground(new java.awt.Color(0, 0, 102));
        btnempleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/trabajadores.png"))); // NOI18N
        btnempleados.setText("REGISTRO EMPLEADOS");
        btnempleados.setBorderPainted(false);
        btnempleados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnempleados.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnempleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnempleadosActionPerformed(evt);
            }
        });

        btnhabitaciones.setBackground(new java.awt.Color(0, 204, 204));
        btnhabitaciones.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnhabitaciones.setForeground(new java.awt.Color(0, 0, 102));
        btnhabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/habitaciones.png"))); // NOI18N
        btnhabitaciones.setText("REGISTRO HABITACIONES");
        btnhabitaciones.setBorderPainted(false);
        btnhabitaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnhabitaciones.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnhabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhabitacionesActionPerformed(evt);
            }
        });

        btnproducto.setBackground(new java.awt.Color(0, 204, 204));
        btnproducto.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnproducto.setForeground(new java.awt.Color(0, 0, 102));
        btnproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/productos.png"))); // NOI18N
        btnproducto.setText("REGISTRO PRODUCTOS");
        btnproducto.setBorderPainted(false);
        btnproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductoActionPerformed(evt);
            }
        });

        btnCongelado.setBackground(new java.awt.Color(0, 204, 204));
        btnCongelado.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnCongelado.setForeground(new java.awt.Color(0, 0, 102));
        btnCongelado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/congelador.png"))); // NOI18N
        btnCongelado.setText("CONGELAR SALDO");
        btnCongelado.setBorderPainted(false);
        btnCongelado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCongelado.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCongelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongeladoActionPerformed(evt);
            }
        });

        btnInformes.setBackground(new java.awt.Color(0, 204, 204));
        btnInformes.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnInformes.setForeground(new java.awt.Color(0, 0, 102));
        btnInformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/informe-seo.png"))); // NOI18N
        btnInformes.setText("INFORMES");
        btnInformes.setBorderPainted(false);
        btnInformes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInformes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformesActionPerformed(evt);
            }
        });

        btnReportes2.setBackground(new java.awt.Color(0, 204, 204));
        btnReportes2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnReportes2.setForeground(new java.awt.Color(0, 0, 102));
        btnReportes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inmigracion.png"))); // NOI18N
        btnReportes2.setText("REPORTES");
        btnReportes2.setBorderPainted(false);
        btnReportes2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportes2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnReportes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportes2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCongelado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportes2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnhabitaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnempleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblacceso, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addComponent(btnproducto))))
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblacceso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnempleados, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCongelado, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportes2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdmenuLayout = new javax.swing.GroupLayout(jdmenu);
        jdmenu.setLayout(jdmenuLayout);
        jdmenuLayout.setHorizontalGroup(
            jdmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        jdmenuLayout.setVerticalGroup(
            jdmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdmenu)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdmenu)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhabitacionesActionPerformed
        Jhabitaciones Jhabitaciones = new Jhabitaciones();
        jdmenu.add(Jhabitaciones);

        Jhabitaciones.setVisible(true);
    }//GEN-LAST:event_btnhabitacionesActionPerformed

    private void btnempleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnempleadosActionPerformed
//        new Jregistroempleados().setVisible(true);
        Jregistroempleados Jregistroempleados = new Jregistroempleados();
        jdmenu.add(Jregistroempleados);
        Jregistroempleados.toFront();
        Jregistroempleados.setVisible(true);
    }//GEN-LAST:event_btnempleadosActionPerformed

    private void btnproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductoActionPerformed
        Jproducto Jproducto = new Jproducto();
        jdmenu.add(Jproducto);
        Jproducto.toFront();
        Jproducto.setVisible(true);
    }//GEN-LAST:event_btnproductoActionPerformed

    private void btnCongeladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCongeladoActionPerformed
        // TODO add your handling code here:
        JabonoCongelado conelado = new JabonoCongelado();
        jdmenu.add(conelado);
        conelado.toFront();
        conelado.setVisible(true);
    }//GEN-LAST:event_btnCongeladoActionPerformed

    private void btnInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformesActionPerformed
        // TODO add your handling code here:
        Jreportefecha reporte = new Jreportefecha();
        jdmenu.add(reporte);
        reporte.toFront();
        reporte.setVisible(true);
    }//GEN-LAST:event_btnInformesActionPerformed

    private void btnReportes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportes2ActionPerformed
        // TODO add your handling code here:
        Jreportes reportes = new Jreportes();
        jdmenu.add(reportes);
        reportes.toFront();
        reportes.setVisible(true);
    }//GEN-LAST:event_btnReportes2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Javanzado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCongelado;
    private javax.swing.JButton btnInformes;
    private javax.swing.JButton btnReportes2;
    private javax.swing.JButton btnempleados;
    private javax.swing.JButton btnhabitaciones;
    private javax.swing.JButton btnproducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JDesktopPane jdmenu;
    public static javax.swing.JLabel lblacceso;
    // End of variables declaration//GEN-END:variables
}
