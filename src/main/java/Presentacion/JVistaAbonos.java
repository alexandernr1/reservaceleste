
package Presentacion;

import Logica.Fabonos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class JVistaAbonos extends javax.swing.JFrame {

    
    public JVistaAbonos() {
        initComponents();
         setLocationRelativeTo(null);
        this.setTitle("LISTA DE ABONOS");
        this.setLocationRelativeTo(null);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         mostrar("", "");
         configurarTabla();
    }
   private void configurarTabla() {
    // Aquí configuras el comportamiento y el estilo de la tabla
    tablalistadosabonos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); 
    tablalistadosabonos.setRowHeight(25); // Ajusta la altura de las filas
    tablalistadosabonos.setRowMargin(5); // Espacio entre filas
    
       // Cambiar color del encabezado usando un renderer personalizado
        JTableHeader header = tablalistadosabonos.getTableHeader();
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
        tablalistadosabonos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        tablalistadosabonos.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(2).setPreferredWidth(0);

      
    }

    public void mostrar(String buscar, String turnoActivo) {
        NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
       try {
        Fabonos func = new Fabonos();
        Object[] resultado = func.mostrarVistaAbono(buscar, turnoActivo);
        DefaultTableModel modelo = (DefaultTableModel) resultado[0];
        int totalEfectivo = (int) resultado[1];
        int totalTarjeta = (int) resultado[2];
        int totalTransferencia = (int) resultado[3];

        tablalistadosabonos.setModel(modelo);
        ocultar_columnas();
        lbltotalregistros.setText("Total Pagos: " + Integer.toString(func.totalregistros));
        
        // Assuming you have JTextFields named txtTotalEfectivo, txtTotalTarjeta, txtTotalTransferencia
        txtTotalEfectivo.setText(formatoMiles.format(totalEfectivo));
        txtTotalTarjeta.setText(formatoMiles.format(totalTarjeta));
        txtTotalTransferencia.setText(formatoMiles.format(totalTransferencia));
        int total = totalEfectivo + totalTarjeta +  totalTransferencia;
        txtTotal.setText(formatoMiles.format(total));

    } catch (Exception e) {
        JOptionPane.showConfirmDialog(rootPane, e);
    }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btneliminar21 = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        txtTotalEfectivo = new javax.swing.JTextField();
        txtTotalTransferencia = new javax.swing.JTextField();
        txtTotalTarjeta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane28 = new javax.swing.JScrollPane();
        tablalistadosabonos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 14, 117, -1));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBuscar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 13, -1, -1));

        btneliminar21.setBackground(new java.awt.Color(204, 204, 204));
        btneliminar21.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btneliminar21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btneliminar21.setText("Eliminar");
        btneliminar21.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btneliminar21.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btneliminar21.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btneliminar21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar21ActionPerformed(evt);
            }
        });
        jPanel1.add(btneliminar21, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 13, -1, -1));

        lbltotalregistros.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbltotalregistros.setText("Registros");
        jPanel1.add(lbltotalregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 17, 109, -1));

        txtTotalEfectivo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jPanel1.add(txtTotalEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 14, 86, -1));

        txtTotalTransferencia.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jPanel1.add(txtTotalTransferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(812, 14, 85, -1));

        txtTotalTarjeta.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jPanel1.add(txtTotalTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 14, 89, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Total Efectivo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 17, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Total Tarjeta:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 17, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Total Transferencia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(692, 17, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Total:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(903, 17, -1, -1));

        txtTotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 14, -1, -1));

        tablalistadosabonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15"
            }
        ));
        jScrollPane28.setViewportView(tablalistadosabonos);

        jScrollPane1.setViewportView(jScrollPane28);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String turnoActivo = "turnoActivo"; // Reemplaza con el valor real del turno activo
        mostrar(txtBuscar.getText(), turnoActivo);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btneliminar21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar21ActionPerformed

    }//GEN-LAST:event_btneliminar21ActionPerformed

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
            java.util.logging.Logger.getLogger(JVistaAbonos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JVistaAbonos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JVistaAbonos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JVistaAbonos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JVistaAbonos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btneliminar21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablalistadosabonos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalEfectivo;
    private javax.swing.JTextField txtTotalTarjeta;
    private javax.swing.JTextField txtTotalTransferencia;
    // End of variables declaration//GEN-END:variables
}
