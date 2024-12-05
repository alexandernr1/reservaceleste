package Logica;

import Datos.Dcambio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fcambio {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrarcambio(String buscar)  {
        DefaultTableModel modelo;

        String[] titulos = {"idcambio", "idingreso", "Idhabitacion", "Empleado", "Fecha nuevoingreso", "Numero turno", "Numero habita", "Tipo habita", "Costoalojamoento", "Documento", "Cliente", "Telefono", "Tipo cliente", "Estado", "Numpersona", "Deuda anterior"};

        String[] registro = new String[16];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT c.idcambio, c.idingreso, c.idhabitacion, c.empleado, c.fecha_nuevoingreso, c.numero_turno, "
                + "c.numero_habita, c.tipo_habita, c.costoalojamiento, c.documento, c.cliente, c.telefono, "
                + "c.tipo_cliente, c.estado, c.numpersona, c.deuda_anterior "
                + "FROM cambio_habitacion c "
                + "WHERE c.numero_habita LIKE '%" + buscar + "%' "
                + "ORDER BY c.idcambio DESC";
       
        try { Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idcambio");
                registro[1] = rs.getString("idingreso");
                registro[2] = rs.getString("idhabitacion");
                registro[3] = rs.getString("empleado");
                registro[4] = rs.getString("fecha_nuevoingreso");
                registro[5] = rs.getString("numero_turno");
                registro[6] = rs.getString("numero_habita");
                registro[7] = rs.getString("tipo_habita");
                registro[8] = rs.getString("costoalojamiento");
                registro[9] = rs.getString("documento");
                registro[10] = rs.getString("cliente");
                registro[11] = rs.getString("telefono");
                registro[12] = rs.getString("tipo_cliente");
                registro[13] = rs.getString("estado");
                registro[14] = rs.getString("numpersona");
                registro[15] = rs.getString("deuda_anterior");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        } 

    }

    public boolean insertarc(Dcambio dts) {
        sSQL = "insert into cambio_habitacion (idingreso, idhabitacion, empleado, fecha_nuevoingreso, numero_turno, "
                + "numero_habita, tipo_habita, costoalojamiento, documento, cliente, telefono, "
                + "tipo_cliente, estado, numpersona, deuda_anterior)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdingreso());
            pst.setInt(2, dts.getIdhabitacion());
            pst.setString(3, dts.getEmpleado());
            pst.setString(4, dts.getFecha_nuevoingreso());
            pst.setInt(5, dts.getNumero_turno());
            pst.setInt(6, dts.getNumero_habita());
            pst.setString(7, dts.getTipo_habita());
            pst.setInt(8, dts.getCostoalojamiento());
            pst.setString(9, dts.getDocumento());
            pst.setString(10, dts.getCliente());
            pst.setString(11, dts.getTelefono());
            pst.setString(12, dts.getTipo_cliente());
            pst.setString(13, dts.getEstado());
            pst.setInt(14, dts.getNumpersona());
            pst.setInt(15, dts.getDeuda_anterior());

            int n = pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATOS ALMACENADOS CORRECTAMENTE");
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } 

    }

    public boolean finalizar(Dcambio dts) {
        sSQL = "update cambio_habitacion set estado='Finalizado'"
                + " where numero_habita=?";
        //alt + 39
        
        try {PreparedStatement pst = cn.prepareStatement(sSQL);
            

            pst.setInt(1, dts.getNumero_habita());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } 
    }


}
