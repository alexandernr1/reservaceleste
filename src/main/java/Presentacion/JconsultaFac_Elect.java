package Presentacion;

import Datos.Dacompañante;
import Datos.Dfactura_electronica;
import Datos.DsalidaAcompañante;
import Datos.Tiempopro;
import Logica.Cconexion;
import Logica.Facompañante;
import Logica.Ffactura_electronica;
import Logica.FsalidaAcompañante;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JconsultaFac_Elect extends javax.swing.JFrame {

    PreparedStatement pst;
    ResultSet rs;

    public JconsultaFac_Elect() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FACTURA ELECTRONICA");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ocultar();

    }
    private String accion = "guardar";
    
    private void ocultar() {
        txtidcliente.setVisible(false);
        txtdepartamento.setVisible(false);
        txtmunicipio.setVisible(false);
        txtdireccion.setVisible(false);
        txttelefono.setVisible(false);
        chbagente_retencion_iva.setVisible(false);
        chbautoretenedor.setVisible(false);
        chbgrancontribuyente.setVisible(false);
        chbregimen_simple_tributario.setVisible(false);
        chbnoresponsable.setVisible(false);
        chbGrancontribuyente.setVisible(false);
        chbautoretenedores.setVisible(false);
        chbregimencomunpersonajuridica.setVisible(false);
        chbNoResponsableIva.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        btnsalida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtdocumento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtrazon_social = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txtdv = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtnum_habitacion = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txthabitacion = new javax.swing.JTextField();
        txttipo_persona = new javax.swing.JTextField();
        txttipo_documento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtdepartamento = new javax.swing.JTextField();
        txtmunicipio = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        chbgrancontribuyente = new javax.swing.JCheckBox();
        chbautoretenedor = new javax.swing.JCheckBox();
        chbagente_retencion_iva = new javax.swing.JCheckBox();
        chbregimen_simple_tributario = new javax.swing.JCheckBox();
        chbautoretenedores = new javax.swing.JCheckBox();
        chbGrancontribuyente = new javax.swing.JCheckBox();
        chbregimencomunpersonajuridica = new javax.swing.JCheckBox();
        chbNoResponsableIva = new javax.swing.JCheckBox();
        chbnoresponsable = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnsalida.setBackground(new java.awt.Color(204, 204, 204));
        btnsalida.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnsalida.setText("Guardar");
        btnsalida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsalida.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnsalida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalidaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Documento/NIT:");

        txtdocumento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocumentoActionPerformed(evt);
            }
        });
        txtdocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdocumentoKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Razon social:");

        txtrazon_social.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtrazon_social.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrazon_socialActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Email:");

        txtemail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        txtdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdvActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setText("D.V");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("N°Habit:");

        txtnum_habitacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtidcliente.setText("0");
        txtidcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidclienteActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txttipo_persona.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txttipo_documento.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Tipo Documento:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Tipo de persona:");

        chbgrancontribuyente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        chbgrancontribuyente.setText("Gran Contribuyente");
        chbgrancontribuyente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbgrancontribuyenteActionPerformed(evt);
            }
        });

        chbautoretenedor.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        chbautoretenedor.setText("Autoretenedor");

        chbagente_retencion_iva.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        chbagente_retencion_iva.setText("Agente de Retencion IVA");

        chbregimen_simple_tributario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        chbregimen_simple_tributario.setText("Regimen simple de tributacion");

        chbautoretenedores.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        chbautoretenedores.setText("Auto Retenedores");
        chbautoretenedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbautoretenedoresActionPerformed(evt);
            }
        });

        chbGrancontribuyente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        chbGrancontribuyente.setText("Gran Contribuyente");
        chbGrancontribuyente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbGrancontribuyenteActionPerformed(evt);
            }
        });

        chbregimencomunpersonajuridica.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        chbregimencomunpersonajuridica.setText("Regimen Comun Persona Juridica");
        chbregimencomunpersonajuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbregimencomunpersonajuridicaActionPerformed(evt);
            }
        });

        chbNoResponsableIva.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        chbNoResponsableIva.setText("No Responsable de Iva");
        chbNoResponsableIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbNoResponsableIvaActionPerformed(evt);
            }
        });

        chbnoresponsable.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        chbnoresponsable.setText("No responsable");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1)
                                .addGap(12, 12, 12)
                                .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(296, 296, 296)
                                .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txttipo_persona))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txttipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtnum_habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtrazon_social, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(btnsalida)
                                    .addGap(35, 35, 35)
                                    .addComponent(txtdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txttelefono))
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chbgrancontribuyente)
                            .addComponent(chbregimen_simple_tributario)
                            .addComponent(chbagente_retencion_iva)
                            .addComponent(chbautoretenedor)
                            .addComponent(chbnoresponsable))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chbNoResponsableIva)
                            .addComponent(chbautoretenedores)
                            .addComponent(chbregimencomunpersonajuridica)
                            .addComponent(chbGrancontribuyente)
                            .addComponent(txtmunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(txtdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(txtnum_habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txttipo_persona, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtrazon_social, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalida))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chbgrancontribuyente)
                    .addComponent(chbautoretenedores))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbautoretenedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chbagente_retencion_iva)
                        .addGap(4, 4, 4)
                        .addComponent(chbregimen_simple_tributario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbnoresponsable)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(chbGrancontribuyente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbregimencomunpersonajuridica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbNoResponsableIva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jLayeredPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalidaActionPerformed

//    private void btnsalidaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // Validaciones iniciales
        if (txtdocumento.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar Documento");
            txtdocumento.requestFocus();
            return;
        }
        if (txtrazon_social.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una Razon social/Nombre");
            txtrazon_social.requestFocus();
            return;
        }

        if (txtidcliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Por favor presione enter en el N° HUESPED PRINCIPAL 0 (BOTÓN DE BUSQUEDA) para relacionar con el CLIENTE");
            txtidcliente.requestFocus();
            return;
        }
        if (txtdv.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Por favor ingrese el Dígito de verificación (D.V)");
            txtdv.requestFocus();
            return;
        }

        // Crear el objeto de factura electrónica
        Dfactura_electronica dts = new Dfactura_electronica();
        Ffactura_electronica fnc = new Ffactura_electronica();

        dts.setDocumento(Integer.parseInt(txtdocumento.getText().trim()));
        dts.setDv(Integer.parseInt(txtdv.getText().trim()));
        dts.setRazon_social(txtrazon_social.getText().trim());
        dts.setEmail(txtemail.getText().trim());
        dts.setTipo_persona(txttipo_persona.getText());
        dts.setTipo_documento(txttipo_documento.getText());
        dts.setDepartamento((String) txtdepartamento.getText());
        dts.setMunicipio((String) txtmunicipio.getText());

        dts.setDireccion(txtdireccion.getText().trim());
        dts.setTelefono(txttelefono.getText().trim());
       

        List<String> responsabilidadesFiscales = new ArrayList<>();
        if (chbagente_retencion_iva.isSelected()) {
            responsabilidadesFiscales.add("Agente Retención IVA");
        }
        if (chbautoretenedor.isSelected()) {
            responsabilidadesFiscales.add("Autoretenedor");
        }
        if (chbgrancontribuyente.isSelected()) {
            responsabilidadesFiscales.add("Gran Contribuyente");
        }
        if (chbregimen_simple_tributario.isSelected()) {
            responsabilidadesFiscales.add("Régimen Simple Tributario");
        }
        if (chbnoresponsable.isSelected()) {
            responsabilidadesFiscales.add("No Responsable");
        }
        dts.setResponsabilidades_fiscales(String.join(",", responsabilidadesFiscales));

        List<String> RegimenFiscal = new ArrayList<>();
        if (chbautoretenedores.isSelected()) {
            RegimenFiscal.add("Auto Retenedores");
        }
        if (chbGrancontribuyente.isSelected()) {
            RegimenFiscal.add("Gran Contribuyente");
        }
        if (chbregimencomunpersonajuridica.isSelected()) {
            RegimenFiscal.add("Regimen Comun Persona Juridica");
        }
        if (chbNoResponsableIva.isSelected()) {
            RegimenFiscal.add("No Responsable de Iva");
        }
        dts.setRegimen_fiscal(String.join(",", RegimenFiscal));

        dts.setIdcliente(Integer.parseInt(txtidcliente.getText().trim()));

        if (fnc.existeCliente(dts.getDocumento())) {
            if (fnc.actualizar(dts)) {
                int opcion1 = JOptionPane.showConfirmDialog(rootPane, "Datos Registrados. ¿Desea realizar un abono?", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (opcion1 == JOptionPane.YES_OPTION) {
                    // Mostrar formulario de abono
                    Jabono formularioAbono = new Jabono();
                    formularioAbono.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error al actualizar la información del cliente.");
            }

        }
      this.dispose();

    }//GEN-LAST:event_btnsalidaActionPerformed

    private void txtdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocumentoActionPerformed
        // TODO add your handling code here:
        txtdocumento.transferFocus();
    }//GEN-LAST:event_txtdocumentoActionPerformed

    private void txtdocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdocumentoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cconexion conexion = new Cconexion();

            try {
                Connection conectar = conexion.establecerConexion();

                pst = conectar.prepareStatement("select * from factura_electronica where documento=?");
                pst.setString(1, txtdocumento.getText());

                rs = pst.executeQuery();

                if (rs.next()) {
                    txtdocumento.setText(String.valueOf(rs.getInt("documento")));
                    txtdv.setText(rs.getString("DV"));
                    txtrazon_social.setText(rs.getString("razon_social"));
                    txtemail.setText(rs.getString("email"));
                    txttipo_persona.setText(rs.getString("tipo_persona"));
                    txttipo_documento.setText(rs.getString("tipo_documento"));
                    txtdepartamento.setText(rs.getString("departamento"));
                    txtmunicipio.setText(rs.getString("municipio"));
                    txtdireccion.setText(rs.getString("direccion"));
                    txttelefono.setText(rs.getString("telefono"));
                  
                    String responsabilidadesFiscales = rs.getString("responsabilidades_fiscales");

                    // Desmarcar todos los checkboxes primero
                    chbagente_retencion_iva.setSelected(false);
                    chbautoretenedor.setSelected(false);
                    chbgrancontribuyente.setSelected(false);
                    chbregimen_simple_tributario.setSelected(false);
                    chbnoresponsable.setSelected(false);

                    // Dividir la cadena de responsabilidades fiscales y marcar los checkboxes correspondientes
                    if (responsabilidadesFiscales != null && !responsabilidadesFiscales.isEmpty()) {
                        String[] responsabilidadesArray = responsabilidadesFiscales.split(",");

                        for (String responsabilidad : responsabilidadesArray) {
                            switch (responsabilidad.trim()) {
                                case "Agente Retención IVA" ->
                                    chbagente_retencion_iva.setSelected(true);
                                case "Autoretenedor" ->
                                    chbautoretenedor.setSelected(true);
                                case "Gran Contribuyente" ->
                                    chbgrancontribuyente.setSelected(true);
                                case "Régimen Simple Tributario" ->
                                    chbregimen_simple_tributario.setSelected(true);
                                case "No Responsable" ->
                                    chbnoresponsable.setSelected(true);
                            }
                        }
                    }
                    String Regimenfiscal = rs.getString("regimen_fiscal");

                    // Desmarcar todos los checkboxes primero
                    chbautoretenedores.setSelected(false);
                    chbGrancontribuyente.setSelected(false);
                    chbregimencomunpersonajuridica.setSelected(false);
                    chbNoResponsableIva.setSelected(false);

                    // Dividir la cadena de responsabilidades fiscales y marcar los checkboxes correspondientes
                    if (Regimenfiscal != null && !Regimenfiscal.isEmpty()) {
                        String[] regimenArray = Regimenfiscal.split(",");

                        for (String regimen : regimenArray) {
                            switch (regimen.trim()) {
                                case "Agente Retención IVA" ->
                                    chbautoretenedores.setSelected(true);
                                case "Autoretenedor" ->
                                    chbGrancontribuyente.setSelected(true);
                                case "Gran Contribuyente" ->
                                    chbregimencomunpersonajuridica.setSelected(true);
                                case "Régimen Simple Tributario" ->
                                    chbNoResponsableIva.setSelected(true);

                            }
                        }
                    }

                } else {
                    int opcion1 = JOptionPane.showConfirmDialog(rootPane, "Cliente no registrado. ¿Desea realizar registro?", "Confirmación", JOptionPane.YES_NO_OPTION);

                    if (opcion1 == JOptionPane.YES_OPTION) {
                        Jregistro_factura_electronica registro = new Jregistro_factura_electronica();
                        registro.toFront();
                        registro.setVisible(true);
                    }
                }
                conectar.close();

            } catch (HeadlessException | SQLException ex) {
                System.err.println("Error: " + ex);
            }
        }
    }//GEN-LAST:event_txtdocumentoKeyPressed

    private void txtrazon_socialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrazon_socialActionPerformed
        // TODO add your handling code here:
        txtrazon_social.transferFocus();
    }//GEN-LAST:event_txtrazon_socialActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
        txtemail.transferFocus();
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdvActionPerformed
        // TODO add your handling code here:
        txtdv.transferFocus();
    }//GEN-LAST:event_txtdvActionPerformed

    private void txtidclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidclienteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Cconexion conexion = new Cconexion();

        try {
            Connection conectar = conexion.establecerConexion();

            // Primera consulta: obtener el idcliente basado en el numdocumento
            PreparedStatement pst1 = conectar.prepareStatement("select idcliente, num_habitacion from ingreso where num_habitacion = ? AND estado = 'Activo'");
            pst1.setString(1, txtnum_habitacion.getText());

            ResultSet rs1 = pst1.executeQuery();

            if (rs1.next()) {
                // Si se encuentra el cliente, establece los valores en los campos
                txtidcliente.setText(rs1.getString("idCliente"));
                txthabitacion.setText(rs1.getString("num_habitacion"));
            } else {
                // Si no se encuentra el cliente
                JOptionPane.showMessageDialog(null, "No se encontró el CLIENTE solicitado");
            }

        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void chbgrancontribuyenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbgrancontribuyenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbgrancontribuyenteActionPerformed

    private void chbautoretenedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbautoretenedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbautoretenedoresActionPerformed

    private void chbGrancontribuyenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbGrancontribuyenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbGrancontribuyenteActionPerformed

    private void chbregimencomunpersonajuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbregimencomunpersonajuridicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbregimencomunpersonajuridicaActionPerformed

    private void chbNoResponsableIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbNoResponsableIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbNoResponsableIvaActionPerformed

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
            java.util.logging.Logger.getLogger(JconsultaFac_Elect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JconsultaFac_Elect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JconsultaFac_Elect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JconsultaFac_Elect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JconsultaFac_Elect().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsalida;
    private javax.swing.JCheckBox chbGrancontribuyente;
    private javax.swing.JCheckBox chbNoResponsableIva;
    private javax.swing.JCheckBox chbagente_retencion_iva;
    private javax.swing.JCheckBox chbautoretenedor;
    private javax.swing.JCheckBox chbautoretenedores;
    private javax.swing.JCheckBox chbgrancontribuyente;
    private javax.swing.JCheckBox chbnoresponsable;
    private javax.swing.JCheckBox chbregimen_simple_tributario;
    private javax.swing.JCheckBox chbregimencomunpersonajuridica;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtdepartamento;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdocumento;
    private javax.swing.JTextField txtdv;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthabitacion;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtmunicipio;
    private javax.swing.JTextField txtnum_habitacion;
    private javax.swing.JTextField txtrazon_social;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttipo_documento;
    private javax.swing.JTextField txttipo_persona;
    // End of variables declaration//GEN-END:variables
}
