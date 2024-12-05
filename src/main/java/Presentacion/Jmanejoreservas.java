package Presentacion;

import java.sql.Date;
import Datos.Dhabitacion;
import Datos.Dinicioturno;
import Datos.Dreserva;
import Datos.Tiempopro;
import Logica.Cconexion;
import Logica.Fhabitacion;
import Logica.Freserva;
import Logica.Fsalida;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public final class Jmanejoreservas extends javax.swing.JFrame {

    PreparedStatement pst;
    ResultSet rs;
//    private static Jmanejoreservas instance;
    Tiempopro time = new Tiempopro();

    public Jmanejoreservas() {

        initComponents();
        setLocationRelativeTo(null);
        setTitle("RESERVAS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mostrar("");
        inhabilitar();
        agregarWindowFocusListener();
        mostrarTiempo();
        configurarTabla();
        AutoCompleteDecoreitor();
        limpiarcajas();

    }

    private void AutoCompleteDecoreitor() {
        if (txtcliente != null) {
            // Lista de autocompletado para `txtcliente`
            List<String> clientes = obtenerListaClientes(); // Método que obtiene los nombres y apellidos
            AutoCompleteDecorator.decorate(txtcliente, clientes, false);
        }
    }

    private List<String> obtenerListaClientes() {
        List<String> listaClientes = new ArrayList<>();
        Cconexion conexion = new Cconexion();
        try {
            // Realiza la consulta para obtener los nombres de clientes
            Connection conectar = conexion.establecerConexion();
            pst = conectar.prepareStatement("SELECT nombres, apellidos FROM cliente ");
            rs = pst.executeQuery();

            while (rs.next()) {
                String nombreCompleto = rs.getString("nombres") + " " + rs.getString("apellidos");
                listaClientes.add(nombreCompleto);
            }
        } catch (SQLException e) {
        } finally {
        }
        return listaClientes;
    }
    private String accion = "guardar";
    public static int idusuario;

//    public static Jmanejoreservas getInstance() {
//        if (instance == null) {
//            instance = new Jmanejoreservas();
//        }
//        return instance;
//    }

    public void mostrarTiempo() {

        txtfechareserva.setText(time.getFechacomp());
        txtfechaingreso.setText(time.getFechacomp());
    }

    public void limpiarTabla(JTable tablalistadoreserva) {
        DefaultTableModel model = (DefaultTableModel) tablalistadoreserva.getModel();
        model.setRowCount(0);
    }

    private void mostrarnumeroturno() {
        Fsalida func = new Fsalida();
        Dinicioturno numeroturno = func.numeroturno();

        txtnum_turno.setText(String.valueOf(numeroturno.getNumeroTurno()));
        txtidinicioturno.setText(String.valueOf(numeroturno.getIdInicioTurno()));
    }

    private void agregarWindowFocusListener() {
        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                mostrarnumeroturno();  // Actualiza el número de turno cuando la ventana recibe el foco
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                // No hacer nada cuando la ventana pierde el foco
            }
        });
    }

    private void configurarTabla() {
        // Aquí configuras el comportamiento y el estilo de la tabla
        tablalistadoreserva.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablalistadoreserva.setRowHeight(25); // Ajusta la altura de las filas
        tablalistadoreserva.setRowMargin(5); // Espacio entre filas

        // Cambiar color del encabezado usando un renderer personalizado
        JTableHeader header = tablalistadoreserva.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                cell.setBackground(new Color(135, 206, 235));
                cell.setForeground(Color.BLACK); // Texto blanco para encabezado
                cell.setFont(new Font("SansSerif", Font.BOLD, 14)); // Fuente personalizada
                return cell;
            }
        });

        // Establecer colores alternos en las filas
        tablalistadoreserva.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        cajanumero.setText("");
        txtnumero.setText("0");
        txtnumnoches.setText("0");
        txtcostoalojamiento.setText("0");
        txttipohabitacion.setText("");
        txtdocumento.setText("0");
        txtcliente.setText("");
        txttelefono.setText("0");
        dcfechasalida.setDate(null);
        comestado.setSelectedItem(0);
        txtnumpersonas.setText("");
        txtidcliente.setText("0");

    }

    void inhabilitar() {
        txtidhabitacion.setVisible(false);
        txtidinicioturno.setVisible(false);
        txtidreserva.setVisible(false);
    }

    void ocultar_columnas() {
        tablalistadoreserva.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistadoreserva.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadoreserva.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistadoreserva.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadoreserva.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoreserva.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablalistadoreserva.getColumnModel().getColumn(15).setMaxWidth(0);
        tablalistadoreserva.getColumnModel().getColumn(15).setMinWidth(0);
        tablalistadoreserva.getColumnModel().getColumn(15).setPreferredWidth(0);

        tablalistadoreserva.getColumnModel().getColumn(14).setMaxWidth(0);
        tablalistadoreserva.getColumnModel().getColumn(14).setMinWidth(0);
        tablalistadoreserva.getColumnModel().getColumn(14).setPreferredWidth(0);

        tablalistadoreserva.getColumnModel().getColumn(6).setMaxWidth(0);
        tablalistadoreserva.getColumnModel().getColumn(6).setMinWidth(0);
        tablalistadoreserva.getColumnModel().getColumn(6).setPreferredWidth(0);

        tablalistadoreserva.getColumnModel().getColumn(7).setMaxWidth(0);
        tablalistadoreserva.getColumnModel().getColumn(7).setMinWidth(0);
        tablalistadoreserva.getColumnModel().getColumn(7).setPreferredWidth(0);

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            Freserva func = new Freserva();
            modelo = func.mostrar(buscar);

            tablalistadoreserva.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jFrame1 = new javax.swing.JFrame();
        jlnuevo = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcostoalojamiento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cajanumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txttipohabitacion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtcliente = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtdocumento = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        Jpnreserva = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnumpersonas = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comestado = new javax.swing.JComboBox<>();
        dcfechasalida = new com.toedter.calendar.JDateChooser();
        txtnumnoches = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfechareserva = new javax.swing.JTextField();
        txtfechaingreso = new javax.swing.JTextField();
        txtempleado = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtidreserva = new javax.swing.JTextField();
        txtidhabitacion = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tablalistadoreserva = new javax.swing.JTable();
        lbturno = new javax.swing.JLabel();
        txtnum_turno = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtidinicioturno = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manejo Reservas");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HABITACIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("N° Habitación:");

        txtnumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Costo *noche:");

        txtcostoalojamiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Tipo Habitación:");

        cajanumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajanumeroActionPerformed(evt);
            }
        });
        cajanumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cajanumeroKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Buscar Habit:");

        txttipohabitacion.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cajanumero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcostoalojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttipohabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajanumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcostoalojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txttipohabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txtcliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });
        txtcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtclienteKeyPressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("Cliente:");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("Documento:");

        txtdocumento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocumentoActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("Telefono:");

        txttelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttelefonoKeyPressed(evt);
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
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        btnlimpiar.setBackground(new java.awt.Color(204, 204, 204));
        btnlimpiar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.GIF"))); // NOI18N
        btnlimpiar.setText("Nuevo");
        btnlimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnlimpiar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnlimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        Jpnreserva.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " RESERVAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Fecha Reserva:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Fecha ingreso:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Salida:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("N° Personas:");

        txtnumpersonas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Estado:");

        comestado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activa", "Anulada" }));

        dcfechasalida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtnumnoches.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("N° Noches:");

        txtfechareserva.setEditable(false);
        txtfechareserva.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        txtfechaingreso.setEditable(false);
        txtfechaingreso.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        javax.swing.GroupLayout JpnreservaLayout = new javax.swing.GroupLayout(Jpnreserva);
        Jpnreserva.setLayout(JpnreservaLayout);
        JpnreservaLayout.setHorizontalGroup(
            JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnreservaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dcfechasalida, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(txtfechareserva)
                    .addComponent(txtfechaingreso, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtnumpersonas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addComponent(txtnumnoches, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(19, 19, 19))
        );
        JpnreservaLayout.setVerticalGroup(
            JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnreservaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpnreservaLayout.createSequentialGroup()
                        .addGroup(JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addGroup(JpnreservaLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtfechareserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtnumnoches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtfechaingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnreservaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JpnreservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnumpersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(JpnreservaLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(dcfechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        txtempleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtempleadoActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("Encargado");

        txtidreserva.setText("IDRE");
        txtidreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidreservaActionPerformed(evt);
            }
        });

        txtidhabitacion.setText("IDHBI");
        txtidhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidhabitacionActionPerformed(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(244, 244, 244));

        jLabel28.setText("Buscar");

        btnbuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnbuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(204, 204, 204));
        btneliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        lbltotalregistros.setText("Registros");

        tablalistadoreserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero", "Cliente", "Empleado", "Tipo Reserva", "FechaReserva", "Fecha Salida", "FechaIngreso", "Costo", "Estado", "N Noches", "N Personas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablalistadoreserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoreservaMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tablalistadoreserva);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btneliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane15)
                .addGap(14, 14, 14))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar)
                    .addComponent(btneliminar)
                    .addComponent(lbltotalregistros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbturno.setText("turno");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("N°Turno:");

        txtidinicioturno.setText("0");

        txtidcliente.setText("0");
        txtidcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidclienteActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inmigracion.png"))); // NOI18N
        jButton1.setText("Registro");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jlnuevo.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(btnguardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(btnlimpiar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(Jpnreserva, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(txtempleado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(txtidreserva, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(txtidhabitacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(jPanel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(lbturno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(txtnum_turno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(txtidinicioturno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(txtidcliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlnuevo.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jlnuevoLayout = new javax.swing.GroupLayout(jlnuevo);
        jlnuevo.setLayout(jlnuevoLayout);
        jlnuevoLayout.setHorizontalGroup(
            jlnuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlnuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jlnuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jlnuevoLayout.createSequentialGroup()
                        .addGroup(jlnuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jlnuevoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbturno, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jlnuevoLayout.createSequentialGroup()
                                .addComponent(btnlimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(jlnuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(txtidinicioturno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jlnuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnum_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(86, 86, 86))
                    .addGroup(jlnuevoLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jlnuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Jpnreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 562, Short.MAX_VALUE)
                .addContainerGap())
        );
        jlnuevoLayout.setVerticalGroup(
            jlnuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlnuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jlnuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jlnuevoLayout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jlnuevoLayout.createSequentialGroup()
                        .addComponent(Jpnreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jlnuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jlnuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jlnuevoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jlnuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnlimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnguardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jlnuevoLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jlnuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidinicioturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jlnuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtnum_turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbturno))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlnuevo))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlnuevo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        // TODO add your handling code here:
        limpiarcajas();
        btnguardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if (txtidhabitacion.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes Seleccionar una Habitación");
            txtidhabitacion.requestFocus();
            return;
        }

        if (txtcostoalojamiento.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un precio del Alojamiento");
            txtcostoalojamiento.requestFocus();
            return;
        }

        if (txtnumpersonas.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar numero de personas");
            txtnumpersonas.requestFocus();
            return;
        }
        if (txtnumnoches.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar numero de noches a reservar");
            txtnumnoches.requestFocus();
            return;
        }
        Dreserva dts = new Dreserva();
        Freserva func = new Freserva();

        dts.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));

        Calendar cal;
        int d, m, a;

        dts.setFechareserva(txtfechareserva.getText());
        dts.setFechaingreso(txtfechaingreso.getText());

        cal = dcfechasalida.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        dts.setFechasalida(new Date(a, m, d));

        int estado = comestado.getSelectedIndex();
        dts.setEstado(comestado.getItemAt(estado));
        dts.setNumnoches(Integer.parseInt(txtnumnoches.getText()));
        dts.setNumpersonas(Integer.parseInt(txtnumpersonas.getText()));
        dts.setCliente(txtcliente.getText());
        dts.setDocumento(Integer.parseInt(txtdocumento.getText()));
        dts.setTelefono(txttelefono.getText());
        dts.setNumhabitacion(Integer.parseInt(txtnumero.getText()));
        dts.setCostoalojamiento(Integer.parseInt(txtcostoalojamiento.getText()));

        dts.setTipohabitacion((String) txttipohabitacion.getText());
        dts.setEmpleado(txtempleado.getText());
        dts.setIdinicioturno(Integer.parseInt(txtidinicioturno.getText()));
        dts.setNum_turno(Integer.parseInt(txtnum_turno.getText()));
        dts.setTurno(lbturno.getText());
        dts.setIdcliente(Integer.parseInt(txtidcliente.getText()));

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "La reserva fue registrada satisfactoriamente");
                mostrar("");
                Fhabitacion habitacion = new Fhabitacion();
                 Dreserva reserva = new Dreserva();
                reserva.setFechaingreso(txtfechaingreso.getText());
                reserva.setNumhabitacion(Integer.parseInt(txtnumero.getText()));
                habitacion.verificarReservas(reserva);
                inhabilitar();

            }

        } else if (accion.equals("editar")) {
            // Establece el ID de la reserva
            dts.setIdreserva(Integer.parseInt(txtidreserva.getText()));

            // Editar la reserva
            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "La reserva fue Editada satisfactoriamente");

                // Mostrar reservas y deshabilitar la interfaz para nuevas ediciones
                mostrar("");
                inhabilitar();

                // Verificar el estado de la reserva
                String estadoReserva = comestado.getSelectedItem().toString();

                // Si el estado de la reserva es "Anulada"
                if (estadoReserva.equals("Anulada")) {
                    Fhabitacion habitacion = new Fhabitacion();
                    Dhabitacion dts1 = new Dhabitacion();
                    dts1.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
                    habitacion.disponible(dts1);

                } else if (estadoReserva.equals("Activa")) {
                    Fhabitacion habitacion = new Fhabitacion();
                    Dhabitacion dts1 = new Dhabitacion();
                    dts1.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
                    habitacion.EditarEstadoReserva(dts1);
                }
            }

            this.dispose();
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtempleadoActionPerformed

    }//GEN-LAST:event_txtempleadoActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdocumentoActionPerformed

    private void txtnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroActionPerformed

    private void txtidhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidhabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidhabitacionActionPerformed

    private void cajanumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajanumeroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cconexion conexion = new Cconexion();

            try {
                Connection conectar = conexion.establecerConexion();

                // Preparamos la consulta
                pst = conectar.prepareStatement("select * from habitacion where numero=?");
                pst.setString(1, cajanumero.getText());

                rs = pst.executeQuery();

                if (rs.next()) {
                    String estado = rs.getString("estado");
                    if ("Ocupado".equalsIgnoreCase(estado)) {
                        JOptionPane.showMessageDialog(null, "La habitación está Ocupado.");
                    }
                    if ("Mantenimeinto".equalsIgnoreCase(estado)) {
                        JOptionPane.showMessageDialog(null, "La habitación esa en manenimiento.");
                    }
                    if ("Reserva".equalsIgnoreCase(estado)) {
                        JOptionPane.showMessageDialog(null, "La habitación está Reserva.");
                    }
                    if ("Limpieza".equalsIgnoreCase(estado)) {
                        JOptionPane.showMessageDialog(null, "La habitación está EN Limpieza.");
                    }
                    if ("Disponible".equals(estado)) {
                        txtidhabitacion.setText(String.valueOf(rs.getInt("idhabitacion")));
                        txtnumero.setText(rs.getString("numero"));
                        txttipohabitacion.setText(rs.getString("tipohabitacion"));
                        txtcostoalojamiento.setText(rs.getString("precio"));

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el NUMERO solicitado.");
                }
                conectar.close();

            } catch (HeadlessException | SQLException ex) {

            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_cajanumeroKeyPressed

    private void cajanumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajanumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajanumeroActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        mostrar(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        if (!txtidreserva.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar la Reserva?", "Confirmar", 2);

            if (confirmacion == 0) {

                Fhabitacion habitacion = new Fhabitacion();
                Dhabitacion dts1 = new Dhabitacion();
                dts1.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
                habitacion.disponible(dts1);

                Freserva func = new Freserva();
                Dreserva dts = new Dreserva();

                dts.setIdreserva(Integer.parseInt(txtidreserva.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void tablalistadoreservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoreservaMouseClicked
        btnguardar.setText("Editar");
//        inhabilitar();
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistadoreserva.rowAtPoint(evt.getPoint());

        txtidreserva.setText(tablalistadoreserva.getValueAt(fila, 0).toString());
        txtidhabitacion.setText(tablalistadoreserva.getValueAt(fila, 1).toString());
//        txtfechareserva.setText(tablalistadoreserva.getValueAt(fila, 2).toString());
        txtfechaingreso.setText(tablalistadoreserva.getValueAt(fila, 3).toString());
        dcfechasalida.setDate(Date.valueOf(tablalistadoreserva.getValueAt(fila, 4).toString()));
        comestado.setSelectedItem(tablalistadoreserva.getValueAt(fila, 5).toString());
        txtnumnoches.setText(tablalistadoreserva.getValueAt(fila, 6).toString());
        txtnumpersonas.setText(tablalistadoreserva.getValueAt(fila, 7).toString());
        txtcliente.setText(tablalistadoreserva.getValueAt(fila, 8).toString());
        txtdocumento.setText(tablalistadoreserva.getValueAt(fila, 9).toString());
        txttelefono.setText(tablalistadoreserva.getValueAt(fila, 10).toString());
        txtnumero.setText(tablalistadoreserva.getValueAt(fila, 11).toString());
        txtcostoalojamiento.setText(tablalistadoreserva.getValueAt(fila, 12).toString());
        txttipohabitacion.setText(tablalistadoreserva.getValueAt(fila, 13).toString());
        txtempleado.setText(tablalistadoreserva.getValueAt(fila, 14).toString());
        txtidcliente.setText(tablalistadoreserva.getValueAt(fila, 15).toString());

    }//GEN-LAST:event_tablalistadoreservaMouseClicked

    private void txtidreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidreservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidreservaActionPerformed

    private void txttelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cconexion conexion = new Cconexion();

            try {
                Connection conectar = conexion.establecerConexion();

                // Preparar la consulta SQL para buscar el cliente por número de documento
                pst = conectar.prepareStatement("SELECT * FROM cliente WHERE telefono=?");
                pst.setString(1, txttelefono.getText()); // Aquí puedes obtener el valor del nombre desde un JTextField

                rs = pst.executeQuery();

                if (rs.next()) {
                    txtidcliente.setText(String.valueOf(rs.getInt("idcliente")));
                    txtcliente.setText(rs.getString("nombres") + " " + rs.getString("apellidos"));
                    txttelefono.setText(rs.getString("telefono"));
                    txtdocumento.setText(rs.getString("numdocumento"));
                } else {
                    // Mensaje si no se encuentra el cliente
                    JOptionPane.showMessageDialog(null, "No se encontró el CLIENTE solicitado.");
                }

                conectar.close();

            } catch (HeadlessException | SQLException ex) {
                System.err.println("Error: " + ex);
            }
        }
    }//GEN-LAST:event_txttelefonoKeyPressed

    private void txtclienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclienteKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cconexion conexion = new Cconexion();

            try {
                Connection conectar = conexion.establecerConexion();

                // Preparar la consulta SQL para buscar el cliente por nombre completo (nombres + apellidos)
                pst = conectar.prepareStatement("SELECT * FROM cliente WHERE CONCAT(nombres, ' ', apellidos) = ?");
                pst.setString(1, txtcliente.getText()); // Aquí puedes obtener el valor del nombre completo desde un JTextField

                rs = pst.executeQuery();

                if (rs.next()) {
                    txtidcliente.setText(String.valueOf(rs.getInt("idcliente")));
                    txtcliente.setText(rs.getString("nombres") + " " + rs.getString("apellidos"));
                    txttelefono.setText(rs.getString("telefono"));
                    txtdocumento.setText(rs.getString("numdocumento"));
                } else {
                    // Mensaje si no se encuentra el cliente
                    JOptionPane.showMessageDialog(null, "No se encontró el CLIENTE solicitado.");
                }

                conectar.close();

            } catch (HeadlessException | SQLException ex) {
                System.err.println("Error: " + ex);
            }
        }
    }//GEN-LAST:event_txtclienteKeyPressed

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteActionPerformed

    private void txtidclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidclienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Jcliente cliente = new Jcliente();
        cliente.toFront();
        cliente.requestFocus();
        cliente.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ClassNotFoundException e) {
            java.util.logging.Logger.getLogger(Jmanejoreservas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, e);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jmanejoreservas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jmanejoreservas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jmanejoreservas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Jmanejoreservas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpnreserva;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JTextField cajanumero;
    private javax.swing.JComboBox<String> comestado;
    private com.toedter.calendar.JDateChooser dcfechasalida;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JLayeredPane jlnuevo;
    private javax.swing.JLabel lbltotalregistros;
    public static javax.swing.JLabel lbturno;
    private javax.swing.JTable tablalistadoreserva;
    private javax.swing.JTextField txtbuscar;
    public static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtcostoalojamiento;
    public static javax.swing.JTextField txtdocumento;
    public static javax.swing.JTextField txtempleado;
    private javax.swing.JTextField txtfechaingreso;
    private javax.swing.JTextField txtfechareserva;
    private javax.swing.JTextField txtidcliente;
    public static javax.swing.JTextField txtidhabitacion;
    private javax.swing.JTextField txtidinicioturno;
    private javax.swing.JTextField txtidreserva;
    private javax.swing.JTextField txtnum_turno;
    public static javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtnumnoches;
    private javax.swing.JTextField txtnumpersonas;
    public static javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttipohabitacion;
    // End of variables declaration//GEN-END:variables
}
