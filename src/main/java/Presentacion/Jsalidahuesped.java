package Presentacion;

import Datos.Dacompañante;
import Datos.Dcambio;
import Datos.Dfactura_electronica;
import Datos.Dhabitacion;
import Datos.Dingreso;
import Datos.Dinicioturno;
import Datos.Dsalida;
import Datos.Tiempopro;
import Impresion.ImprimirSalida;
import Logica.Facompañante;
import Logica.Fcambio;
import Logica.Fhabitacion;
import Logica.Fingreso;
import Logica.Fsalida;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class Jsalidahuesped extends javax.swing.JFrame {

    Tiempopro time = new Tiempopro();
    private static Jsalidahuesped instance;

    public Jsalidahuesped() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("SALIDA");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mostrarTiempo();
        inhabilitar();
        colocarceros();
        clientesVarios();
        agregarWindowFocusListener();
        txtcobrosfraccion.setText("0");
        txtotros_cobros.setText("0");
        txtvalor_noches.setText("0");
        txtabonos.setText("0");
        txtvalor_total.setText("0");
        txttotaldescuentos.setText("0");
        txtotros_cobros.setText("0");
        txttotal_pago.setText("0");

    }
    public static int idusuario;
    private String accion = "guardar";

    public static String razon_social = "";
    public static String documento = "";
    public static String correo;
    public static String numero_noches;
    public static String habitacion = "";
    public static String totaldescuentos = "";
    public static String cobros_extra = "";
    public static String pagototal = "";
    public static String empleado = "";
    public static String numero_turno = "";
    public static String deuda_anterior = "";
    public static String idcliente = "";
    public static String costoalojamiento = "";
    public static String total = "";

    public static Jsalidahuesped getInstance() {
        if (instance == null) {
            instance = new Jsalidahuesped();
        }
        return instance;
    }
    private void clientesVarios() {
        txtrazon_social.setText("Clientes Varios");
        txtDocumento.setText("22222");
        txtcorreo.setText("ClietesVarios@clientes.com");
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

    private void mostrarTiempo() {

        txtfecha_hora_salida.setText(time.getFechacomp() + " " + time.getHoracomp());
    }

    void colocarceros() {
        txtdeudaanterior.setText("0");
        txtvalorSinIVA.setText("0");
        txtIVA_19.setText("0");
        txtreten_35.setText("0");
        txtreten4.setText("0");
        txtefectivo.setText("0");
        txttarjeta.setText("0");
        txttransferencia.setText("0");
    }

    void limpiarcajas() {
        txtcajabuscar.setText("");
        txtcliente.setText("");
        txtdocumento.setText("");
        txtnumnoches.setText("");
        txtcostoalojamiento.setText("");
        txtfecha_hora_ingreso.setText("");
        txtfecha_hora_salida.setText("");
        txtnumero.setText("");
        cbotipo_cliente.setSelectedItem(0);
        txtcliente.setText("");
        txtvalor_noches.setText("");
        txtabonos.setText("");
        txtvalor_total.setText("");
        txttotaldescuentos.setText("");
        txtcobrosfraccion.setText("");
        txtotros_cobros.setText("");
        txttotal_pago.setText("");
        txtdeudaanterior.setText("");
        txtDocumento.setText("");
        txtcorreo.setText("");
        txtrazon_social.setText("");
        txttotal.setText("");
        txtvalorSinIVA.setText("");
        txtIVA_19.setText("");
        txtreten_35.setText("");
        txtreten4.setText("");
        txtsubtotal.setText("");
        txtefectivo.setText("");
        txttarjeta.setText("");
        txttransferencia.setText("");
        txttelefono.setText("");
        txtparqueadero.setText("");
        txtlavanderia.setText("");

    }

    void inhabilitar() {
        txtidingreso.setVisible(false);
        txtidabono.setVisible(false);
        txtidsalida.setVisible(false);
        txtidempleado.setVisible(false);
        txtidhabitacion.setVisible(false);
        txtidcliente.setVisible(false);

    }

    void imprimir() {
        ImprimirSalida imprimir = new ImprimirSalida();
        try {
            imprimir.ImprimirFacturaPago();

        } catch (IOException ex) {
            Logger.getLogger(Jsalidahuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtvalor_noches = new javax.swing.JTextField();
        txttotaldescuentos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtabonos = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtotros_cobros = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtvalor_total = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txttotal_pago = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtcobrosfraccion = new javax.swing.JTextField();
        txtreten4 = new javax.swing.JTextField();
        txtvalorSinIVA = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        deudaanterior = new javax.swing.JLabel();
        txtdeudaanterior = new javax.swing.JTextField();
        txtIVA_19 = new javax.swing.JTextField();
        txtreten_35 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        calcular35 = new javax.swing.JButton();
        calcular4 = new javax.swing.JButton();
        txttarjeta = new javax.swing.JTextField();
        txttransferencia = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtefectivo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtempleado = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtnumero_turno = new javax.swing.JTextField();
        lbturno = new javax.swing.JLabel();
        txtparqueadero = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtlavanderia = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txttelefono = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbotipo_cliente = new javax.swing.JComboBox<>();
        txtdocumento = new javax.swing.JTextField();
        txtnumero = new javax.swing.JTextField();
        txtcostoalojamiento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtfecha_hora_salida = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtfecha_hora_ingreso = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtcajabuscar = new javax.swing.JTextField();
        txtnumnoches = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtidcliente = new javax.swing.JTextField();
        txtidingreso = new javax.swing.JTextField();
        txtidhabitacion = new javax.swing.JTextField();
        txtidempleado = new javax.swing.JTextField();
        txtidsalida = new javax.swing.JTextField();
        txtidabono = new javax.swing.JTextField();
        txtidinicioturno = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtrazon_social = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        factura = new javax.swing.JButton();
        btncambiohabit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new java.awt.Color(244, 244, 244));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "COBROS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Valor noches:");

        txtvalor_noches.setEditable(false);
        txtvalor_noches.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtvalor_noches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalor_nochesActionPerformed(evt);
            }
        });

        txttotaldescuentos.setEditable(false);
        txttotaldescuentos.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Descuentos:");
        jLabel10.setToolTipText("");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Otros cobros:");

        txtabonos.setEditable(false);
        txtabonos.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Abonos:");
        jLabel14.setToolTipText("");

        txtotros_cobros.setEditable(false);
        txtotros_cobros.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Valor total:");

        txtvalor_total.setEditable(false);
        txtvalor_total.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtvalor_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalor_totalActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("Total Pago:");

        txttotal_pago.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txttotal_pago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttotal_pagoKeyPressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("IVA(19.00%):");

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setText("Reten (3.5%):");

        txtcobrosfraccion.setEditable(false);
        txtcobrosfraccion.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtcobrosfraccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcobrosfraccionActionPerformed(evt);
            }
        });

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

        txtvalorSinIVA.setEditable(false);
        txtvalorSinIVA.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setText("Valor antes de IVA:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Cobro fraccion:");

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setText("total:");

        deudaanterior.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        deudaanterior.setText("Deuda Anterior:");

        txtdeudaanterior.setEditable(false);
        txtdeudaanterior.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

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

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setText("Reten (4%):");

        txttotal.setEditable(false);
        txttotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        txttotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttotalKeyPressed(evt);
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

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setText("Ttransferencia:");

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel30.setText("Tarjeta:");

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel31.setText("Efectivo:");

        txtefectivo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtefectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtefectivoKeyPressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setText("Calcular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel32.setText("Subtotal:");

        txtsubtotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtsubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubtotalActionPerformed(evt);
            }
        });
        txtsubtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsubtotalKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Responsable salida:");

        txtempleado.setEditable(false);
        txtempleado.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtempleadoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("Turno:");
        jLabel17.setToolTipText("");

        txtnumero_turno.setEditable(false);

        lbturno.setText("jLabel1");

        txtparqueadero.setEditable(false);
        txtparqueadero.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtparqueadero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtparqueaderoActionPerformed(evt);
            }
        });
        txtparqueadero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtparqueaderoKeyPressed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel34.setText("Parqueadero:");

        txtlavanderia.setEditable(false);
        txtlavanderia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtlavanderia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlavanderiaActionPerformed(evt);
            }
        });
        txtlavanderia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtlavanderiaKeyPressed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setText("Lavanderia;");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16)
                            .addComponent(jLabel9)
                            .addComponent(deudaanterior)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel28))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtreten4, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(calcular4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtvalorSinIVA, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtIVA_19, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtreten_35, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(calcular35)
                                            .addComponent(jButton2)))
                                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtparqueadero, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtlavanderia, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel29)
                                                .addComponent(jLabel21))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtefectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txttarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txttransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txttotal_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(83, 83, 83))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtdeudaanterior)
                                        .addComponent(txtabonos)
                                        .addComponent(txttotaldescuentos)
                                        .addComponent(txtvalor_total)
                                        .addComponent(txtotros_cobros)
                                        .addComponent(txtcobrosfraccion)
                                        .addComponent(txtvalor_noches, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtnumero_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbturno)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtvalor_noches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtabonos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txttotaldescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtvalor_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtotros_cobros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtcobrosfraccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deudaanterior)
                            .addComponent(txtdeudaanterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtparqueadero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtlavanderia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtvalorSinIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(txtIVA_19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(txtreten_35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(txtreten4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(calcular4)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(calcular35)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtefectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txttarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txttransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotal_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(114, 114, 114)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtnumero_turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbturno))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HUESPED", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 12))); // NOI18N

        txttelefono.setEditable(false);
        txttelefono.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Telefono:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Cliente:");

        txtcliente.setEditable(false);
        txtcliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Docuemento:");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("Tipo cliente:");

        cbotipo_cliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbotipo_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "General", "Administrativo" }));

        txtdocumento.setEditable(false);
        txtdocumento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocumentoActionPerformed(evt);
            }
        });

        txtnumero.setEditable(false);
        txtnumero.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroActionPerformed(evt);
            }
        });

        txtcostoalojamiento.setEditable(false);
        txtcostoalojamiento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("Valor noche:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Habitación:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Fecha de ingreso:");

        txtfecha_hora_salida.setEditable(false);
        txtfecha_hora_salida.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtfecha_hora_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfecha_hora_salidaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Fecha de salida:");

        txtfecha_hora_ingreso.setEditable(false);
        txtfecha_hora_ingreso.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtfecha_hora_ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfecha_hora_ingresoActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N

        txtcajabuscar.setMinimumSize(new java.awt.Dimension(70, 30));
        txtcajabuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcajabuscarActionPerformed(evt);
            }
        });
        txtcajabuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcajabuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcajabuscarKeyReleased(evt);
            }
        });

        txtnumnoches.setEditable(false);
        txtnumnoches.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtnumnoches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumnochesActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("N° Noches:");

        txtidcliente.setText("DIC");
        txtidcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidclienteActionPerformed(evt);
            }
        });

        txtidingreso.setText("IDI");

        txtidhabitacion.setText("DIH");
        txtidhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidhabitacionActionPerformed(evt);
            }
        });

        txtidempleado.setText("IDE");

        txtidsalida.setText("IDS");

        txtidabono.setText("IDA");

        txtidinicioturno.setText("IDI");

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel33.setText("bus *Habita:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtfecha_hora_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbotipo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumnoches, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcostoalojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtcajabuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtfecha_hora_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidinicioturno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidabono, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcajabuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtidabono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtfecha_hora_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtidempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtidinicioturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtfecha_hora_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidsalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbotipo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(txtnumnoches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtcostoalojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista-de-verificacion.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(204, 204, 204));
        btnguardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida-de-emergencia.png"))); // NOI18N
        btnguardar.setText("Salida");
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS FACTURACION ELECTRONICA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 12))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("NIT/CC:");

        txtrazon_social.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Razon Social:");

        txtcorreo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setText("Correo:");

        txtDocumento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel20))
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrazon_social, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtrazon_social, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        factura.setBackground(new java.awt.Color(204, 204, 204));
        factura.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        factura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/facturacion.png"))); // NOI18N
        factura.setText("Imprimir");
        factura.setEnabled(false);
        factura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        factura.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        factura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaActionPerformed(evt);
            }
        });

        btncambiohabit.setBackground(new java.awt.Color(204, 204, 204));
        btncambiohabit.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btncambiohabit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/habitaciones.png"))); // NOI18N
        btncambiohabit.setText("Cambio habit");
        btncambiohabit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncambiohabit.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btncambiohabit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncambiohabit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncambiohabitActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnguardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(factura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btncambiohabit, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(6, 6, 6)
                        .addComponent(btnguardar)
                        .addGap(6, 6, 6)
                        .addComponent(factura)
                        .addGap(6, 6, 6)
                        .addComponent(btncambiohabit))))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnguardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(factura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btncambiohabit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroActionPerformed

    private void txtfecha_hora_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfecha_hora_salidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfecha_hora_salidaActionPerformed

    private void txtdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdocumentoActionPerformed

    private void txtfecha_hora_ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfecha_hora_ingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfecha_hora_ingresoActionPerformed

    private void txtempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtempleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtempleadoActionPerformed

    private void txtnumnochesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumnochesActionPerformed
//        mostradias();

    }//GEN-LAST:event_txtnumnochesActionPerformed

    private void txtvalor_nochesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalor_nochesActionPerformed


    }//GEN-LAST:event_txtvalor_nochesActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        if (txtrazon_social.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Porfavor colocar dastos de facturacion electronica");
            txtrazon_social.requestFocus();
            return;

        }
        
        
        if (!btnguardar.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de darle salida?", "Confirmar", 2);
            if (confirmacion == 0) {
                Dsalida dts = new Dsalida();
                Fsalida func = new Fsalida();
                dts.setIdingreso(Integer.parseInt(txtidingreso.getText()));
                dts.setIdcliente(Integer.parseInt(txtidcliente.getText()));
                dts.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
                dts.setIdabono(Integer.parseInt(txtidabono.getText()));
                dts.setEmpleado(String.valueOf(txtempleado.getText()));
                dts.setNumero_turno(Integer.parseInt(txtnumero_turno.getText()));
                dts.setNumero(Integer.parseInt(txtnumero.getText()));
                dts.setCliente(String.valueOf(txtcliente.getText()));
                dts.setNumnoches(Integer.parseInt(txtnumnoches.getText()));
                dts.setRazon_social(txtrazon_social.getText());
                dts.setDocumento(Integer.parseInt(txtDocumento.getText()));
                dts.setEmail(txtcorreo.getText());
                dts.setCostoalojamiento(Integer.parseInt(txtcostoalojamiento.getText().replace(",", "")));
                dts.setFechaingreso(String.valueOf(txtfecha_hora_ingreso.getText()));
                dts.setFechasalida(String.valueOf(txtfecha_hora_salida.getText()));

                String seleccionadoTipocliente = (String) cbotipo_cliente.getSelectedItem();
                dts.setTipocliente(seleccionadoTipocliente);

                dts.setValor_noches(Integer.parseInt(txtvalor_noches.getText().replace(",", "")));
                dts.setAbonos(Integer.parseInt(txtabonos.getText().replace(",", "")));
                dts.setValor_total(Integer.parseInt(txtvalor_total.getText().replace(",", "")));
                dts.setDescuentos(Integer.parseInt(txttotaldescuentos.getText().replace(",", "")));
                dts.setCobros_extra(Integer.parseInt(txtcobrosfraccion.getText().replace(",", "")));
                dts.setOtros_cobros(Integer.parseInt(txtotros_cobros.getText().replace(",", "")));
                dts.setDeuda_anterior(Integer.parseInt(txtdeudaanterior.getText().replace(",", "")));
                dts.setTotal(Integer.parseInt(txttotal.getText().replace(",", "")));
                dts.setAntesIVA(Integer.parseInt(txtvalorSinIVA.getText().replace(",", "")));
                dts.setIVA19(Integer.parseInt(txtIVA_19.getText().replace(",", "")));
                dts.setReten35(Integer.parseInt(txtreten_35.getText().replace(",", "")));
                dts.setReten4(Integer.parseInt(txtreten4.getText().replace(",", "")));
                dts.setSubtotal(Integer.parseInt(txtsubtotal.getText().replace(",", "")));
                dts.setEfectivo(Integer.parseInt(txtefectivo.getText().replace(",", "")));
                dts.setTarjeta(Integer.parseInt(txttarjeta.getText().replace(",", "")));
                dts.setTransferencias(Integer.parseInt(txttransferencia.getText()));
                dts.setTotalpago(Integer.parseInt(txttotal_pago.getText().replace(",", "")));
                dts.setIdinicioturno(Integer.parseInt(txtidinicioturno.getText()));
                dts.setTurno(lbturno.getText());
                dts.setParqueadero(Integer.parseInt(txtparqueadero.getText().replace(",", "")));
                dts.setLavanderia(Integer.parseInt(txtlavanderia.getText().replace(",", "")));

                if (accion.equals("guardar")) {
                    if (func.insertar(dts)) {

                        inhabilitar();

                        Fhabitacion func2 = new Fhabitacion();
                        Dhabitacion dts2 = new Dhabitacion();

                        dts2.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
                        func2.desocupar(dts2);

                        Fingreso fnc = new Fingreso();
                        Dingreso dts3 = new Dingreso();

                        dts3.setIdingreso(Integer.parseInt(txtidingreso.getText()));
                        fnc.finalizar(dts3);

                        Fcambio func3 = new Fcambio();
                        Dcambio dts4 = new Dcambio();

                        dts4.setNumero_habita(Integer.parseInt(txtnumero.getText()));
                        func3.finalizar(dts4);

                        Facompañante funci = new Facompañante();
                        Dacompañante datos = new Dacompañante();

                        datos.setIdcliente(Integer.parseInt(txtidcliente.getText()));
                        funci.desocuparacompañante(datos);
//                        imprimir();

                        int respuesta = JOptionPane.showConfirmDialog(rootPane, "SALIDA DE HUESPED EXITO. ¿Deseas asignar limpeza?", "confirmación", JOptionPane.YES_NO_OPTION);
                        limpiarcajas();
                        if (respuesta == JOptionPane.YES_NO_OPTION) {

                            Jlimpieza limpieza = new Jlimpieza();
                            limpieza.toFront();
                            limpieza.setVisible(true);

                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtidhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidhabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidhabitacionActionPerformed

    private void txtidclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidclienteActionPerformed

    private void txtvalor_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalor_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalor_totalActionPerformed

    private void txtcobrosfraccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcobrosfraccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcobrosfraccionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarcajas();     
        clientesVarios();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcajabuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcajabuscarKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            txtotros_cobros.setText("0");
            txtcobrosfraccion.setText("0");
            txttotal.setText("0");
            txtvalorSinIVA.setText("0");
            txtIVA_19.setText("0");
            txtreten_35.setText("0");
            txtreten4.setText("0");
            txtsubtotal.setText("0");
            txtefectivo.setText("0");
            txttarjeta.setText("0");
            txttransferencia.setText("0");
            txttotal_pago.setText("0");
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            try {
                ResultSet rs = new Fsalida().realizarConsulta(txtcajabuscar.getText());

                if (rs.next()) {
                    txtidingreso.setText(String.valueOf(rs.getInt("idingreso")));
                    txtidcliente.setText(String.valueOf(rs.getInt("idcliente")));
                    txtidabono.setText(String.valueOf(rs.getInt("idabono")));
//                    txtabonos.setText(String.valueOf(rs.getInt("abonohabitacion")));

                    txtidhabitacion.setText(String.valueOf(rs.getInt("idhabitacion")));
                    txtcliente.setText(rs.getString("clienten") + " " + rs.getString("clienteap"));
                    txttelefono.setText(rs.getString("clientete"));
                    cbotipo_cliente.setSelectedItem(String.valueOf(rs.getString("tipo_cliente")));

                    // Formatear el costo de alojamiento
                    int costoAlojamiento = rs.getInt("costoalojamiento");
                    txtcostoalojamiento.setText(formatoMiles.format(costoAlojamiento));

                    txtnumero.setText(String.valueOf(rs.getInt("numero")));
                    txtdocumento.setText(String.valueOf(rs.getString("clientenu")));
                    txtfecha_hora_ingreso.setText(String.valueOf(rs.getString("fecha_hora_ingreso")));

                    String fechaHoraIngreso = rs.getString("fecha_hora_ingreso").trim();
                    // Parsear la fecha de ingreso
                    LocalDateTime fechaIngreso = LocalDateTime.parse(fechaHoraIngreso, DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a", Locale.ENGLISH));

                    // Definir los límites del Turno 3 (10:00 PM a 6:00 AM del día siguiente)
                    LocalTime inicioTurno3 = LocalTime.of(22, 0);  // 10:00 PM
                    LocalTime finTurno3 = LocalTime.of(6, 0);      // 6:00 AM

                    // Obtener la fecha y hora actual
                    LocalDateTime fechaHoraActual = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a", Locale.ENGLISH);
                    String fechaHoraActualFormateada = fechaHoraActual.format(formatter);
                    txtfecha_hora_salida.setText(fechaHoraActualFormateada); // Establecer la fecha de salida en el campo

                    // Calcular la diferencia en días entre la fecha de ingreso y la fecha actual
                    long numNoches = ChronoUnit.DAYS.between(fechaIngreso.toLocalDate(), fechaHoraActual.toLocalDate());

                    // Verificar si la entrada es durante el Turno 3
                    if ((fechaIngreso.toLocalTime().isAfter(inicioTurno3) || fechaIngreso.toLocalTime().equals(inicioTurno3))
                            || (fechaIngreso.toLocalTime().isAfter(LocalTime.MIDNIGHT) && fechaIngreso.toLocalTime().isBefore(finTurno3))) {
                        // Si ingresó después de la medianoche durante el Turno 3, contar como una noche adicional
                        if (fechaIngreso.toLocalTime().isAfter(LocalTime.MIDNIGHT) && fechaIngreso.toLocalTime().isBefore(finTurno3)) {
                            numNoches += 1; // Contar la noche que corresponde al turno
                        }
                    } else if (numNoches == 0) {
                        // Si ingresó y salió el mismo día, cobrar una sola noche
                        numNoches = 1;
                    } else {
                        // Verificar si la salida es después de las 3:00 PM
                        LocalTime horaLimiteCobroTarde = LocalTime.of(15, 0); // 3:00 PM
                        if (fechaHoraActual.toLocalTime().isAfter(horaLimiteCobroTarde)) {
                            numNoches += 1; // Cobrar una noche adicional si la salida es después de las 3:00 PM
                        }
                    }

                    // Establecer el número de noches en el campo correspondiente
                    txtnumnoches.setText(String.valueOf(numNoches));

                    // Calcular nuevo costo de alojamiento
                    int numeroNoches = Integer.parseInt(txtnumnoches.getText());
                    int nuevoCostoAlojamiento = costoAlojamiento * numeroNoches;
                    txtvalor_noches.setText(formatoMiles.format(nuevoCostoAlojamiento));

                    int descuentosSuma = Integer.parseInt(txtidingreso.getText());
                    Fsalida des = new Fsalida();
                    int Sumadescuantos = des.sumadescuentos(descuentosSuma);
                    System.out.print("descuento es de:" + Sumadescuantos);
                    txttotaldescuentos.setText(formatoMiles.format(Sumadescuantos));
                    
                      int IDingreso = Integer.parseInt(txtidingreso.getText());
                    Fsalida funa1 = new Fsalida();
                    int[] suma1 = funa1.parque_lavan(IDingreso);
                    int parqueadero = suma1[0];
                    int lavanderia = suma1[1];

                    txtparqueadero.setText(formatoMiles.format(parqueadero));
                    txtlavanderia.setText(formatoMiles.format(lavanderia));

                    int parqueo = Integer.parseInt(txtparqueadero.getText().replace(",", ""));
                    int lavada = Integer.parseInt(txtlavanderia.getText().replace(",", ""));
                    int nuemero = Integer.parseInt(txtidingreso.getText().replace(",", ""));
                    Fsalida funa = new Fsalida();
                    int suma = funa.sumaAbono(nuemero);
                    int nuevoabono = (int) suma - parqueo - lavada;
                    txtabonos.setText(formatoMiles.format(nuevoabono));

               
                    int Nuevovalortotal = (int) nuevoCostoAlojamiento - nuevoabono - Sumadescuantos;

                    txtvalor_total.setText(formatoMiles.format(Nuevovalortotal));

                    int costoFraccionEntero = 0;

                    if (!fechaHoraActual.isEqual(fechaIngreso)) {
                        // Establecer la hora estándar de check-out a las 12:10 PM
                        LocalDateTime checkOutStandard = fechaHoraActual.toLocalDate().atTime(12, 10);

                        // Verificar si la hora actual está dentro del período de cobro extra (hasta 3 horas después del check-out estándar)
                        if (fechaHoraActual.isBefore(checkOutStandard.plusHours(3))) {

                            if (fechaHoraActual.isAfter(checkOutStandard)) {
                                long horasAdicionales = ChronoUnit.HOURS.between(checkOutStandard, fechaHoraActual);

                                // Redondear hacia arriba si hay fracción de hora
                                if (fechaHoraActual.getMinute() > 0) {
                                    horasAdicionales++;  // Aumentar las horas si ha pasado una fracción
                                }

                                // Calcular el costo adicional por las horas adicionales
                                int costoFraccion = (int) (horasAdicionales * 0.10 * costoAlojamiento);
                                costoFraccionEntero = (int) Math.round(costoFraccion);
                                txtcobrosfraccion.setText(formatoMiles.format(costoFraccionEntero));
                            }

                        }
                    } else {
                        // No se aplica cobro adicional si es igual a la hora de ingreso
                        txtcobrosfraccion.setText("0");
                    }

                    Fsalida func = new Fsalida();
                    String documento = txtdocumento.getText();
                    int deudaanterior = func.deudaanterior(documento);
                    txtdeudaanterior.setText(formatoMiles.format(deudaanterior));

                    //DATOS DE CLIENTE FACTURA ELECTRONICA
                    int factura = Integer.parseInt(txtidcliente.getText());
                    Dfactura_electronica clienteF = new Fsalida().cleinteFacturar(factura);
                    if (clienteF != null) {
                        txtrazon_social.setText(clienteF.getRazon_social());
                        txtcorreo.setText(clienteF.getEmail());
                        txtDocumento.setText(String.valueOf(clienteF.getDocumento()));
                    }

                    int netocobros = Integer.parseInt(txtidingreso.getText());
                    int otroscobros = func.otroscobros(netocobros);
                    txtotros_cobros.setText(String.valueOf(otroscobros));

                    // Cálculo del subtotal
                    int valorTOTAL = Integer.parseInt(txtvalor_total.getText().replace(",", ""));
                    int otrosCobros = Integer.parseInt(txtotros_cobros.getText().replace(",", ""));
                    int cobrofraccion = Integer.parseInt(txtcobrosfraccion.getText().replace(",", ""));
                    int deudaAnterior = Integer.parseInt(txtdeudaanterior.getText().replace(",", ""));

                    int subtotal = (valorTOTAL + otrosCobros + cobrofraccion + deudaAnterior);
                    System.out.print("el subtotal es"+subtotal);
                    txttotal.setText(formatoMiles.format(subtotal));

                    // Calcular total a pagar
                    String tipoCliente = rs.getString("tipo_cliente");
                    if (!"Administrativo".equalsIgnoreCase(tipoCliente)) {
                        // Si el cliente no es administrativo, se calcula el total normal.
                        int totalAPagar = subtotal /* + otros posibles descuentos */;
                        if (totalAPagar < 0) {
                            totalAPagar = 0; // No puede haber un valor negativo de cobro.
                        }
                        txttotal.setText(formatoMiles.format(subtotal));
                    } else {
                        // Si el cliente es administrativo, establecer los cobros como 0
                        txttotal.setText("0");
                        txttotaldescuentos.setText("0");
                        txtvalor_total.setText("0");
                        txtotros_cobros.setText("0");
                        txtcobrosfraccion.setText("0");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el CLIENTE solicitado");
                }
            } catch (HeadlessException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al procesar la información del cliente.");

            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_txtcajabuscarKeyPressed

    private void btncambiohabitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambiohabitActionPerformed
        // TODO add your handling code here:
        pagototal = txttotal.getText();
        empleado = txtempleado.getText();
        numero_turno = txtnumero_turno.getText();
        JcambioHabit cambio = new JcambioHabit();
        cambio.toFront();
        cambio.setVisible(true);
    }//GEN-LAST:event_btncambiohabitActionPerformed

    private void txtcajabuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcajabuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcajabuscarActionPerformed

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaActionPerformed
        imprimir();

    }//GEN-LAST:event_facturaActionPerformed

    private void txtIVA_19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIVA_19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIVA_19ActionPerformed

    private void txtIVA_19KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIVA_19KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIVA_19KeyPressed

    private void txtreten_35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreten_35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreten_35ActionPerformed

    private void txtreten_35KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtreten_35KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreten_35KeyPressed

    private void txtreten4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreten4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreten4ActionPerformed

    private void txtreten4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtreten4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreten4KeyPressed

    private void txttotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            try {
                // Obtener los valores de los campos de texto y convertirlos a enteros
                int valoracobrar = Integer.parseInt(txtvalorSinIVA.getText().replace(",", ""));
                int Iva19 = Integer.parseInt(txtIVA_19.getText().replace(",", ""));
                int reten35 = Integer.parseInt(txtreten_35.getText().replace(",", ""));
                int reten4 = Integer.parseInt(txtreten4.getText().replace(",", ""));
                int fraccion = Integer.parseInt(txtcobrosfraccion.getText().replace(",", ""));
                int deudaanterior = Integer.parseInt(txtdeudaanterior.getText().replace(",", ""));

                int subtotal = valoracobrar + Iva19 - reten35 - reten4 + fraccion + deudaanterior;

                txttotal.setText(formatoMiles.format(subtotal));

            } catch (NumberFormatException e) {
                // Manejar la excepción si alguno de los campos de texto no contiene un número válido
                System.err.println("Error: uno o más campos no contienen un número válido");
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_txttotalKeyPressed

    private void calcular4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcular4ActionPerformed
        // TODO add your handling code here:
        NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
        int valorcobrar = Integer.parseInt(txtvalorSinIVA.getText().replace(",", ""));
        int reten4 = (int) (valorcobrar * 0.04);
        txtreten4.setText(formatoMiles.format(reten4));
    }//GEN-LAST:event_calcular4ActionPerformed

    private void calcular35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcular35ActionPerformed
        // TODO add your handling code here:
        NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
        int valorcobrar = Integer.parseInt(txtvalorSinIVA.getText().replace(",", ""));
        int Reten35 = (int) (valorcobrar * 0.035);
        txtreten_35.setText(formatoMiles.format(Reten35));
    }//GEN-LAST:event_calcular35ActionPerformed

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
                txttotal_pago.setText(formatoMiles.format(totalPago));

            } catch (NumberFormatException e) {
                // Manejar la excepción si alguno de los campos de texto no contiene un número válido
                JOptionPane.showMessageDialog(null, "Error: uno o más campos no contienen un número válido");
            }

        }
    }//GEN-LAST:event_txtefectivoKeyPressed

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
                txttotal_pago.setText(formatoMiles.format(totalPago));

            } catch (NumberFormatException e) {
                // Manejar la excepción si alguno de los campos de texto no contiene un número válido
                JOptionPane.showMessageDialog(null, "Error: uno o más campos no contienen un número válido");
            }

        }
    }//GEN-LAST:event_txttarjetaKeyPressed

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
                txttotal_pago.setText(formatoMiles.format(totalPago));

            } catch (NumberFormatException e) {
                // Manejar la excepción si alguno de los campos de texto no contiene un número válido
                JOptionPane.showMessageDialog(null, "Error: uno o más campos no contienen un número válido");
            }

        }
    }//GEN-LAST:event_txttransferenciaKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
        try {
            int costoalojamiento = Integer.parseInt(txttotal.getText().replace(",", ""));
            int valorsinIVA = (int) (costoalojamiento / 1.19);
            txtvalorSinIVA.setText(String.valueOf(valorsinIVA).replace(",", ""));

            int valorConIVA = (int) (valorsinIVA * 0.19);
            txtIVA_19.setText(String.valueOf(valorConIVA).replace(",", ""));

            // Obtener los valores de los campos de texto y convertirlos a enteros
            int valosiIVA = Integer.parseInt(txtvalorSinIVA.getText().replace(",", ""));
            int Iva19 = Integer.parseInt(txtIVA_19.getText().replace(",", ""));
            int reten35 = Integer.parseInt(txtreten_35.getText().replace(",", ""));
            int reten4 = Integer.parseInt(txtreten4.getText().replace(",", ""));

            int subtotal = valosiIVA + Iva19 - reten35 - reten4 + 1;
//              int subtotalRedondeado = Math.round((float) subtotal);
            int subtotalRedondeado = (int) (Math.ceil(subtotal / 100.0) * 100);
            txtsubtotal.setText(formatoMiles.format(subtotalRedondeado));

        } catch (NumberFormatException e) {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void txtsubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubtotalActionPerformed

    private void txtsubtotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsubtotalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            try {
                // Obtener los valores de los campos de texto y convertirlos a enteros
                int valosiIVA = Integer.parseInt(txtvalorSinIVA.getText().replace(",", ""));
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

    private void txtcajabuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcajabuscarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcajabuscarKeyReleased

    private void txttotal_pagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotal_pagoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            try {
                // Obtener los valores de los campos de texto y convertirlos a enteros
                int efectivo = Integer.parseInt(txtefectivo.getText().replace(",", ""));
                int tarjeta = Integer.parseInt(txttarjeta.getText().replace(",", ""));
                int transferencia = Integer.parseInt(txttransferencia.getText().replace(",", ""));

                int totalPago = efectivo + tarjeta + transferencia;
                txttotal_pago.setText(formatoMiles.format(totalPago));

            } catch (NumberFormatException e) {
                // Manejar la excepción si alguno de los campos de texto no contiene un número válido
                JOptionPane.showMessageDialog(null, "Error: uno o más campos no contienen un número válido");
            }

        }
    }//GEN-LAST:event_txttotal_pagoKeyPressed

    private void txtparqueaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtparqueaderoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtparqueaderoActionPerformed

    private void txtparqueaderoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtparqueaderoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtparqueaderoKeyPressed

    private void txtlavanderiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlavanderiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlavanderiaActionPerformed

    private void txtlavanderiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlavanderiaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlavanderiaKeyPressed

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
            java.util.logging.Logger.getLogger(Jsalidahuesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jsalidahuesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jsalidahuesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jsalidahuesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Jsalidahuesped().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncambiohabit;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton calcular35;
    private javax.swing.JButton calcular4;
    private javax.swing.JComboBox<String> cbotipo_cliente;
    private javax.swing.JLabel deudaanterior;
    private javax.swing.JButton factura;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel lbturno;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtIVA_19;
    private javax.swing.JTextField txtabonos;
    private javax.swing.JTextField txtcajabuscar;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtcobrosfraccion;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtcostoalojamiento;
    private javax.swing.JTextField txtdeudaanterior;
    private javax.swing.JTextField txtdocumento;
    private javax.swing.JTextField txtefectivo;
    public static javax.swing.JTextField txtempleado;
    private javax.swing.JTextField txtfecha_hora_ingreso;
    private javax.swing.JTextField txtfecha_hora_salida;
    private javax.swing.JTextField txtidabono;
    private javax.swing.JTextField txtidcliente;
    public static javax.swing.JTextField txtidempleado;
    private javax.swing.JTextField txtidhabitacion;
    private javax.swing.JTextField txtidingreso;
    private javax.swing.JTextField txtidinicioturno;
    private javax.swing.JTextField txtidsalida;
    private javax.swing.JTextField txtlavanderia;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtnumero_turno;
    private javax.swing.JTextField txtnumnoches;
    private javax.swing.JTextField txtotros_cobros;
    private javax.swing.JTextField txtparqueadero;
    private javax.swing.JTextField txtrazon_social;
    private javax.swing.JTextField txtreten4;
    private javax.swing.JTextField txtreten_35;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttarjeta;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txttotal_pago;
    private javax.swing.JTextField txttotaldescuentos;
    private javax.swing.JTextField txttransferencia;
    private javax.swing.JTextField txtvalorSinIVA;
    private javax.swing.JTextField txtvalor_noches;
    private javax.swing.JTextField txtvalor_total;
    // End of variables declaration//GEN-END:variables
}
