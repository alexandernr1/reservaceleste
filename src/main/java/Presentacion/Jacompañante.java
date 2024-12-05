package Presentacion;

import Datos.Dacompañante;
import Logica.Cconexion;
import Logica.Facompañante;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public final class Jacompañante extends javax.swing.JFrame {

    PreparedStatement pst;
    ResultSet rs;
    private static Jacompañante instance;

    public Jacompañante() {
        initComponents();

        mostraracompañante("");
        setLocationRelativeTo(null);
        setTitle("INGRESO DE ACOMPAÑANTE");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inhabilita();
        QuitarespaciosCombobox();
        AutoCompleteDecoreitor();

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

    public static Jacompañante getInstance() {
        if (instance == null) {
            instance = new Jacompañante();
        }
        return instance;
    }

    public void inhabilita() {
        txtidacompañante.setVisible(false);
        txtidcliente.setVisible(false);
    }

    public void limpiarcampo() {
        txtidcliente.setText("");
        txtacompañante.setText(null);
        cbo_tipoDocumento.setSelectedItem("Seleccionar");
        txtdocumentos.setText(null);
        cboparentesco.setSelectedItem("Seleccionar");
        txtnumero_habitacion.setText(null);
        cbociudadprocedencia.setSelectedItem("Seleccionar");
        cbociudadrecidencia.setSelectedItem("Seleccionar");

    }

    void ocultarcolumnas() {
        tablalistadoacompañante.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistadoacompañante.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadoacompañante.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistadoacompañante.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadoacompañante.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoacompañante.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    public void mostraracompañante(String buscar) {
        try {
            DefaultTableModel modelo;
            Facompañante func = new Facompañante();
            modelo = func.mostraracompañante(buscar);

            tablalistadoacompañante.setModel(modelo);
            ocultarcolumnas();
            lbltotalregistroacompañante.setText("Total Registros " + Integer.toString(func.totalregistros));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtacompañante = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtdocumentos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtnumero_habitacion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnGuardarAcomp = new javax.swing.JButton();
        cboparentesco = new javax.swing.JComboBox<>();
        cbo_tipoDocumento = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        dcCheckin = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtnum_principal = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtidacompañante = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cboestado = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        cbociudadrecidencia = new javax.swing.JComboBox<>();
        cbociudadprocedencia = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablalistadoacompañante = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        txtbuscaracompañante = new javax.swing.JTextField();
        btneliminaracompañante = new javax.swing.JButton();
        btnbuscaracompañante = new javax.swing.JButton();
        lbltotalregistroacompañante = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "INGRESO ACOMPAÑANTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 14))); // NOI18N

        txtacompañante.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Nmbre completo:");

        txtdocumentos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Documento:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Parentesco:");

        txtnumero_habitacion.setEditable(false);
        txtnumero_habitacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtnumero_habitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumero_habitacionActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("N°  Habita:");

        btnGuardarAcomp.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardarAcomp.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnGuardarAcomp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardarAcomp.setText("Ingresar ");
        btnGuardarAcomp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarAcomp.setVerifyInputWhenFocusTarget(false);
        btnGuardarAcomp.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnGuardarAcomp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarAcomp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAcompActionPerformed(evt);
            }
        });

        cboparentesco.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cboparentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Esposo/a", "Padre", "Madre", "Hijo/a", "Familiar", "Compeñero de Trabajo" }));

        cbo_tipoDocumento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbo_tipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Cedula de ciudadania", "Cedula de extragria", "Pasaporte", "Tarjeta de identidad" }));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("Tipo Documento:");

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setText("check IN :");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("Ciudad de Residencia:");

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("Ciudad de Procedencia:");

        txtnum_principal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtnum_principal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnum_principalKeyPressed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setText("N° huesped principal:");

        txtidacompañante.setText("IDAC");
        txtidacompañante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidacompañanteActionPerformed(evt);
            }
        });

        txtidcliente.setEditable(false);
        txtidcliente.setText("IDC");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("Estado:");

        cboestado.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        cboestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Finalizado" }));
        cboestado.setEnabled(false);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.GIF"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbociudadrecidencia.setEditable(true);
        cbociudadrecidencia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbociudadrecidencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar ", "Abejorral - Antioquia ", " Ábrego - Norte De Santander ", " Abriaquí - Antioquia ", " Acacías - Meta ", " Acandí - Chocó ", " Acevedo - Huila ", " Achí - Bolívar ", " Agrado - Huila ", " Agua De Dios - Cundinamarca ", " Aguachica - Cesar ", " Aguada - Santander ", " Aguadas - Caldas ", " Aguazul - Casanare ", " Agustín Codazzi - Cesar ", " Aipe - Huila ", " Albán - Cundinamarca ", " Albán - Nariño ", " Albania - Caquetá ", " Albania - La Guajira ", " Albania - Santander ", " Alcalá - Valle Del Cauca ", " Aldana - Nariño ", " Alejandría - Antioquia ", " Algarrobo - Magdalena ", " Algeciras - Huila ", " Almaguer - Cauca ", " Almeida - Boyacá ", " Alpujarra - Tolima ", " Altamira - Huila ", " Alto Baudó - Chocó ", " Altos Del Rosario - Bolívar ", " Alvarado - Tolima ", " Amagá - Antioquia ", " Amalfi - Antioquia ", " Ambalema - Tolima ", " Anapoima - Cundinamarca ", " Ancuya - Nariño ", " Andalucía - Valle Del Cauca ", " Andes - Antioquia ", " Angelópolis - Antioquia ", " Angostura - Antioquia ", " Anolaima - Cundinamarca ", " Anorí - Antioquia ", " Anserma - Caldas ", " Ansermanuevo - Valle Del Cauca ", " Anzá - Antioquia ", " Anzoátegui - Tolima ", " Apartadó - Antioquia ", " Apía - Risaralda ", " Apulo - Cundinamarca ", " Aquitania - Boyacá ", " Aracataca - Magdalena ", " Aranzazu - Caldas ", " Aratoca - Santander ", " Arauca - Arauca ", " Arauquita - Arauca ", " Arbeláez - Cundinamarca ", " Arboleda - Nariño ", " Arboledas - Norte De Santander ", " Arboletes - Antioquia ", " Arcabuco - Boyacá ", " Arenal - Bolívar ", " Argelia - Antioquia ", " Argelia - Cauca ", " Argelia - Valle Del Cauca ", " Ariguaní - Magdalena ", " Arjona - Bolívar ", " Armenia - Antioquia ", " Armenia - Quindío ", " Armero - Tolima ", " Arroyohondo - Bolívar ", " Astrea - Cesar ", " Ataco - Tolima ", " Atrato - Chocó ", " Ayapel - Córdoba ", " Bagadó - Chocó ", " Bahía Solano - Chocó ", " Bajo Baudó - Chocó ", " Balboa - Cauca ", " Balboa - Risaralda ", " Baranoa - Atlántico ", " Baraya - Huila ", " Barbacoas - Nariño ", " Barbosa - Antioquia ", " Barbosa - Santander ", " Barichara - Santander ", " Barranca De Upía - Meta ", " Barrancabermeja - Santander ", " Barrancas - La Guajira ", " Barranco De Loba - Bolívar ", " Barrancominas - Guainía ", " Barranquilla - Atlántico ", " Becerril - Cesar ", " Belalcázar - Caldas ", " Belén - Boyacá ", " Belén - Nariño ", " Belén De Los Andaquíes - Caquetá ", " Belén De Umbría - Risaralda ", " Bello - Antioquia ", " Belmira - Antioquia ", " Beltrán - Cundinamarca ", " Berbeo - Boyacá ", " Betania - Antioquia ", " Betéitiva - Boyacá ", " Betulia - Antioquia ", " Betulia - Santander ", " Bituima - Cundinamarca ", " Boavita - Boyacá ", " Bochalema - Norte De Santander ", " Bogotá, D.C. - Bogotá, D.C. ", " Bojacá - Cundinamarca ", " Bojayá - Chocó ", " Bolívar - Cauca ", " Bolívar - Santander ", " Bolívar - Valle Del Cauca ", " Bosconia - Cesar ", " Boyacá - Boyacá ", " Briceño - Antioquia ", " Briceño - Boyacá ", " Bucaramanga - Santander ", " Bucarasica - Norte De Santander ", " Buenaventura - Valle Del Cauca ", " Buenavista - Boyacá ", " Buenavista - Córdoba ", " Buenavista - Quindío ", " Buenavista - Sucre ", " Buenos Aires - Cauca ", " Buesaco - Nariño ", " Bugalagrande - Valle Del Cauca ", " Buriticá - Antioquia ", " Busbanzá - Boyacá ", " Cabrera - Cundinamarca ", " Cabrera - Santander ", " Cabuyaro - Meta ", " Cacahual - Guainía ", " Cáceres - Antioquia ", " Cachipay - Cundinamarca ", " Cáchira - Norte De Santander ", " Cácota - Norte De Santander ", " Caicedo - Antioquia ", " Caicedonia - Valle Del Cauca ", " Caimito - Sucre ", " Cajamarca - Tolima ", " Cajibío - Cauca ", " Cajicá - Cundinamarca ", " Calamar - Bolívar ", " Calamar - Guaviare ", " Calarcá - Quindío ", " Caldas - Antioquia ", " Caldas - Boyacá ", " Caldono - Cauca ", " Cali - Valle Del Cauca ", " California - Santander ", " Calima - Valle Del Cauca ", " Caloto - Cauca ", " Campamento - Antioquia ", " Campo De La Cruz - Atlántico ", " Campoalegre - Huila ", " Campohermoso - Boyacá ", " Canalete - Córdoba ", " Candelaria - Atlántico ", " Candelaria - Valle Del Cauca ", " Cantagallo - Bolívar ", " Cañasgordas - Antioquia ", " Caparrapí - Cundinamarca ", " Capitanejo - Santander ", " Cáqueza - Cundinamarca ", " Caracolí - Antioquia ", " Caramanta - Antioquia ", " Carcasí - Santander ", " Carepa - Antioquia ", " Carmen De Apicalá - Tolima ", " Carmen De Carupa - Cundinamarca ", " Carmen Del Darién - Chocó ", " Carolina - Antioquia ", " Cartagena De Indias - Bolívar ", " Cartagena Del Chairá - Caquetá ", " Cartago - Valle Del Cauca ", " Carurú - Vaupés ", " Casabianca - Tolima ", " Castilla La Nueva - Meta ", " Caucasia - Antioquia ", " Cepitá - Santander ", " Cereté - Córdoba ", " Cerinza - Boyacá ", " Cerrito - Santander ", " Cerro De San Antonio - Magdalena ", " Cértegui - Chocó ", " Chachagüí - Nariño ", " Chaguaní - Cundinamarca ", " Chalán - Sucre ", " Chámeza - Casanare ", " Chaparral - Tolima ", " Charalá - Santander ", " Charta - Santander ", " Chía - Cundinamarca ", " Chigorodó - Antioquia ", " Chimá - Córdoba ", " Chima - Santander ", " Chimichagua - Cesar ", " Chinácota - Norte De Santander ", " Chinavita - Boyacá ", " Chinchiná - Caldas ", " Chinú - Córdoba ", " Chipaque - Cundinamarca ", " Chipatá - Santander ", " Chiquinquirá - Boyacá ", " Chíquiza - Boyacá ", " Chiriguaná - Cesar ", " Chiscas - Boyacá ", " Chita - Boyacá ", " Chitagá - Norte De Santander ", " Chitaraque - Boyacá ", " Chivatá - Boyacá ", " Chivolo - Magdalena ", " Chivor - Boyacá ", " Choachí - Cundinamarca ", " Chocontá - Cundinamarca ", " Cicuco - Bolívar ", " Ciénaga - Magdalena ", " Ciénaga De Oro - Córdoba ", " Ciénega - Boyacá ", " Cimitarra - Santander ", " Circasia - Quindío ", " Cisneros - Antioquia ", " Ciudad Bolívar - Antioquia ", " Clemencia - Bolívar ", " Cocorná - Antioquia ", " Coello - Tolima ", " Cogua - Cundinamarca ", " Colombia - Huila ", " Colón - Nariño ", " Colón - Putumayo ", " Colosó - Sucre ", " Cómbita - Boyacá ", " Concepción - Antioquia ", " Concepción - Santander ", " Concordia - Antioquia ", " Concordia - Magdalena ", " Condoto - Chocó ", " Confines - Santander ", " Consacá - Nariño ", " Contadero - Nariño ", " Contratación - Santander ", " Convención - Norte De Santander ", " Copacabana - Antioquia ", " Coper - Boyacá ", " Córdoba - Bolívar ", " Córdoba - Nariño ", " Córdoba - Quindío ", " Corinto - Cauca ", " Coromoro - Santander ", " Corozal - Sucre ", " Corrales - Boyacá ", " Cota - Cundinamarca ", " Cotorra - Córdoba ", " Covarachía - Boyacá ", " Coveñas - Sucre ", " Coyaima - Tolima ", " Cravo Norte - Arauca ", " Cuaspud Carlosama - Nariño ", " Cubará - Boyacá ", " Cubarral - Meta ", " Cucaita - Boyacá ", " Cucunubá - Cundinamarca ", " Cucutilla - Norte De Santander ", " Cuítiva - Boyacá ", " Cumaral - Meta ", " Cumaribo - Vichada ", " Cumbal - Nariño ", " Cumbitara - Nariño ", " Cunday - Tolima ", " Curillo - Caquetá ", " Curití - Santander ", " Curumaní - Cesar ", " Dabeiba - Antioquia ", " Dagua - Valle Del Cauca ", " Dibulla - La Guajira ", " Distracción - La Guajira ", " Dolores - Tolima ", " Donmatías - Antioquia ", " Dosquebradas - Risaralda ", " Duitama - Boyacá ", " Durania - Norte De Santander ", " Ebéjico - Antioquia ", " El Águila - Valle Del Cauca ", " El Bagre - Antioquia ", " El Banco - Magdalena ", " El Cairo - Valle Del Cauca ", " El Calvario - Meta ", " El Cantón Del San Pablo - Chocó ", " El Carmen - Norte De Santander ", " El Carmen De Atrato - Chocó ", " El Carmen De Bolívar - Bolívar ", " El Carmen De Chucurí - Santander ", " El Carmen De Viboral - Antioquia ", " El Castillo - Meta ", " El Cerrito - Valle Del Cauca ", " El Charco - Nariño ", " El Cocuy - Boyacá ", " El Colegio - Cundinamarca ", " El Copey - Cesar ", " El Doncello - Caquetá ", " El Dorado - Meta ", " El Dovio - Valle Del Cauca ", " El Encanto - Amazonas ", " El Espino - Boyacá ", " El Guacamayo - Santander ", " El Guamo - Bolívar ", " El Litoral Del San Juan - Chocó ", " El Molino - La Guajira ", " El Paso - Cesar ", " El Paujíl - Caquetá ", " El Peñol - Nariño ", " El Peñón - Bolívar ", " El Peñón - Cundinamarca ", " El Peñón - Santander ", " El Piñón - Magdalena ", " El Playón - Santander ", " El Retén - Magdalena ", " El Retorno - Guaviare ", " El Roble - Sucre ", " El Rosal - Cundinamarca ", " El Rosario - Nariño ", " El Santuario - Antioquia ", " El Tablón De Gómez - Nariño ", " El Tambo - Cauca ", " El Tambo - Nariño ", " El Tarra - Norte De Santander ", " El Zulia - Norte De Santander ", " Elías - Huila ", " Encino - Santander ", " Enciso - Santander ", " Entrerríos - Antioquia ", " Envigado - Antioquia ", " Espinal - Tolima ", " Facatativá - Cundinamarca ", " Falan - Tolima ", " Filadelfia - Caldas ", " Filandia - Quindío ", " Firavitoba - Boyacá ", " Flandes - Tolima ", " Florencia - Caquetá ", " Florencia - Cauca ", " Floresta - Boyacá ", " Florián - Santander ", " Florida - Valle Del Cauca ", " Floridablanca - Santander ", " Fómeque - Cundinamarca ", " Fonseca - La Guajira ", " Fortul - Arauca ", " Fosca - Cundinamarca ", " Francisco Pizarro - Nariño ", " Fredonia - Antioquia ", " Fresno - Tolima ", " Frontino - Antioquia ", " Fuente De Oro - Meta ", " Fundación - Magdalena ", " Funes - Nariño ", " Funza - Cundinamarca ", " Fúquene - Cundinamarca ", " Fusagasugá - Cundinamarca ", " Gachalá - Cundinamarca ", " Gachancipá - Cundinamarca ", " Gachantivá - Boyacá ", " Gachetá - Cundinamarca ", " Galán - Santander ", " Galapa - Atlántico ", " Galeras - Sucre ", " Gama - Cundinamarca ", " Gamarra - Cesar ", " Gámbita - Santander ", " Gámeza - Boyacá ", " Garagoa - Boyacá ", " Garzón - Huila ", " Génova - Quindío ", " Gigante - Huila ", " Ginebra - Valle Del Cauca ", " Giraldo - Antioquia ", " Girardot - Cundinamarca ", " Girardota - Antioquia ", " Girón - Santander ", " Gómez Plata - Antioquia ", " González - Cesar ", " Gramalote - Norte De Santander ", " Granada - Antioquia ", " Granada - Cundinamarca ", " Granada - Meta ", " Guaca - Santander ", " Guacamayas - Boyacá ", " Guacarí - Valle Del Cauca ", " Guachené - Cauca ", " Guachetá - Cundinamarca ", " Guachucal - Nariño ", " Guadalajara De Buga - Valle Del Cauca ", " Guadalupe - Antioquia ", " Guadalupe - Huila ", " Guadalupe - Santander ", " Guaduas - Cundinamarca ", " Guaitarilla - Nariño ", " Gualmatán - Nariño ", " Guamal - Magdalena ", " Guamal - Meta ", " Guamo - Tolima ", " Guapi - Cauca ", " Guapotá - Santander ", " Guaranda - Sucre ", " Guarne - Antioquia ", " Guasca - Cundinamarca ", " Guatapé - Antioquia ", " Guataquí - Cundinamarca ", " Guatavita - Cundinamarca ", " Guateque - Boyacá ", " Guática - Risaralda ", " Guavatá - Santander ", " Guayabal De Síquima - Cundinamarca ", " Guayabetal - Cundinamarca ", " Guayatá - Boyacá ", " Güepsa - Santander ", " Güicán De La Sierra - Boyacá ", " Gutiérrez - Cundinamarca ", " Hacarí - Norte De Santander ", " Hatillo De Loba - Bolívar ", " Hato - Santander ", " Hato Corozal - Casanare ", " Hatonuevo - La Guajira ", " Heliconia - Antioquia ", " Herrán - Norte De Santander ", " Herveo - Tolima ", " Hispania - Antioquia ", " Hobo - Huila ", " Honda - Tolima ", " Ibagué - Tolima ", " Icononzo - Tolima ", " Iles - Nariño ", " Imués - Nariño ", " Inírida - Guainía ", " Inzá - Cauca ", " Ipiales - Nariño ", " Íquira - Huila ", " Isnos - Huila ", " Istmina - Chocó ", " Itagüí - Antioquia ", " Ituango - Antioquia ", " Iza - Boyacá ", " Jambaló - Cauca ", " Jamundí - Valle Del Cauca ", " Jardín - Antioquia ", " Jenesano - Boyacá ", " Jericó - Antioquia ", " Jericó - Boyacá ", " Jerusalén - Cundinamarca ", " Jesús María - Santander ", " Jordán - Santander ", " Juan De Acosta - Atlántico ", " Junín - Cundinamarca ", " Juradó - Chocó ", " La Apartada - Córdoba ", " La Argentina - Huila ", " La Belleza - Santander ", " La Calera - Cundinamarca ", " La Capilla - Boyacá ", " La Ceja - Antioquia ", " La Celia - Risaralda ", " La Chorrera - Amazonas ", " La Cruz - Nariño ", " La Cumbre - Valle Del Cauca ", " La Dorada - Caldas ", " La Esperanza - Norte De Santander ", " La Estrella - Antioquia ", " La Florida - Nariño ", " La Gloria - Cesar ", " La Guadalupe - Guainía ", " La Jagua De Ibirico - Cesar ", " La Jagua Del Pilar - La Guajira ", " La Llanada - Nariño ", " La Macarena - Meta ", " La Merced - Caldas ", " La Mesa - Cundinamarca ", " La Montañita - Caquetá ", " La Palma - Cundinamarca ", " La Paz - Cesar ", " La Paz - Santander ", " La Pedrera - Amazonas ", " La Peña - Cundinamarca ", " La Pintada - Antioquia ", " La Plata - Huila ", " La Playa - Norte De Santander ", " La Primavera - Vichada ", " La Salina - Casanare ", " La Sierra - Cauca ", " La Tebaida - Quindío ", " La Tola - Nariño ", " La Unión - Antioquia ", " La Unión - Nariño ", " La Unión - Sucre ", " La Unión - Valle Del Cauca ", " La Uvita - Boyacá ", " La Vega - Cauca ", " La Vega - Cundinamarca ", " La Victoria - Amazonas ", " La Victoria - Boyacá ", " La Victoria - Valle Del Cauca ", " La Virginia - Risaralda ", " Labateca - Norte De Santander ", " Labranzagrande - Boyacá ", " Landázuri - Santander ", " Lebrija - Santander ", " Leiva - Nariño ", " Lejanías - Meta ", " Lenguazaque - Cundinamarca ", " Lérida - Tolima ", " Leticia - Amazonas ", " Líbano - Tolima ", " Liborina - Antioquia ", " Linares - Nariño ", " Lloró - Chocó ", " López De Micay - Cauca ", " Lorica - Córdoba ", " Los Andes - Nariño ", " Los Córdobas - Córdoba ", " Los Palmitos - Sucre ", " Los Patios - Norte De Santander ", " Los Santos - Santander ", " Lourdes - Norte De Santander ", " Luruaco - Atlántico ", " Macanal - Boyacá ", " Macaravita - Santander ", " Maceo - Antioquia ", " Machetá - Cundinamarca ", " Madrid - Cundinamarca ", " Magangué - Bolívar ", " Magüí - Nariño ", " Mahates - Bolívar ", " Maicao - La Guajira ", " Majagual - Sucre ", " Málaga - Santander ", " Malambo - Atlántico ", " Mallama - Nariño ", " Manatí - Atlántico ", " Manaure - La Guajira ", " Manaure Balcón Del Cesar - Cesar ", " Maní - Casanare ", " Manizales - Caldas ", " Manta - Cundinamarca ", " Manzanares - Caldas ", " Mapiripán - Meta ", " Margarita - Bolívar ", " María La Baja - Bolívar ", " Marinilla - Antioquia ", " Maripí - Boyacá ", " Marmato - Caldas ", " Marquetalia - Caldas ", " Marsella - Risaralda ", " Marulanda - Caldas ", " Matanza - Santander ", " Medellín - Antioquia ", " Medina - Cundinamarca ", " Medio Atrato - Chocó ", " Medio Baudó - Chocó ", " Medio San Juan - Chocó ", " Melgar - Tolima ", " Mercaderes - Cauca ", " Mesetas - Meta ", " Milán - Caquetá ", " Miraflores - Boyacá ", " Miraflores - Guaviare ", " Miranda - Cauca ", " Mirití - Paraná - Amazonas ", " Mistrató - Risaralda ", " Mitú - Vaupés ", " Mocoa - Putumayo ", " Mogotes - Santander ", " Molagavita - Santander ", " Momil - Córdoba ", " Mongua - Boyacá ", " Monguí - Boyacá ", " Moniquirá - Boyacá ", " Montebello - Antioquia ", " Montecristo - Bolívar ", " Montelíbano - Córdoba ", " Montenegro - Quindío ", " Montería - Córdoba ", " Monterrey - Casanare ", " Moñitos - Córdoba ", " Morales - Bolívar ", " Morales - Cauca ", " Morelia - Caquetá ", " Morichal - Guainía ", " Morroa - Sucre ", " Mosquera - Cundinamarca ", " Mosquera - Nariño ", " Motavita - Boyacá ", " Murillo - Tolima ", " Murindó - Antioquia ", " Mutatá - Antioquia ", " Mutiscua - Norte De Santander ", " Muzo - Boyacá ", " Nariño - Antioquia ", " Nariño - Cundinamarca ", " Nariño - Nariño ", " Nátaga - Huila ", " Natagaima - Tolima ", " Nechí - Antioquia ", " Necoclí - Antioquia ", " Neira - Caldas ", " Neiva - Huila ", " Nemocón - Cundinamarca ", " Nilo - Cundinamarca ", " Nimaima - Cundinamarca ", " Nobsa - Boyacá ", " Nocaima - Cundinamarca ", " Norcasia - Caldas ", " Norosí - Bolívar ", " Nóvita - Chocó ", " Nueva Granada - Magdalena ", " Nuevo Colón - Boyacá ", " Nunchía - Casanare ", " Nuquí - Chocó ", " Obando - Valle Del Cauca ", " Ocamonte - Santander ", " Ocaña - Norte De Santander ", " Oiba - Santander ", " Oicatá - Boyacá ", " Olaya - Antioquia ", " Olaya Herrera - Nariño ", " Onzaga - Santander ", " Oporapa - Huila ", " Orito - Putumayo ", " Orocué - Casanare ", " Ortega - Tolima ", " Ospina - Nariño ", " Otanche - Boyacá ", " Ovejas - Sucre ", " Pachavita - Boyacá ", " Pacho - Cundinamarca ", " Pacoa - Vaupés ", " Pácora - Caldas ", " Padilla - Cauca ", " Páez - Boyacá ", " Páez - Cauca ", " Paicol - Huila ", " Pailitas - Cesar ", " Paime - Cundinamarca ", " Paipa - Boyacá ", " Pajarito - Boyacá ", " Palermo - Huila ", " Palestina - Caldas ", " Palestina - Huila ", " Palmar - Santander ", " Palmar De Varela - Atlántico ", " Palmas Del Socorro - Santander ", " Palmira - Valle Del Cauca ", " Palmito - Sucre ", " Palocabildo - Tolima ", " Pamplona - Norte De Santander ", " Pamplonita - Norte De Santander ", " Pana Pana - Guainía ", " Pandi - Cundinamarca ", " Panqueba - Boyacá ", " Papunahua - Vaupés ", " Páramo - Santander ", " Paratebueno - Cundinamarca ", " Pasca - Cundinamarca ", " Pasto - Nariño ", " Patía - Cauca ", " Pauna - Boyacá ", " Paya - Boyacá ", " Paz De Ariporo - Casanare ", " Paz De Río - Boyacá ", " Pedraza - Magdalena ", " Pelaya - Cesar ", " Pensilvania - Caldas ", " Peñol - Antioquia ", " Peque - Antioquia ", " Pereira - Risaralda ", " Pesca - Boyacá ", " Piamonte - Cauca ", " Piedecuesta - Santander ", " Piedras - Tolima ", " Piendamó - Tunía - Cauca ", " Pijao - Quindío ", " Pijiño Del Carmen - Magdalena ", " Pinchote - Santander ", " Pinillos - Bolívar ", " Piojó - Atlántico ", " Pisba - Boyacá ", " Pital - Huila ", " Pitalito - Huila ", " Pivijay - Magdalena ", " Planadas - Tolima ", " Planeta Rica - Córdoba ", " Plato - Magdalena ", " Policarpa - Nariño ", " Polonuevo - Atlántico ", " Ponedera - Atlántico ", " Popayán - Cauca ", " Pore - Casanare ", " Potosí - Nariño ", " Pradera - Valle Del Cauca ", " Prado - Tolima ", " Providencia - Archipiélago De San Andrés, Providencia Y Santa Catalina ", " Providencia - Nariño ", " Pueblo Bello - Cesar ", " Pueblo Nuevo - Córdoba ", " Pueblo Rico - Risaralda ", " Pueblorrico - Antioquia ", " Puebloviejo - Magdalena ", " Puente Nacional - Santander ", " Puerres - Nariño ", " Puerto Alegría - Amazonas ", " Puerto Arica - Amazonas ", " Puerto Asís - Putumayo ", " Puerto Berrío - Antioquia ", " Puerto Boyacá - Boyacá ", " Puerto Caicedo - Putumayo ", " Puerto Carreño - Vichada ", " Puerto Colombia - Atlántico ", " Puerto Colombia - Guainía ", " Puerto Concordia - Meta ", " Puerto Escondido - Córdoba ", " Puerto Gaitán - Meta ", " Puerto Guzmán - Putumayo ", " Puerto Leguízamo - Putumayo ", " Puerto Libertador - Córdoba ", " Puerto Lleras - Meta ", " Puerto López - Meta ", " Puerto Nare - Antioquia ", " Puerto Nariño - Amazonas ", " Puerto Parra - Santander ", " Puerto Rico - Caquetá ", " Puerto Rico - Meta ", " Puerto Rondón - Arauca ", " Puerto Salgar - Cundinamarca ", " Puerto Santander - Amazonas ", " Puerto Santander - Norte De Santander ", " Puerto Tejada - Cauca ", " Puerto Triunfo - Antioquia ", " Puerto Wilches - Santander ", " Pulí - Cundinamarca ", " Pupiales - Nariño ", " Puracé - Cauca ", " Purificación - Tolima ", " Purísima De La Concepción - Córdoba ", " Quebradanegra - Cundinamarca ", " Quetame - Cundinamarca ", " Quibdó - Chocó ", " Quimbaya - Quindío ", " Quinchía - Risaralda ", " Quípama - Boyacá ", " Quipile - Cundinamarca ", " Ragonvalia - Norte De Santander ", " Ramiriquí - Boyacá ", " Ráquira - Boyacá ", " Recetor - Casanare ", " Regidor - Bolívar ", " Remedios - Antioquia ", " Remolino - Magdalena ", " Repelón - Atlántico ", " Restrepo - Meta ", " Restrepo - Valle Del Cauca ", " Retiro - Antioquia ", " Ricaurte - Cundinamarca ", " Ricaurte - Nariño ", " Río De Oro - Cesar ", " Río Iró - Chocó ", " Río Quito - Chocó ", " Río Viejo - Bolívar ", " Rioblanco - Tolima ", " Riofrío - Valle Del Cauca ", " Riohacha - La Guajira ", " Rionegro - Antioquia ", " Rionegro - Santander ", " Riosucio - Caldas ", " Riosucio - Chocó ", " Risaralda - Caldas ", " Rivera - Huila ", " Roberto Payán - Nariño ", " Roldanillo - Valle Del Cauca ", " Roncesvalles - Tolima ", " Rondón - Boyacá ", " Rosas - Cauca ", " Rovira - Tolima ", " Sabana De Torres - Santander ", " Sabanagrande - Atlántico ", " Sabanalarga - Antioquia ", " Sabanalarga - Atlántico ", " Sabanalarga - Casanare ", " Sabanas De San Ángel - Magdalena ", " Sabaneta - Antioquia ", " Saboyá - Boyacá ", " Sácama - Casanare ", " Sáchica - Boyacá ", " Sahagún - Córdoba ", " Saladoblanco - Huila ", " Salamina - Caldas ", " Salamina - Magdalena ", " Salazar - Norte De Santander ", " Saldaña - Tolima ", " Salento - Quindío ", " Salgar - Antioquia ", " Samacá - Boyacá ", " Samaná - Caldas ", " Samaniego - Nariño ", " Sampués - Sucre ", " San Agustín - Huila ", " San Alberto - Cesar ", " San Andrés - Archipiélago De San Andrés, Providencia Y Santa Catalina ", " San Andrés - Santander ", " San Andrés De Cuerquía - Antioquia ", " San Andrés De Sotavento - Córdoba ", " San Andrés De Tumaco - Nariño ", " San Antero - Córdoba ", " San Antonio - Tolima ", " San Antonio Del Tequendama - Cundinamarca ", " San Benito - Santander ", " San Benito Abad - Sucre ", " San Bernardo - Cundinamarca ", " San Bernardo - Nariño ", " San Bernardo Del Viento - Córdoba ", " San Calixto - Norte De Santander ", " San Carlos - Antioquia ", " San Carlos - Córdoba ", " San Carlos De Guaroa - Meta ", " San Cayetano - Cundinamarca ", " San Cayetano - Norte De Santander ", " San Cristóbal - Bolívar ", " San Diego - Cesar ", " San Eduardo - Boyacá ", " San Estanislao - Bolívar ", " San Felipe - Guainía ", " San Fernando - Bolívar ", " San Francisco - Antioquia ", " San Francisco - Cundinamarca ", " San Francisco - Putumayo ", " San Gil - Santander ", " San Jacinto - Bolívar ", " San Jacinto Del Cauca - Bolívar ", " San Jerónimo - Antioquia ", " San Joaquín - Santander ", " San José - Caldas ", " San José De Cúcuta - Norte De Santander ", " San José De La Montaña - Antioquia ", " San José De Miranda - Santander ", " San José De Pare - Boyacá ", " San José De Toluviejo - Sucre ", " San José De Uré - Córdoba ", " San José Del Fragua - Caquetá ", " San José Del Guaviare - Guaviare ", " San José Del Palmar - Chocó ", " San Juan De Arama - Meta ", " San Juan De Betulia - Sucre ", " San Juan De Rioseco - Cundinamarca ", " San Juan De Urabá - Antioquia ", " San Juan Del Cesar - La Guajira ", " San Juan Nepomuceno - Bolívar ", " San Juanito - Meta ", " San Lorenzo - Nariño ", " San Luis - Antioquia ", " San Luis - Tolima ", " San Luis De Gaceno - Boyacá ", " San Luis De Palenque - Casanare ", " San Luis De Sincé - Sucre ", " San Marcos - Sucre ", " San Martín - Cesar ", " San Martín - Meta ", " San Martín De Loba - Bolívar ", " San Mateo - Boyacá ", " San Miguel - Putumayo ", " San Miguel - Santander ", " San Miguel De Sema - Boyacá ", " San Onofre - Sucre ", " San Pablo - Bolívar ", " San Pablo - Nariño ", " San Pablo De Borbur - Boyacá ", " San Pedro - Sucre ", " San Pedro - Valle Del Cauca ", " San Pedro De Cartago - Nariño ", " San Pedro De Los Milagros - Antioquia ", " San Pedro De Urabá - Antioquia ", " San Pelayo - Córdoba ", " San Rafael - Antioquia ", " San Roque - Antioquia ", " San Sebastián - Cauca ", " San Sebastián De Buenavista - Magdalena ", " San Sebastián De Mariquita - Tolima ", " San Vicente De Chucurí - Santander ", " San Vicente Del Caguán - Caquetá ", " San Vicente Ferrer - Antioquia ", " San Zenón - Magdalena ", " Sandoná - Nariño ", " Santa Ana - Magdalena ", " Santa Bárbara - Antioquia ", " Santa Bárbara - Nariño ", " Santa Bárbara - Santander ", " Santa Bárbara De Pinto - Magdalena ", " Santa Catalina - Bolívar ", " Santa Cruz De Mompox - Bolívar ", " Santa Fé De Antioquia - Antioquia ", " Santa Helena Del Opón - Santander ", " Santa Isabel - Tolima ", " Santa Lucía - Atlántico ", " Santa María - Boyacá ", " Santa María - Huila ", " Santa Marta - Magdalena ", " Santa Rosa - Bolívar ", " Santa Rosa - Cauca ", " Santa Rosa De Cabal - Risaralda ", " Santa Rosa De Osos - Antioquia ", " Santa Rosa De Viterbo - Boyacá ", " Santa Rosa Del Sur - Bolívar ", " Santa Rosalía - Vichada ", " Santa Sofía - Boyacá ", " Santacruz - Nariño ", " Santana - Boyacá ", " Santander De Quilichao - Cauca ", " Santiago - Norte De Santander ", " Santiago - Putumayo ", " Santiago De Tolú - Sucre ", " Santo Domingo - Antioquia ", " Santo Tomás - Atlántico ", " Santuario - Risaralda ", " Sapuyes - Nariño ", " Saravena - Arauca ", " Sardinata - Norte De Santander ", " Sasaima - Cundinamarca ", " Sativanorte - Boyacá ", " Sativasur - Boyacá ", " Segovia - Antioquia ", " Sesquilé - Cundinamarca ", " Sevilla - Valle Del Cauca ", " Siachoque - Boyacá ", " Sibaté - Cundinamarca ", " Sibundoy - Putumayo ", " Silos - Norte De Santander ", " Silvania - Cundinamarca ", " Silvia - Cauca ", " Simacota - Santander ", " Simijaca - Cundinamarca ", " Simití - Bolívar ", " Sincelejo - Sucre ", " Sipí - Chocó ", " Sitionuevo - Magdalena ", " Soacha - Cundinamarca ", " Soatá - Boyacá ", " Socha - Boyacá ", " Socorro - Santander ", " Socotá - Boyacá ", " Sogamoso - Boyacá ", " Solano - Caquetá ", " Soledad - Atlántico ", " Solita - Caquetá ", " Somondoco - Boyacá ", " Sonsón - Antioquia ", " Sopetrán - Antioquia ", " Soplaviento - Bolívar ", " Sopó - Cundinamarca ", " Sora - Boyacá ", " Soracá - Boyacá ", " Sotaquirá - Boyacá ", " Sotará Paispamba - Cauca ", " Suaita - Santander ", " Suan - Atlántico ", " Suárez - Cauca ", " Suárez - Tolima ", " Suaza - Huila ", " Subachoque - Cundinamarca ", " Sucre - Cauca ", " Sucre - Santander ", " Sucre - Sucre ", " Suesca - Cundinamarca ", " Supatá - Cundinamarca ", " Supía - Caldas ", " Suratá - Santander ", " Susa - Cundinamarca ", " Susacón - Boyacá ", " Sutamarchán - Boyacá ", " Sutatausa - Cundinamarca ", " Sutatenza - Boyacá ", " Tabio - Cundinamarca ", " Tadó - Chocó ", " Talaigua Nuevo - Bolívar ", " Tamalameque - Cesar ", " Támara - Casanare ", " Tame - Arauca ", " Támesis - Antioquia ", " Taminango - Nariño ", " Tangua - Nariño ", " Taraira - Vaupés ", " Tarapacá - Amazonas ", " Tarazá - Antioquia ", " Tarqui - Huila ", " Tarso - Antioquia ", " Tasco - Boyacá ", " Tauramena - Casanare ", " Tausa - Cundinamarca ", " Tello - Huila ", " Tena - Cundinamarca ", " Tenerife - Magdalena ", " Tenjo - Cundinamarca ", " Tenza - Boyacá ", " Teorama - Norte De Santander ", " Teruel - Huila ", " Tesalia - Huila ", " Tibacuy - Cundinamarca ", " Tibaná - Boyacá ", " Tibasosa - Boyacá ", " Tibirita - Cundinamarca ", " Tibú - Norte De Santander ", " Tierralta - Córdoba ", " Timaná - Huila ", " Timbío - Cauca ", " Timbiquí - Cauca ", " Tinjacá - Boyacá ", " Tipacoque - Boyacá ", " Tiquisio - Bolívar ", " Titiribí - Antioquia ", " Toca - Boyacá ", " Tocaima - Cundinamarca ", " Tocancipá - Cundinamarca ", " Togüí - Boyacá ", " Toledo - Antioquia ", " Toledo - Norte De Santander ", " Tona - Santander ", " Tópaga - Boyacá ", " Topaipí - Cundinamarca ", " Toribío - Cauca ", " Toro - Valle Del Cauca ", " Tota - Boyacá ", " Totoró - Cauca ", " Trinidad - Casanare ", " Trujillo - Valle Del Cauca ", " Tubará - Atlántico ", " Tuchín - Córdoba ", " Tuluá - Valle Del Cauca ", " Tunja - Boyacá ", " Tununguá - Boyacá ", " Túquerres - Nariño ", " Turbaco - Bolívar ", " Turbaná - Bolívar ", " Turbo - Antioquia ", " Turmequé - Boyacá ", " Tuta - Boyacá ", " Tutazá - Boyacá ", " Ubalá - Cundinamarca ", " Ubaque - Cundinamarca ", " Ulloa - Valle Del Cauca ", " Úmbita - Boyacá ", " Une - Cundinamarca ", " Unguía - Chocó ", " Unión Panamericana - Chocó ", " Uramita - Antioquia ", " Uribe - Meta ", " Uribia - La Guajira ", " Urrao - Antioquia ", " Urumita - La Guajira ", " Usiacurí - Atlántico ", " Útica - Cundinamarca ", " Valdivia - Antioquia ", " Valencia - Córdoba ", " Valle De San José - Santander ", " Valle De San Juan - Tolima ", " Valle Del Guamuez - Putumayo ", " Valledupar - Cesar ", " Valparaíso - Antioquia ", " Valparaíso - Caquetá ", " Vegachí - Antioquia ", " Vélez - Santander ", " Venadillo - Tolima ", " Venecia - Antioquia ", " Venecia - Cundinamarca ", " Ventaquemada - Boyacá ", " Vergara - Cundinamarca ", " Versalles - Valle Del Cauca ", " Vetas - Santander ", " Vianí - Cundinamarca ", " Victoria - Caldas ", " Vigía Del Fuerte - Antioquia ", " Vijes - Valle Del Cauca ", " Villa Caro - Norte De Santander ", " Villa De Leyva - Boyacá ", " Villa De San Diego De Ubaté - Cundinamarca ", " Villa Del Rosario - Norte De Santander ", " Villa Rica - Cauca ", " Villagarzón - Putumayo ", " Villagómez - Cundinamarca ", " Villahermosa - Tolima ", " Villamaría - Caldas ", " Villanueva - Bolívar ", " Villanueva - Casanare ", " Villanueva - La Guajira ", " Villanueva - Santander ", " Villapinzón - Cundinamarca ", " Villarrica - Tolima ", " Villavicencio - Meta ", " Villavieja - Huila ", " Villeta - Cundinamarca ", " Viotá - Cundinamarca ", " Viracachá - Boyacá ", " Vistahermosa - Meta ", " Viterbo - Caldas ", " Yacopí - Cundinamarca ", " Yacuanquer - Nariño ", " Yaguará - Huila ", " Yalí - Antioquia ", " Yarumal - Antioquia ", " Yavaraté - Vaupés ", " Yolombó - Antioquia ", " Yondó - Antioquia ", " Yopal - Casanare ", " Yotoco - Valle Del Cauca ", " Yumbo - Valle Del Cauca ", " Zambrano - Bolívar ", " Zapatoca - Santander ", " Zapayán - Magdalena ", " Zaragoza - Antioquia ", " Zarzal - Valle Del Cauca ", " Zetaquira - Boyacá ", " Zipacón - Cundinamarca ", " Zipaquirá - Cundinamarca ", " Zona Bananera - Magdalena ", "[San Cristóbal de] la Laguna" }));

        cbociudadprocedencia.setEditable(true);
        cbociudadprocedencia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbociudadprocedencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar ", "Abejorral - Antioquia ", " Ábrego - Norte De Santander ", " Abriaquí - Antioquia ", " Acacías - Meta ", " Acandí - Chocó ", " Acevedo - Huila ", " Achí - Bolívar ", " Agrado - Huila ", " Agua De Dios - Cundinamarca ", " Aguachica - Cesar ", " Aguada - Santander ", " Aguadas - Caldas ", " Aguazul - Casanare ", " Agustín Codazzi - Cesar ", " Aipe - Huila ", " Albán - Cundinamarca ", " Albán - Nariño ", " Albania - Caquetá ", " Albania - La Guajira ", " Albania - Santander ", " Alcalá - Valle Del Cauca ", " Aldana - Nariño ", " Alejandría - Antioquia ", " Algarrobo - Magdalena ", " Algeciras - Huila ", " Almaguer - Cauca ", " Almeida - Boyacá ", " Alpujarra - Tolima ", " Altamira - Huila ", " Alto Baudó - Chocó ", " Altos Del Rosario - Bolívar ", " Alvarado - Tolima ", " Amagá - Antioquia ", " Amalfi - Antioquia ", " Ambalema - Tolima ", " Anapoima - Cundinamarca ", " Ancuya - Nariño ", " Andalucía - Valle Del Cauca ", " Andes - Antioquia ", " Angelópolis - Antioquia ", " Angostura - Antioquia ", " Anolaima - Cundinamarca ", " Anorí - Antioquia ", " Anserma - Caldas ", " Ansermanuevo - Valle Del Cauca ", " Anzá - Antioquia ", " Anzoátegui - Tolima ", " Apartadó - Antioquia ", " Apía - Risaralda ", " Apulo - Cundinamarca ", " Aquitania - Boyacá ", " Aracataca - Magdalena ", " Aranzazu - Caldas ", " Aratoca - Santander ", " Arauca - Arauca ", " Arauquita - Arauca ", " Arbeláez - Cundinamarca ", " Arboleda - Nariño ", " Arboledas - Norte De Santander ", " Arboletes - Antioquia ", " Arcabuco - Boyacá ", " Arenal - Bolívar ", " Argelia - Antioquia ", " Argelia - Cauca ", " Argelia - Valle Del Cauca ", " Ariguaní - Magdalena ", " Arjona - Bolívar ", " Armenia - Antioquia ", " Armenia - Quindío ", " Armero - Tolima ", " Arroyohondo - Bolívar ", " Astrea - Cesar ", " Ataco - Tolima ", " Atrato - Chocó ", " Ayapel - Córdoba ", " Bagadó - Chocó ", " Bahía Solano - Chocó ", " Bajo Baudó - Chocó ", " Balboa - Cauca ", " Balboa - Risaralda ", " Baranoa - Atlántico ", " Baraya - Huila ", " Barbacoas - Nariño ", " Barbosa - Antioquia ", " Barbosa - Santander ", " Barichara - Santander ", " Barranca De Upía - Meta ", " Barrancabermeja - Santander ", " Barrancas - La Guajira ", " Barranco De Loba - Bolívar ", " Barrancominas - Guainía ", " Barranquilla - Atlántico ", " Becerril - Cesar ", " Belalcázar - Caldas ", " Belén - Boyacá ", " Belén - Nariño ", " Belén De Los Andaquíes - Caquetá ", " Belén De Umbría - Risaralda ", " Bello - Antioquia ", " Belmira - Antioquia ", " Beltrán - Cundinamarca ", " Berbeo - Boyacá ", " Betania - Antioquia ", " Betéitiva - Boyacá ", " Betulia - Antioquia ", " Betulia - Santander ", " Bituima - Cundinamarca ", " Boavita - Boyacá ", " Bochalema - Norte De Santander ", " Bogotá, D.C. - Bogotá, D.C. ", " Bojacá - Cundinamarca ", " Bojayá - Chocó ", " Bolívar - Cauca ", " Bolívar - Santander ", " Bolívar - Valle Del Cauca ", " Bosconia - Cesar ", " Boyacá - Boyacá ", " Briceño - Antioquia ", " Briceño - Boyacá ", " Bucaramanga - Santander ", " Bucarasica - Norte De Santander ", " Buenaventura - Valle Del Cauca ", " Buenavista - Boyacá ", " Buenavista - Córdoba ", " Buenavista - Quindío ", " Buenavista - Sucre ", " Buenos Aires - Cauca ", " Buesaco - Nariño ", " Bugalagrande - Valle Del Cauca ", " Buriticá - Antioquia ", " Busbanzá - Boyacá ", " Cabrera - Cundinamarca ", " Cabrera - Santander ", " Cabuyaro - Meta ", " Cacahual - Guainía ", " Cáceres - Antioquia ", " Cachipay - Cundinamarca ", " Cáchira - Norte De Santander ", " Cácota - Norte De Santander ", " Caicedo - Antioquia ", " Caicedonia - Valle Del Cauca ", " Caimito - Sucre ", " Cajamarca - Tolima ", " Cajibío - Cauca ", " Cajicá - Cundinamarca ", " Calamar - Bolívar ", " Calamar - Guaviare ", " Calarcá - Quindío ", " Caldas - Antioquia ", " Caldas - Boyacá ", " Caldono - Cauca ", " Cali - Valle Del Cauca ", " California - Santander ", " Calima - Valle Del Cauca ", " Caloto - Cauca ", " Campamento - Antioquia ", " Campo De La Cruz - Atlántico ", " Campoalegre - Huila ", " Campohermoso - Boyacá ", " Canalete - Córdoba ", " Candelaria - Atlántico ", " Candelaria - Valle Del Cauca ", " Cantagallo - Bolívar ", " Cañasgordas - Antioquia ", " Caparrapí - Cundinamarca ", " Capitanejo - Santander ", " Cáqueza - Cundinamarca ", " Caracolí - Antioquia ", " Caramanta - Antioquia ", " Carcasí - Santander ", " Carepa - Antioquia ", " Carmen De Apicalá - Tolima ", " Carmen De Carupa - Cundinamarca ", " Carmen Del Darién - Chocó ", " Carolina - Antioquia ", " Cartagena De Indias - Bolívar ", " Cartagena Del Chairá - Caquetá ", " Cartago - Valle Del Cauca ", " Carurú - Vaupés ", " Casabianca - Tolima ", " Castilla La Nueva - Meta ", " Caucasia - Antioquia ", " Cepitá - Santander ", " Cereté - Córdoba ", " Cerinza - Boyacá ", " Cerrito - Santander ", " Cerro De San Antonio - Magdalena ", " Cértegui - Chocó ", " Chachagüí - Nariño ", " Chaguaní - Cundinamarca ", " Chalán - Sucre ", " Chámeza - Casanare ", " Chaparral - Tolima ", " Charalá - Santander ", " Charta - Santander ", " Chía - Cundinamarca ", " Chigorodó - Antioquia ", " Chimá - Córdoba ", " Chima - Santander ", " Chimichagua - Cesar ", " Chinácota - Norte De Santander ", " Chinavita - Boyacá ", " Chinchiná - Caldas ", " Chinú - Córdoba ", " Chipaque - Cundinamarca ", " Chipatá - Santander ", " Chiquinquirá - Boyacá ", " Chíquiza - Boyacá ", " Chiriguaná - Cesar ", " Chiscas - Boyacá ", " Chita - Boyacá ", " Chitagá - Norte De Santander ", " Chitaraque - Boyacá ", " Chivatá - Boyacá ", " Chivolo - Magdalena ", " Chivor - Boyacá ", " Choachí - Cundinamarca ", " Chocontá - Cundinamarca ", " Cicuco - Bolívar ", " Ciénaga - Magdalena ", " Ciénaga De Oro - Córdoba ", " Ciénega - Boyacá ", " Cimitarra - Santander ", " Circasia - Quindío ", " Cisneros - Antioquia ", " Ciudad Bolívar - Antioquia ", " Clemencia - Bolívar ", " Cocorná - Antioquia ", " Coello - Tolima ", " Cogua - Cundinamarca ", " Colombia - Huila ", " Colón - Nariño ", " Colón - Putumayo ", " Colosó - Sucre ", " Cómbita - Boyacá ", " Concepción - Antioquia ", " Concepción - Santander ", " Concordia - Antioquia ", " Concordia - Magdalena ", " Condoto - Chocó ", " Confines - Santander ", " Consacá - Nariño ", " Contadero - Nariño ", " Contratación - Santander ", " Convención - Norte De Santander ", " Copacabana - Antioquia ", " Coper - Boyacá ", " Córdoba - Bolívar ", " Córdoba - Nariño ", " Córdoba - Quindío ", " Corinto - Cauca ", " Coromoro - Santander ", " Corozal - Sucre ", " Corrales - Boyacá ", " Cota - Cundinamarca ", " Cotorra - Córdoba ", " Covarachía - Boyacá ", " Coveñas - Sucre ", " Coyaima - Tolima ", " Cravo Norte - Arauca ", " Cuaspud Carlosama - Nariño ", " Cubará - Boyacá ", " Cubarral - Meta ", " Cucaita - Boyacá ", " Cucunubá - Cundinamarca ", " Cucutilla - Norte De Santander ", " Cuítiva - Boyacá ", " Cumaral - Meta ", " Cumaribo - Vichada ", " Cumbal - Nariño ", " Cumbitara - Nariño ", " Cunday - Tolima ", " Curillo - Caquetá ", " Curití - Santander ", " Curumaní - Cesar ", " Dabeiba - Antioquia ", " Dagua - Valle Del Cauca ", " Dibulla - La Guajira ", " Distracción - La Guajira ", " Dolores - Tolima ", " Donmatías - Antioquia ", " Dosquebradas - Risaralda ", " Duitama - Boyacá ", " Durania - Norte De Santander ", " Ebéjico - Antioquia ", " El Águila - Valle Del Cauca ", " El Bagre - Antioquia ", " El Banco - Magdalena ", " El Cairo - Valle Del Cauca ", " El Calvario - Meta ", " El Cantón Del San Pablo - Chocó ", " El Carmen - Norte De Santander ", " El Carmen De Atrato - Chocó ", " El Carmen De Bolívar - Bolívar ", " El Carmen De Chucurí - Santander ", " El Carmen De Viboral - Antioquia ", " El Castillo - Meta ", " El Cerrito - Valle Del Cauca ", " El Charco - Nariño ", " El Cocuy - Boyacá ", " El Colegio - Cundinamarca ", " El Copey - Cesar ", " El Doncello - Caquetá ", " El Dorado - Meta ", " El Dovio - Valle Del Cauca ", " El Encanto - Amazonas ", " El Espino - Boyacá ", " El Guacamayo - Santander ", " El Guamo - Bolívar ", " El Litoral Del San Juan - Chocó ", " El Molino - La Guajira ", " El Paso - Cesar ", " El Paujíl - Caquetá ", " El Peñol - Nariño ", " El Peñón - Bolívar ", " El Peñón - Cundinamarca ", " El Peñón - Santander ", " El Piñón - Magdalena ", " El Playón - Santander ", " El Retén - Magdalena ", " El Retorno - Guaviare ", " El Roble - Sucre ", " El Rosal - Cundinamarca ", " El Rosario - Nariño ", " El Santuario - Antioquia ", " El Tablón De Gómez - Nariño ", " El Tambo - Cauca ", " El Tambo - Nariño ", " El Tarra - Norte De Santander ", " El Zulia - Norte De Santander ", " Elías - Huila ", " Encino - Santander ", " Enciso - Santander ", " Entrerríos - Antioquia ", " Envigado - Antioquia ", " Espinal - Tolima ", " Facatativá - Cundinamarca ", " Falan - Tolima ", " Filadelfia - Caldas ", " Filandia - Quindío ", " Firavitoba - Boyacá ", " Flandes - Tolima ", " Florencia - Caquetá ", " Florencia - Cauca ", " Floresta - Boyacá ", " Florián - Santander ", " Florida - Valle Del Cauca ", " Floridablanca - Santander ", " Fómeque - Cundinamarca ", " Fonseca - La Guajira ", " Fortul - Arauca ", " Fosca - Cundinamarca ", " Francisco Pizarro - Nariño ", " Fredonia - Antioquia ", " Fresno - Tolima ", " Frontino - Antioquia ", " Fuente De Oro - Meta ", " Fundación - Magdalena ", " Funes - Nariño ", " Funza - Cundinamarca ", " Fúquene - Cundinamarca ", " Fusagasugá - Cundinamarca ", " Gachalá - Cundinamarca ", " Gachancipá - Cundinamarca ", " Gachantivá - Boyacá ", " Gachetá - Cundinamarca ", " Galán - Santander ", " Galapa - Atlántico ", " Galeras - Sucre ", " Gama - Cundinamarca ", " Gamarra - Cesar ", " Gámbita - Santander ", " Gámeza - Boyacá ", " Garagoa - Boyacá ", " Garzón - Huila ", " Génova - Quindío ", " Gigante - Huila ", " Ginebra - Valle Del Cauca ", " Giraldo - Antioquia ", " Girardot - Cundinamarca ", " Girardota - Antioquia ", " Girón - Santander ", " Gómez Plata - Antioquia ", " González - Cesar ", " Gramalote - Norte De Santander ", " Granada - Antioquia ", " Granada - Cundinamarca ", " Granada - Meta ", " Guaca - Santander ", " Guacamayas - Boyacá ", " Guacarí - Valle Del Cauca ", " Guachené - Cauca ", " Guachetá - Cundinamarca ", " Guachucal - Nariño ", " Guadalajara De Buga - Valle Del Cauca ", " Guadalupe - Antioquia ", " Guadalupe - Huila ", " Guadalupe - Santander ", " Guaduas - Cundinamarca ", " Guaitarilla - Nariño ", " Gualmatán - Nariño ", " Guamal - Magdalena ", " Guamal - Meta ", " Guamo - Tolima ", " Guapi - Cauca ", " Guapotá - Santander ", " Guaranda - Sucre ", " Guarne - Antioquia ", " Guasca - Cundinamarca ", " Guatapé - Antioquia ", " Guataquí - Cundinamarca ", " Guatavita - Cundinamarca ", " Guateque - Boyacá ", " Guática - Risaralda ", " Guavatá - Santander ", " Guayabal De Síquima - Cundinamarca ", " Guayabetal - Cundinamarca ", " Guayatá - Boyacá ", " Güepsa - Santander ", " Güicán De La Sierra - Boyacá ", " Gutiérrez - Cundinamarca ", " Hacarí - Norte De Santander ", " Hatillo De Loba - Bolívar ", " Hato - Santander ", " Hato Corozal - Casanare ", " Hatonuevo - La Guajira ", " Heliconia - Antioquia ", " Herrán - Norte De Santander ", " Herveo - Tolima ", " Hispania - Antioquia ", " Hobo - Huila ", " Honda - Tolima ", " Ibagué - Tolima ", " Icononzo - Tolima ", " Iles - Nariño ", " Imués - Nariño ", " Inírida - Guainía ", " Inzá - Cauca ", " Ipiales - Nariño ", " Íquira - Huila ", " Isnos - Huila ", " Istmina - Chocó ", " Itagüí - Antioquia ", " Ituango - Antioquia ", " Iza - Boyacá ", " Jambaló - Cauca ", " Jamundí - Valle Del Cauca ", " Jardín - Antioquia ", " Jenesano - Boyacá ", " Jericó - Antioquia ", " Jericó - Boyacá ", " Jerusalén - Cundinamarca ", " Jesús María - Santander ", " Jordán - Santander ", " Juan De Acosta - Atlántico ", " Junín - Cundinamarca ", " Juradó - Chocó ", " La Apartada - Córdoba ", " La Argentina - Huila ", " La Belleza - Santander ", " La Calera - Cundinamarca ", " La Capilla - Boyacá ", " La Ceja - Antioquia ", " La Celia - Risaralda ", " La Chorrera - Amazonas ", " La Cruz - Nariño ", " La Cumbre - Valle Del Cauca ", " La Dorada - Caldas ", " La Esperanza - Norte De Santander ", " La Estrella - Antioquia ", " La Florida - Nariño ", " La Gloria - Cesar ", " La Guadalupe - Guainía ", " La Jagua De Ibirico - Cesar ", " La Jagua Del Pilar - La Guajira ", " La Llanada - Nariño ", " La Macarena - Meta ", " La Merced - Caldas ", " La Mesa - Cundinamarca ", " La Montañita - Caquetá ", " La Palma - Cundinamarca ", " La Paz - Cesar ", " La Paz - Santander ", " La Pedrera - Amazonas ", " La Peña - Cundinamarca ", " La Pintada - Antioquia ", " La Plata - Huila ", " La Playa - Norte De Santander ", " La Primavera - Vichada ", " La Salina - Casanare ", " La Sierra - Cauca ", " La Tebaida - Quindío ", " La Tola - Nariño ", " La Unión - Antioquia ", " La Unión - Nariño ", " La Unión - Sucre ", " La Unión - Valle Del Cauca ", " La Uvita - Boyacá ", " La Vega - Cauca ", " La Vega - Cundinamarca ", " La Victoria - Amazonas ", " La Victoria - Boyacá ", " La Victoria - Valle Del Cauca ", " La Virginia - Risaralda ", " Labateca - Norte De Santander ", " Labranzagrande - Boyacá ", " Landázuri - Santander ", " Lebrija - Santander ", " Leiva - Nariño ", " Lejanías - Meta ", " Lenguazaque - Cundinamarca ", " Lérida - Tolima ", " Leticia - Amazonas ", " Líbano - Tolima ", " Liborina - Antioquia ", " Linares - Nariño ", " Lloró - Chocó ", " López De Micay - Cauca ", " Lorica - Córdoba ", " Los Andes - Nariño ", " Los Córdobas - Córdoba ", " Los Palmitos - Sucre ", " Los Patios - Norte De Santander ", " Los Santos - Santander ", " Lourdes - Norte De Santander ", " Luruaco - Atlántico ", " Macanal - Boyacá ", " Macaravita - Santander ", " Maceo - Antioquia ", " Machetá - Cundinamarca ", " Madrid - Cundinamarca ", " Magangué - Bolívar ", " Magüí - Nariño ", " Mahates - Bolívar ", " Maicao - La Guajira ", " Majagual - Sucre ", " Málaga - Santander ", " Malambo - Atlántico ", " Mallama - Nariño ", " Manatí - Atlántico ", " Manaure - La Guajira ", " Manaure Balcón Del Cesar - Cesar ", " Maní - Casanare ", " Manizales - Caldas ", " Manta - Cundinamarca ", " Manzanares - Caldas ", " Mapiripán - Meta ", " Margarita - Bolívar ", " María La Baja - Bolívar ", " Marinilla - Antioquia ", " Maripí - Boyacá ", " Marmato - Caldas ", " Marquetalia - Caldas ", " Marsella - Risaralda ", " Marulanda - Caldas ", " Matanza - Santander ", " Medellín - Antioquia ", " Medina - Cundinamarca ", " Medio Atrato - Chocó ", " Medio Baudó - Chocó ", " Medio San Juan - Chocó ", " Melgar - Tolima ", " Mercaderes - Cauca ", " Mesetas - Meta ", " Milán - Caquetá ", " Miraflores - Boyacá ", " Miraflores - Guaviare ", " Miranda - Cauca ", " Mirití - Paraná - Amazonas ", " Mistrató - Risaralda ", " Mitú - Vaupés ", " Mocoa - Putumayo ", " Mogotes - Santander ", " Molagavita - Santander ", " Momil - Córdoba ", " Mongua - Boyacá ", " Monguí - Boyacá ", " Moniquirá - Boyacá ", " Montebello - Antioquia ", " Montecristo - Bolívar ", " Montelíbano - Córdoba ", " Montenegro - Quindío ", " Montería - Córdoba ", " Monterrey - Casanare ", " Moñitos - Córdoba ", " Morales - Bolívar ", " Morales - Cauca ", " Morelia - Caquetá ", " Morichal - Guainía ", " Morroa - Sucre ", " Mosquera - Cundinamarca ", " Mosquera - Nariño ", " Motavita - Boyacá ", " Murillo - Tolima ", " Murindó - Antioquia ", " Mutatá - Antioquia ", " Mutiscua - Norte De Santander ", " Muzo - Boyacá ", " Nariño - Antioquia ", " Nariño - Cundinamarca ", " Nariño - Nariño ", " Nátaga - Huila ", " Natagaima - Tolima ", " Nechí - Antioquia ", " Necoclí - Antioquia ", " Neira - Caldas ", " Neiva - Huila ", " Nemocón - Cundinamarca ", " Nilo - Cundinamarca ", " Nimaima - Cundinamarca ", " Nobsa - Boyacá ", " Nocaima - Cundinamarca ", " Norcasia - Caldas ", " Norosí - Bolívar ", " Nóvita - Chocó ", " Nueva Granada - Magdalena ", " Nuevo Colón - Boyacá ", " Nunchía - Casanare ", " Nuquí - Chocó ", " Obando - Valle Del Cauca ", " Ocamonte - Santander ", " Ocaña - Norte De Santander ", " Oiba - Santander ", " Oicatá - Boyacá ", " Olaya - Antioquia ", " Olaya Herrera - Nariño ", " Onzaga - Santander ", " Oporapa - Huila ", " Orito - Putumayo ", " Orocué - Casanare ", " Ortega - Tolima ", " Ospina - Nariño ", " Otanche - Boyacá ", " Ovejas - Sucre ", " Pachavita - Boyacá ", " Pacho - Cundinamarca ", " Pacoa - Vaupés ", " Pácora - Caldas ", " Padilla - Cauca ", " Páez - Boyacá ", " Páez - Cauca ", " Paicol - Huila ", " Pailitas - Cesar ", " Paime - Cundinamarca ", " Paipa - Boyacá ", " Pajarito - Boyacá ", " Palermo - Huila ", " Palestina - Caldas ", " Palestina - Huila ", " Palmar - Santander ", " Palmar De Varela - Atlántico ", " Palmas Del Socorro - Santander ", " Palmira - Valle Del Cauca ", " Palmito - Sucre ", " Palocabildo - Tolima ", " Pamplona - Norte De Santander ", " Pamplonita - Norte De Santander ", " Pana Pana - Guainía ", " Pandi - Cundinamarca ", " Panqueba - Boyacá ", " Papunahua - Vaupés ", " Páramo - Santander ", " Paratebueno - Cundinamarca ", " Pasca - Cundinamarca ", " Pasto - Nariño ", " Patía - Cauca ", " Pauna - Boyacá ", " Paya - Boyacá ", " Paz De Ariporo - Casanare ", " Paz De Río - Boyacá ", " Pedraza - Magdalena ", " Pelaya - Cesar ", " Pensilvania - Caldas ", " Peñol - Antioquia ", " Peque - Antioquia ", " Pereira - Risaralda ", " Pesca - Boyacá ", " Piamonte - Cauca ", " Piedecuesta - Santander ", " Piedras - Tolima ", " Piendamó - Tunía - Cauca ", " Pijao - Quindío ", " Pijiño Del Carmen - Magdalena ", " Pinchote - Santander ", " Pinillos - Bolívar ", " Piojó - Atlántico ", " Pisba - Boyacá ", " Pital - Huila ", " Pitalito - Huila ", " Pivijay - Magdalena ", " Planadas - Tolima ", " Planeta Rica - Córdoba ", " Plato - Magdalena ", " Policarpa - Nariño ", " Polonuevo - Atlántico ", " Ponedera - Atlántico ", " Popayán - Cauca ", " Pore - Casanare ", " Potosí - Nariño ", " Pradera - Valle Del Cauca ", " Prado - Tolima ", " Providencia - Archipiélago De San Andrés, Providencia Y Santa Catalina ", " Providencia - Nariño ", " Pueblo Bello - Cesar ", " Pueblo Nuevo - Córdoba ", " Pueblo Rico - Risaralda ", " Pueblorrico - Antioquia ", " Puebloviejo - Magdalena ", " Puente Nacional - Santander ", " Puerres - Nariño ", " Puerto Alegría - Amazonas ", " Puerto Arica - Amazonas ", " Puerto Asís - Putumayo ", " Puerto Berrío - Antioquia ", " Puerto Boyacá - Boyacá ", " Puerto Caicedo - Putumayo ", " Puerto Carreño - Vichada ", " Puerto Colombia - Atlántico ", " Puerto Colombia - Guainía ", " Puerto Concordia - Meta ", " Puerto Escondido - Córdoba ", " Puerto Gaitán - Meta ", " Puerto Guzmán - Putumayo ", " Puerto Leguízamo - Putumayo ", " Puerto Libertador - Córdoba ", " Puerto Lleras - Meta ", " Puerto López - Meta ", " Puerto Nare - Antioquia ", " Puerto Nariño - Amazonas ", " Puerto Parra - Santander ", " Puerto Rico - Caquetá ", " Puerto Rico - Meta ", " Puerto Rondón - Arauca ", " Puerto Salgar - Cundinamarca ", " Puerto Santander - Amazonas ", " Puerto Santander - Norte De Santander ", " Puerto Tejada - Cauca ", " Puerto Triunfo - Antioquia ", " Puerto Wilches - Santander ", " Pulí - Cundinamarca ", " Pupiales - Nariño ", " Puracé - Cauca ", " Purificación - Tolima ", " Purísima De La Concepción - Córdoba ", " Quebradanegra - Cundinamarca ", " Quetame - Cundinamarca ", " Quibdó - Chocó ", " Quimbaya - Quindío ", " Quinchía - Risaralda ", " Quípama - Boyacá ", " Quipile - Cundinamarca ", " Ragonvalia - Norte De Santander ", " Ramiriquí - Boyacá ", " Ráquira - Boyacá ", " Recetor - Casanare ", " Regidor - Bolívar ", " Remedios - Antioquia ", " Remolino - Magdalena ", " Repelón - Atlántico ", " Restrepo - Meta ", " Restrepo - Valle Del Cauca ", " Retiro - Antioquia ", " Ricaurte - Cundinamarca ", " Ricaurte - Nariño ", " Río De Oro - Cesar ", " Río Iró - Chocó ", " Río Quito - Chocó ", " Río Viejo - Bolívar ", " Rioblanco - Tolima ", " Riofrío - Valle Del Cauca ", " Riohacha - La Guajira ", " Rionegro - Antioquia ", " Rionegro - Santander ", " Riosucio - Caldas ", " Riosucio - Chocó ", " Risaralda - Caldas ", " Rivera - Huila ", " Roberto Payán - Nariño ", " Roldanillo - Valle Del Cauca ", " Roncesvalles - Tolima ", " Rondón - Boyacá ", " Rosas - Cauca ", " Rovira - Tolima ", " Sabana De Torres - Santander ", " Sabanagrande - Atlántico ", " Sabanalarga - Antioquia ", " Sabanalarga - Atlántico ", " Sabanalarga - Casanare ", " Sabanas De San Ángel - Magdalena ", " Sabaneta - Antioquia ", " Saboyá - Boyacá ", " Sácama - Casanare ", " Sáchica - Boyacá ", " Sahagún - Córdoba ", " Saladoblanco - Huila ", " Salamina - Caldas ", " Salamina - Magdalena ", " Salazar - Norte De Santander ", " Saldaña - Tolima ", " Salento - Quindío ", " Salgar - Antioquia ", " Samacá - Boyacá ", " Samaná - Caldas ", " Samaniego - Nariño ", " Sampués - Sucre ", " San Agustín - Huila ", " San Alberto - Cesar ", " San Andrés - Archipiélago De San Andrés, Providencia Y Santa Catalina ", " San Andrés - Santander ", " San Andrés De Cuerquía - Antioquia ", " San Andrés De Sotavento - Córdoba ", " San Andrés De Tumaco - Nariño ", " San Antero - Córdoba ", " San Antonio - Tolima ", " San Antonio Del Tequendama - Cundinamarca ", " San Benito - Santander ", " San Benito Abad - Sucre ", " San Bernardo - Cundinamarca ", " San Bernardo - Nariño ", " San Bernardo Del Viento - Córdoba ", " San Calixto - Norte De Santander ", " San Carlos - Antioquia ", " San Carlos - Córdoba ", " San Carlos De Guaroa - Meta ", " San Cayetano - Cundinamarca ", " San Cayetano - Norte De Santander ", " San Cristóbal - Bolívar ", " San Diego - Cesar ", " San Eduardo - Boyacá ", " San Estanislao - Bolívar ", " San Felipe - Guainía ", " San Fernando - Bolívar ", " San Francisco - Antioquia ", " San Francisco - Cundinamarca ", " San Francisco - Putumayo ", " San Gil - Santander ", " San Jacinto - Bolívar ", " San Jacinto Del Cauca - Bolívar ", " San Jerónimo - Antioquia ", " San Joaquín - Santander ", " San José - Caldas ", " San José De Cúcuta - Norte De Santander ", " San José De La Montaña - Antioquia ", " San José De Miranda - Santander ", " San José De Pare - Boyacá ", " San José De Toluviejo - Sucre ", " San José De Uré - Córdoba ", " San José Del Fragua - Caquetá ", " San José Del Guaviare - Guaviare ", " San José Del Palmar - Chocó ", " San Juan De Arama - Meta ", " San Juan De Betulia - Sucre ", " San Juan De Rioseco - Cundinamarca ", " San Juan De Urabá - Antioquia ", " San Juan Del Cesar - La Guajira ", " San Juan Nepomuceno - Bolívar ", " San Juanito - Meta ", " San Lorenzo - Nariño ", " San Luis - Antioquia ", " San Luis - Tolima ", " San Luis De Gaceno - Boyacá ", " San Luis De Palenque - Casanare ", " San Luis De Sincé - Sucre ", " San Marcos - Sucre ", " San Martín - Cesar ", " San Martín - Meta ", " San Martín De Loba - Bolívar ", " San Mateo - Boyacá ", " San Miguel - Putumayo ", " San Miguel - Santander ", " San Miguel De Sema - Boyacá ", " San Onofre - Sucre ", " San Pablo - Bolívar ", " San Pablo - Nariño ", " San Pablo De Borbur - Boyacá ", " San Pedro - Sucre ", " San Pedro - Valle Del Cauca ", " San Pedro De Cartago - Nariño ", " San Pedro De Los Milagros - Antioquia ", " San Pedro De Urabá - Antioquia ", " San Pelayo - Córdoba ", " San Rafael - Antioquia ", " San Roque - Antioquia ", " San Sebastián - Cauca ", " San Sebastián De Buenavista - Magdalena ", " San Sebastián De Mariquita - Tolima ", " San Vicente De Chucurí - Santander ", " San Vicente Del Caguán - Caquetá ", " San Vicente Ferrer - Antioquia ", " San Zenón - Magdalena ", " Sandoná - Nariño ", " Santa Ana - Magdalena ", " Santa Bárbara - Antioquia ", " Santa Bárbara - Nariño ", " Santa Bárbara - Santander ", " Santa Bárbara De Pinto - Magdalena ", " Santa Catalina - Bolívar ", " Santa Cruz De Mompox - Bolívar ", " Santa Fé De Antioquia - Antioquia ", " Santa Helena Del Opón - Santander ", " Santa Isabel - Tolima ", " Santa Lucía - Atlántico ", " Santa María - Boyacá ", " Santa María - Huila ", " Santa Marta - Magdalena ", " Santa Rosa - Bolívar ", " Santa Rosa - Cauca ", " Santa Rosa De Cabal - Risaralda ", " Santa Rosa De Osos - Antioquia ", " Santa Rosa De Viterbo - Boyacá ", " Santa Rosa Del Sur - Bolívar ", " Santa Rosalía - Vichada ", " Santa Sofía - Boyacá ", " Santacruz - Nariño ", " Santana - Boyacá ", " Santander De Quilichao - Cauca ", " Santiago - Norte De Santander ", " Santiago - Putumayo ", " Santiago De Tolú - Sucre ", " Santo Domingo - Antioquia ", " Santo Tomás - Atlántico ", " Santuario - Risaralda ", " Sapuyes - Nariño ", " Saravena - Arauca ", " Sardinata - Norte De Santander ", " Sasaima - Cundinamarca ", " Sativanorte - Boyacá ", " Sativasur - Boyacá ", " Segovia - Antioquia ", " Sesquilé - Cundinamarca ", " Sevilla - Valle Del Cauca ", " Siachoque - Boyacá ", " Sibaté - Cundinamarca ", " Sibundoy - Putumayo ", " Silos - Norte De Santander ", " Silvania - Cundinamarca ", " Silvia - Cauca ", " Simacota - Santander ", " Simijaca - Cundinamarca ", " Simití - Bolívar ", " Sincelejo - Sucre ", " Sipí - Chocó ", " Sitionuevo - Magdalena ", " Soacha - Cundinamarca ", " Soatá - Boyacá ", " Socha - Boyacá ", " Socorro - Santander ", " Socotá - Boyacá ", " Sogamoso - Boyacá ", " Solano - Caquetá ", " Soledad - Atlántico ", " Solita - Caquetá ", " Somondoco - Boyacá ", " Sonsón - Antioquia ", " Sopetrán - Antioquia ", " Soplaviento - Bolívar ", " Sopó - Cundinamarca ", " Sora - Boyacá ", " Soracá - Boyacá ", " Sotaquirá - Boyacá ", " Sotará Paispamba - Cauca ", " Suaita - Santander ", " Suan - Atlántico ", " Suárez - Cauca ", " Suárez - Tolima ", " Suaza - Huila ", " Subachoque - Cundinamarca ", " Sucre - Cauca ", " Sucre - Santander ", " Sucre - Sucre ", " Suesca - Cundinamarca ", " Supatá - Cundinamarca ", " Supía - Caldas ", " Suratá - Santander ", " Susa - Cundinamarca ", " Susacón - Boyacá ", " Sutamarchán - Boyacá ", " Sutatausa - Cundinamarca ", " Sutatenza - Boyacá ", " Tabio - Cundinamarca ", " Tadó - Chocó ", " Talaigua Nuevo - Bolívar ", " Tamalameque - Cesar ", " Támara - Casanare ", " Tame - Arauca ", " Támesis - Antioquia ", " Taminango - Nariño ", " Tangua - Nariño ", " Taraira - Vaupés ", " Tarapacá - Amazonas ", " Tarazá - Antioquia ", " Tarqui - Huila ", " Tarso - Antioquia ", " Tasco - Boyacá ", " Tauramena - Casanare ", " Tausa - Cundinamarca ", " Tello - Huila ", " Tena - Cundinamarca ", " Tenerife - Magdalena ", " Tenjo - Cundinamarca ", " Tenza - Boyacá ", " Teorama - Norte De Santander ", " Teruel - Huila ", " Tesalia - Huila ", " Tibacuy - Cundinamarca ", " Tibaná - Boyacá ", " Tibasosa - Boyacá ", " Tibirita - Cundinamarca ", " Tibú - Norte De Santander ", " Tierralta - Córdoba ", " Timaná - Huila ", " Timbío - Cauca ", " Timbiquí - Cauca ", " Tinjacá - Boyacá ", " Tipacoque - Boyacá ", " Tiquisio - Bolívar ", " Titiribí - Antioquia ", " Toca - Boyacá ", " Tocaima - Cundinamarca ", " Tocancipá - Cundinamarca ", " Togüí - Boyacá ", " Toledo - Antioquia ", " Toledo - Norte De Santander ", " Tona - Santander ", " Tópaga - Boyacá ", " Topaipí - Cundinamarca ", " Toribío - Cauca ", " Toro - Valle Del Cauca ", " Tota - Boyacá ", " Totoró - Cauca ", " Trinidad - Casanare ", " Trujillo - Valle Del Cauca ", " Tubará - Atlántico ", " Tuchín - Córdoba ", " Tuluá - Valle Del Cauca ", " Tunja - Boyacá ", " Tununguá - Boyacá ", " Túquerres - Nariño ", " Turbaco - Bolívar ", " Turbaná - Bolívar ", " Turbo - Antioquia ", " Turmequé - Boyacá ", " Tuta - Boyacá ", " Tutazá - Boyacá ", " Ubalá - Cundinamarca ", " Ubaque - Cundinamarca ", " Ulloa - Valle Del Cauca ", " Úmbita - Boyacá ", " Une - Cundinamarca ", " Unguía - Chocó ", " Unión Panamericana - Chocó ", " Uramita - Antioquia ", " Uribe - Meta ", " Uribia - La Guajira ", " Urrao - Antioquia ", " Urumita - La Guajira ", " Usiacurí - Atlántico ", " Útica - Cundinamarca ", " Valdivia - Antioquia ", " Valencia - Córdoba ", " Valle De San José - Santander ", " Valle De San Juan - Tolima ", " Valle Del Guamuez - Putumayo ", " Valledupar - Cesar ", " Valparaíso - Antioquia ", " Valparaíso - Caquetá ", " Vegachí - Antioquia ", " Vélez - Santander ", " Venadillo - Tolima ", " Venecia - Antioquia ", " Venecia - Cundinamarca ", " Ventaquemada - Boyacá ", " Vergara - Cundinamarca ", " Versalles - Valle Del Cauca ", " Vetas - Santander ", " Vianí - Cundinamarca ", " Victoria - Caldas ", " Vigía Del Fuerte - Antioquia ", " Vijes - Valle Del Cauca ", " Villa Caro - Norte De Santander ", " Villa De Leyva - Boyacá ", " Villa De San Diego De Ubaté - Cundinamarca ", " Villa Del Rosario - Norte De Santander ", " Villa Rica - Cauca ", " Villagarzón - Putumayo ", " Villagómez - Cundinamarca ", " Villahermosa - Tolima ", " Villamaría - Caldas ", " Villanueva - Bolívar ", " Villanueva - Casanare ", " Villanueva - La Guajira ", " Villanueva - Santander ", " Villapinzón - Cundinamarca ", " Villarrica - Tolima ", " Villavicencio - Meta ", " Villavieja - Huila ", " Villeta - Cundinamarca ", " Viotá - Cundinamarca ", " Viracachá - Boyacá ", " Vistahermosa - Meta ", " Viterbo - Caldas ", " Yacopí - Cundinamarca ", " Yacuanquer - Nariño ", " Yaguará - Huila ", " Yalí - Antioquia ", " Yarumal - Antioquia ", " Yavaraté - Vaupés ", " Yolombó - Antioquia ", " Yondó - Antioquia ", " Yopal - Casanare ", " Yotoco - Valle Del Cauca ", " Yumbo - Valle Del Cauca ", " Zambrano - Bolívar ", " Zapatoca - Santander ", " Zapayán - Magdalena ", " Zaragoza - Antioquia ", " Zarzal - Valle Del Cauca ", " Zetaquira - Boyacá ", " Zipacón - Cundinamarca ", " Zipaquirá - Cundinamarca ", " Zona Bananera - Magdalena ", "[San Cristóbal de] la Laguna" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtacompañante, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_tipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboparentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnumero_habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dcCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnum_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtidacompañante, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbociudadrecidencia, 0, 1, Short.MAX_VALUE)
                            .addComponent(cbociudadprocedencia, javax.swing.GroupLayout.Alignment.TRAILING, 0, 1, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGuardarAcomp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dcCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtnum_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidacompañante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtnumero_habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtacompañante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_tipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cboparentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbociudadrecidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cbociudadprocedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardarAcomp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablalistadoacompañante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Tipo Documento", "Documento", "Parentesco", "N° Habita"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablalistadoacompañante.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tablalistadoacompañante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoacompañanteMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tablalistadoacompañante);

        jLabel24.setText("Buscar");

        txtbuscaracompañante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscaracompañanteActionPerformed(evt);
            }
        });

        btneliminaracompañante.setBackground(new java.awt.Color(204, 204, 204));
        btneliminaracompañante.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btneliminaracompañante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btneliminaracompañante.setText("Eliminar");
        btneliminaracompañante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminaracompañanteActionPerformed(evt);
            }
        });

        btnbuscaracompañante.setBackground(new java.awt.Color(204, 204, 204));
        btnbuscaracompañante.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnbuscaracompañante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnbuscaracompañante.setText("Buscar");
        btnbuscaracompañante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscaracompañanteActionPerformed(evt);
            }
        });

        lbltotalregistroacompañante.setText("Total registro");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltotalregistroacompañante)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbuscaracompañante, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnbuscaracompañante, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btneliminaracompañante)))
                        .addContainerGap(137, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtbuscaracompañante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscaracompañante)
                    .addComponent(btneliminaracompañante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbltotalregistroacompañante)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumero_habitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumero_habitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumero_habitacionActionPerformed

    private void btnGuardarAcompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAcompActionPerformed
        // TODO add your handling code here:

        if (txtidcliente.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Porfavor presione enter en el huesped principal para relacionar con el Idcliente");
            txtidcliente.requestFocus();
            return;

        }
        Facompañante func = new Facompañante();
        Dacompañante dts = new Dacompañante();

        dts.setIdcliente(Integer.parseInt(txtidcliente.getText()));
        dts.setNombre_apellido(txtacompañante.getText());
        int seleccionado = cbo_tipoDocumento.getSelectedIndex();
        dts.setTipo_documento((String) cbo_tipoDocumento.getItemAt(seleccionado));
        dts.setDocumento(Integer.parseInt(txtdocumentos.getText().trim()));
        int parentesco = cboparentesco.getSelectedIndex();
        dts.setParentesco((String) cboparentesco.getItemAt(parentesco));
        dts.setNum_habitacion(Integer.parseInt(txtnumero_habitacion.getText()));
        Calendar cal;
        int d, m, a;
        cal = dcCheckin.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        dts.setCheckin(new Date(a, m, d));

        dts.setNum_huesped_principal(Integer.parseInt(txtnum_principal.getText().trim()));
        int ciudadrecidencia = cbociudadrecidencia.getSelectedIndex();
        dts.setCiudad_de_residencia(cbociudadrecidencia.getItemAt(ciudadrecidencia));
        int ciudadprocedencia = cbociudadprocedencia.getSelectedIndex();
        dts.setCiudad_de_procedencia(cbociudadprocedencia.getItemAt(ciudadprocedencia));

        int Estado = cboestado.getSelectedIndex();
        dts.setEstado((String) cboestado.getItemAt(Estado));

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                mostraracompañante("");

                int respuesta = JOptionPane.showConfirmDialog(rootPane, "ACOMPAÑANTE REGISTRADO.Deseas ingresar otro", "comfirmar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_NO_OPTION) {
                    limpiarcampo();
                    this.dispose();

                }

            }

        }
    }//GEN-LAST:event_btnGuardarAcompActionPerformed

    private void tablalistadoacompañanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoacompañanteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoacompañanteMouseClicked

    private void txtbuscaracompañanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscaracompañanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscaracompañanteActionPerformed

    private void btneliminaracompañanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminaracompañanteActionPerformed
        // TODO add your handling code here:
        if (!txtidacompañante.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el ACOMPAÑANTE?", "Confirmar", 2);

            if (confirmacion == 0) {
                Facompañante func = new Facompañante();
                Dacompañante dts = new Dacompañante();

                dts.setIdacompañante(Integer.parseInt(txtidacompañante.getText()));
                func.eliminar(dts);
                mostraracompañante("");

            }

        }
    }//GEN-LAST:event_btneliminaracompañanteActionPerformed

    private void btnbuscaracompañanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscaracompañanteActionPerformed
        // TODO add your handling code here:
        mostraracompañante(txtbuscaracompañante.getText());
    }//GEN-LAST:event_btnbuscaracompañanteActionPerformed

    private void txtidacompañanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidacompañanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidacompañanteActionPerformed

    private void txtnum_principalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnum_principalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cconexion conexion = new Cconexion();

            try {
                Connection conectar = conexion.establecerConexion();

                // Primera consulta: obtener el idcliente basado en el numdocumento
                PreparedStatement pst1 = conectar.prepareStatement("select idcliente from ingreso where documento = ? AND estado = 'Activo'");
                pst1.setString(1, txtnum_principal.getText());

                ResultSet rs1 = pst1.executeQuery();

                if (rs1.next()) {
                    int idCliente = rs1.getInt("idcliente");

                    // Segunda consulta: obtener el num_habitacion basado en el idcliente
                    PreparedStatement pst2 = conectar.prepareStatement("select num_habitacion from ingreso where idcliente=?  and estado = 'Activo'");
                    pst2.setInt(1, idCliente);

                    ResultSet rs2 = pst2.executeQuery();

                    if (rs2.next()) {
                        txtidcliente.setText(String.valueOf(idCliente));
                        txtnumero_habitacion.setText(rs2.getString("num_habitacion"));
//                txtcliente.setText(rs1.getString("nombres") + " " + rs1.getString("apellidos"));

                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la habitación para el CLIENTE solicitado");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el CLIENTE solicitado");
                }

            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }

    }//GEN-LAST:event_txtnum_principalKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        limpiarcampo();
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jacompañante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jacompañante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jacompañante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jacompañante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jacompañante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarAcomp;
    private javax.swing.JButton btnbuscaracompañante;
    private javax.swing.JButton btneliminaracompañante;
    private javax.swing.JComboBox<String> cbo_tipoDocumento;
    private javax.swing.JComboBox<String> cbociudadprocedencia;
    private javax.swing.JComboBox<String> cbociudadrecidencia;
    private javax.swing.JComboBox<String> cboestado;
    private javax.swing.JComboBox<String> cboparentesco;
    private com.toedter.calendar.JDateChooser dcCheckin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lbltotalregistroacompañante;
    private javax.swing.JTable tablalistadoacompañante;
    private javax.swing.JTextField txtacompañante;
    private javax.swing.JTextField txtbuscaracompañante;
    private javax.swing.JTextField txtdocumentos;
    private static javax.swing.JTextField txtidacompañante;
    public static javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtnum_principal;
    private javax.swing.JTextField txtnumero_habitacion;
    // End of variables declaration//GEN-END:variables
}
