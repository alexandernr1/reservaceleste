package Presentacion;

import Datos.Dabono;
import Datos.Dfactura_electronica;
import Datos.Dinicioturno;
import Datos.Tiempopro;
import Impresion.ImpresionAbono;
import Logica.Cconexion;
import Logica.Fabonos;
import Logica.Fsalida;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Jabono extends javax.swing.JFrame {

    private static Jabono instance;
    Tiempopro time = new Tiempopro();

    public Jabono() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("ABONOS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mostrar("");
        configurarTabla();
        inhabilitar();
        mostrarTiempo();
        agregarWindowFocusListener();
        clientesVarios();
        iniciosenceros();

    }
    private String accion = "guardar";

    public static Jabono getInstance() {
        if (instance == null) {
            instance = new Jabono();
        }
        return instance;
    }

    private void iniciosenceros() {

        txtnumeronoches.setText("0");
        txtvalordescuento.setText("0");
        txtcostoalojamiento.setText("0");
        txtabonohabitacion.setText("0");
        txtdescuentos.setText("0");
        txtotroscobros.setText("0");
        txtcolchonadi.setText("");
        txtsubtotal.setText("");
        txtbruto.setText("0");
        txtIVA_19.setText("0");
        txtreten_35.setText("0");
        txtreten4.setText("0");
        txtefectivo.setText("0");
        txttarjeta.setText("0");
        txttransferencia.setText("0");
        txtparqueadero.setText("0");
        txtlavanderia.setText("0");
        txtcolchonadi.setText("0");
    }

    private void clientesVarios() {
        txtrazon_social.setText("Clientes Varios");
        txtdocumento.setText("22222");
        txtemail.setText("ClietesVarios@clientes.com");
    }

    public void generarnumero() {
        Fabonos func = new Fabonos();
        int numero = func.generarComprobante();
        txtnumcomprobante.setText(String.valueOf(numero));
    }

    private void mostrarTiempo() {

        txtfecha_abono.setText(time.getFechacomp());
    }

    private void mostrarnumeroturno() {
        Fsalida func = new Fsalida();
        Dinicioturno numeroturno = func.numeroturno();

        txtnumero_turno.setText(String.valueOf(numeroturno.getNumeroTurno()));
        txtidinicioturno.setText(String.valueOf(numeroturno.getIdInicioTurno()));
    }

    private void agregarWindowFocusListener() {
        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                mostrarnumeroturno();  // Actualiza el número de turno cuando la ventana recibe el foco
                generarnumero();
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                // No hacer nada cuando la ventana pierde el foco
            }
        });
    }

    public void limpiarTabla(JTable tablalistadosabonos) {
        DefaultTableModel model = (DefaultTableModel) tablalistadosabonos.getModel();
        model.setRowCount(0);
    }

    private void imprimir() {
        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Deseas imprimir?", "Confirmar", 2);

        if (confirmacion == 0) {

            ImpresionAbono imprimir = new ImpresionAbono();
            try {
                try {
                    imprimir.ImprimirFacturaAbono();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Jabono.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Jabono.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (IOException ex) {
                Logger.getLogger(Jabono.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

        tablalistadosabonos.getColumnModel().getColumn(4).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(4).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(4).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(10).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(10).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(10).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(12).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(12).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(12).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(13).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(13).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(13).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(15).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(15).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(15).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(16).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(16).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(16).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(17).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(17).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(17).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(18).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(18).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(18).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(19).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(19).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(19).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(21).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(21).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(21).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(22).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(22).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(22).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(23).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(23).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(23).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(24).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(24).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(24).setPreferredWidth(0);

        tablalistadosabonos.getColumnModel().getColumn(25).setMaxWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(25).setMinWidth(0);
        tablalistadosabonos.getColumnModel().getColumn(25).setPreferredWidth(0);

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

    public void limpiarcajas() {
        txtnumero.setText("");
        txtcliente.setText("");
        txtclientenu.setText("");
        cajanumero.setText("");
        txtrazon_social.setText("");
        txtdocumento.setText("");
        txtemail.setText("");
        txtcostoalojamiento.setText("");
        txtnumeronoches.setText("");
        txtvalordescuento.setText("");
        txtbruto.setText("");
        txtefectivo.setText("");
        txttarjeta.setText("");
        txttransferencia.setText("");
        txtIVA_19.setText("");
        txtreten4.setText("");
        txtreten_35.setText("");
        txtbruto.setText("");
        txtabonohabitacion.setText("");
        txtdescuentos.setText("");
        txtconcepto.setText("");
        txttotalapagar.setText("");
        cboprivilegiosadmon.setSelectedItem("Seleccionar");
        cboprivilegiosrecep.setSelectedItem("Seleccionar");
        txtotroscobros.setText("");
        txtcolchonadi.setText("");
    }

    private void inhabilitar() {
        txtidabono.setVisible(false);
        txtidingreso.setVisible(false);
        txtidhabitacion.setVisible(false);
//        txtidcliente.setVisible(false);

    }

    private void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            Fabonos func = new Fabonos();
            modelo = func.mostrar(buscar);

            tablalistadosabonos.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Pagos " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtcliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtclientenu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cajanumero = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtnumero_turno = new javax.swing.JTextField();
        txtfecha_abono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtidcliente = new javax.swing.JTextField();
        txtidabono = new javax.swing.JTextField();
        txtidhabitacion = new javax.swing.JTextField();
        txtidingreso = new javax.swing.JTextField();
        txtidinicioturno = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtdocumento = new javax.swing.JTextField();
        txtrazon_social = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtdescuentos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtotroscobros = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txttotalapagar = new javax.swing.JTextField();
        txtabonohabitacion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtefectivo = new javax.swing.JTextField();
        txttarjeta = new javax.swing.JTextField();
        txttransferencia = new javax.swing.JTextField();
        txtvalordescuento = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtcolchonadi = new javax.swing.JTextField();
        txtIVA_19 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtreten4 = new javax.swing.JTextField();
        txtreten_35 = new javax.swing.JTextField();
        calcular35 = new javax.swing.JButton();
        calcular4 = new javax.swing.JButton();
        txtsubtotal = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtcostoalojamiento = new javax.swing.JTextField();
        txtnumeronoches = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtbruto = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtlavanderia = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtparqueadero = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtvalorbruto = new javax.swing.JTextField();
        cboprivilegiosadmon = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboprivilegiosrecep = new javax.swing.JComboBox<>();
        txtconcepto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtnumcomprobante = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablalistadosabonos = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        cbotipocomprobante = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        lbturno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL HUESPED", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 14))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        txtcliente.setEditable(false);
        txtcliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Cliente:");

        txtclientenu.setEditable(false);
        txtclientenu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Idenficación:");

        txtnumero.setEditable(false);
        txtnumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("N° Habitación:");

        cajanumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajanumeroActionPerformed(evt);
            }
        });
        cajanumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cajanumeroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajanumeroKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Buscar Hbit");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Numero Turno:");

        txtnumero_turno.setEditable(false);
        txtnumero_turno.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtnumero_turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumero_turnoActionPerformed(evt);
            }
        });

        txtfecha_abono.setEditable(false);
        txtfecha_abono.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Fecha:");

        txtidcliente.setText("IDC");

        txtidabono.setText("IDA");
        txtidabono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidabonoActionPerformed(evt);
            }
        });

        txtidhabitacion.setText("IDH");

        txtidingreso.setText("IDI");

        txtidinicioturno.setText("IDIT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtclientenu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtidabono, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtidingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtidinicioturno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajanumero, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnumero_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfecha_abono, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajanumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(txtnumero_turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtfecha_abono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtclientenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidabono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidinicioturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE FACTURA ELECTRONICA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 14))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("NIT/C.C:");

        txtdocumento.setEditable(false);
        txtdocumento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtdocumento.setText(" ");
        txtdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocumentoActionPerformed(evt);
            }
        });

        txtrazon_social.setEditable(false);
        txtrazon_social.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtrazon_social.setText(" ");
        txtrazon_social.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrazon_socialActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("Cliente:");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Correo:");

        txtemail.setEditable(false);
        txtemail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtemail.setText(" ");
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrazon_social, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtrazon_social, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ABONOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 14))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Abono Habitación:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Descuentos:");

        txtdescuentos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtdescuentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescuentosActionPerformed(evt);
            }
        });
        txtdescuentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescuentosKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Otros cobros:");

        txtotroscobros.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtotroscobros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtotroscobrosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("total apagar:");

        txttotalapagar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txttotalapagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttotalapagarKeyPressed(evt);
            }
        });

        txtabonohabitacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtabonohabitacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtabonohabitacionKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Efectivo:");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("Tarjeta:");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("Ttransferencia:");

        txtefectivo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtefectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtefectivoKeyPressed(evt);
            }
        });

        txttarjeta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txttarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttarjetaKeyPressed(evt);
            }
        });

        txttransferencia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txttransferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttransferenciaKeyPressed(evt);
            }
        });

        txtvalordescuento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setText("valor descuento:");

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("Colchon Adi:");

        txtcolchonadi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtcolchonadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcolchonadiActionPerformed(evt);
            }
        });
        txtcolchonadi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcolchonadiKeyPressed(evt);
            }
        });

        txtIVA_19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtIVA_19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIVA_19ActionPerformed(evt);
            }
        });
        txtIVA_19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIVA_19KeyPressed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setText("IVA(19.00%):");

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setText("Descuento Reten (3.5%):");

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setText("Descuento Reten (4%):");

        txtreten4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtreten4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtreten4ActionPerformed(evt);
            }
        });
        txtreten4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtreten4KeyPressed(evt);
            }
        });

        txtreten_35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtreten_35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtreten_35ActionPerformed(evt);
            }
        });
        txtreten_35.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtreten_35KeyPressed(evt);
            }
        });

        calcular35.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        calcular35.setText("Calcular");
        calcular35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcular35ActionPerformed(evt);
            }
        });

        calcular4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        calcular4.setText("Calcular");
        calcular4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcular4ActionPerformed(evt);
            }
        });

        txtsubtotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtsubtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsubtotalKeyPressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("Subtotal:");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("Costo Alojamiento:");

        txtcostoalojamiento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        txtnumeronoches.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtnumeronoches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeronochesActionPerformed(evt);
            }
        });
        txtnumeronoches.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnumeronochesKeyPressed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setText("# Noches:");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtbruto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel30.setText("Valor antes de IVA:");

        txtlavanderia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlavanderiaActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel31.setText("Lavandería:");

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel32.setText("Parqueadero:");

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel33.setText("Total:");

        txtvalorbruto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtvalorbruto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalorbrutoActionPerformed(evt);
            }
        });
        txtvalorbruto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtvalorbrutoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtvalorbruto, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(txtcolchonadi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(txtvalordescuento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtdescuentos, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(txtotroscobros)
                                    .addComponent(txtabonohabitacion)
                                    .addComponent(txtlavanderia)
                                    .addComponent(txtparqueadero)
                                    .addComponent(txtcostoalojamiento))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnumeronoches, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(jLabel30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtreten_35, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(txtreten4)
                            .addComponent(txtsubtotal)
                            .addComponent(txtefectivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calcular35)
                            .addComponent(calcular4)))
                    .addComponent(txttarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotalapagar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtbruto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIVA_19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtnumeronoches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIVA_19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtvalordescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtreten_35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calcular35)
                            .addComponent(txtcostoalojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtreten4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calcular4)
                            .addComponent(txtabonohabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtsubtotal)
                            .addComponent(txtdescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtefectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtotroscobros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txttarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtlavanderia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txttransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtparqueadero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtcolchonadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txttotalapagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtvalorbruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)))))
        );

        cboprivilegiosadmon.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cboprivilegiosadmon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Negociar descuentos por volumen.", "Adicion de cama a habitacion." }));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("privilegios recepcion:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("privilegios de admon:");

        cboprivilegiosrecep.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cboprivilegiosrecep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Ninguno" }));

        txtconcepto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Concepto del descuento");

        txtnumcomprobante.setEditable(false);
        txtnumcomprobante.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtnumcomprobante.setText(" ");
        txtnumcomprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumcomprobanteActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setText("N° Comprobante: ");

        btnnuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnnuevo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista-de-verificacion.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnuevo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(204, 204, 204));
        btnguardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnimprimir.setBackground(new java.awt.Color(204, 204, 204));
        btnimprimir.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/facturacion.png"))); // NOI18N
        btnimprimir.setText("Inprimir");
        btnimprimir.setEnabled(false);
        btnimprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnimprimir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnimprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        tablalistadosabonos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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
        tablalistadosabonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadosabonosMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tablalistadosabonos);

        jScrollPane1.setViewportView(jScrollPane7);

        btnbuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnbuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnbuscar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnbuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(204, 204, 204));
        btneliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btneliminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btneliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        lbltotalregistros.setText("Registros");

        cbotipocomprobante.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbotipocomprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Recibo", "Factura", "Otros" }));

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setText("Tipo Comprobante:");

        lbturno.setText("turno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnbuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btneliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbturno, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtconcepto, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbotipocomprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtnumcomprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(142, 142, 142))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(cboprivilegiosrecep, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cboprivilegiosadmon, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnnuevo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnguardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnimprimir)
                                .addGap(73, 73, 73))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cboprivilegiosadmon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboprivilegiosrecep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel28)
                        .addComponent(cbotipocomprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29)
                        .addComponent(txtnumcomprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnimprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscar)
                            .addComponent(btneliminar)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltotalregistros)
                            .addComponent(lbturno))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablalistadosabonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadosabonosMouseClicked

        btnguardar.setText("Editar");
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistadosabonos.rowAtPoint(evt.getPoint());
        txtidabono.setText(tablalistadosabonos.getValueAt(fila, 0).toString());
        txtidingreso.setText(tablalistadosabonos.getValueAt(fila, 1).toString());
        txtidhabitacion.setText(tablalistadosabonos.getValueAt(fila, 2).toString());
        txtnumero.setText(tablalistadosabonos.getValueAt(fila, 3).toString());
        txtidcliente.setText(tablalistadosabonos.getValueAt(fila, 4).toString());
        txtcliente.setText(tablalistadosabonos.getValueAt(fila, 5).toString());
        txtclientenu.setText(tablalistadosabonos.getValueAt(fila, 6).toString());
        txtfecha_abono.setText(tablalistadosabonos.getValueAt(fila, 7).toString());
        txtabonohabitacion.setText(tablalistadosabonos.getValueAt(fila, 8).toString());
        txtdescuentos.setText(tablalistadosabonos.getValueAt(fila, 9).toString());
        txtconcepto.setText(tablalistadosabonos.getValueAt(fila, 10).toString());
//        txttotalapagar.setText(tablalistadosabonos.getValueAt(fila, 11).toString());
        cboprivilegiosadmon.setSelectedItem(tablalistadosabonos.getValueAt(fila, 12).toString());
        cboprivilegiosrecep.setSelectedItem(tablalistadosabonos.getValueAt(fila, 13).toString());
        txtotroscobros.setText(tablalistadosabonos.getValueAt(fila, 14).toString());
        txtnumero_turno.setText(tablalistadosabonos.getValueAt(fila, 15).toString());
        txtdocumento.setText(tablalistadosabonos.getValueAt(fila, 16).toString());
        txtrazon_social.setText(tablalistadosabonos.getValueAt(fila, 17).toString());
        txtemail.setText(tablalistadosabonos.getValueAt(fila, 18).toString());
        txtnumeronoches.setText(tablalistadosabonos.getValueAt(fila, 19).toString());
        txtvalordescuento.setText(tablalistadosabonos.getValueAt(fila, 20).toString());
        cbotipocomprobante.setSelectedItem(tablalistadosabonos.getValueAt(fila, 21).toString());
//        txtnumcomprobante.setText(tablalistadosabonos.getValueAt(fila, 22).toString());
        txtIVA_19.setText(tablalistadosabonos.getValueAt(fila, 23).toString());
        txtreten_35.setText(tablalistadosabonos.getValueAt(fila, 24).toString());
        txtreten4.setText(tablalistadosabonos.getValueAt(fila, 25).toString());
        txtsubtotal.setText(tablalistadosabonos.getValueAt(fila, 26).toString());
        txtefectivo.setText(tablalistadosabonos.getValueAt(fila, 27).toString());
        txttarjeta.setText(tablalistadosabonos.getValueAt(fila, 28).toString());
        txttransferencia.setText(tablalistadosabonos.getValueAt(fila, 29).toString());
        txttotalapagar.setText(tablalistadosabonos.getValueAt(fila, 30).toString());
        txtcolchonadi.setText(tablalistadosabonos.getValueAt(fila, 31).toString());
        txtbruto.setText(tablalistadosabonos.getValueAt(fila, 32).toString());
        txtparqueadero.setText(tablalistadosabonos.getValueAt(fila, 33).toString());
        txtlavanderia.setText(tablalistadosabonos.getValueAt(fila, 34).toString());
        txtcolchonadi.setText(tablalistadosabonos.getValueAt(fila, 35).toString());

    }//GEN-LAST:event_tablalistadosabonosMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        if (!txtidabono.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el abono seleccionado?", "Confirmar", 2);

            if (confirmacion == 0) {
                Fabonos func = new Fabonos();
                Dabono dts = new Dabono();

                dts.setIdabono(Integer.parseInt(txtidabono.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtidabonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidabonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidabonoActionPerformed

    private void txtnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroActionPerformed

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed

        limpiarcajas();
        iniciosenceros();
        mostrarTiempo();
        clientesVarios();
        btnguardar.setText("Guardar");
        accion = "guardar";


    }//GEN-LAST:event_btnnuevoActionPerformed

    private void cajanumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajanumeroKeyPressed

        NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cconexion conexion = new Cconexion();

            try ( Connection conectar = conexion.establecerConexion()) {
                String consultaSQL = "SELECT i.idingreso, i.idhabitacion, h.numero,i.costoalojamiento, i.idcliente, "
                        + "(SELECT nombres FROM cliente WHERE idcliente = i.idcliente) AS clienten, "
                        + "(SELECT apellidos FROM cliente WHERE idcliente = i.idcliente) AS clienteap, "
                        + "(SELECT numdocumento FROM cliente WHERE idcliente = i.idcliente) AS clientenu "
                        + "FROM ingreso i "
                        + "INNER JOIN habitacion h ON i.idhabitacion = h.idhabitacion "
                        + "WHERE h.numero = ? AND i.estado = 'Activo'";

                try ( PreparedStatement pst = conectar.prepareStatement(consultaSQL)) {
                    pst.setString(1, cajanumero.getText());

                    try ( ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            // Mostrar datos en los JTextField correspondientes
                            txtidingreso.setText(String.valueOf(rs.getInt("idingreso")));
                            txtidhabitacion.setText(String.valueOf(rs.getInt("idhabitacion")));
                            txtidcliente.setText(String.valueOf(rs.getInt("idcliente")));
                            txtcliente.setText(rs.getString("clienten") + " " + rs.getString("clienteap"));
                            txtcostoalojamiento.setText(formatoMiles.format(rs.getInt("costoalojamiento")));
                            txtnumero.setText(String.valueOf(rs.getInt("numero")));
                            txtclientenu.setText(String.valueOf(rs.getString("clientenu")));

                            int factura = Integer.parseInt(txtidcliente.getText());
                            Dfactura_electronica clienteF = new Fsalida().cleinteFacturar(factura);
                            if (clienteF != null) {
                                txtrazon_social.setText(clienteF.getRazon_social());
                                txtemail.setText(clienteF.getEmail());
                                txtdocumento.setText(String.valueOf(clienteF.getDocumento()));
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró el CLIENTE solicitado.");
                        }
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_cajanumeroKeyPressed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        mostrar(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtnumero_turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumero_turnoActionPerformed
        // Generar el número de turno
    }//GEN-LAST:event_txtnumero_turnoActionPerformed

    private void txtdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdocumentoActionPerformed

    private void txtrazon_socialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrazon_socialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrazon_socialActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void cajanumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajanumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajanumeroActionPerformed

    private void txtIVA_19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIVA_19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIVA_19ActionPerformed

    private void txtIVA_19KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIVA_19KeyPressed
        // TODO add your handling code here:
        NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                int costoalojamiento = Integer.parseInt(txtcolchonadi.getText().replace(",", ""));
//                int numeronoches = Integer.parseInt(txtnumeronoches.getText());

                int valorsinIVA = (int) (costoalojamiento / 1.19);

                txtbruto.setText(formatoMiles.format(valorsinIVA));
                int valorConIVA = (int) (valorsinIVA * 0.19);
                txtIVA_19.setText(formatoMiles.format(valorConIVA));
                // Obtener los valores de los campos de texto y convertirlos a enteros
                int valosiIVA = Integer.parseInt(txtbruto.getText().replace(",", ""));
                int Iva19 = Integer.parseInt(txtIVA_19.getText().replace(",", ""));
                int reten35 = Integer.parseInt(txtreten_35.getText().replace(",", ""));
                int reten4 = Integer.parseInt(txtreten4.getText().replace(",", ""));

                int subtotal = valosiIVA + Iva19 - reten35 - reten4 + 1;
//                int subtotalRedondeado = Math.round((float) subtotal);
                int subtotalRedondeado = (int) (Math.ceil(subtotal / 100.0) * 100);
                txtsubtotal.setText(formatoMiles.format(subtotalRedondeado));

            } catch (NumberFormatException e) {

            }

        }

    }//GEN-LAST:event_txtIVA_19KeyPressed

    private void txtreten4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreten4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreten4ActionPerformed

    private void txtreten4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtreten4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreten4KeyPressed

    private void txtreten_35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreten_35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreten_35ActionPerformed

    private void txtreten_35KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtreten_35KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreten_35KeyPressed

    private void calcular35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcular35ActionPerformed
        // TODO add your handling code here:
        NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
        int costoalojamiento = Integer.parseInt(txtcostoalojamiento.getText().replace(",", ""));
        int numeronoches = Integer.parseInt(txtnumeronoches.getText().replace(",", ""));

        int valorsinIVA = (int) (costoalojamiento * numeronoches / 1.19);

        int Reten35 = (int) (valorsinIVA * 0.035);
        txtreten_35.setText(formatoMiles.format(Reten35));
    }//GEN-LAST:event_calcular35ActionPerformed

    private void calcular4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcular4ActionPerformed
        // TODO add your handling code here:
        NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
        int costoalojamiento = Integer.parseInt(txtcostoalojamiento.getText().replace(",", ""));
        int numeronoches = Integer.parseInt(txtnumeronoches.getText().replace(",", ""));

        int valorsinIVA = (int) (costoalojamiento * numeronoches / 1.19);
        int reten4 = (int) (valorsinIVA * 0.04);
        txtreten4.setText(formatoMiles.format(reten4));
    }//GEN-LAST:event_calcular4ActionPerformed

    private void txtsubtotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsubtotalKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            try {
                // Obtener los valores de los campos de texto y convertirlos a enteros
                int valosiIVA = Integer.parseInt(txtbruto.getText().replace(",", ""));
                int Iva19 = Integer.parseInt(txtIVA_19.getText().replace(",", ""));
                int reten35 = Integer.parseInt(txtreten_35.getText().replace(",", ""));
                int reten4 = Integer.parseInt(txtreten4.getText().replace(",", ""));

                int subtotal = valosiIVA + Iva19 - reten35 - reten4 + 1;
                // Redondea al múltiplo de 1000 más cercano
//                int subtotalRedondeado = ((subtotal + 500) / 1000) * 1000;
//                int subtotalRedondeado = Math.round((float) subtotal);
                int subtotalRedondeado = (int) (Math.ceil(subtotal / 100.0) * 100);

                txtsubtotal.setText(formatoMiles.format(subtotalRedondeado));

            } catch (NumberFormatException e) {

            }

        }

    }//GEN-LAST:event_txtsubtotalKeyPressed

    private void txtnumeronochesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeronochesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeronochesActionPerformed

    private void txtotroscobrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtotroscobrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtotroscobrosActionPerformed

    private void txtdescuentosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescuentosKeyPressed

    }//GEN-LAST:event_txtdescuentosKeyPressed

    private void txtdescuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescuentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescuentosActionPerformed

    private void txtnumcomprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumcomprobanteActionPerformed

    }//GEN-LAST:event_txtnumcomprobanteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
        try {
            int costoalojamiento = Integer.parseInt(txtvalorbruto.getText().replace(",", ""));
//                int numeronoches = Integer.parseInt(txtnumeronoches.getText());

            int valorsinIVA = (int) (costoalojamiento / 1.19);

            txtbruto.setText(formatoMiles.format(valorsinIVA));
            int valorConIVA = (int) (valorsinIVA * 0.19);
            txtIVA_19.setText(formatoMiles.format(valorConIVA));
            // Obtener los valores de los campos de texto y convertirlos a enteros
            int valosiIVA = Integer.parseInt(txtbruto.getText().replace(",", ""));
            int Iva19 = Integer.parseInt(txtIVA_19.getText().replace(",", ""));
            int reten35 = Integer.parseInt(txtreten_35.getText().replace(",", ""));
            int reten4 = Integer.parseInt(txtreten4.getText().replace(",", ""));

            int subtotal = valosiIVA + Iva19 - reten35 - reten4 + 1;
//            int subtotalRedondeado = Math.round((float) subtotal);
            int subtotalRedondeado = (int) (Math.ceil(subtotal / 100.0) * 100);
            txtsubtotal.setText(formatoMiles.format(subtotalRedondeado));

        } catch (NumberFormatException e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcolchonadiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcolchonadiKeyPressed

    }//GEN-LAST:event_txtcolchonadiKeyPressed

    private void txtabonohabitacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtabonohabitacionKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtabonohabitacionKeyPressed

    private void txttotalapagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalapagarKeyPressed
        // TODO add your handling code here:
        NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                // Obtener los valores de los campos de texto y convertirlos a enteros
                int efectivo = Integer.parseInt(txtefectivo.getText().replace(",", ""));
                int tarjeta = Integer.parseInt(txttarjeta.getText().replace(",", ""));
                int transferencia = Integer.parseInt(txttransferencia.getText().replace(",", ""));

                int totalPago = efectivo + tarjeta + transferencia;
                txttotalapagar.setText(formatoMiles.format(totalPago));

            } catch (NumberFormatException e) {
                // Manejar la excepción si alguno de los campos de texto no contiene un número válido
                JOptionPane.showMessageDialog(null, "Error: uno o más campos no contienen un número válido");
            }

        }
    }//GEN-LAST:event_txttotalapagarKeyPressed

    private void txtcolchonadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcolchonadiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcolchonadiActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
        imprimir();

    }//GEN-LAST:event_btnimprimirActionPerformed

    private void txtnumeronochesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeronochesKeyPressed
//
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
//            try {
//                int costoalojamiento = Integer.parseInt(txtcostoalojamiento.getText().replace(",", ""));
//                int numeronoches = Integer.parseInt(txtnumeronoches.getText().replace(",", ""));
//                int valordescuento = Integer.parseInt(txtvalordescuento.getText().replace(",", ""));
//
//                // Validación adicional para evitar cálculos negativos
//                if (costoalojamiento < 0 || numeronoches < 0) {
//                    JOptionPane.showMessageDialog(null, "El número de noches y el valor del descuento deben ser positivos.");
//                    return;
//                }
//
//                int calculo = valordescuento * numeronoches;
//                int calculo1 = costoalojamiento * numeronoches;
//                txtabonohabitacion.setText(formatoMiles.format(calculo1));
//                txtdescuentos.setText(formatoMiles.format(calculo));
//
//                int nuevoabono = Integer.parseInt(txtabonohabitacion.getText().replace(",", ""));
//                int nuevodescuent = Integer.parseInt(txtdescuentos.getText().replace(",", ""));
//                int otroscobros = Integer.parseInt(txtotroscobros.getText().replace(",", ""));
//                int parqueadero = Integer.parseInt(txtparqueadero.getText().replace(",", ""));
//                int lavanderia = Integer.parseInt(txtlavanderia.getText().replace(",", ""));
//
//                int nuevocalculo = nuevoabono - nuevodescuent + otroscobros + parqueadero + lavanderia;
//                txt.setText(formatoMiles.format(nuevocalculo));
//
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "Por favor, ingresa números válidos.");
//            }
//        }
    }//GEN-LAST:event_txtnumeronochesKeyPressed

    private void cajanumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajanumeroKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cajanumeroKeyReleased

    private void txttransferenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttransferenciaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            try {
                // Obtener los valores de los campos de texto y convertirlos a enteros
                int efectivo = Integer.parseInt(txtefectivo.getText().replace(",", ""));
                int tarjeta = Integer.parseInt(txttarjeta.getText().replace(",", ""));
                int transferencia = Integer.parseInt(txttransferencia.getText().replace(",", ""));

                int totalPago = efectivo + tarjeta + transferencia;
                txttotalapagar.setText(formatoMiles.format(totalPago));

            } catch (NumberFormatException e) {
                // Manejar la excepción si alguno de los campos de texto no contiene un número válido
                JOptionPane.showMessageDialog(null, "Error: uno o más campos no contienen un número válido");
            }

        }
    }//GEN-LAST:event_txttransferenciaKeyPressed

    private void txttarjetaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttarjetaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            try {
                // Obtener los valores de los campos de texto y convertirlos a enteros
                int efectivo = Integer.parseInt(txtefectivo.getText().replace(",", ""));
                int tarjeta = Integer.parseInt(txttarjeta.getText().replace(",", ""));
                int transferencia = Integer.parseInt(txttransferencia.getText().replace(",", ""));

                int totalPago = efectivo + tarjeta + transferencia;
                txttotalapagar.setText(formatoMiles.format(totalPago));

            } catch (NumberFormatException e) {
                // Manejar la excepción si alguno de los campos de texto no contiene un número válido
                JOptionPane.showMessageDialog(null, "Error: uno o más campos no contienen un número válido");
            }

        }
    }//GEN-LAST:event_txttarjetaKeyPressed

    private void txtefectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtefectivoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            try {
                // Obtener los valores de los campos de texto y convertirlos a enteros
                int efectivo = Integer.parseInt(txtefectivo.getText().replace(",", ""));
                int tarjeta = Integer.parseInt(txttarjeta.getText().replace(",", ""));
                int transferencia = Integer.parseInt(txttransferencia.getText().replace(",", ""));

                int totalPago = efectivo + tarjeta + transferencia;
                txttotalapagar.setText(formatoMiles.format(totalPago));

            } catch (NumberFormatException e) {
                // Manejar la excepción si alguno de los campos de texto no contiene un número válido
                JOptionPane.showMessageDialog(null, "Error: uno o más campos no contienen un número válido");
            }

        }
    }//GEN-LAST:event_txtefectivoKeyPressed

    private void txtlavanderiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlavanderiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlavanderiaActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        if (cbotipocomprobante.getSelectedIndex() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Seleciona el tipo de comprobante");
            cbotipocomprobante.requestFocus();
            return;
        }
        if (txtcolchonadi.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "presiona enter para obtener el total en el cuadro");
            cbotipocomprobante.requestFocus();
            return;
        }
        if (txtsubtotal.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "presiona enter para obtener el subtotal en el cuadro");
            cbotipocomprobante.requestFocus();
            return;
        }
        if (txttotalapagar.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "presiona enter para obtener el total a pagar en el cuadro");
            cbotipocomprobante.requestFocus();
            return;
        }

        Dabono dts = new Dabono();
        Fabonos func = new Fabonos();

        // Establecer datos básicos
        dts.setIdingreso(Integer.parseInt(txtidingreso.getText()));
        dts.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
        dts.setIdcliente(Integer.parseInt(txtidcliente.getText()));
        dts.setFechaabono(txtfecha_abono.getText());

        // Establecer datos adicionales
        dts.setConceptodescuento(txtconcepto.getText());

        int abonohabitacion = Integer.parseInt(txtabonohabitacion.getText().replace(",", ""));
        dts.setAbonohabitacion(abonohabitacion);
        txtabonohabitacion.setText(String.valueOf(abonohabitacion));

        int seleccionadoAdmon = cboprivilegiosadmon.getSelectedIndex();
        int seleccionadoRecep = cboprivilegiosrecep.getSelectedIndex();
        dts.setPrivilegiosAdmon(String.valueOf(seleccionadoAdmon));
        dts.setPrivilegiosrecepcion(String.valueOf(seleccionadoRecep));

        int descuentos = Integer.parseInt(txtdescuentos.getText().replace(",", ""));
        dts.setDescuentos(String.valueOf(descuentos));
        txtdescuentos.setText(String.valueOf(descuentos));

        int totalAbonos = Integer.parseInt(txttotalapagar.getText().replace(",", ""));
        dts.setTotalAbonos(totalAbonos);
        txttotalapagar.setText(String.valueOf(totalAbonos));

        int otrosCobros = Integer.parseInt(txtotroscobros.getText().replace(",", ""));
        dts.setOtroscobros(otrosCobros);
        txtotroscobros.setText(String.valueOf(otrosCobros));

        dts.setNumero_turno(Integer.parseInt(txtnumero_turno.getText()));

        // Establecer los nuevos campos
        dts.setHabitacion(Integer.parseInt(txtnumero.getText()));
        dts.setCliente(txtcliente.getText());
        dts.setDocumento(txtdocumento.getText());
        dts.setRazon_social(txtrazon_social.getText());
        dts.setEmail(txtemail.getText()); // Asegúrate de que txtemail existe
        dts.setNumeronoches(Integer.parseInt(txtnumeronoches.getText()));
        dts.setValordescuento(Integer.parseInt(txtvalordescuento.getText().replace(",", "")));

        int tipocomprobante = cbotipocomprobante.getSelectedIndex();
        dts.setTipocomprobante((String) cbotipocomprobante.getItemAt(tipocomprobante));

        dts.setNumerocomprobante(txtnumcomprobante.getText());
        dts.setValor_bruto(Integer.parseInt(txtcolchonadi.getText().replace(",", "")));
        dts.setIva19(Integer.parseInt(txtIVA_19.getText().replace(",", "")));
        dts.setRetencion35(Integer.parseInt(txtreten_35.getText().replace(",", "")));
        dts.setRetencion4(Integer.parseInt(txtreten4.getText().replace(",", "")));
        dts.setSubtotal(Integer.parseInt(txtsubtotal.getText().replace(",", "")));
        dts.setEfectivo(Integer.parseInt(txtefectivo.getText().replace(",", "")));
        dts.setTarjeta(Integer.parseInt(txttarjeta.getText().replace(",", "")));
        dts.setTransferencia(Integer.parseInt(txttransferencia.getText().replace(",", "")));
        dts.setTotalapagar(Integer.parseInt(txttotalapagar.getText().replace(",", "")));
        dts.setAntesIVA(Integer.parseInt(txtbruto.getText().replace(",", "")));
        dts.setCostoalojamiento(Integer.parseInt(txtcostoalojamiento.getText().replace(",", "")));
        dts.setParqueadero(Integer.parseInt(txtparqueadero.getText().replace(",", "")));//Parqueadero
        dts.setLavanderia(Integer.parseInt(txtlavanderia.getText().replace(",", ""))); //Lavanderia
        dts.setColchonadi(Integer.parseInt(txtcolchonadi.getText().replace(",", "")));
        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El abono fue registrado satisfactoriamente");
                mostrar("");
                limpiarcajas();
//                imprimir();
                this.dispose();
            }
        } else if (accion.equals("editar")) {
            dts.setIdabono(Integer.parseInt(txtidabono.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El abono del Sr. " + txtcliente.getText() + " ha sido modificado correctamente");
                mostrar("");
                limpiarcajas();
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtvalorbrutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalorbrutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorbrutoActionPerformed

    private void txtvalorbrutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorbrutoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            try {
                int costoalojamiento = Integer.parseInt(txtcostoalojamiento.getText().replace(",", ""));
                int numeronoches = Integer.parseInt(txtnumeronoches.getText().replace(",", ""));
                int valordescuento = Integer.parseInt(txtvalordescuento.getText().replace(",", ""));

                // Validación adicional para evitar cálculos negativos
                if (costoalojamiento < 0 || numeronoches < 0) {
                    JOptionPane.showMessageDialog(null, "El número de noches y el valor del descuento deben ser positivos.");
                    return;
                }

                int calculo = valordescuento * numeronoches;
                int calculo1 = costoalojamiento * numeronoches;
                txtabonohabitacion.setText(formatoMiles.format(calculo1));
                txtdescuentos.setText(formatoMiles.format(calculo));

                int nuevoabono = Integer.parseInt(txtabonohabitacion.getText().replace(",", ""));
                int nuevodescuent = Integer.parseInt(txtdescuentos.getText().replace(",", ""));
                int otroscobros = Integer.parseInt(txtotroscobros.getText().replace(",", ""));
                int parqueadero = Integer.parseInt(txtparqueadero.getText().replace(",", ""));
                int lavanderia = Integer.parseInt(txtlavanderia.getText().replace(",", ""));
                int colchonadi = Integer.parseInt(txtcolchonadi.getText().replace(",", ""));

                int nuevocalculo = nuevoabono - nuevodescuent + otroscobros + parqueadero + lavanderia + colchonadi;
                txtvalorbruto.setText(formatoMiles.format(nuevocalculo));

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa números válidos.");
            }
        }
    }//GEN-LAST:event_txtvalorbrutoKeyPressed

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
            java.util.logging.Logger.getLogger(Jabono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jabono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jabono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jabono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Jabono().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JTextField cajanumero;
    private javax.swing.JButton calcular35;
    private javax.swing.JButton calcular4;
    private javax.swing.JComboBox<String> cboprivilegiosadmon;
    private javax.swing.JComboBox<String> cboprivilegiosrecep;
    private javax.swing.JComboBox<String> cbotipocomprobante;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lbltotalregistros;
    public static javax.swing.JLabel lbturno;
    private javax.swing.JTable tablalistadosabonos;
    private javax.swing.JTextField txtIVA_19;
    public static javax.swing.JTextField txtabonohabitacion;
    private javax.swing.JTextField txtbruto;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtclientenu;
    private javax.swing.JTextField txtcolchonadi;
    private javax.swing.JTextField txtconcepto;
    private javax.swing.JTextField txtcostoalojamiento;
    private javax.swing.JTextField txtdescuentos;
    private javax.swing.JTextField txtdocumento;
    private javax.swing.JTextField txtefectivo;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfecha_abono;
    private javax.swing.JTextField txtidabono;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtidhabitacion;
    private javax.swing.JTextField txtidingreso;
    private javax.swing.JTextField txtidinicioturno;
    private javax.swing.JTextField txtlavanderia;
    private javax.swing.JTextField txtnumcomprobante;
    public static javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtnumero_turno;
    private javax.swing.JTextField txtnumeronoches;
    private javax.swing.JTextField txtotroscobros;
    private javax.swing.JTextField txtparqueadero;
    private javax.swing.JTextField txtrazon_social;
    private javax.swing.JTextField txtreten4;
    private javax.swing.JTextField txtreten_35;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttarjeta;
    private javax.swing.JTextField txttotalapagar;
    private javax.swing.JTextField txttransferencia;
    private javax.swing.JTextField txtvalorbruto;
    private javax.swing.JTextField txtvalordescuento;
    // End of variables declaration//GEN-END:variables
}
