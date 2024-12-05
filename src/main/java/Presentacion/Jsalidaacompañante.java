package Presentacion;

import Datos.Dacompañante;
import Datos.DsalidaAcompañante;
import Datos.Tiempopro;
import Logica.Cconexion;
import Logica.Facompañante;
import Logica.FsalidaAcompañante;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Jsalidaacompañante extends javax.swing.JFrame {

    Tiempopro time = new Tiempopro();
    PreparedStatement pst;
    ResultSet rs;

    public Jsalidaacompañante() {
        initComponents();
        mostrarTiempo();
        setLocationRelativeTo(null);
        setTitle("SALIDA DE ACOMPAÑANTE");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    private String accion = "guardar";

    private void mostrarTiempo() {

        txtfechasalida.setText(time.getFechacomp());
    }
     public void limpiarcampo() {
        txtacompañante.setText(null);
        cbo_tipoDocumento.setSelectedItem(0);
        txtdocumentos.setText(null);
        cboparentesco.setSelectedItem(0);
        txtnumero_habitacion.setText(null);
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        txtacompañante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdocumentos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtnumero_habitacion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cboparentesco = new javax.swing.JComboBox<>();
        cbo_tipoDocumento = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtciudad_recidencia = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtciudad_procedencia = new javax.swing.JTextField();
        txtfechasalida = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtfechaentrada = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtnum_principal = new javax.swing.JTextField();
        txtidacompañante = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        btnsalida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "SALIDA ACOMPAÑANTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 14))); // NOI18N

        txtacompañante.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel7.setText("Nmbre completo:");

        txtdocumentos.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel11.setText("Documento:");

        jLabel13.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel13.setText("Parentesco:");

        txtnumero_habitacion.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtnumero_habitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumero_habitacionActionPerformed(evt);
            }
        });
        txtnumero_habitacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnumero_habitacionKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel16.setText("N°  Habita:");

        cboparentesco.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        cboparentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Esposo/a", "Padre", "Madre", "Hijo/a", "Familiar", "Compeñero de Trabajo" }));

        cbo_tipoDocumento.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        cbo_tipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Cedula de ciudadania", "Cedula de extragria", "Pasaporte", "Tarjeta de identidad" }));

        jLabel18.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel18.setText("Tipo Documento:");

        jLabel25.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel25.setText("check IN :");

        txtciudad_recidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtciudad_recidenciaActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel26.setText("Ciudad de Residencia:");

        jLabel27.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel27.setText("Ciudad de Procedencia:");

        txtciudad_procedencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtciudad_procedenciaActionPerformed(evt);
            }
        });

        txtfechasalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfechasalidaKeyPressed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel28.setText("Check Oup:");

        txtfechaentrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfechaentradaKeyPressed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel29.setText("N° huesped principal:");

        txtnum_principal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnum_principalKeyPressed(evt);
            }
        });

        txtidacompañante.setText("IDAC");
        txtidacompañante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidacompañanteActionPerformed(evt);
            }
        });

        txtidcliente.setEditable(false);
        txtidcliente.setText("IDC");

        btnsalida.setBackground(new java.awt.Color(204, 204, 204));
        btnsalida.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnsalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida-de-emergencia.png"))); // NOI18N
        btnsalida.setText("Salida");
        btnsalida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsalida.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnsalida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnsalida))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtacompañante, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_tipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboparentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtciudad_recidencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtciudad_procedencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtfechaentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnum_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnumero_habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtidacompañante, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(13, 13, 13))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel29))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtnum_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtfechaentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtfechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtnumero_habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtacompañante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidacompañante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_tipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cboparentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtciudad_recidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtciudad_procedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnsalida)
                .addContainerGap())
        );

        jLayeredPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumero_habitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumero_habitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumero_habitacionActionPerformed

    private void txtciudad_recidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtciudad_recidenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtciudad_recidenciaActionPerformed

    private void txtciudad_procedenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtciudad_procedenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtciudad_procedenciaActionPerformed

    private void txtfechasalidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechasalidaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechasalidaKeyPressed

    private void txtfechaentradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechaentradaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaentradaKeyPressed

    private void txtnum_principalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnum_principalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cconexion conexion = new Cconexion();

            try {
                Connection conectar = conexion.establecerConexion();

                pst = conectar.prepareStatement("select * from acompañantes where num_huesped_principal=? and estado = 'Activo'");
                pst.setString(1, txtnum_principal.getText());

                rs = pst.executeQuery();

                if (rs.next()) {
                    txtidcliente.setText(String.valueOf(rs.getInt("idcliente")));
                    txtidacompañante.setText(String.valueOf(rs.getString("idacompañante")));
                    txtacompañante.setText(String.valueOf(rs.getString("nombre_apellido")));
                    String tipoDocumento = rs.getString("tipo_documento");
                    cbo_tipoDocumento.setSelectedItem(tipoDocumento);
                    txtdocumentos.setText(String.valueOf(rs.getString("documento")));
                    String parentesco = rs.getString("parentesco");
                    cboparentesco.setSelectedItem(parentesco);
                    txtnumero_habitacion.setText(String.valueOf(rs.getString("num_habitacion")));
                    txtfechaentrada.setText(String.valueOf(rs.getString("checkin")));
                    txtnum_principal.setText(String.valueOf(rs.getString("num_huesped_principal")));
                    txtciudad_procedencia.setText(String.valueOf(rs.getString("ciudad_de_procedencia")));
                    txtciudad_recidencia.setText(String.valueOf(rs.getString("ciudad_de_residencia")));
                    

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro el CLIENTE solicitado");
                }

            } catch (Exception ex) {
                System.err.println("Error" + ex);
            }
        }
    }//GEN-LAST:event_txtnum_principalKeyPressed

    private void btnsalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalidaActionPerformed

      FsalidaAcompañante func = new FsalidaAcompañante();
    DsalidaAcompañante dts = new DsalidaAcompañante();
    
    dts.setIdacompañante(Integer.parseInt(txtidacompañante.getText()));
    dts.setIdcliente(Integer.parseInt(txtidcliente.getText()));
    dts.setNombre_apellido(txtacompañante.getText());
    int seleccionado = cbo_tipoDocumento.getSelectedIndex();
    dts.setTipo_documento((String) cbo_tipoDocumento.getItemAt(seleccionado));
    dts.setDocumento(Integer.parseInt(txtdocumentos.getText()));
    int parentesco = cboparentesco.getSelectedIndex();
    dts.setParentesco((String) cboparentesco.getItemAt(parentesco));
    dts.setNum_habitacion(Integer.parseInt(txtnumero_habitacion.getText()));
    dts.setCheckin(txtfechaentrada.getText());
    dts.setCheckoup(txtfechasalida.getText());
    dts.setNum_huesped_principal(Integer.parseInt(txtnum_principal.getText()));
    dts.setCiudad_de_residencia(txtciudad_recidencia.getText());
    dts.setCiudad_de_procedencia(txtciudad_procedencia.getText());

    System.out.println("ID Acompañante: " + dts.getIdacompañante());  // Añadido para depuración

    if (accion.equals("guardar")) {
        if (func.insertar(dts)) {
//                mostraracompañante("");
            Dacompañante dts1 = new Dacompañante();
            Facompañante fnc = new Facompañante();
            dts1.setIdacompañante(Integer.parseInt(txtidacompañante.getText()));

            System.out.println("ID Acompañante para salida: " + dts1.getIdacompañante());  // Añadido para depuración
            if (fnc.SalidaAcompañante(dts1)) {
                int respuesta = JOptionPane.showConfirmDialog(rootPane, "ACOMPAÑANTE FINALIZADO. ¿Deseas finalizar otro?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    limpiarcampo();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error al finalizar la salida del acompañante.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error al guardar los datos del acompañante.");
        }
    }
    }//GEN-LAST:event_btnsalidaActionPerformed

    private void txtidacompañanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidacompañanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidacompañanteActionPerformed

    private void txtnumero_habitacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumero_habitacionKeyPressed


    }//GEN-LAST:event_txtnumero_habitacionKeyPressed

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
            java.util.logging.Logger.getLogger(Jsalidaacompañante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jsalidaacompañante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jsalidaacompañante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jsalidaacompañante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jsalidaacompañante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsalida;
    private javax.swing.JComboBox<String> cbo_tipoDocumento;
    private javax.swing.JComboBox<String> cboparentesco;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtacompañante;
    private javax.swing.JTextField txtciudad_procedencia;
    private javax.swing.JTextField txtciudad_recidencia;
    private javax.swing.JTextField txtdocumentos;
    private javax.swing.JTextField txtfechaentrada;
    private javax.swing.JTextField txtfechasalida;
    private static javax.swing.JTextField txtidacompañante;
    public static javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtnum_principal;
    private javax.swing.JTextField txtnumero_habitacion;
    // End of variables declaration//GEN-END:variables
}
