package Presentacion;

import Datos.Dhabitacion;
import Datos.Dingreso;
import Datos.Dinicioturno;
import Datos.Dreserva;
import Datos.Tiempopro;
import Logica.Cconexion;
import Logica.Fhabitacion;
import Logica.Fingreso;
import Logica.Freserva;
import Logica.Fsalida;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public final class Jingreso extends javax.swing.JFrame {

    PreparedStatement pst;
    ResultSet rs;
    Tiempopro time = new Tiempopro();
//    private static Jingreso instance;
    private Jacompañante acompañante;
    private Jregistro_factura_electronica factura;

//    public Jingreso() {
//        this("", "", "", "", "", ""); // Llamar al constructor parametrizado con valores predeterminados
//    }

    public Jingreso() {
        initComponents();
        inhabilitar();
        mostrar("");
        setLocationRelativeTo(null);
//        setTitle("INGRESO DE HUESPED");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mostrarTiempo();
        configurarTabla();
        QuitarespaciosCombobox();
        AutoCompleteDecoreitor();
        inicioAutoCompleteDecoreitor();
        agregarWindowFocusListener();
        txtplaca.setText("0");
//        txtcliente.setText(cliente);
//        txtnumdocumento.setText(documento);
//        txttelefono.setText(telefono);
//        txttipohabitacion.setText(tipoHabitacion);
//        txtnumero.setText(numhbitacion);
//        txtcostoalojamiento.setText(costoalojamiento);
    }

    private void inicioAutoCompleteDecoreitor() {
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

    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
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
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                // No hacer nada cuando la ventana pierde el foco
            }
        });
    }

    private void configurarTabla() {
        // Aquí configuras el comportamiento y el estilo de la tabla
        tablalistadoingreso.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablalistadoingreso.setRowHeight(25); // Ajusta la altura de las filas
        tablalistadoingreso.setRowMargin(5); // Espacio entre filas

        // Cambiar color del encabezado usando un renderer personalizado
        JTableHeader header = tablalistadoingreso.getTableHeader();
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
        tablalistadoingreso.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

    private void QuitarespaciosCombobox() {
        // Supongamos que tienes un JComboBox llamado cbociudadrecidencia
        for (int i = 0; i < cbociudadrecidencia.getItemCount(); i++) {
            // Obtener el elemento, eliminar espacios y volver a establecer el elemento
            String item = cbociudadrecidencia.getItemAt(i).trim();
            cbociudadrecidencia.insertItemAt(item, i);
            cbociudadrecidencia.removeItemAt(i + 1);
        }

// Repite el proceso para el otro JComboBox, si es necesario
        for (int i = 0; i < cbociudadprocedencia.getItemCount(); i++) {
            String item = cbociudadprocedencia.getItemAt(i).trim();
            cbociudadprocedencia.insertItemAt(item, i);
            cbociudadprocedencia.removeItemAt(i + 1);
        }

    }

    private void AutoCompleteDecoreitor() {
        AutoCompleteDecorator.decorate(cbociudadrecidencia);
        AutoCompleteDecorator.decorate(cbociudadprocedencia);
    }

    private String accion = "guardar";

    public static String idcliente = "";

    public static int idusuario;

    public void mostrarTiempo() {

        jdfechaingreso.setText(time.getFechacomp() + " " + time.getHoracomp());
    }

//    public static Jingreso getInstance() {
//        if (instance == null) {
//            instance = new Jingreso();
//        }
//        return instance;
//    }

    void limpiarcajas() {
        jdfechaingreso.setText("");
        txtidcliente.setText("");
        cbociudadrecidencia.setSelectedItem("Seleccionar");
        cbociudadprocedencia.setSelectedItem("Seleccionar");
        txtbuscar.setText("");
        txtnum_personas.setText("");
        txtnumero.setText("");
        txtcostoalojamiento.setText("");
        txtcliente.setText("");
        txttelefono.setText("");
        cbotipo_cliente.setSelectedItem("Seleccionar");
        cbo_tipoDocumento.setSelectedItem("Selccionar");
        comestado.setSelectedItem("Activo");
        cbomotivoviaje.setSelectedItem("");
        txtnumdocumento.setText("");
        txttipohabitacion.setText("");
        txtplaca.setText("");
    }

    void inhabilitar() {
        lbturnos.setVisible(false);
        txtidinicioturno.setVisible(false);
        txtidempleado.setVisible(false);
        txtidhabitacion.setVisible(false);
        txtidcliente.setVisible(false);
        txtidingreso.setVisible(false);
    }

    void ocultar_columnas() {
        tablalistadoingreso.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistadoingreso.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablalistadoingreso.getColumnModel().getColumn(3).setMaxWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(3).setMinWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(3).setPreferredWidth(0);

        tablalistadoingreso.getColumnModel().getColumn(4).setMaxWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(4).setMinWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(4).setPreferredWidth(0);

        tablalistadoingreso.getColumnModel().getColumn(5).setMaxWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(5).setMinWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(5).setPreferredWidth(0);

        tablalistadoingreso.getColumnModel().getColumn(7).setMaxWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(7).setMinWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(7).setPreferredWidth(0);

        tablalistadoingreso.getColumnModel().getColumn(10).setMaxWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(10).setMinWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(10).setPreferredWidth(0);

        tablalistadoingreso.getColumnModel().getColumn(13).setMaxWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(13).setMinWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(13).setPreferredWidth(0);

        tablalistadoingreso.getColumnModel().getColumn(15).setMaxWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(15).setMinWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(15).setPreferredWidth(0);

        tablalistadoingreso.getColumnModel().getColumn(16).setMaxWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(16).setMinWidth(0);
        tablalistadoingreso.getColumnModel().getColumn(16).setPreferredWidth(0);
    }

    public void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            Fingreso func = new Fingreso();
            modelo = func.mostrar(buscar);

            tablalistadoingreso.setModel(modelo);
            ocultar_columnas();
            lbltotalregistro.setText("Total Registros " + Integer.toString(func.totalregistros));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        txtnumdocumento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jdfechaingreso = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbo_tipoDocumento = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cbotipo_cliente = new javax.swing.JComboBox<>();
        cbociudadrecidencia = new javax.swing.JComboBox<>();
        cbociudadprocedencia = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbomotivoviaje = new javax.swing.JComboBox<>();
        txtidingreso = new javax.swing.JTextField();
        txtidhabitacion = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        txtidempleado = new javax.swing.JTextField();
        txtidinicioturno = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        txttipohabitacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcostoalojamiento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnum_personas = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        comestado = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txtcaracteristicas = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnacompañante = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtplaca = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtnumero_turno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtempleado = new javax.swing.JTextField();
        lbturnos = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        lbltotalregistros = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablalistadoingreso = new javax.swing.JTable();
        lbltotalregistro = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Cliente:");

        txtcliente.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtclienteKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Telefono:");

        txttelefono.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });

        txtnumdocumento.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtnumdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumdocumentoActionPerformed(evt);
            }
        });
        txtnumdocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnumdocumentoKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Documento:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Fecha de ingreso:");

        jdfechaingreso.setEditable(false);
        jdfechaingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdfechaingresoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("Ciudad de Residencia:");

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("Ciudad de Procedencia:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Tipod Documento:");

        cbo_tipoDocumento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbo_tipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Cedula de ciudadania", "Tarjeta de identidad", "Cedula de extrageria", "Pasaporte", " " }));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("Tipo de cliente:");

        cbotipo_cliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbotipo_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "General", "Administrativo", "Otros" }));

        cbociudadrecidencia.setEditable(true);
        cbociudadrecidencia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbociudadrecidencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar ", "Abejorral - Antioquia ", "Ábrego - Norte De Santander ", "Abriaquí - Antioquia ", "Acacías - Meta ", "Acandí - Chocó ", " Acevedo - Huila ", " Achí - Bolívar ", " Agrado - Huila ", " Agua De Dios - Cundinamarca ", " Aguachica - Cesar ", " Aguada - Santander ", " Aguadas - Caldas ", " Aguazul - Casanare ", " Agustín Codazzi - Cesar ", " Aipe - Huila ", " Albán - Cundinamarca ", " Albán - Nariño ", " Albania - Caquetá ", " Albania - La Guajira ", " Albania - Santander ", " Alcalá - Valle Del Cauca ", " Aldana - Nariño ", " Alejandría - Antioquia ", " Algarrobo - Magdalena ", " Algeciras - Huila ", " Almaguer - Cauca ", " Almeida - Boyacá ", " Alpujarra - Tolima ", " Altamira - Huila ", " Alto Baudó - Chocó ", " Altos Del Rosario - Bolívar ", " Alvarado - Tolima ", " Amagá - Antioquia ", " Amalfi - Antioquia ", " Ambalema - Tolima ", " Anapoima - Cundinamarca ", " Ancuya - Nariño ", " Andalucía - Valle Del Cauca ", " Andes - Antioquia ", " Angelópolis - Antioquia ", " Angostura - Antioquia ", " Anolaima - Cundinamarca ", " Anorí - Antioquia ", " Anserma - Caldas ", " Ansermanuevo - Valle Del Cauca ", " Anzá - Antioquia ", " Anzoátegui - Tolima ", " Apartadó - Antioquia ", " Apía - Risaralda ", " Apulo - Cundinamarca ", " Aquitania - Boyacá ", " Aracataca - Magdalena ", " Aranzazu - Caldas ", " Aratoca - Santander ", " Arauca - Arauca ", " Arauquita - Arauca ", " Arbeláez - Cundinamarca ", " Arboleda - Nariño ", " Arboledas - Norte De Santander ", " Arboletes - Antioquia ", " Arcabuco - Boyacá ", " Arenal - Bolívar ", " Argelia - Antioquia ", " Argelia - Cauca ", " Argelia - Valle Del Cauca ", " Ariguaní - Magdalena ", " Arjona - Bolívar ", " Armenia - Antioquia ", " Armenia - Quindío ", " Armero - Tolima ", " Arroyohondo - Bolívar ", " Astrea - Cesar ", " Ataco - Tolima ", " Atrato - Chocó ", " Ayapel - Córdoba ", " Bagadó - Chocó ", " Bahía Solano - Chocó ", " Bajo Baudó - Chocó ", " Balboa - Cauca ", " Balboa - Risaralda ", " Baranoa - Atlántico ", " Baraya - Huila ", " Barbacoas - Nariño ", " Barbosa - Antioquia ", "Barbosa - Santander ", "Barichara - Santander ", "Barranca De Upía - Meta ", "Barrancabermeja - Santander ", " Barrancas - La Guajira ", " Barranco De Loba - Bolívar ", " Barrancominas - Guainía ", " Barranquilla - Atlántico ", " Becerril - Cesar ", " Belalcázar - Caldas ", " Belén - Boyacá ", " Belén - Nariño ", " Belén De Los Andaquíes - Caquetá ", " Belén De Umbría - Risaralda ", " Bello - Antioquia ", " Belmira - Antioquia ", " Beltrán - Cundinamarca ", " Berbeo - Boyacá ", " Betania - Antioquia ", " Betéitiva - Boyacá ", " Betulia - Antioquia ", " Betulia - Santander ", " Bituima - Cundinamarca ", " Boavita - Boyacá ", " Bochalema - Norte De Santander ", " Bogotá, D.C. - Bogotá, D.C. ", " Bojacá - Cundinamarca ", " Bojayá - Chocó ", " Bolívar - Cauca ", " Bolívar - Santander ", " Bolívar - Valle Del Cauca ", " Bosconia - Cesar ", " Boyacá - Boyacá ", " Briceño - Antioquia ", " Briceño - Boyacá ", " Bucaramanga - Santander ", " Bucarasica - Norte De Santander ", " Buenaventura - Valle Del Cauca ", " Buenavista - Boyacá ", " Buenavista - Córdoba ", " Buenavista - Quindío ", " Buenavista - Sucre ", " Buenos Aires - Cauca ", " Buesaco - Nariño ", " Bugalagrande - Valle Del Cauca ", " Buriticá - Antioquia ", " Busbanzá - Boyacá ", " Cabrera - Cundinamarca ", " Cabrera - Santander ", " Cabuyaro - Meta ", " Cacahual - Guainía ", " Cáceres - Antioquia ", " Cachipay - Cundinamarca ", " Cáchira - Norte De Santander ", " Cácota - Norte De Santander ", " Caicedo - Antioquia ", " Caicedonia - Valle Del Cauca ", " Caimito - Sucre ", " Cajamarca - Tolima ", " Cajibío - Cauca ", " Cajicá - Cundinamarca ", " Calamar - Bolívar ", " Calamar - Guaviare ", " Calarcá - Quindío ", " Caldas - Antioquia ", " Caldas - Boyacá ", " Caldono - Cauca ", " Cali - Valle Del Cauca ", " California - Santander ", " Calima - Valle Del Cauca ", " Caloto - Cauca ", " Campamento - Antioquia ", " Campo De La Cruz - Atlántico ", " Campoalegre - Huila ", " Campohermoso - Boyacá ", " Canalete - Córdoba ", " Candelaria - Atlántico ", " Candelaria - Valle Del Cauca ", " Cantagallo - Bolívar ", " Cañasgordas - Antioquia ", " Caparrapí - Cundinamarca ", " Capitanejo - Santander ", " Cáqueza - Cundinamarca ", " Caracolí - Antioquia ", " Caramanta - Antioquia ", " Carcasí - Santander ", " Carepa - Antioquia ", " Carmen De Apicalá - Tolima ", " Carmen De Carupa - Cundinamarca ", " Carmen Del Darién - Chocó ", " Carolina - Antioquia ", " Cartagena De Indias - Bolívar ", " Cartagena Del Chairá - Caquetá ", " Cartago - Valle Del Cauca ", " Carurú - Vaupés ", " Casabianca - Tolima ", " Castilla La Nueva - Meta ", " Caucasia - Antioquia ", " Cepitá - Santander ", " Cereté - Córdoba ", " Cerinza - Boyacá ", " Cerrito - Santander ", " Cerro De San Antonio - Magdalena ", " Cértegui - Chocó ", " Chachagüí - Nariño ", " Chaguaní - Cundinamarca ", " Chalán - Sucre ", " Chámeza - Casanare ", " Chaparral - Tolima ", " Charalá - Santander ", " Charta - Santander ", " Chía - Cundinamarca ", " Chigorodó - Antioquia ", " Chimá - Córdoba ", " Chima - Santander ", " Chimichagua - Cesar ", " Chinácota - Norte De Santander ", " Chinavita - Boyacá ", " Chinchiná - Caldas ", " Chinú - Córdoba ", " Chipaque - Cundinamarca ", " Chipatá - Santander ", " Chiquinquirá - Boyacá ", " Chíquiza - Boyacá ", " Chiriguaná - Cesar ", " Chiscas - Boyacá ", " Chita - Boyacá ", " Chitagá - Norte De Santander ", " Chitaraque - Boyacá ", " Chivatá - Boyacá ", " Chivolo - Magdalena ", " Chivor - Boyacá ", " Choachí - Cundinamarca ", " Chocontá - Cundinamarca ", " Cicuco - Bolívar ", " Ciénaga - Magdalena ", " Ciénaga De Oro - Córdoba ", " Ciénega - Boyacá ", " Cimitarra - Santander ", " Circasia - Quindío ", " Cisneros - Antioquia ", " Ciudad Bolívar - Antioquia ", " Clemencia - Bolívar ", " Cocorná - Antioquia ", " Coello - Tolima ", " Cogua - Cundinamarca ", " Colombia - Huila ", " Colón - Nariño ", " Colón - Putumayo ", " Colosó - Sucre ", " Cómbita - Boyacá ", " Concepción - Antioquia ", " Concepción - Santander ", " Concordia - Antioquia ", " Concordia - Magdalena ", " Condoto - Chocó ", " Confines - Santander ", " Consacá - Nariño ", " Contadero - Nariño ", " Contratación - Santander ", " Convención - Norte De Santander ", " Copacabana - Antioquia ", " Coper - Boyacá ", " Córdoba - Bolívar ", " Córdoba - Nariño ", " Córdoba - Quindío ", " Corinto - Cauca ", " Coromoro - Santander ", " Corozal - Sucre ", " Corrales - Boyacá ", " Cota - Cundinamarca ", " Cotorra - Córdoba ", " Covarachía - Boyacá ", " Coveñas - Sucre ", " Coyaima - Tolima ", " Cravo Norte - Arauca ", " Cuaspud Carlosama - Nariño ", " Cubará - Boyacá ", " Cubarral - Meta ", " Cucaita - Boyacá ", " Cucunubá - Cundinamarca ", " Cucutilla - Norte De Santander ", " Cuítiva - Boyacá ", " Cumaral - Meta ", " Cumaribo - Vichada ", " Cumbal - Nariño ", " Cumbitara - Nariño ", " Cunday - Tolima ", " Curillo - Caquetá ", " Curití - Santander ", " Curumaní - Cesar ", " Dabeiba - Antioquia ", " Dagua - Valle Del Cauca ", " Dibulla - La Guajira ", " Distracción - La Guajira ", " Dolores - Tolima ", " Donmatías - Antioquia ", " Dosquebradas - Risaralda ", " Duitama - Boyacá ", " Durania - Norte De Santander ", " Ebéjico - Antioquia ", " El Águila - Valle Del Cauca ", " El Bagre - Antioquia ", " El Banco - Magdalena ", " El Cairo - Valle Del Cauca ", " El Calvario - Meta ", " El Cantón Del San Pablo - Chocó ", " El Carmen - Norte De Santander ", " El Carmen De Atrato - Chocó ", " El Carmen De Bolívar - Bolívar ", " El Carmen De Chucurí - Santander ", " El Carmen De Viboral - Antioquia ", " El Castillo - Meta ", " El Cerrito - Valle Del Cauca ", " El Charco - Nariño ", " El Cocuy - Boyacá ", " El Colegio - Cundinamarca ", " El Copey - Cesar ", " El Doncello - Caquetá ", " El Dorado - Meta ", " El Dovio - Valle Del Cauca ", " El Encanto - Amazonas ", " El Espino - Boyacá ", " El Guacamayo - Santander ", " El Guamo - Bolívar ", " El Litoral Del San Juan - Chocó ", " El Molino - La Guajira ", " El Paso - Cesar ", " El Paujíl - Caquetá ", " El Peñol - Nariño ", " El Peñón - Bolívar ", " El Peñón - Cundinamarca ", " El Peñón - Santander ", " El Piñón - Magdalena ", " El Playón - Santander ", " El Retén - Magdalena ", " El Retorno - Guaviare ", " El Roble - Sucre ", " El Rosal - Cundinamarca ", " El Rosario - Nariño ", " El Santuario - Antioquia ", " El Tablón De Gómez - Nariño ", " El Tambo - Cauca ", " El Tambo - Nariño ", " El Tarra - Norte De Santander ", " El Zulia - Norte De Santander ", " Elías - Huila ", " Encino - Santander ", " Enciso - Santander ", " Entrerríos - Antioquia ", " Envigado - Antioquia ", " Espinal - Tolima ", " Facatativá - Cundinamarca ", " Falan - Tolima ", " Filadelfia - Caldas ", " Filandia - Quindío ", " Firavitoba - Boyacá ", " Flandes - Tolima ", " Florencia - Caquetá ", " Florencia - Cauca ", " Floresta - Boyacá ", " Florián - Santander ", " Florida - Valle Del Cauca ", " Floridablanca - Santander ", " Fómeque - Cundinamarca ", " Fonseca - La Guajira ", " Fortul - Arauca ", " Fosca - Cundinamarca ", " Francisco Pizarro - Nariño ", " Fredonia - Antioquia ", " Fresno - Tolima ", " Frontino - Antioquia ", " Fuente De Oro - Meta ", " Fundación - Magdalena ", " Funes - Nariño ", " Funza - Cundinamarca ", " Fúquene - Cundinamarca ", " Fusagasugá - Cundinamarca ", " Gachalá - Cundinamarca ", " Gachancipá - Cundinamarca ", " Gachantivá - Boyacá ", " Gachetá - Cundinamarca ", " Galán - Santander ", " Galapa - Atlántico ", " Galeras - Sucre ", " Gama - Cundinamarca ", " Gamarra - Cesar ", " Gámbita - Santander ", " Gámeza - Boyacá ", " Garagoa - Boyacá ", " Garzón - Huila ", " Génova - Quindío ", " Gigante - Huila ", " Ginebra - Valle Del Cauca ", " Giraldo - Antioquia ", " Girardot - Cundinamarca ", " Girardota - Antioquia ", " Girón - Santander ", " Gómez Plata - Antioquia ", " González - Cesar ", " Gramalote - Norte De Santander ", " Granada - Antioquia ", " Granada - Cundinamarca ", " Granada - Meta ", " Guaca - Santander ", " Guacamayas - Boyacá ", " Guacarí - Valle Del Cauca ", " Guachené - Cauca ", " Guachetá - Cundinamarca ", " Guachucal - Nariño ", " Guadalajara De Buga - Valle Del Cauca ", " Guadalupe - Antioquia ", " Guadalupe - Huila ", " Guadalupe - Santander ", " Guaduas - Cundinamarca ", " Guaitarilla - Nariño ", " Gualmatán - Nariño ", " Guamal - Magdalena ", " Guamal - Meta ", " Guamo - Tolima ", " Guapi - Cauca ", " Guapotá - Santander ", " Guaranda - Sucre ", " Guarne - Antioquia ", " Guasca - Cundinamarca ", " Guatapé - Antioquia ", " Guataquí - Cundinamarca ", " Guatavita - Cundinamarca ", " Guateque - Boyacá ", " Guática - Risaralda ", " Guavatá - Santander ", " Guayabal De Síquima - Cundinamarca ", " Guayabetal - Cundinamarca ", " Guayatá - Boyacá ", " Güepsa - Santander ", " Güicán De La Sierra - Boyacá ", " Gutiérrez - Cundinamarca ", " Hacarí - Norte De Santander ", " Hatillo De Loba - Bolívar ", " Hato - Santander ", " Hato Corozal - Casanare ", " Hatonuevo - La Guajira ", " Heliconia - Antioquia ", " Herrán - Norte De Santander ", " Herveo - Tolima ", " Hispania - Antioquia ", " Hobo - Huila ", " Honda - Tolima ", " Ibagué - Tolima ", " Icononzo - Tolima ", " Iles - Nariño ", " Imués - Nariño ", " Inírida - Guainía ", " Inzá - Cauca ", " Ipiales - Nariño ", " Íquira - Huila ", " Isnos - Huila ", " Istmina - Chocó ", " Itagüí - Antioquia ", " Ituango - Antioquia ", " Iza - Boyacá ", " Jambaló - Cauca ", " Jamundí - Valle Del Cauca ", " Jardín - Antioquia ", " Jenesano - Boyacá ", " Jericó - Antioquia ", " Jericó - Boyacá ", " Jerusalén - Cundinamarca ", " Jesús María - Santander ", " Jordán - Santander ", " Juan De Acosta - Atlántico ", " Junín - Cundinamarca ", " Juradó - Chocó ", " La Apartada - Córdoba ", " La Argentina - Huila ", " La Belleza - Santander ", " La Calera - Cundinamarca ", " La Capilla - Boyacá ", " La Ceja - Antioquia ", " La Celia - Risaralda ", " La Chorrera - Amazonas ", " La Cruz - Nariño ", " La Cumbre - Valle Del Cauca ", " La Dorada - Caldas ", " La Esperanza - Norte De Santander ", " La Estrella - Antioquia ", " La Florida - Nariño ", " La Gloria - Cesar ", " La Guadalupe - Guainía ", " La Jagua De Ibirico - Cesar ", " La Jagua Del Pilar - La Guajira ", " La Llanada - Nariño ", " La Macarena - Meta ", " La Merced - Caldas ", " La Mesa - Cundinamarca ", " La Montañita - Caquetá ", " La Palma - Cundinamarca ", " La Paz - Cesar ", " La Paz - Santander ", " La Pedrera - Amazonas ", " La Peña - Cundinamarca ", " La Pintada - Antioquia ", " La Plata - Huila ", " La Playa - Norte De Santander ", " La Primavera - Vichada ", " La Salina - Casanare ", " La Sierra - Cauca ", " La Tebaida - Quindío ", " La Tola - Nariño ", " La Unión - Antioquia ", " La Unión - Nariño ", " La Unión - Sucre ", " La Unión - Valle Del Cauca ", " La Uvita - Boyacá ", " La Vega - Cauca ", " La Vega - Cundinamarca ", " La Victoria - Amazonas ", " La Victoria - Boyacá ", " La Victoria - Valle Del Cauca ", " La Virginia - Risaralda ", " Labateca - Norte De Santander ", " Labranzagrande - Boyacá ", " Landázuri - Santander ", " Lebrija - Santander ", " Leiva - Nariño ", " Lejanías - Meta ", " Lenguazaque - Cundinamarca ", " Lérida - Tolima ", " Leticia - Amazonas ", " Líbano - Tolima ", " Liborina - Antioquia ", " Linares - Nariño ", " Lloró - Chocó ", " López De Micay - Cauca ", " Lorica - Córdoba ", " Los Andes - Nariño ", " Los Córdobas - Córdoba ", " Los Palmitos - Sucre ", " Los Patios - Norte De Santander ", " Los Santos - Santander ", " Lourdes - Norte De Santander ", " Luruaco - Atlántico ", " Macanal - Boyacá ", " Macaravita - Santander ", " Maceo - Antioquia ", " Machetá - Cundinamarca ", " Madrid - Cundinamarca ", " Magangué - Bolívar ", " Magüí - Nariño ", " Mahates - Bolívar ", " Maicao - La Guajira ", " Majagual - Sucre ", " Málaga - Santander ", " Malambo - Atlántico ", " Mallama - Nariño ", " Manatí - Atlántico ", " Manaure - La Guajira ", " Manaure Balcón Del Cesar - Cesar ", " Maní - Casanare ", " Manizales - Caldas ", " Manta - Cundinamarca ", " Manzanares - Caldas ", " Mapiripán - Meta ", " Margarita - Bolívar ", " María La Baja - Bolívar ", " Marinilla - Antioquia ", " Maripí - Boyacá ", " Marmato - Caldas ", " Marquetalia - Caldas ", " Marsella - Risaralda ", " Marulanda - Caldas ", " Matanza - Santander ", " Medellín - Antioquia ", " Medina - Cundinamarca ", " Medio Atrato - Chocó ", " Medio Baudó - Chocó ", " Medio San Juan - Chocó ", " Melgar - Tolima ", " Mercaderes - Cauca ", " Mesetas - Meta ", " Milán - Caquetá ", " Miraflores - Boyacá ", " Miraflores - Guaviare ", " Miranda - Cauca ", " Mirití - Paraná - Amazonas ", " Mistrató - Risaralda ", " Mitú - Vaupés ", " Mocoa - Putumayo ", " Mogotes - Santander ", " Molagavita - Santander ", " Momil - Córdoba ", " Mongua - Boyacá ", " Monguí - Boyacá ", " Moniquirá - Boyacá ", " Montebello - Antioquia ", " Montecristo - Bolívar ", " Montelíbano - Córdoba ", " Montenegro - Quindío ", " Montería - Córdoba ", " Monterrey - Casanare ", " Moñitos - Córdoba ", " Morales - Bolívar ", " Morales - Cauca ", " Morelia - Caquetá ", " Morichal - Guainía ", " Morroa - Sucre ", " Mosquera - Cundinamarca ", " Mosquera - Nariño ", " Motavita - Boyacá ", " Murillo - Tolima ", " Murindó - Antioquia ", " Mutatá - Antioquia ", " Mutiscua - Norte De Santander ", " Muzo - Boyacá ", " Nariño - Antioquia ", " Nariño - Cundinamarca ", " Nariño - Nariño ", " Nátaga - Huila ", " Natagaima - Tolima ", " Nechí - Antioquia ", " Necoclí - Antioquia ", " Neira - Caldas ", " Neiva - Huila ", " Nemocón - Cundinamarca ", " Nilo - Cundinamarca ", " Nimaima - Cundinamarca ", " Nobsa - Boyacá ", " Nocaima - Cundinamarca ", " Norcasia - Caldas ", " Norosí - Bolívar ", " Nóvita - Chocó ", " Nueva Granada - Magdalena ", " Nuevo Colón - Boyacá ", " Nunchía - Casanare ", " Nuquí - Chocó ", " Obando - Valle Del Cauca ", " Ocamonte - Santander ", " Ocaña - Norte De Santander ", " Oiba - Santander ", " Oicatá - Boyacá ", " Olaya - Antioquia ", " Olaya Herrera - Nariño ", " Onzaga - Santander ", " Oporapa - Huila ", " Orito - Putumayo ", " Orocué - Casanare ", " Ortega - Tolima ", " Ospina - Nariño ", " Otanche - Boyacá ", " Ovejas - Sucre ", " Pachavita - Boyacá ", " Pacho - Cundinamarca ", " Pacoa - Vaupés ", " Pácora - Caldas ", " Padilla - Cauca ", " Páez - Boyacá ", " Páez - Cauca ", " Paicol - Huila ", " Pailitas - Cesar ", " Paime - Cundinamarca ", " Paipa - Boyacá ", " Pajarito - Boyacá ", " Palermo - Huila ", " Palestina - Caldas ", " Palestina - Huila ", " Palmar - Santander ", " Palmar De Varela - Atlántico ", " Palmas Del Socorro - Santander ", " Palmira - Valle Del Cauca ", " Palmito - Sucre ", " Palocabildo - Tolima ", " Pamplona - Norte De Santander ", " Pamplonita - Norte De Santander ", " Pana Pana - Guainía ", " Pandi - Cundinamarca ", " Panqueba - Boyacá ", " Papunahua - Vaupés ", " Páramo - Santander ", " Paratebueno - Cundinamarca ", " Pasca - Cundinamarca ", " Pasto - Nariño ", " Patía - Cauca ", " Pauna - Boyacá ", " Paya - Boyacá ", " Paz De Ariporo - Casanare ", " Paz De Río - Boyacá ", " Pedraza - Magdalena ", " Pelaya - Cesar ", " Pensilvania - Caldas ", " Peñol - Antioquia ", " Peque - Antioquia ", " Pereira - Risaralda ", " Pesca - Boyacá ", " Piamonte - Cauca ", " Piedecuesta - Santander ", " Piedras - Tolima ", " Piendamó - Tunía - Cauca ", " Pijao - Quindío ", " Pijiño Del Carmen - Magdalena ", " Pinchote - Santander ", " Pinillos - Bolívar ", " Piojó - Atlántico ", " Pisba - Boyacá ", " Pital - Huila ", " Pitalito - Huila ", " Pivijay - Magdalena ", " Planadas - Tolima ", " Planeta Rica - Córdoba ", " Plato - Magdalena ", " Policarpa - Nariño ", " Polonuevo - Atlántico ", " Ponedera - Atlántico ", " Popayán - Cauca ", " Pore - Casanare ", " Potosí - Nariño ", " Pradera - Valle Del Cauca ", " Prado - Tolima ", " Providencia - Archipiélago De San Andrés, Providencia Y Santa Catalina ", " Providencia - Nariño ", " Pueblo Bello - Cesar ", " Pueblo Nuevo - Córdoba ", " Pueblo Rico - Risaralda ", " Pueblorrico - Antioquia ", " Puebloviejo - Magdalena ", " Puente Nacional - Santander ", " Puerres - Nariño ", " Puerto Alegría - Amazonas ", " Puerto Arica - Amazonas ", " Puerto Asís - Putumayo ", " Puerto Berrío - Antioquia ", " Puerto Boyacá - Boyacá ", " Puerto Caicedo - Putumayo ", " Puerto Carreño - Vichada ", " Puerto Colombia - Atlántico ", " Puerto Colombia - Guainía ", " Puerto Concordia - Meta ", " Puerto Escondido - Córdoba ", " Puerto Gaitán - Meta ", " Puerto Guzmán - Putumayo ", " Puerto Leguízamo - Putumayo ", " Puerto Libertador - Córdoba ", " Puerto Lleras - Meta ", " Puerto López - Meta ", " Puerto Nare - Antioquia ", " Puerto Nariño - Amazonas ", " Puerto Parra - Santander ", " Puerto Rico - Caquetá ", " Puerto Rico - Meta ", " Puerto Rondón - Arauca ", " Puerto Salgar - Cundinamarca ", " Puerto Santander - Amazonas ", " Puerto Santander - Norte De Santander ", " Puerto Tejada - Cauca ", " Puerto Triunfo - Antioquia ", " Puerto Wilches - Santander ", " Pulí - Cundinamarca ", " Pupiales - Nariño ", " Puracé - Cauca ", " Purificación - Tolima ", " Purísima De La Concepción - Córdoba ", " Quebradanegra - Cundinamarca ", " Quetame - Cundinamarca ", " Quibdó - Chocó ", " Quimbaya - Quindío ", " Quinchía - Risaralda ", " Quípama - Boyacá ", " Quipile - Cundinamarca ", " Ragonvalia - Norte De Santander ", " Ramiriquí - Boyacá ", " Ráquira - Boyacá ", " Recetor - Casanare ", " Regidor - Bolívar ", " Remedios - Antioquia ", " Remolino - Magdalena ", " Repelón - Atlántico ", " Restrepo - Meta ", " Restrepo - Valle Del Cauca ", " Retiro - Antioquia ", " Ricaurte - Cundinamarca ", " Ricaurte - Nariño ", " Río De Oro - Cesar ", " Río Iró - Chocó ", " Río Quito - Chocó ", " Río Viejo - Bolívar ", " Rioblanco - Tolima ", " Riofrío - Valle Del Cauca ", " Riohacha - La Guajira ", " Rionegro - Antioquia ", " Rionegro - Santander ", " Riosucio - Caldas ", " Riosucio - Chocó ", " Risaralda - Caldas ", " Rivera - Huila ", " Roberto Payán - Nariño ", " Roldanillo - Valle Del Cauca ", " Roncesvalles - Tolima ", " Rondón - Boyacá ", " Rosas - Cauca ", " Rovira - Tolima ", " Sabana De Torres - Santander ", " Sabanagrande - Atlántico ", " Sabanalarga - Antioquia ", " Sabanalarga - Atlántico ", " Sabanalarga - Casanare ", " Sabanas De San Ángel - Magdalena ", " Sabaneta - Antioquia ", " Saboyá - Boyacá ", " Sácama - Casanare ", " Sáchica - Boyacá ", " Sahagún - Córdoba ", " Saladoblanco - Huila ", " Salamina - Caldas ", " Salamina - Magdalena ", " Salazar - Norte De Santander ", " Saldaña - Tolima ", " Salento - Quindío ", " Salgar - Antioquia ", " Samacá - Boyacá ", " Samaná - Caldas ", " Samaniego - Nariño ", " Sampués - Sucre ", " San Agustín - Huila ", " San Alberto - Cesar ", " San Andrés - Archipiélago De San Andrés, Providencia Y Santa Catalina ", " San Andrés - Santander ", " San Andrés De Cuerquía - Antioquia ", " San Andrés De Sotavento - Córdoba ", " San Andrés De Tumaco - Nariño ", " San Antero - Córdoba ", " San Antonio - Tolima ", " San Antonio Del Tequendama - Cundinamarca ", " San Benito - Santander ", " San Benito Abad - Sucre ", " San Bernardo - Cundinamarca ", " San Bernardo - Nariño ", " San Bernardo Del Viento - Córdoba ", " San Calixto - Norte De Santander ", " San Carlos - Antioquia ", " San Carlos - Córdoba ", " San Carlos De Guaroa - Meta ", " San Cayetano - Cundinamarca ", " San Cayetano - Norte De Santander ", " San Cristóbal - Bolívar ", " San Diego - Cesar ", " San Eduardo - Boyacá ", " San Estanislao - Bolívar ", " San Felipe - Guainía ", " San Fernando - Bolívar ", " San Francisco - Antioquia ", " San Francisco - Cundinamarca ", " San Francisco - Putumayo ", " San Gil - Santander ", " San Jacinto - Bolívar ", " San Jacinto Del Cauca - Bolívar ", " San Jerónimo - Antioquia ", " San Joaquín - Santander ", " San José - Caldas ", " San José De Cúcuta - Norte De Santander ", " San José De La Montaña - Antioquia ", " San José De Miranda - Santander ", " San José De Pare - Boyacá ", " San José De Toluviejo - Sucre ", " San José De Uré - Córdoba ", " San José Del Fragua - Caquetá ", " San José Del Guaviare - Guaviare ", " San José Del Palmar - Chocó ", " San Juan De Arama - Meta ", " San Juan De Betulia - Sucre ", " San Juan De Rioseco - Cundinamarca ", " San Juan De Urabá - Antioquia ", " San Juan Del Cesar - La Guajira ", " San Juan Nepomuceno - Bolívar ", " San Juanito - Meta ", " San Lorenzo - Nariño ", " San Luis - Antioquia ", " San Luis - Tolima ", " San Luis De Gaceno - Boyacá ", " San Luis De Palenque - Casanare ", " San Luis De Sincé - Sucre ", " San Marcos - Sucre ", " San Martín - Cesar ", " San Martín - Meta ", " San Martín De Loba - Bolívar ", " San Mateo - Boyacá ", " San Miguel - Putumayo ", " San Miguel - Santander ", " San Miguel De Sema - Boyacá ", " San Onofre - Sucre ", " San Pablo - Bolívar ", " San Pablo - Nariño ", " San Pablo De Borbur - Boyacá ", " San Pedro - Sucre ", " San Pedro - Valle Del Cauca ", " San Pedro De Cartago - Nariño ", " San Pedro De Los Milagros - Antioquia ", " San Pedro De Urabá - Antioquia ", " San Pelayo - Córdoba ", " San Rafael - Antioquia ", " San Roque - Antioquia ", " San Sebastián - Cauca ", " San Sebastián De Buenavista - Magdalena ", " San Sebastián De Mariquita - Tolima ", " San Vicente De Chucurí - Santander ", " San Vicente Del Caguán - Caquetá ", " San Vicente Ferrer - Antioquia ", " San Zenón - Magdalena ", " Sandoná - Nariño ", " Santa Ana - Magdalena ", " Santa Bárbara - Antioquia ", " Santa Bárbara - Nariño ", " Santa Bárbara - Santander ", " Santa Bárbara De Pinto - Magdalena ", " Santa Catalina - Bolívar ", " Santa Cruz De Mompox - Bolívar ", " Santa Fé De Antioquia - Antioquia ", " Santa Helena Del Opón - Santander ", " Santa Isabel - Tolima ", " Santa Lucía - Atlántico ", " Santa María - Boyacá ", " Santa María - Huila ", " Santa Marta - Magdalena ", " Santa Rosa - Bolívar ", " Santa Rosa - Cauca ", " Santa Rosa De Cabal - Risaralda ", " Santa Rosa De Osos - Antioquia ", " Santa Rosa De Viterbo - Boyacá ", " Santa Rosa Del Sur - Bolívar ", " Santa Rosalía - Vichada ", " Santa Sofía - Boyacá ", " Santacruz - Nariño ", " Santana - Boyacá ", " Santander De Quilichao - Cauca ", " Santiago - Norte De Santander ", " Santiago - Putumayo ", " Santiago De Tolú - Sucre ", " Santo Domingo - Antioquia ", " Santo Tomás - Atlántico ", " Santuario - Risaralda ", " Sapuyes - Nariño ", " Saravena - Arauca ", " Sardinata - Norte De Santander ", " Sasaima - Cundinamarca ", " Sativanorte - Boyacá ", " Sativasur - Boyacá ", " Segovia - Antioquia ", " Sesquilé - Cundinamarca ", " Sevilla - Valle Del Cauca ", " Siachoque - Boyacá ", " Sibaté - Cundinamarca ", " Sibundoy - Putumayo ", " Silos - Norte De Santander ", " Silvania - Cundinamarca ", " Silvia - Cauca ", " Simacota - Santander ", " Simijaca - Cundinamarca ", " Simití - Bolívar ", " Sincelejo - Sucre ", " Sipí - Chocó ", " Sitionuevo - Magdalena ", " Soacha - Cundinamarca ", " Soatá - Boyacá ", " Socha - Boyacá ", " Socorro - Santander ", " Socotá - Boyacá ", " Sogamoso - Boyacá ", " Solano - Caquetá ", " Soledad - Atlántico ", " Solita - Caquetá ", " Somondoco - Boyacá ", " Sonsón - Antioquia ", " Sopetrán - Antioquia ", " Soplaviento - Bolívar ", " Sopó - Cundinamarca ", " Sora - Boyacá ", " Soracá - Boyacá ", " Sotaquirá - Boyacá ", " Sotará Paispamba - Cauca ", " Suaita - Santander ", " Suan - Atlántico ", " Suárez - Cauca ", " Suárez - Tolima ", " Suaza - Huila ", " Subachoque - Cundinamarca ", " Sucre - Cauca ", " Sucre - Santander ", " Sucre - Sucre ", " Suesca - Cundinamarca ", " Supatá - Cundinamarca ", " Supía - Caldas ", " Suratá - Santander ", " Susa - Cundinamarca ", " Susacón - Boyacá ", " Sutamarchán - Boyacá ", " Sutatausa - Cundinamarca ", " Sutatenza - Boyacá ", " Tabio - Cundinamarca ", " Tadó - Chocó ", " Talaigua Nuevo - Bolívar ", " Tamalameque - Cesar ", " Támara - Casanare ", " Tame - Arauca ", " Támesis - Antioquia ", " Taminango - Nariño ", " Tangua - Nariño ", " Taraira - Vaupés ", " Tarapacá - Amazonas ", " Tarazá - Antioquia ", " Tarqui - Huila ", " Tarso - Antioquia ", " Tasco - Boyacá ", " Tauramena - Casanare ", " Tausa - Cundinamarca ", " Tello - Huila ", " Tena - Cundinamarca ", " Tenerife - Magdalena ", " Tenjo - Cundinamarca ", " Tenza - Boyacá ", " Teorama - Norte De Santander ", " Teruel - Huila ", " Tesalia - Huila ", " Tibacuy - Cundinamarca ", " Tibaná - Boyacá ", " Tibasosa - Boyacá ", " Tibirita - Cundinamarca ", " Tibú - Norte De Santander ", " Tierralta - Córdoba ", " Timaná - Huila ", " Timbío - Cauca ", " Timbiquí - Cauca ", " Tinjacá - Boyacá ", " Tipacoque - Boyacá ", " Tiquisio - Bolívar ", " Titiribí - Antioquia ", " Toca - Boyacá ", " Tocaima - Cundinamarca ", " Tocancipá - Cundinamarca ", " Togüí - Boyacá ", " Toledo - Antioquia ", " Toledo - Norte De Santander ", " Tona - Santander ", " Tópaga - Boyacá ", " Topaipí - Cundinamarca ", " Toribío - Cauca ", " Toro - Valle Del Cauca ", " Tota - Boyacá ", " Totoró - Cauca ", " Trinidad - Casanare ", " Trujillo - Valle Del Cauca ", " Tubará - Atlántico ", " Tuchín - Córdoba ", " Tuluá - Valle Del Cauca ", " Tunja - Boyacá ", " Tununguá - Boyacá ", " Túquerres - Nariño ", " Turbaco - Bolívar ", " Turbaná - Bolívar ", " Turbo - Antioquia ", " Turmequé - Boyacá ", " Tuta - Boyacá ", " Tutazá - Boyacá ", " Ubalá - Cundinamarca ", " Ubaque - Cundinamarca ", " Ulloa - Valle Del Cauca ", " Úmbita - Boyacá ", " Une - Cundinamarca ", " Unguía - Chocó ", " Unión Panamericana - Chocó ", " Uramita - Antioquia ", " Uribe - Meta ", " Uribia - La Guajira ", " Urrao - Antioquia ", " Urumita - La Guajira ", " Usiacurí - Atlántico ", " Útica - Cundinamarca ", " Valdivia - Antioquia ", " Valencia - Córdoba ", " Valle De San José - Santander ", " Valle De San Juan - Tolima ", " Valle Del Guamuez - Putumayo ", " Valledupar - Cesar ", " Valparaíso - Antioquia ", " Valparaíso - Caquetá ", " Vegachí - Antioquia ", " Vélez - Santander ", " Venadillo - Tolima ", " Venecia - Antioquia ", " Venecia - Cundinamarca ", " Ventaquemada - Boyacá ", " Vergara - Cundinamarca ", " Versalles - Valle Del Cauca ", " Vetas - Santander ", " Vianí - Cundinamarca ", " Victoria - Caldas ", " Vigía Del Fuerte - Antioquia ", " Vijes - Valle Del Cauca ", " Villa Caro - Norte De Santander ", " Villa De Leyva - Boyacá ", " Villa De San Diego De Ubaté - Cundinamarca ", " Villa Del Rosario - Norte De Santander ", " Villa Rica - Cauca ", " Villagarzón - Putumayo ", " Villagómez - Cundinamarca ", " Villahermosa - Tolima ", " Villamaría - Caldas ", " Villanueva - Bolívar ", " Villanueva - Casanare ", " Villanueva - La Guajira ", " Villanueva - Santander ", " Villapinzón - Cundinamarca ", " Villarrica - Tolima ", " Villavicencio - Meta ", " Villavieja - Huila ", " Villeta - Cundinamarca ", " Viotá - Cundinamarca ", " Viracachá - Boyacá ", " Vistahermosa - Meta ", " Viterbo - Caldas ", " Yacopí - Cundinamarca ", " Yacuanquer - Nariño ", " Yaguará - Huila ", " Yalí - Antioquia ", " Yarumal - Antioquia ", " Yavaraté - Vaupés ", " Yolombó - Antioquia ", " Yondó - Antioquia ", " Yopal - Casanare ", " Yotoco - Valle Del Cauca ", " Yumbo - Valle Del Cauca ", " Zambrano - Bolívar ", " Zapatoca - Santander ", " Zapayán - Magdalena ", " Zaragoza - Antioquia ", " Zarzal - Valle Del Cauca ", " Zetaquira - Boyacá ", " Zipacón - Cundinamarca ", " Zipaquirá - Cundinamarca ", " Zona Bananera - Magdalena ", "[San Cristóbal de] la Laguna" }));
        cbociudadrecidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbociudadrecidenciaActionPerformed(evt);
            }
        });

        cbociudadprocedencia.setEditable(true);
        cbociudadprocedencia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbociudadprocedencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar ", "Abejorral - Antioquia ", " Ábrego - Norte De Santander ", " Abriaquí - Antioquia ", " Acacías - Meta ", " Acandí - Chocó ", " Acevedo - Huila ", " Achí - Bolívar ", " Agrado - Huila ", " Agua De Dios - Cundinamarca ", " Aguachica - Cesar ", " Aguada - Santander ", " Aguadas - Caldas ", " Aguazul - Casanare ", " Agustín Codazzi - Cesar ", " Aipe - Huila ", " Albán - Cundinamarca ", " Albán - Nariño ", " Albania - Caquetá ", " Albania - La Guajira ", " Albania - Santander ", " Alcalá - Valle Del Cauca ", " Aldana - Nariño ", " Alejandría - Antioquia ", " Algarrobo - Magdalena ", " Algeciras - Huila ", " Almaguer - Cauca ", " Almeida - Boyacá ", " Alpujarra - Tolima ", " Altamira - Huila ", " Alto Baudó - Chocó ", " Altos Del Rosario - Bolívar ", " Alvarado - Tolima ", " Amagá - Antioquia ", " Amalfi - Antioquia ", " Ambalema - Tolima ", " Anapoima - Cundinamarca ", " Ancuya - Nariño ", " Andalucía - Valle Del Cauca ", " Andes - Antioquia ", " Angelópolis - Antioquia ", " Angostura - Antioquia ", " Anolaima - Cundinamarca ", " Anorí - Antioquia ", " Anserma - Caldas ", " Ansermanuevo - Valle Del Cauca ", " Anzá - Antioquia ", " Anzoátegui - Tolima ", " Apartadó - Antioquia ", " Apía - Risaralda ", " Apulo - Cundinamarca ", " Aquitania - Boyacá ", " Aracataca - Magdalena ", " Aranzazu - Caldas ", " Aratoca - Santander ", " Arauca - Arauca ", " Arauquita - Arauca ", " Arbeláez - Cundinamarca ", " Arboleda - Nariño ", " Arboledas - Norte De Santander ", " Arboletes - Antioquia ", " Arcabuco - Boyacá ", " Arenal - Bolívar ", " Argelia - Antioquia ", " Argelia - Cauca ", " Argelia - Valle Del Cauca ", " Ariguaní - Magdalena ", " Arjona - Bolívar ", " Armenia - Antioquia ", " Armenia - Quindío ", " Armero - Tolima ", " Arroyohondo - Bolívar ", " Astrea - Cesar ", " Ataco - Tolima ", " Atrato - Chocó ", " Ayapel - Córdoba ", " Bagadó - Chocó ", " Bahía Solano - Chocó ", " Bajo Baudó - Chocó ", " Balboa - Cauca ", " Balboa - Risaralda ", " Baranoa - Atlántico ", " Baraya - Huila ", " Barbacoas - Nariño ", " Barbosa - Antioquia ", " Barbosa - Santander ", " Barichara - Santander ", " Barranca De Upía - Meta ", " Barrancabermeja - Santander ", " Barrancas - La Guajira ", " Barranco De Loba - Bolívar ", " Barrancominas - Guainía ", " Barranquilla - Atlántico ", " Becerril - Cesar ", " Belalcázar - Caldas ", " Belén - Boyacá ", " Belén - Nariño ", " Belén De Los Andaquíes - Caquetá ", " Belén De Umbría - Risaralda ", " Bello - Antioquia ", " Belmira - Antioquia ", " Beltrán - Cundinamarca ", " Berbeo - Boyacá ", " Betania - Antioquia ", " Betéitiva - Boyacá ", " Betulia - Antioquia ", " Betulia - Santander ", " Bituima - Cundinamarca ", " Boavita - Boyacá ", " Bochalema - Norte De Santander ", " Bogotá, D.C. - Bogotá, D.C. ", " Bojacá - Cundinamarca ", " Bojayá - Chocó ", " Bolívar - Cauca ", " Bolívar - Santander ", " Bolívar - Valle Del Cauca ", " Bosconia - Cesar ", " Boyacá - Boyacá ", " Briceño - Antioquia ", " Briceño - Boyacá ", " Bucaramanga - Santander ", " Bucarasica - Norte De Santander ", " Buenaventura - Valle Del Cauca ", " Buenavista - Boyacá ", " Buenavista - Córdoba ", " Buenavista - Quindío ", " Buenavista - Sucre ", " Buenos Aires - Cauca ", " Buesaco - Nariño ", " Bugalagrande - Valle Del Cauca ", " Buriticá - Antioquia ", " Busbanzá - Boyacá ", " Cabrera - Cundinamarca ", " Cabrera - Santander ", " Cabuyaro - Meta ", " Cacahual - Guainía ", " Cáceres - Antioquia ", " Cachipay - Cundinamarca ", " Cáchira - Norte De Santander ", " Cácota - Norte De Santander ", " Caicedo - Antioquia ", " Caicedonia - Valle Del Cauca ", " Caimito - Sucre ", " Cajamarca - Tolima ", " Cajibío - Cauca ", " Cajicá - Cundinamarca ", " Calamar - Bolívar ", " Calamar - Guaviare ", " Calarcá - Quindío ", " Caldas - Antioquia ", " Caldas - Boyacá ", " Caldono - Cauca ", " Cali - Valle Del Cauca ", " California - Santander ", " Calima - Valle Del Cauca ", " Caloto - Cauca ", " Campamento - Antioquia ", " Campo De La Cruz - Atlántico ", " Campoalegre - Huila ", " Campohermoso - Boyacá ", " Canalete - Córdoba ", " Candelaria - Atlántico ", " Candelaria - Valle Del Cauca ", " Cantagallo - Bolívar ", " Cañasgordas - Antioquia ", " Caparrapí - Cundinamarca ", " Capitanejo - Santander ", " Cáqueza - Cundinamarca ", " Caracolí - Antioquia ", " Caramanta - Antioquia ", " Carcasí - Santander ", " Carepa - Antioquia ", " Carmen De Apicalá - Tolima ", " Carmen De Carupa - Cundinamarca ", " Carmen Del Darién - Chocó ", " Carolina - Antioquia ", " Cartagena De Indias - Bolívar ", " Cartagena Del Chairá - Caquetá ", " Cartago - Valle Del Cauca ", " Carurú - Vaupés ", " Casabianca - Tolima ", " Castilla La Nueva - Meta ", " Caucasia - Antioquia ", " Cepitá - Santander ", " Cereté - Córdoba ", " Cerinza - Boyacá ", " Cerrito - Santander ", " Cerro De San Antonio - Magdalena ", " Cértegui - Chocó ", " Chachagüí - Nariño ", " Chaguaní - Cundinamarca ", " Chalán - Sucre ", " Chámeza - Casanare ", " Chaparral - Tolima ", " Charalá - Santander ", " Charta - Santander ", " Chía - Cundinamarca ", " Chigorodó - Antioquia ", " Chimá - Córdoba ", " Chima - Santander ", " Chimichagua - Cesar ", " Chinácota - Norte De Santander ", " Chinavita - Boyacá ", " Chinchiná - Caldas ", " Chinú - Córdoba ", " Chipaque - Cundinamarca ", " Chipatá - Santander ", " Chiquinquirá - Boyacá ", " Chíquiza - Boyacá ", " Chiriguaná - Cesar ", " Chiscas - Boyacá ", " Chita - Boyacá ", " Chitagá - Norte De Santander ", " Chitaraque - Boyacá ", " Chivatá - Boyacá ", " Chivolo - Magdalena ", " Chivor - Boyacá ", " Choachí - Cundinamarca ", " Chocontá - Cundinamarca ", " Cicuco - Bolívar ", " Ciénaga - Magdalena ", " Ciénaga De Oro - Córdoba ", " Ciénega - Boyacá ", " Cimitarra - Santander ", " Circasia - Quindío ", " Cisneros - Antioquia ", " Ciudad Bolívar - Antioquia ", " Clemencia - Bolívar ", " Cocorná - Antioquia ", " Coello - Tolima ", " Cogua - Cundinamarca ", " Colombia - Huila ", " Colón - Nariño ", " Colón - Putumayo ", " Colosó - Sucre ", " Cómbita - Boyacá ", " Concepción - Antioquia ", " Concepción - Santander ", " Concordia - Antioquia ", " Concordia - Magdalena ", " Condoto - Chocó ", " Confines - Santander ", " Consacá - Nariño ", " Contadero - Nariño ", " Contratación - Santander ", " Convención - Norte De Santander ", " Copacabana - Antioquia ", " Coper - Boyacá ", " Córdoba - Bolívar ", " Córdoba - Nariño ", " Córdoba - Quindío ", " Corinto - Cauca ", " Coromoro - Santander ", " Corozal - Sucre ", " Corrales - Boyacá ", " Cota - Cundinamarca ", " Cotorra - Córdoba ", " Covarachía - Boyacá ", " Coveñas - Sucre ", " Coyaima - Tolima ", " Cravo Norte - Arauca ", " Cuaspud Carlosama - Nariño ", " Cubará - Boyacá ", " Cubarral - Meta ", " Cucaita - Boyacá ", " Cucunubá - Cundinamarca ", " Cucutilla - Norte De Santander ", " Cuítiva - Boyacá ", " Cumaral - Meta ", " Cumaribo - Vichada ", " Cumbal - Nariño ", " Cumbitara - Nariño ", " Cunday - Tolima ", " Curillo - Caquetá ", " Curití - Santander ", " Curumaní - Cesar ", " Dabeiba - Antioquia ", " Dagua - Valle Del Cauca ", " Dibulla - La Guajira ", " Distracción - La Guajira ", " Dolores - Tolima ", " Donmatías - Antioquia ", " Dosquebradas - Risaralda ", " Duitama - Boyacá ", " Durania - Norte De Santander ", " Ebéjico - Antioquia ", " El Águila - Valle Del Cauca ", " El Bagre - Antioquia ", " El Banco - Magdalena ", " El Cairo - Valle Del Cauca ", " El Calvario - Meta ", " El Cantón Del San Pablo - Chocó ", " El Carmen - Norte De Santander ", " El Carmen De Atrato - Chocó ", " El Carmen De Bolívar - Bolívar ", " El Carmen De Chucurí - Santander ", " El Carmen De Viboral - Antioquia ", " El Castillo - Meta ", " El Cerrito - Valle Del Cauca ", " El Charco - Nariño ", " El Cocuy - Boyacá ", " El Colegio - Cundinamarca ", " El Copey - Cesar ", " El Doncello - Caquetá ", " El Dorado - Meta ", " El Dovio - Valle Del Cauca ", " El Encanto - Amazonas ", " El Espino - Boyacá ", " El Guacamayo - Santander ", " El Guamo - Bolívar ", " El Litoral Del San Juan - Chocó ", " El Molino - La Guajira ", " El Paso - Cesar ", " El Paujíl - Caquetá ", " El Peñol - Nariño ", " El Peñón - Bolívar ", " El Peñón - Cundinamarca ", " El Peñón - Santander ", " El Piñón - Magdalena ", " El Playón - Santander ", " El Retén - Magdalena ", " El Retorno - Guaviare ", " El Roble - Sucre ", " El Rosal - Cundinamarca ", " El Rosario - Nariño ", " El Santuario - Antioquia ", " El Tablón De Gómez - Nariño ", " El Tambo - Cauca ", " El Tambo - Nariño ", " El Tarra - Norte De Santander ", " El Zulia - Norte De Santander ", " Elías - Huila ", " Encino - Santander ", " Enciso - Santander ", " Entrerríos - Antioquia ", " Envigado - Antioquia ", " Espinal - Tolima ", " Facatativá - Cundinamarca ", " Falan - Tolima ", " Filadelfia - Caldas ", " Filandia - Quindío ", " Firavitoba - Boyacá ", " Flandes - Tolima ", " Florencia - Caquetá ", " Florencia - Cauca ", " Floresta - Boyacá ", " Florián - Santander ", " Florida - Valle Del Cauca ", " Floridablanca - Santander ", " Fómeque - Cundinamarca ", " Fonseca - La Guajira ", " Fortul - Arauca ", " Fosca - Cundinamarca ", " Francisco Pizarro - Nariño ", " Fredonia - Antioquia ", " Fresno - Tolima ", " Frontino - Antioquia ", " Fuente De Oro - Meta ", " Fundación - Magdalena ", " Funes - Nariño ", " Funza - Cundinamarca ", " Fúquene - Cundinamarca ", " Fusagasugá - Cundinamarca ", " Gachalá - Cundinamarca ", " Gachancipá - Cundinamarca ", " Gachantivá - Boyacá ", " Gachetá - Cundinamarca ", " Galán - Santander ", " Galapa - Atlántico ", " Galeras - Sucre ", " Gama - Cundinamarca ", " Gamarra - Cesar ", " Gámbita - Santander ", " Gámeza - Boyacá ", " Garagoa - Boyacá ", " Garzón - Huila ", " Génova - Quindío ", " Gigante - Huila ", " Ginebra - Valle Del Cauca ", " Giraldo - Antioquia ", " Girardot - Cundinamarca ", " Girardota - Antioquia ", " Girón - Santander ", " Gómez Plata - Antioquia ", " González - Cesar ", " Gramalote - Norte De Santander ", " Granada - Antioquia ", " Granada - Cundinamarca ", " Granada - Meta ", " Guaca - Santander ", " Guacamayas - Boyacá ", " Guacarí - Valle Del Cauca ", " Guachené - Cauca ", " Guachetá - Cundinamarca ", " Guachucal - Nariño ", " Guadalajara De Buga - Valle Del Cauca ", " Guadalupe - Antioquia ", " Guadalupe - Huila ", " Guadalupe - Santander ", " Guaduas - Cundinamarca ", " Guaitarilla - Nariño ", " Gualmatán - Nariño ", " Guamal - Magdalena ", " Guamal - Meta ", " Guamo - Tolima ", " Guapi - Cauca ", " Guapotá - Santander ", " Guaranda - Sucre ", " Guarne - Antioquia ", " Guasca - Cundinamarca ", " Guatapé - Antioquia ", " Guataquí - Cundinamarca ", " Guatavita - Cundinamarca ", " Guateque - Boyacá ", " Guática - Risaralda ", " Guavatá - Santander ", " Guayabal De Síquima - Cundinamarca ", " Guayabetal - Cundinamarca ", " Guayatá - Boyacá ", " Güepsa - Santander ", " Güicán De La Sierra - Boyacá ", " Gutiérrez - Cundinamarca ", " Hacarí - Norte De Santander ", " Hatillo De Loba - Bolívar ", " Hato - Santander ", " Hato Corozal - Casanare ", " Hatonuevo - La Guajira ", " Heliconia - Antioquia ", " Herrán - Norte De Santander ", " Herveo - Tolima ", " Hispania - Antioquia ", " Hobo - Huila ", " Honda - Tolima ", " Ibagué - Tolima ", " Icononzo - Tolima ", " Iles - Nariño ", " Imués - Nariño ", " Inírida - Guainía ", " Inzá - Cauca ", " Ipiales - Nariño ", " Íquira - Huila ", " Isnos - Huila ", " Istmina - Chocó ", " Itagüí - Antioquia ", " Ituango - Antioquia ", " Iza - Boyacá ", " Jambaló - Cauca ", " Jamundí - Valle Del Cauca ", " Jardín - Antioquia ", " Jenesano - Boyacá ", " Jericó - Antioquia ", " Jericó - Boyacá ", " Jerusalén - Cundinamarca ", " Jesús María - Santander ", " Jordán - Santander ", " Juan De Acosta - Atlántico ", " Junín - Cundinamarca ", " Juradó - Chocó ", " La Apartada - Córdoba ", " La Argentina - Huila ", " La Belleza - Santander ", " La Calera - Cundinamarca ", " La Capilla - Boyacá ", " La Ceja - Antioquia ", " La Celia - Risaralda ", " La Chorrera - Amazonas ", " La Cruz - Nariño ", " La Cumbre - Valle Del Cauca ", " La Dorada - Caldas ", " La Esperanza - Norte De Santander ", " La Estrella - Antioquia ", " La Florida - Nariño ", " La Gloria - Cesar ", " La Guadalupe - Guainía ", " La Jagua De Ibirico - Cesar ", " La Jagua Del Pilar - La Guajira ", " La Llanada - Nariño ", " La Macarena - Meta ", " La Merced - Caldas ", " La Mesa - Cundinamarca ", " La Montañita - Caquetá ", " La Palma - Cundinamarca ", " La Paz - Cesar ", " La Paz - Santander ", " La Pedrera - Amazonas ", " La Peña - Cundinamarca ", " La Pintada - Antioquia ", " La Plata - Huila ", " La Playa - Norte De Santander ", " La Primavera - Vichada ", " La Salina - Casanare ", " La Sierra - Cauca ", " La Tebaida - Quindío ", " La Tola - Nariño ", " La Unión - Antioquia ", " La Unión - Nariño ", " La Unión - Sucre ", " La Unión - Valle Del Cauca ", " La Uvita - Boyacá ", " La Vega - Cauca ", " La Vega - Cundinamarca ", " La Victoria - Amazonas ", " La Victoria - Boyacá ", " La Victoria - Valle Del Cauca ", " La Virginia - Risaralda ", " Labateca - Norte De Santander ", " Labranzagrande - Boyacá ", " Landázuri - Santander ", " Lebrija - Santander ", " Leiva - Nariño ", " Lejanías - Meta ", " Lenguazaque - Cundinamarca ", " Lérida - Tolima ", " Leticia - Amazonas ", " Líbano - Tolima ", " Liborina - Antioquia ", " Linares - Nariño ", " Lloró - Chocó ", " López De Micay - Cauca ", " Lorica - Córdoba ", " Los Andes - Nariño ", " Los Córdobas - Córdoba ", " Los Palmitos - Sucre ", " Los Patios - Norte De Santander ", " Los Santos - Santander ", " Lourdes - Norte De Santander ", " Luruaco - Atlántico ", " Macanal - Boyacá ", " Macaravita - Santander ", " Maceo - Antioquia ", " Machetá - Cundinamarca ", " Madrid - Cundinamarca ", " Magangué - Bolívar ", " Magüí - Nariño ", " Mahates - Bolívar ", " Maicao - La Guajira ", " Majagual - Sucre ", " Málaga - Santander ", " Malambo - Atlántico ", " Mallama - Nariño ", " Manatí - Atlántico ", " Manaure - La Guajira ", " Manaure Balcón Del Cesar - Cesar ", " Maní - Casanare ", " Manizales - Caldas ", " Manta - Cundinamarca ", " Manzanares - Caldas ", " Mapiripán - Meta ", " Margarita - Bolívar ", " María La Baja - Bolívar ", " Marinilla - Antioquia ", " Maripí - Boyacá ", " Marmato - Caldas ", " Marquetalia - Caldas ", " Marsella - Risaralda ", " Marulanda - Caldas ", " Matanza - Santander ", " Medellín - Antioquia ", " Medina - Cundinamarca ", " Medio Atrato - Chocó ", " Medio Baudó - Chocó ", " Medio San Juan - Chocó ", " Melgar - Tolima ", " Mercaderes - Cauca ", " Mesetas - Meta ", " Milán - Caquetá ", " Miraflores - Boyacá ", " Miraflores - Guaviare ", " Miranda - Cauca ", " Mirití - Paraná - Amazonas ", " Mistrató - Risaralda ", " Mitú - Vaupés ", " Mocoa - Putumayo ", " Mogotes - Santander ", " Molagavita - Santander ", " Momil - Córdoba ", " Mongua - Boyacá ", " Monguí - Boyacá ", " Moniquirá - Boyacá ", " Montebello - Antioquia ", " Montecristo - Bolívar ", " Montelíbano - Córdoba ", " Montenegro - Quindío ", " Montería - Córdoba ", " Monterrey - Casanare ", " Moñitos - Córdoba ", " Morales - Bolívar ", " Morales - Cauca ", " Morelia - Caquetá ", " Morichal - Guainía ", " Morroa - Sucre ", " Mosquera - Cundinamarca ", " Mosquera - Nariño ", " Motavita - Boyacá ", " Murillo - Tolima ", " Murindó - Antioquia ", " Mutatá - Antioquia ", " Mutiscua - Norte De Santander ", " Muzo - Boyacá ", " Nariño - Antioquia ", " Nariño - Cundinamarca ", " Nariño - Nariño ", " Nátaga - Huila ", " Natagaima - Tolima ", " Nechí - Antioquia ", " Necoclí - Antioquia ", " Neira - Caldas ", " Neiva - Huila ", " Nemocón - Cundinamarca ", " Nilo - Cundinamarca ", " Nimaima - Cundinamarca ", " Nobsa - Boyacá ", " Nocaima - Cundinamarca ", " Norcasia - Caldas ", " Norosí - Bolívar ", " Nóvita - Chocó ", " Nueva Granada - Magdalena ", " Nuevo Colón - Boyacá ", " Nunchía - Casanare ", " Nuquí - Chocó ", " Obando - Valle Del Cauca ", " Ocamonte - Santander ", " Ocaña - Norte De Santander ", " Oiba - Santander ", " Oicatá - Boyacá ", " Olaya - Antioquia ", " Olaya Herrera - Nariño ", " Onzaga - Santander ", " Oporapa - Huila ", " Orito - Putumayo ", " Orocué - Casanare ", " Ortega - Tolima ", " Ospina - Nariño ", " Otanche - Boyacá ", " Ovejas - Sucre ", " Pachavita - Boyacá ", " Pacho - Cundinamarca ", " Pacoa - Vaupés ", " Pácora - Caldas ", " Padilla - Cauca ", " Páez - Boyacá ", " Páez - Cauca ", " Paicol - Huila ", " Pailitas - Cesar ", " Paime - Cundinamarca ", " Paipa - Boyacá ", " Pajarito - Boyacá ", " Palermo - Huila ", " Palestina - Caldas ", " Palestina - Huila ", " Palmar - Santander ", " Palmar De Varela - Atlántico ", " Palmas Del Socorro - Santander ", " Palmira - Valle Del Cauca ", " Palmito - Sucre ", " Palocabildo - Tolima ", " Pamplona - Norte De Santander ", " Pamplonita - Norte De Santander ", " Pana Pana - Guainía ", " Pandi - Cundinamarca ", " Panqueba - Boyacá ", " Papunahua - Vaupés ", " Páramo - Santander ", " Paratebueno - Cundinamarca ", " Pasca - Cundinamarca ", " Pasto - Nariño ", " Patía - Cauca ", " Pauna - Boyacá ", " Paya - Boyacá ", " Paz De Ariporo - Casanare ", " Paz De Río - Boyacá ", " Pedraza - Magdalena ", " Pelaya - Cesar ", " Pensilvania - Caldas ", " Peñol - Antioquia ", " Peque - Antioquia ", " Pereira - Risaralda ", " Pesca - Boyacá ", " Piamonte - Cauca ", " Piedecuesta - Santander ", " Piedras - Tolima ", " Piendamó - Tunía - Cauca ", " Pijao - Quindío ", " Pijiño Del Carmen - Magdalena ", " Pinchote - Santander ", " Pinillos - Bolívar ", " Piojó - Atlántico ", " Pisba - Boyacá ", " Pital - Huila ", " Pitalito - Huila ", " Pivijay - Magdalena ", " Planadas - Tolima ", " Planeta Rica - Córdoba ", " Plato - Magdalena ", " Policarpa - Nariño ", " Polonuevo - Atlántico ", " Ponedera - Atlántico ", " Popayán - Cauca ", " Pore - Casanare ", " Potosí - Nariño ", " Pradera - Valle Del Cauca ", " Prado - Tolima ", " Providencia - Archipiélago De San Andrés, Providencia Y Santa Catalina ", " Providencia - Nariño ", " Pueblo Bello - Cesar ", " Pueblo Nuevo - Córdoba ", " Pueblo Rico - Risaralda ", " Pueblorrico - Antioquia ", " Puebloviejo - Magdalena ", " Puente Nacional - Santander ", " Puerres - Nariño ", " Puerto Alegría - Amazonas ", " Puerto Arica - Amazonas ", " Puerto Asís - Putumayo ", " Puerto Berrío - Antioquia ", " Puerto Boyacá - Boyacá ", " Puerto Caicedo - Putumayo ", " Puerto Carreño - Vichada ", " Puerto Colombia - Atlántico ", " Puerto Colombia - Guainía ", " Puerto Concordia - Meta ", " Puerto Escondido - Córdoba ", " Puerto Gaitán - Meta ", " Puerto Guzmán - Putumayo ", " Puerto Leguízamo - Putumayo ", " Puerto Libertador - Córdoba ", " Puerto Lleras - Meta ", " Puerto López - Meta ", " Puerto Nare - Antioquia ", " Puerto Nariño - Amazonas ", " Puerto Parra - Santander ", " Puerto Rico - Caquetá ", " Puerto Rico - Meta ", " Puerto Rondón - Arauca ", " Puerto Salgar - Cundinamarca ", " Puerto Santander - Amazonas ", " Puerto Santander - Norte De Santander ", " Puerto Tejada - Cauca ", " Puerto Triunfo - Antioquia ", " Puerto Wilches - Santander ", " Pulí - Cundinamarca ", " Pupiales - Nariño ", " Puracé - Cauca ", " Purificación - Tolima ", " Purísima De La Concepción - Córdoba ", " Quebradanegra - Cundinamarca ", " Quetame - Cundinamarca ", " Quibdó - Chocó ", " Quimbaya - Quindío ", " Quinchía - Risaralda ", " Quípama - Boyacá ", " Quipile - Cundinamarca ", " Ragonvalia - Norte De Santander ", " Ramiriquí - Boyacá ", " Ráquira - Boyacá ", " Recetor - Casanare ", " Regidor - Bolívar ", " Remedios - Antioquia ", " Remolino - Magdalena ", " Repelón - Atlántico ", " Restrepo - Meta ", " Restrepo - Valle Del Cauca ", " Retiro - Antioquia ", " Ricaurte - Cundinamarca ", " Ricaurte - Nariño ", " Río De Oro - Cesar ", " Río Iró - Chocó ", " Río Quito - Chocó ", " Río Viejo - Bolívar ", " Rioblanco - Tolima ", " Riofrío - Valle Del Cauca ", " Riohacha - La Guajira ", " Rionegro - Antioquia ", " Rionegro - Santander ", " Riosucio - Caldas ", " Riosucio - Chocó ", " Risaralda - Caldas ", " Rivera - Huila ", " Roberto Payán - Nariño ", " Roldanillo - Valle Del Cauca ", " Roncesvalles - Tolima ", " Rondón - Boyacá ", " Rosas - Cauca ", " Rovira - Tolima ", " Sabana De Torres - Santander ", " Sabanagrande - Atlántico ", " Sabanalarga - Antioquia ", " Sabanalarga - Atlántico ", " Sabanalarga - Casanare ", " Sabanas De San Ángel - Magdalena ", " Sabaneta - Antioquia ", " Saboyá - Boyacá ", " Sácama - Casanare ", " Sáchica - Boyacá ", " Sahagún - Córdoba ", " Saladoblanco - Huila ", " Salamina - Caldas ", " Salamina - Magdalena ", " Salazar - Norte De Santander ", " Saldaña - Tolima ", " Salento - Quindío ", " Salgar - Antioquia ", " Samacá - Boyacá ", " Samaná - Caldas ", " Samaniego - Nariño ", " Sampués - Sucre ", " San Agustín - Huila ", " San Alberto - Cesar ", " San Andrés - Archipiélago De San Andrés, Providencia Y Santa Catalina ", " San Andrés - Santander ", " San Andrés De Cuerquía - Antioquia ", " San Andrés De Sotavento - Córdoba ", " San Andrés De Tumaco - Nariño ", " San Antero - Córdoba ", " San Antonio - Tolima ", " San Antonio Del Tequendama - Cundinamarca ", " San Benito - Santander ", " San Benito Abad - Sucre ", " San Bernardo - Cundinamarca ", " San Bernardo - Nariño ", " San Bernardo Del Viento - Córdoba ", " San Calixto - Norte De Santander ", " San Carlos - Antioquia ", " San Carlos - Córdoba ", " San Carlos De Guaroa - Meta ", " San Cayetano - Cundinamarca ", " San Cayetano - Norte De Santander ", " San Cristóbal - Bolívar ", " San Diego - Cesar ", " San Eduardo - Boyacá ", " San Estanislao - Bolívar ", " San Felipe - Guainía ", " San Fernando - Bolívar ", " San Francisco - Antioquia ", " San Francisco - Cundinamarca ", " San Francisco - Putumayo ", " San Gil - Santander ", " San Jacinto - Bolívar ", " San Jacinto Del Cauca - Bolívar ", " San Jerónimo - Antioquia ", " San Joaquín - Santander ", " San José - Caldas ", " San José De Cúcuta - Norte De Santander ", " San José De La Montaña - Antioquia ", " San José De Miranda - Santander ", " San José De Pare - Boyacá ", " San José De Toluviejo - Sucre ", " San José De Uré - Córdoba ", " San José Del Fragua - Caquetá ", " San José Del Guaviare - Guaviare ", " San José Del Palmar - Chocó ", " San Juan De Arama - Meta ", " San Juan De Betulia - Sucre ", " San Juan De Rioseco - Cundinamarca ", " San Juan De Urabá - Antioquia ", " San Juan Del Cesar - La Guajira ", " San Juan Nepomuceno - Bolívar ", " San Juanito - Meta ", " San Lorenzo - Nariño ", " San Luis - Antioquia ", " San Luis - Tolima ", " San Luis De Gaceno - Boyacá ", " San Luis De Palenque - Casanare ", " San Luis De Sincé - Sucre ", " San Marcos - Sucre ", " San Martín - Cesar ", " San Martín - Meta ", " San Martín De Loba - Bolívar ", " San Mateo - Boyacá ", " San Miguel - Putumayo ", " San Miguel - Santander ", " San Miguel De Sema - Boyacá ", " San Onofre - Sucre ", " San Pablo - Bolívar ", " San Pablo - Nariño ", " San Pablo De Borbur - Boyacá ", " San Pedro - Sucre ", " San Pedro - Valle Del Cauca ", " San Pedro De Cartago - Nariño ", " San Pedro De Los Milagros - Antioquia ", " San Pedro De Urabá - Antioquia ", " San Pelayo - Córdoba ", " San Rafael - Antioquia ", " San Roque - Antioquia ", " San Sebastián - Cauca ", " San Sebastián De Buenavista - Magdalena ", " San Sebastián De Mariquita - Tolima ", " San Vicente De Chucurí - Santander ", " San Vicente Del Caguán - Caquetá ", " San Vicente Ferrer - Antioquia ", " San Zenón - Magdalena ", " Sandoná - Nariño ", " Santa Ana - Magdalena ", " Santa Bárbara - Antioquia ", " Santa Bárbara - Nariño ", " Santa Bárbara - Santander ", " Santa Bárbara De Pinto - Magdalena ", " Santa Catalina - Bolívar ", " Santa Cruz De Mompox - Bolívar ", " Santa Fé De Antioquia - Antioquia ", " Santa Helena Del Opón - Santander ", " Santa Isabel - Tolima ", " Santa Lucía - Atlántico ", " Santa María - Boyacá ", " Santa María - Huila ", " Santa Marta - Magdalena ", " Santa Rosa - Bolívar ", " Santa Rosa - Cauca ", " Santa Rosa De Cabal - Risaralda ", " Santa Rosa De Osos - Antioquia ", " Santa Rosa De Viterbo - Boyacá ", " Santa Rosa Del Sur - Bolívar ", " Santa Rosalía - Vichada ", " Santa Sofía - Boyacá ", " Santacruz - Nariño ", " Santana - Boyacá ", " Santander De Quilichao - Cauca ", " Santiago - Norte De Santander ", " Santiago - Putumayo ", " Santiago De Tolú - Sucre ", " Santo Domingo - Antioquia ", " Santo Tomás - Atlántico ", " Santuario - Risaralda ", " Sapuyes - Nariño ", " Saravena - Arauca ", " Sardinata - Norte De Santander ", " Sasaima - Cundinamarca ", " Sativanorte - Boyacá ", " Sativasur - Boyacá ", " Segovia - Antioquia ", " Sesquilé - Cundinamarca ", " Sevilla - Valle Del Cauca ", " Siachoque - Boyacá ", " Sibaté - Cundinamarca ", " Sibundoy - Putumayo ", " Silos - Norte De Santander ", " Silvania - Cundinamarca ", " Silvia - Cauca ", " Simacota - Santander ", " Simijaca - Cundinamarca ", " Simití - Bolívar ", " Sincelejo - Sucre ", " Sipí - Chocó ", " Sitionuevo - Magdalena ", " Soacha - Cundinamarca ", " Soatá - Boyacá ", " Socha - Boyacá ", " Socorro - Santander ", " Socotá - Boyacá ", " Sogamoso - Boyacá ", " Solano - Caquetá ", " Soledad - Atlántico ", " Solita - Caquetá ", " Somondoco - Boyacá ", " Sonsón - Antioquia ", " Sopetrán - Antioquia ", " Soplaviento - Bolívar ", " Sopó - Cundinamarca ", " Sora - Boyacá ", " Soracá - Boyacá ", " Sotaquirá - Boyacá ", " Sotará Paispamba - Cauca ", " Suaita - Santander ", " Suan - Atlántico ", " Suárez - Cauca ", " Suárez - Tolima ", " Suaza - Huila ", " Subachoque - Cundinamarca ", " Sucre - Cauca ", " Sucre - Santander ", " Sucre - Sucre ", " Suesca - Cundinamarca ", " Supatá - Cundinamarca ", " Supía - Caldas ", " Suratá - Santander ", " Susa - Cundinamarca ", " Susacón - Boyacá ", " Sutamarchán - Boyacá ", " Sutatausa - Cundinamarca ", " Sutatenza - Boyacá ", " Tabio - Cundinamarca ", " Tadó - Chocó ", " Talaigua Nuevo - Bolívar ", " Tamalameque - Cesar ", " Támara - Casanare ", " Tame - Arauca ", " Támesis - Antioquia ", " Taminango - Nariño ", " Tangua - Nariño ", " Taraira - Vaupés ", " Tarapacá - Amazonas ", " Tarazá - Antioquia ", " Tarqui - Huila ", " Tarso - Antioquia ", " Tasco - Boyacá ", " Tauramena - Casanare ", " Tausa - Cundinamarca ", " Tello - Huila ", " Tena - Cundinamarca ", " Tenerife - Magdalena ", " Tenjo - Cundinamarca ", " Tenza - Boyacá ", " Teorama - Norte De Santander ", " Teruel - Huila ", " Tesalia - Huila ", " Tibacuy - Cundinamarca ", " Tibaná - Boyacá ", " Tibasosa - Boyacá ", " Tibirita - Cundinamarca ", " Tibú - Norte De Santander ", " Tierralta - Córdoba ", " Timaná - Huila ", " Timbío - Cauca ", " Timbiquí - Cauca ", " Tinjacá - Boyacá ", " Tipacoque - Boyacá ", " Tiquisio - Bolívar ", " Titiribí - Antioquia ", " Toca - Boyacá ", " Tocaima - Cundinamarca ", " Tocancipá - Cundinamarca ", " Togüí - Boyacá ", " Toledo - Antioquia ", " Toledo - Norte De Santander ", " Tona - Santander ", " Tópaga - Boyacá ", " Topaipí - Cundinamarca ", " Toribío - Cauca ", " Toro - Valle Del Cauca ", " Tota - Boyacá ", " Totoró - Cauca ", " Trinidad - Casanare ", " Trujillo - Valle Del Cauca ", " Tubará - Atlántico ", " Tuchín - Córdoba ", " Tuluá - Valle Del Cauca ", " Tunja - Boyacá ", " Tununguá - Boyacá ", " Túquerres - Nariño ", " Turbaco - Bolívar ", " Turbaná - Bolívar ", " Turbo - Antioquia ", " Turmequé - Boyacá ", " Tuta - Boyacá ", " Tutazá - Boyacá ", " Ubalá - Cundinamarca ", " Ubaque - Cundinamarca ", " Ulloa - Valle Del Cauca ", " Úmbita - Boyacá ", " Une - Cundinamarca ", " Unguía - Chocó ", " Unión Panamericana - Chocó ", " Uramita - Antioquia ", " Uribe - Meta ", " Uribia - La Guajira ", " Urrao - Antioquia ", " Urumita - La Guajira ", " Usiacurí - Atlántico ", " Útica - Cundinamarca ", " Valdivia - Antioquia ", " Valencia - Córdoba ", " Valle De San José - Santander ", " Valle De San Juan - Tolima ", " Valle Del Guamuez - Putumayo ", " Valledupar - Cesar ", " Valparaíso - Antioquia ", " Valparaíso - Caquetá ", " Vegachí - Antioquia ", " Vélez - Santander ", " Venadillo - Tolima ", " Venecia - Antioquia ", " Venecia - Cundinamarca ", " Ventaquemada - Boyacá ", " Vergara - Cundinamarca ", " Versalles - Valle Del Cauca ", " Vetas - Santander ", " Vianí - Cundinamarca ", " Victoria - Caldas ", " Vigía Del Fuerte - Antioquia ", " Vijes - Valle Del Cauca ", " Villa Caro - Norte De Santander ", " Villa De Leyva - Boyacá ", " Villa De San Diego De Ubaté - Cundinamarca ", " Villa Del Rosario - Norte De Santander ", " Villa Rica - Cauca ", " Villagarzón - Putumayo ", " Villagómez - Cundinamarca ", " Villahermosa - Tolima ", " Villamaría - Caldas ", " Villanueva - Bolívar ", " Villanueva - Casanare ", " Villanueva - La Guajira ", " Villanueva - Santander ", " Villapinzón - Cundinamarca ", " Villarrica - Tolima ", " Villavicencio - Meta ", " Villavieja - Huila ", " Villeta - Cundinamarca ", " Viotá - Cundinamarca ", " Viracachá - Boyacá ", " Vistahermosa - Meta ", " Viterbo - Caldas ", " Yacopí - Cundinamarca ", " Yacuanquer - Nariño ", " Yaguará - Huila ", " Yalí - Antioquia ", " Yarumal - Antioquia ", " Yavaraté - Vaupés ", " Yolombó - Antioquia ", " Yondó - Antioquia ", " Yopal - Casanare ", " Yotoco - Valle Del Cauca ", " Yumbo - Valle Del Cauca ", " Zambrano - Bolívar ", " Zapatoca - Santander ", " Zapayán - Magdalena ", " Zaragoza - Antioquia ", " Zarzal - Valle Del Cauca ", " Zetaquira - Boyacá ", " Zipacón - Cundinamarca ", " Zipaquirá - Cundinamarca ", " Zona Bananera - Magdalena ", "[San Cristóbal de] la Laguna" }));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Principal motivo del viaje:");

        cbomotivoviaje.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbomotivoviaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Negocios y motivos profesionales", "Vacaciones, recreo y ocio", "Visitas a familiares y a amigos", "Educación y formación", "Salud y atención médica", "Religión / peregrinaciones", "Compras", "Tránsito", "Otros motivos" }));

        txtidingreso.setText("IDI");

        txtidhabitacion.setText("IDH");
        txtidhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidhabitacionActionPerformed(evt);
            }
        });

        txtidcliente.setText("IDC");
        txtidcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidclienteActionPerformed(evt);
            }
        });

        txtidempleado.setText("IDEM");

        txtidinicioturno.setEditable(false);
        txtidinicioturno.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtidinicioturno.setText("IDIT");
        txtidinicioturno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidinicioturnoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("N° Habitación:");

        txtnumero.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroActionPerformed(evt);
            }
        });
        txtnumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnumeroKeyPressed(evt);
            }
        });

        txttipohabitacion.setEditable(false);
        txttipohabitacion.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Tipo Habita:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Costo Alojameinto:");

        txtcostoalojamiento.setEditable(false);
        txtcostoalojamiento.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Numero Personas:");

        txtnum_personas.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtnum_personas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_personasActionPerformed(evt);
            }
        });
        txtnum_personas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnum_personasKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Estado:");

        comestado.setEditable(true);
        comestado.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        comestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Finalizado", " " }));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro.png"))); // NOI18N
        jButton1.setText("Fact-Elec");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtcaracteristicas.setEditable(false);
        txtcaracteristicas.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Caracteristicas");

        btnacompañante.setBackground(new java.awt.Color(204, 204, 204));
        btnacompañante.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnacompañante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/amistoso.png"))); // NOI18N
        btnacompañante.setText("Acompa");
        btnacompañante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnacompañante.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnacompañante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnacompañante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnacompañanteActionPerformed(evt);
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

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Placa:");

        txtplaca.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtplaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplacaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Responsable:");

        txtnumero_turno.setEditable(false);
        txtnumero_turno.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtnumero_turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumero_turnoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("N°Turno:");

        txtempleado.setEditable(false);
        txtempleado.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N

        lbturnos.setText("lbturnos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnlimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnguardar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnacompañante))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcaracteristicas))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txttipohabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcostoalojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnum_personas, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(comestado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnumero_turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbturnos))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(txtcaracteristicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttipohabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtcostoalojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtnum_personas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnumero_turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(lbturnos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnacompañante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbociudadprocedencia, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtnumdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtidempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbociudadrecidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cbomotivoviaje, 0, 1, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtidinicioturno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jdfechaingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtidingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbo_tipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbotipo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jdfechaingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtidingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnumdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidinicioturno, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_tipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbotipo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbociudadrecidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cbociudadprocedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbomotivoviaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(244, 244, 244));

        jLabel16.setText("Buscar");

        lbltotalregistros.setText("Registros");

        tablalistadoingreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero", "Cliente", "Identificación", "Telefono", "Fecha Ingreso", "N° Personas", "Tipo Cliente", "Costo", "Motivo de Viaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablalistadoingreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoingresoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablalistadoingreso);

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

        btneliminar.setBackground(new java.awt.Color(204, 204, 204));
        btneliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalregistro)
                .addGap(45, 45, 45)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addGap(16, 16, 16))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar)
                    .addComponent(btneliminar)
                    .addComponent(lbltotalregistros)
                    .addComponent(lbltotalregistro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnum_personasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_personasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnum_personasActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        if (txtnum_personas.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar número de personas");
            txtnum_personas.requestFocus();
            return;
        }
        if (cbotipo_cliente.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el tipo de cliente");
            cbotipo_cliente.requestFocus();
            return;
        }
        if (jdfechaingreso.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes presionar NUEVO para refrescar la fecha");
            cbotipo_cliente.requestFocus();
            return;
        }

        Dingreso dts = new Dingreso();
        Fingreso func = new Fingreso();

        dts.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
        dts.setIdcliente(Integer.parseInt(txtidcliente.getText()));
        dts.setFecha_hora_ingreso(jdfechaingreso.getText());
        dts.setNum_personas(Integer.parseInt(txtnum_personas.getText().trim()));
        int seleccionado = cbotipo_cliente.getSelectedIndex();
        dts.setTipo_cliente((String) cbotipo_cliente.getItemAt(seleccionado));
        dts.setCostoalojamiento(Integer.parseInt(txtcostoalojamiento.getText().replace(",", "")));
        int motivoviaje = cbomotivoviaje.getSelectedIndex();
        dts.setMotivo_viaje(cbomotivoviaje.getItemAt(motivoviaje));
        int estado = comestado.getSelectedIndex();
        dts.setEstado((String) comestado.getItemAt(estado));
        int ciudadrecidencia = cbociudadrecidencia.getSelectedIndex();
        dts.setCiudad_de_recidencia(cbociudadrecidencia.getItemAt(ciudadrecidencia));
        int ciudadprocedencia = cbociudadprocedencia.getSelectedIndex();
        dts.setCiudad_de_procedencia(cbociudadprocedencia.getItemAt(ciudadprocedencia));
        dts.setNum_habitacion(Integer.parseInt(txtnumero.getText()));
        dts.setDocumento(txtnumdocumento.getText().trim());
        int tipo_documento = cbo_tipoDocumento.getSelectedIndex();
        dts.setTipo_documento((String) cbo_tipoDocumento.getItemAt(tipo_documento));
        dts.setTipo_habitacion(txttipohabitacion.getText());
        dts.setIdinicioturno(Integer.parseInt(txtidinicioturno.getText()));
        dts.setTurno(lbturnos.getText());
        dts.setNum_turno(Integer.parseInt(txtnumero_turno.getText()));

        if (accion.equals("guardar")) {
            // Verificar si ya existe un ingreso similar para evitar duplicados
            if (func.existeIngreso(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El ingreso ya existe. No se puede duplicar.");
                return;
            }

            if (func.insertar(dts)) {
                mostrar("");
//                JOptionPane.showMessageDialog(rootPane, "Ingreso registrado satisfactoriamente");
                Freserva estad = new Freserva();
                Dreserva dts1 = new Dreserva();
                dts1.setNumhabitacion(Integer.parseInt(txtnumero.getText()));
                estad.CambiarEstado(dts1);
                
                Fhabitacion func3 = new Fhabitacion();
                Dhabitacion dts3 = new Dhabitacion();
                dts3.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
                func3.ocupar(dts3);

                limpiarcajas();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error al guardar el ingreso");
                this.dispose();
            }
            String[] options = {"SI", "NO"};
            int confirmacion = JOptionPane.showOptionDialog(null,
                    "¿Desea asignar facturacion electronica?",
                    "FACTURA ELECTRÓNICA",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE, icono("/Imagenes/banca_electronica.png", 40, 40),
                    options,
                    options[0]);

            if (confirmacion == JOptionPane.YES_OPTION) { // 0 corresponde a la opción "SI"
                JconsultaFac_Elect facturaelectronica = new JconsultaFac_Elect();
                facturaelectronica.toFront();
                facturaelectronica.setVisible(true);
            } else if (confirmacion == JOptionPane.NO_OPTION) {

            }
        }

        if (accion.equals("editar")) {
            dts.setIdingreso(Integer.parseInt(txtidingreso.getText()));
            mostrar("");
            inhabilitar();

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "Editado satisfactoriamente");

                // Verificar el estado de la reserva
                Fhabitacion habitacionHandler = new Fhabitacion();
                Dhabitacion dtsHabitacion = new Dhabitacion();
                String estadoingreso = (String) comestado.getSelectedItem();

                dtsHabitacion.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));

                switch (estadoingreso) {
                    case "Activo" -> {
                        if (habitacionHandler.ocupar(dtsHabitacion)) {
                            JOptionPane.showMessageDialog(rootPane, "La habitación se marcó como ocupada.");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Error al marcar la habitación como disponible.");
                        }
                    }

                    case "Finalizado" -> {
                        if (habitacionHandler.desocupar(dtsHabitacion)) {
                            JOptionPane.showMessageDialog(rootPane, "La habitación se marcó como desocupada.");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Error al marcar la habitación como ocupada.");
                        }

                        limpiarcajas();
                        mostrarTiempo();
                    }

                    default ->
                        JOptionPane.showMessageDialog(rootPane, "Estado no reconocido.");
                }
            }
        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtidhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidhabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidhabitacionActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        // TODO add your handling code here:
        limpiarcajas();
        mostrarTiempo();
        btnguardar.setText("Guardar");
        accion = "guardar";
//        habilitar();


    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void txtnumdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumdocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumdocumentoActionPerformed

    private void jdfechaingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdfechaingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdfechaingresoActionPerformed

    private void txtnumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cconexion conexion = new Cconexion();
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);

            try {
                // Preparamos la consulta
                try (Connection conectar = conexion.establecerConexion()) {
                    // Preparamos la consulta
                    pst = conectar.prepareStatement("SELECT * FROM habitacion WHERE numero = ?");
                    pst.setString(1, txtnumero.getText());
                    rs = pst.executeQuery();
                    
                    if (rs.next()) {
                        String estado = rs.getString("estado");
                        
                        switch (estado.toLowerCase()) {
                            case "ocupado" -> JOptionPane.showMessageDialog(null, "La habitación está Ocupada.");
                            
                            case "mantenimiento" -> JOptionPane.showMessageDialog(null, "La habitación está en mantenimiento.");
                            
                            case "reserva" -> {
                                txtidhabitacion.setText(String.valueOf(rs.getInt("idhabitacion")));
                                txtnumero.setText(rs.getString("numero"));
                                txttipohabitacion.setText(rs.getString("tipohabitacion"));
                                txtcostoalojamiento.setText(formatoMiles.format(rs.getInt("precio")));
                                txtcaracteristicas.setText(rs.getString("caracteristicas"));
//                            int opcion = JOptionPane.showConfirmDialog(
//                                    rootPane, "La Habitación tiene reserva. ¿Desea darle ingreso?",
//                                    "Confirmación", JOptionPane.YES_NO_OPTION
//                            );
//
//                            if (opcion == JOptionPane.YES_OPTION) {
//                                // Obtener datos de reserva
//                                Fingreso func = new Fingreso();
//                                int habitacion = Integer.parseInt(txtnumero.getText());
//                                Object[] Numero = func.DatosReserva(habitacion);
//
//                                // Verificar y convertir los valores del arreglo
//                                String cliente = Numero[0] != null ? Numero[0].toString() : "";
//                                String documento = Numero[1] != null ? Numero[1].toString() : "";
//                                String telefono = Numero[2] != null ? Numero[2].toString() : "";
//                                int numHabitacion = Numero[3] != null ? Integer.parseInt(Numero[3].toString()) : 0;
//                                String tipohabitacion = Numero[4] != null ? Numero[4].toString() : "";
//                                int costoalojamiento = Numero[5] != null ? Integer.parseInt(Numero[5].toString()) : 0;
//                                String caracteristicas = Numero[6] != null ? Numero[6].toString() : "";
//                                int idhabitacion = Numero[7] != null ? Integer.parseInt(Numero[7].toString()) : 0;
//                                int idcliente = Numero[8] != null ? Integer.parseInt(Numero[8].toString()) : 0;
//                                // Actualizar la información en el formulario
//                                txtcliente.setText(cliente);
//                                txtnumdocumento.setText(documento);
//                                txttelefono.setText(telefono);
//                                txtnumero.setText(String.valueOf(numHabitacion));
//                                txttipohabitacion.setText(tipohabitacion);
//                                txtcostoalojamiento.setText(String.valueOf(costoalojamiento));
//                                txtcaracteristicas.setText(String.valueOf(caracteristicas));
//                                txtidhabitacion.setText(String.valueOf(idhabitacion));
//                                txtidcliente.setText(String.valueOf(idcliente));
//
//                                Freserva cambio = new Freserva();
//                                Dreserva dts = new Dreserva();
//                                dts.setNumhabitacion(Integer.parseInt(txtnumero.getText()));
//                                cambio.CambiarEstado(dts);
//
//                                Fhabitacion Funci = new Fhabitacion();
//                                Dhabitacion dts1 = new Dhabitacion();
//                                dts1.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
//                                Funci.disponible(dts1);
//                            }
                            }
                            
                            case "limpieza" -> JOptionPane.showMessageDialog(null, "La habitación está en Limpieza.");
                            
                            case "disponible" -> {
                                txtidhabitacion.setText(String.valueOf(rs.getInt("idhabitacion")));
                                txtnumero.setText(rs.getString("numero"));
                                txttipohabitacion.setText(rs.getString("tipohabitacion"));
                                txtcostoalojamiento.setText(formatoMiles.format(rs.getInt("precio")));
                                txtcaracteristicas.setText(rs.getString("caracteristicas"));
                            }
                            
                            default -> JOptionPane.showMessageDialog(null, "Estado desconocido.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el número solicitado.");
                    }
                }

            } catch (HeadlessException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: " + ex.getMessage());
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroKeyPressed

    private void txtnumdocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumdocumentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cconexion conexion = new Cconexion();

            try {
                // Preparar la consulta SQL para buscar el cliente por número de documento
                try (Connection conectar = conexion.establecerConexion()) {
                    // Preparar la consulta SQL para buscar el cliente por número de documento
                    pst = conectar.prepareStatement("SELECT * FROM cliente WHERE numdocumento=?");
                    pst.setString(1, txtnumdocumento.getText());
                    
                    rs = pst.executeQuery();
                    
                    if (rs.next()) {
                        // Rellenar los campos del formulario con los datos del cliente
                        txtidcliente.setText(String.valueOf(rs.getInt("idcliente")));
                        txtcliente.setText(rs.getString("nombres") + " " + rs.getString("apellidos"));
                        txtnumdocumento.setText(rs.getString("numdocumento"));
                        txttelefono.setText(rs.getString("telefono"));
                        
                        // Obtener el tipo de documento desde la base de datos
                        String tipoDocumentoDB = rs.getString("tipodocumento");
                        
                        // Comprobar si el tipo de documento obtenido coincide con alguna opción del JComboBox
                        boolean encontrado = false;
                        for (int i = 0; i < cbo_tipoDocumento.getItemCount(); i++) {
                            if (cbo_tipoDocumento.getItemAt(i).equals(tipoDocumentoDB)) {
                                cbo_tipoDocumento.setSelectedIndex(i);
                                encontrado = true;
                                break;
                            }
                        }
                        
                        // Si no se encuentra una coincidencia, podrías mostrar un mensaje o dejar el JComboBox sin selección
                        if (!encontrado) {
                            JOptionPane.showMessageDialog(null, "El tipo de documento no coincide con las opciones disponibles.");
                            cbo_tipoDocumento.setSelectedIndex(-1); // Deja el JComboBox sin selección
                        }
                        
                    } else {
                        // Mensaje si no se encuentra el cliente
                        JOptionPane.showMessageDialog(null, "No se encontró el CLIENTE solicitado.");
                    }
                }

            } catch (HeadlessException | SQLException ex) {
                System.err.println("Error: " + ex);
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_txtnumdocumentoKeyPressed

    private void tablalistadoingresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoingresoMouseClicked

        btnguardar.setText("Editar");
//        inhabilitar();
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistadoingreso.rowAtPoint(evt.getPoint());

        txtidingreso.setText(tablalistadoingreso.getValueAt(fila, 0).toString());
        txtidhabitacion.setText(tablalistadoingreso.getValueAt(fila, 1).toString());
        txtnumero.setText(tablalistadoingreso.getValueAt(fila, 2).toString());
        txttipohabitacion.setText(tablalistadoingreso.getValueAt(fila, 3).toString());
        txtcaracteristicas.setText(tablalistadoingreso.getValueAt(fila, 4).toString());
        txtidcliente.setText(tablalistadoingreso.getValueAt(fila, 5).toString());
        txtcliente.setText(tablalistadoingreso.getValueAt(fila, 6).toString());
        txttelefono.setText(tablalistadoingreso.getValueAt(fila, 7).toString());
        txtnumdocumento.setText(tablalistadoingreso.getValueAt(fila, 8).toString());
        jdfechaingreso.setText(tablalistadoingreso.getValueAt(fila, 9).toString());
        txtnum_personas.setText(tablalistadoingreso.getValueAt(fila, 10).toString());
        cbotipo_cliente.setSelectedItem(tablalistadoingreso.getValueAt(fila, 11).toString());
        txtcostoalojamiento.setText(tablalistadoingreso.getValueAt(fila, 12).toString());
        cbomotivoviaje.setSelectedItem(tablalistadoingreso.getValueAt(fila, 13).toString());
        comestado.setSelectedItem(tablalistadoingreso.getValueAt(fila, 14).toString());
        cbociudadrecidencia.setSelectedItem(tablalistadoingreso.getValueAt(fila, 15).toString());
        cbociudadprocedencia.setSelectedItem(tablalistadoingreso.getValueAt(fila, 16).toString());
        txtplaca.setText(tablalistadoingreso.getValueAt(fila, 17).toString());

    }//GEN-LAST:event_tablalistadoingresoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        if (!txtidingreso.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el ingreso?", "Confirmar", 2);

            if (confirmacion == 0) {

                Fhabitacion habitacion = new Fhabitacion();
                Dhabitacion dts1 = new Dhabitacion();
                dts1.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
                habitacion.disponible(dts1);

                Fingreso func = new Fingreso();
                Dingreso dts = new Dingreso();

                dts.setIdingreso(Integer.parseInt(txtidingreso.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        mostrar(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnacompañanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnacompañanteActionPerformed
        // TODO add your handling code here:

        if (acompañante == null || !acompañante.isVisible()) {
            // Si no está abierto, crea una nueva instancia o usa el Singleton
            acompañante = Jacompañante.getInstance(); // Usando Singleton
            acompañante.setVisible(true);
        } else {
            // Si ya está abierto, enfócalo
            acompañante.setExtendedState(JFrame.NORMAL); // Restaurar si está minimizado
            acompañante.toFront(); // Traer al frente
            acompañante.requestFocus(); // Solicitar foco
        }

    }//GEN-LAST:event_btnacompañanteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        idcliente = txtidcliente.getText();

        if (factura == null || !factura.isVisible()) {
            // Si no está abierto, crea una nueva instancia o usa el Singleton
            factura = Jregistro_factura_electronica.getInstance(); // Usando Singleton
            factura.setVisible(true);

            // Añadir WindowListener para limpiar la variable cuando se cierre el formulario
            factura.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    idcliente = ""; // Limpiar la variable
                }

                @Override
                public void windowClosed(WindowEvent e) {
                    idcliente = ""; // Limpiar la variable cuando el formulario ya se haya cerrado
                }
            });

        } else {
            // Si ya está abierto, enfócalo
            factura.setExtendedState(JFrame.NORMAL); // Restaurar si está minimizado
            factura.toFront(); // Traer al frente
            factura.requestFocus(); // Solicitar foco
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtnum_personasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnum_personasKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            try {
//                // Obtener el número de personas desde el campo de texto
//                int numeroPersonas = Integer.parseInt(txtnum_personas.getText().trim());
//
//                // Supongamos que tienes un campo de texto o una variable para el tipo de habitación
//                String tipoHabitacion = txttipohabitacion.getText().trim(); // Cambia esto según tu variable o campo
//                String caracteristica = txtcaracteristicas.getText().trim();
//
//                int costoAlojamiento = Integer.parseInt(txtcostoalojamiento.getText());
//                // Valor por defecto del costo de alojamiento
//
//                // Verificar las condiciones para cambiar el costo de alojamiento
//                if (numeroPersonas == 2 && tipoHabitacion.equalsIgnoreCase("Doble")) {
//                    costoAlojamiento = Integer.parseInt(txtcostoalojamiento.getText()); // Cambia el costo de alojamiento a 150.000
//                } else if (numeroPersonas == 1 && caracteristica.equalsIgnoreCase("Sencillas")) {
//                    costoAlojamiento = 70000; // Cambia el costo de alojamiento a 70.000
//                }
//
//                // Mostrar el costo de alojamiento actualizado
//                txtcostoalojamiento.setText(String.valueOf(costoAlojamiento));
//
//            } catch (HeadlessException ex) {
//                System.err.println("Error: " + ex);
//            } catch (NumberFormatException ex) {
//                // Manejar el caso donde el número de personas no sea un número válido
//                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido de personas.");
//            }
//        }
    }//GEN-LAST:event_txtnum_personasKeyPressed

    private void cbociudadrecidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbociudadrecidenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbociudadrecidenciaActionPerformed

    private void txtnumero_turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumero_turnoActionPerformed
        // Generar el número de turno
    }//GEN-LAST:event_txtnumero_turnoActionPerformed

    private void txtidinicioturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidinicioturnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidinicioturnoActionPerformed

    private void txtclienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclienteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cconexion conexion = new Cconexion();

            try {
                // Preparar la consulta SQL para buscar el cliente por número de documento
                try (Connection conectar = conexion.establecerConexion()) {
                    // Preparar la consulta SQL para buscar el cliente por número de documento
                    pst = conectar.prepareStatement("SELECT * FROM cliente WHERE CONCAT(nombres, ' ', apellidos) = ?");
                    pst.setString(1, txtcliente.getText());
                    
                    rs = pst.executeQuery();
                    
                    if (rs.next()) {
                        // Rellenar los campos del formulario con los datos del cliente
                        txtidcliente.setText(String.valueOf(rs.getInt("idcliente")));
                        txtcliente.setText(rs.getString("nombres") + " " + rs.getString("apellidos"));
                        txtnumdocumento.setText(rs.getString("numdocumento"));
                        txttelefono.setText(rs.getString("telefono"));
                        
                        // Obtener el tipo de documento desde la base de datos
                        String tipoDocumentoDB = rs.getString("tipodocumento");
                        
                        // Comprobar si el tipo de documento obtenido coincide con alguna opción del JComboBox
                        boolean encontrado = false;
                        for (int i = 0; i < cbo_tipoDocumento.getItemCount(); i++) {
                            if (cbo_tipoDocumento.getItemAt(i).equals(tipoDocumentoDB)) {
                                cbo_tipoDocumento.setSelectedIndex(i);
                                encontrado = true;
                                break;
                            }
                        }
                        
                        // Si no se encuentra una coincidencia, podrías mostrar un mensaje o dejar el JComboBox sin selección
                        if (!encontrado) {
                            JOptionPane.showMessageDialog(null, "El tipo de documento no coincide con las opciones disponibles.");
                            cbo_tipoDocumento.setSelectedIndex(-1); // Deja el JComboBox sin selección
                        }
                        
                    } else {
                        // Mensaje si no se encuentra el cliente
                        JOptionPane.showMessageDialog(null, "No se encontró el CLIENTE solicitado.");
                    }
                }

            } catch (HeadlessException | SQLException ex) {
                System.err.println("Error: " + ex);
            }
        }
    }//GEN-LAST:event_txtclienteKeyPressed

    private void txtplacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplacaActionPerformed

    private void txtidclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidclienteActionPerformed

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
            java.util.logging.Logger.getLogger(Jingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Jingreso().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnacompañante;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JComboBox<String> cbo_tipoDocumento;
    private javax.swing.JComboBox<String> cbociudadprocedencia;
    private javax.swing.JComboBox<String> cbociudadrecidencia;
    private javax.swing.JComboBox<String> cbomotivoviaje;
    private javax.swing.JComboBox<String> cbotipo_cliente;
    private javax.swing.JComboBox<String> comestado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jdfechaingreso;
    private javax.swing.JLabel lbltotalregistro;
    private javax.swing.JLabel lbltotalregistros;
    public static javax.swing.JLabel lbturnos;
    private javax.swing.JTable tablalistadoingreso;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcaracteristicas;
    public static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtcostoalojamiento;
    public static javax.swing.JTextField txtempleado;
    public static javax.swing.JTextField txtidcliente;
    public static javax.swing.JTextField txtidempleado;
    public static javax.swing.JTextField txtidhabitacion;
    public static javax.swing.JTextField txtidingreso;
    private javax.swing.JTextField txtidinicioturno;
    private javax.swing.JTextField txtnum_personas;
    public static javax.swing.JTextField txtnumdocumento;
    public static javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtnumero_turno;
    private javax.swing.JTextField txtplaca;
    public static javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttipohabitacion;
    // End of variables declaration//GEN-END:variables

}
