
package PresentacionP;

import Datos.Tiempopro;
import DatosP.Dempleadop;
import DatosP.Dinicioturnop;
import LogicaP.Cconexionp;
import LogicaP.Fempleadop;
import LogicaP.Finicioturnop;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Jinicioturnop extends javax.swing.JFrame {

    Statement st;
    ResultSet rs;

    Tiempopro time = new Tiempopro();
    public Jinicioturnop() {
        initComponents();
         initComponents();
        setLocationRelativeTo(null);
        this.setTitle("ACCESO AL SISTEMA");
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mostrarTiempo();
        fechacbo();

        generarnumero();
        llenarcboempleado1(cboempleados);
    }
private void llenarcboempleado1(JComboBox combo) {
        Finicioturnop func = new Finicioturnop();
        DefaultComboBoxModel com = new DefaultComboBoxModel();
        combo.setModel(com);
        Cconexionp conexion = new Cconexionp();
        com.addElement("Seleccione un usuario");

        try {
            Connection conectar = conexion.establecerConexion();
            st = conectar.createStatement();
            rs = st.executeQuery("SELECT p.nombres, p.apellidos,p.numdocumento "
                    + "FROM empleado e "
                    + "JOIN persona p ON e.idpersona = p.idpersona "
                    + "WHERE e.acceso = 'Empleado' ;");

            while (rs.next()) {

                Dempleadop empleado = new Dempleadop();
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                int documento = rs.getInt("numdocumento");

                empleado.setNombres(nombres + " " + apellidos);
                empleado.setDocumento(documento);
                func.agregarEmpleados(empleado);
                com.addElement(empleado.getNombres());

            }
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }

    }
    public static int idpersona;

    private String accion = "guardar";

    public void generarnumero() {
        Finicioturnop func = new Finicioturnop();
        int numeroTurno = func.generarNumeroTurno();

        // Convertir el número de turno a cadena
        String numero = Integer.toString(numeroTurno);

        // Mostrar el número de turno en el campo de texto
        txtnumero_turno.setText(numero);
    }

    private void fechacbo() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaActual = LocalDate.now().format(formatter);
        cboturnos.addItem("Seleccionar");
        cboturnos.addItem("Turno 1" + " " + fechaActual);
        cboturnos.addItem("Turno 2" + " " + fechaActual);
        cboturnos.addItem("Turno 3" + " " + fechaActual);

    }

    private void mostrarTiempo() {

        txtfecha_hora_inicio.setText(time.getFechacomp() + " " + time.getHoracomp());
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtfecha_hora_inicio = new javax.swing.JTextField();
        cboturnos = new javax.swing.JComboBox<>();
        cboestado = new javax.swing.JComboBox<>();
        txtnumero_turno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboempleados = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        ingresoTurno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INICIO TURNOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Estado:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Password:");

        txtusuario.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtusuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });

        txtpassword.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Numero:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Fecha y Hora Inicio:");

        txtfecha_hora_inicio.setEditable(false);
        txtfecha_hora_inicio.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N

        cboestado.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        cboestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Finalizado" }));
        cboestado.setEnabled(false);

        txtnumero_turno.setEditable(false);
        txtnumero_turno.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtnumero_turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumero_turnoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Empleado:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Usuario:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Turno:");

        ingresoTurno.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        ingresoTurno.setText("Ingreso");
        ingresoTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7)
                        .addComponent(cboempleados, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4)
                        .addGap(3, 3, 3)
                        .addComponent(txtfecha_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnumero_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(cboturnos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(ingresoTurno)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addComponent(cboempleados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfecha_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtnumero_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboturnos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(ingresoTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        txtusuario.transferFocus();
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        txtpassword.transferFocus();
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        //        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (cboempleados.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN NOMBRE DE EMPLEADO", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (cboturnos.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN TURNO", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Finicioturnop func1 = new Finicioturnop();
            Dinicioturnop dts1 = new Dinicioturnop();

            dts1.setFecha_hora_inicio(txtfecha_hora_inicio.getText());

            int selecturno = cboturnos.getSelectedIndex();
            dts1.setTurno((String) cboturnos.getItemAt(selecturno));

            int estado = cboestado.getSelectedIndex();
            dts1.setEstado((String) cboestado.getItemAt(estado));

            int trabajador = cboempleados.getSelectedIndex();
            dts1.setEmpleado((String) cboempleados.getItemAt(trabajador));

            dts1.setNumero_turno(Integer.parseInt(txtnumero_turno.getText()));

            if (accion.equals("guardar")) {
                if (func1.insertar(dts1)) {
                    // Turno registrado
                }
            }

            try {
                Fempleadop func = new Fempleadop();

                // Obtener el usuario y contraseña ingresados
                String login = txtusuario.getText();
                String password = txtpassword.getText();

                Dempleadop empleado = func.login(login, password);

                if (empleado != null) {
                    Jmenuparqueadero.sesionIniciada = true; // Cambiar el estado de la sesión

                    this.dispose();

                    // Establecer los valores en Jmenuhotel
                    Jmenuparqueadero.actualizarDatosUsuario1(
                        txtfecha_hora_inicio.getText(),
                        (String) cboturnos.getItemAt(selecturno),
                        (String) cboempleados.getItemAt(trabajador),
                        (String) cboestado.getItemAt(estado)
                    );

                    // Mostrar Jsalidaturno solo si la sesión ya estaba iniciada
                    if (Jmenuparqueadero.sesionIniciada) {
                        Jfinturnop form = new Jfinturnop();
                        form.toFront();
                        form.setVisible(false);
                        form.actualizarTurno(
                            txtfecha_hora_inicio.getText(),
                            (String) cboturnos.getItemAt(selecturno)
                        );

                        //                        Jsalidaturno.txtempleado.setText(empleado.getNombres() + " " + empleado.getApellidos());
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Acceso Denegado", "Error de Login", JOptionPane.ERROR_MESSAGE);
                }
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(rootPane, "Ocurrió un error durante el login.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(Jinicioturnop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtpasswordKeyPressed

    private void txtnumero_turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumero_turnoActionPerformed
        // Generar el número de turno
    }//GEN-LAST:event_txtnumero_turnoActionPerformed

    private void ingresoTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoTurnoActionPerformed

        if (cboempleados.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN NOMBRE DE EMPLEADO", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (cboturnos.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN TURNO", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Finicioturnop func1 = new Finicioturnop();
        Dinicioturnop dts1 = new Dinicioturnop();

        dts1.setFecha_hora_inicio(txtfecha_hora_inicio.getText());

        int selecturno = cboturnos.getSelectedIndex();
        dts1.setTurno((String) cboturnos.getItemAt(selecturno));

        int estado = cboestado.getSelectedIndex();
        dts1.setEstado((String) cboestado.getItemAt(estado));

        int trabajador = cboempleados.getSelectedIndex();
        dts1.setEmpleado((String) cboempleados.getItemAt(trabajador));

        dts1.setNumero_turno(Integer.parseInt(txtnumero_turno.getText()));

        if (accion.equals("guardar")) {
            if (func1.insertar(dts1)) {
                // Turno registrado
            }
        }

        try {
            Fempleadop func = new Fempleadop();

            // Obtener el usuario y contraseña ingresados
            String login = txtusuario.getText();
            String password = txtpassword.getText();

            Dempleadop empleado = func.login(login, password);

            if (empleado != null) {
                Jmenuparqueadero.sesionIniciada = true; // Cambiar el estado de la sesión

                this.dispose();

                // Establecer los valores en Jmenuhotel
                Jmenuparqueadero.actualizarDatosUsuario1(
                    txtfecha_hora_inicio.getText(),
                    (String) cboturnos.getItemAt(selecturno),
                    (String) cboempleados.getItemAt(trabajador),
                    (String) cboestado.getItemAt(estado)
                );

                // Mostrar Jsalidaturno solo si la sesión ya estaba iniciada
                if (Jmenuparqueadero.sesionIniciada) {
                    Jfinturnop form = new Jfinturnop();
                    form.toFront();
                    form.setVisible(false);
                    form.actualizarTurno(
                        txtfecha_hora_inicio.getText(),
                        (String) cboturnos.getItemAt(selecturno)
                    );

                    //                    Jsalidaturno.txtempleado.setText(empleado.getNombres() + " " + empleado.getApellidos());
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Acceso Denegado", "Error de Login", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, "Ocurrió un error durante el login.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Jinicioturnop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ingresoTurnoActionPerformed

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
            java.util.logging.Logger.getLogger(Jinicioturnop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jinicioturnop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jinicioturnop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jinicioturnop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jinicioturnop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> cboempleados;
    private javax.swing.JComboBox<String> cboestado;
    private javax.swing.JComboBox<String> cboturnos;
    private javax.swing.JButton ingresoTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtfecha_hora_inicio;
    private javax.swing.JTextField txtnumero_turno;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
