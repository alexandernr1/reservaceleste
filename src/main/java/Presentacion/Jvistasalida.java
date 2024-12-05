package Presentacion;

import javax.swing.JFrame;
import Logica.Fsalida;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class Jvistasalida extends javax.swing.JFrame {

    public Jvistasalida() {
        initComponents();
        setTitle("REGISTRO DE SALIDAS");
        mostrar1("", "");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
         configurarTabla();
    }

    public void limpiarTabla(JTable tablalistadosalida) {
        DefaultTableModel model = (DefaultTableModel) tablalistadosalida.getModel();
        model.setRowCount(0);
    }

    private void configurarTabla() {
        // Aquí configuras el comportamiento y el estilo de la tabla
        tablalistadosalida.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablalistadosalida.setRowHeight(25); // Ajusta la altura de las filas
        tablalistadosalida.setRowMargin(5); // Espacio entre filas

        // Cambiar color del encabezado usando un renderer personalizado
        JTableHeader header = tablalistadosalida.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                cell.setBackground(new Color(135, 206, 235));
                cell.setForeground(Color.WHITE); // Texto blanco para encabezado
                cell.setFont(new Font("SansSerif", Font.BOLD, 14)); // Fuente personalizada
                return cell;
            }
        });

        // Establecer colores alternos en las filas
        tablalistadosalida.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Color de las filas alternas
                if (!isSelected) {
                    if (row % 2 == 0) {
                        cell.setBackground(Color.LIGHT_GRAY); // Filas pares
                    } else {
                        cell.setBackground(Color.WHITE); // Filas impares
                    }
                } else {
                    cell.setBackground(Color.CYAN); // Color para fila seleccionada
                }

                return cell;
            }
        });
    }

    void ocultar_columnas() {
        tablalistadosalida.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(2).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(3).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(3).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(3).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(4).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(4).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(4).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(5).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(5).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(5).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(8).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(8).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(8).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(9).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(9).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(9).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(13).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(13).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(13).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(16).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(16).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(16).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(17).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(17).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(17).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(25).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(25).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(25).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(26).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(26).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(26).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(27).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(27).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(27).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(28).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(28).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(28).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(29).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(29).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(29).setPreferredWidth(0);

        tablalistadosalida.getColumnModel().getColumn(33).setMaxWidth(0);
        tablalistadosalida.getColumnModel().getColumn(33).setMinWidth(0);
        tablalistadosalida.getColumnModel().getColumn(33).setPreferredWidth(0);

    }

    void mostrar1(String buscar, String turnoActivo) {
        try {
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            Fsalida func = new Fsalida();
            Object[] resultado = func.mostrarsalida(buscar, turnoActivo);
            DefaultTableModel modelo = (DefaultTableModel) resultado[0];
            int totalEfectivo = (int) resultado[1];
            int totalTarjeta = (int) resultado[2];
            int totalTransferencia = (int) resultado[3];

            tablalistadosalida.setModel(modelo);
            ocultar_columnas();
            lbltotalregistro.setText("Total Registros " + Integer.toString(func.totalregistros));

            txtTotalEfectivo.setText(formatoMiles.format(totalEfectivo));
            txtTotalTarjeta.setText(formatoMiles.format(totalTarjeta));
            txtTotalTransferencia.setText(formatoMiles.format(totalTransferencia));
            int total = totalEfectivo + totalTarjeta + totalTransferencia;
            txtTotal.setText(formatoMiles.format(total));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistadosalida = new javax.swing.JTable();
        lbltotalregistro = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        txtTotalEfectivo = new javax.swing.JTextField();
        txtTotalTarjeta = new javax.swing.JTextField();
        txtTotalTransferencia = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(244, 244, 244));

        jLabel4.setText("Buscar:");

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        tablalistadosalida.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tablalistadosalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombres", "Apellidos", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19", "Title 20", "Title 21", "Title 22", "Title 23"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablalistadosalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadosalidaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablalistadosalidaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistadosalida);

        lbltotalregistro.setText("Total registro");

        btnbuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnbuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        txtTotalEfectivo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txtTotalTarjeta.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txtTotalTransferencia.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txtTotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Total Efectivo:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Total Tarjeta:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Total Transferencia:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Total:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbuscar)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalregistro)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTotalEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTotalTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTotalTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltotalregistro))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablalistadosalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadosalidaMouseClicked


    }//GEN-LAST:event_tablalistadosalidaMouseClicked

    private void tablalistadosalidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadosalidaMousePressed

    }//GEN-LAST:event_tablalistadosalidaMousePressed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        String turnoActivo = "turnoActivo"; // Reemplaza con el valor real del turno activo
        mostrar1(txtbuscar.getText(), turnoActivo);
    }//GEN-LAST:event_btnbuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Jvistasalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jvistasalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jvistasalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jvistasalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Jvistasalida().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistro;
    private javax.swing.JTable tablalistadosalida;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalEfectivo;
    private javax.swing.JTextField txtTotalTarjeta;
    private javax.swing.JTextField txtTotalTransferencia;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
