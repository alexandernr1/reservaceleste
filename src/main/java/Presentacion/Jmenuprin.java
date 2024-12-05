package Presentacion;

import Logica.Cconexion;
import LogicaP.Cconexionp;
import PresentacionP.Jmenuparqueadero;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;

public class Jmenuprin extends javax.swing.JFrame {

    public static Boolean sesionIniciada = false;
    private LoguinDeAdmin Javanzado;
    private Jmenuhotel menuhotel;

    public Jmenuprin() {

        initComponents();
        setLocationRelativeTo(null);
//        setTitle("SISTEMA SIHOMULTISERV");

        setLocationRelativeTo(this);
        inhabilitar();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        setVisible(true);

    }

    static void inhabilitar() {
        lblidpersona.setVisible(false);
        lblnombres.setVisible(false);
        lblapellidos.setVisible(false);
        lblacceso.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        lblnombres = new javax.swing.JLabel();
        lblapellidos = new javax.swing.JLabel();
        lblacceso = new javax.swing.JLabel();
        lblidpersona = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnhotel = new javax.swing.JMenuItem();
        btnparqueadero = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(204, 204, 204));
        escritorio.setLayout(new java.awt.BorderLayout());

        lblnombres.setText("nombres");
        escritorio.add(lblnombres, java.awt.BorderLayout.LINE_START);

        lblapellidos.setText("apellidos");
        escritorio.add(lblapellidos, java.awt.BorderLayout.PAGE_START);

        lblacceso.setText("acceso");
        escritorio.add(lblacceso, java.awt.BorderLayout.PAGE_END);

        lblidpersona.setText("idpersona");
        escritorio.add(lblidpersona, java.awt.BorderLayout.LINE_END);

        jMenuBar1.setBackground(new java.awt.Color(0, 204, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu1.setBackground(new java.awt.Color(0, 204, 204));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Inicio.png"))); // NOI18N
        jMenu1.setText("MENU PRINCIPAL");

        btnhotel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hotel.png"))); // NOI18N
        btnhotel.setText("HOTEL");
        btnhotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhotelActionPerformed(evt);
            }
        });
        jMenu1.add(btnhotel);

        btnparqueadero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estacionamiento.png"))); // NOI18N
        btnparqueadero.setText("PARQUEADERO");
        btnparqueadero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnparqueaderoActionPerformed(evt);
            }
        });
        jMenu1.add(btnparqueadero);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lavadora.png"))); // NOI18N
        jMenuItem3.setText("LAVANDERIA");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/restaurante.png"))); // NOI18N
        jMenuItem4.setText("RESTAURANTE");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Configuraciones.png"))); // NOI18N
        jMenu2.setText("CONFIGURACIÓN");

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/datosmaestros.png"))); // NOI18N
        jMenuItem5.setText("DATOS MESTROS");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ayuda.png"))); // NOI18N
        jMenuItem6.setText("AYUDA");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Javanzado = new LoguinDeAdmin();
        Javanzado.toFront();
        Javanzado.setVisible(true);
        sesionIniciada = true;
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void btnhotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhotelActionPerformed
        // TODO add your handling code here:
        Jmenuhotel form = Jmenuhotel.getInstance();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
  // Conectar a la base de datos del parquedero
    Cconexion conexionHotel = new Cconexion();
    Connection conHotel = conexionHotel.establecerConexion();
    
    if (conHotel != null) {
        System.out.println("Conectado a la base de datos del parquedero");
    } else {
        System.out.println("Error al conectar a la base de datos del parquedero");
    }

    }//GEN-LAST:event_btnhotelActionPerformed

    private void btnparqueaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnparqueaderoActionPerformed
       // Mostrar la interfaz del parquedero
    Jmenuparqueadero form = new Jmenuparqueadero();
    escritorio.add(form);
    form.toFront();
    form.setVisible(true);

    // Conectar a la base de datos del parquedero
    Cconexionp conexionParquedero = new Cconexionp();
    Connection conParquedero = conexionParquedero.establecerConexion();
    
    if (conParquedero != null) {
        System.out.println("Conectado a la base de datos del parquedero");
    } else {
        System.out.println("Error al conectar a la base de datos del parquedero");
    }
    }//GEN-LAST:event_btnparqueaderoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Jmenuprin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnhotel;
    private javax.swing.JMenuItem btnparqueadero;
    private javax.swing.JPanel escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    public static javax.swing.JLabel lblacceso;
    public static javax.swing.JLabel lblapellidos;
    public static javax.swing.JLabel lblidpersona;
    public static javax.swing.JLabel lblnombres;
    // End of variables declaration//GEN-END:variables
}
