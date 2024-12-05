package Logica;

import Datos.Dlimpieza;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Flimpieza {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Idlimpieza", "Idempleado", "Empleado", "Numero Habita", "Fecha", "Tipo habita", "Estado", "Turno", "idhabitacion"};
        String[] registro = new String[9];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT l.idlimpieza, l.idempleado, p.nombres AS empleadon, p.apellidos AS empleadoap, l.numero, l.fecha, l.tipo_habitacion, l.estado, l.turno, l.idhabitacion "
                + "FROM limpieza l "
                + "INNER JOIN persona p ON l.idempleado = p.idpersona "
                + "WHERE l.numero LIKE '%" + buscar + "%' "
                + "ORDER BY idlimpieza DESC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idlimpieza");
                registro[1] = rs.getString("idempleado");
                registro[2] = rs.getString("empleadon") + " " + rs.getString("empleadoap");
                registro[3] = rs.getString("numero");
                registro[4] = rs.getString("fecha");
                registro[5] = rs.getString("tipo_habitacion");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("turno");
                registro[8] = rs.getString("idhabitacion");

                totalregistros++;
                modelo.addRow(registro);
            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE MOSTRAR LOS DATOS");
            return null;
        }
    }

    public boolean insertar(Dlimpieza dts) {
        sSQL = "insert into limpieza(idempleado, numero,  tipo_habitacion, fecha, estado, turno, idhabitacion)" + "values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdempleado());
            pst.setInt(2, dts.getNumero());
            pst.setString(3, dts.getTipo_habitacion());
            pst.setDate(4, dts.getFecha());
            pst.setString(5, dts.getEstado());
            pst.setString(6, dts.getTurno());
            pst.setInt(7, dts.getIdhabitacion());

            int n = pst.executeUpdate();
            // JOptionPane.showMessageDialog(null, "DATOS ALMACENADOS CORRECTAMENTE");
            return n != 0;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(Dlimpieza dts) {
        sSQL = "delete from limpieza where idlimpieza=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdlimpieza());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(Dlimpieza dts) {
        sSQL = "update limpieza set idempleado=?, numero=?, tipo_habitacion=?, fecha=?, estado=?, turno=?, idhabitacion=?"
                + " where idlimpieza=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdempleado());
            pst.setInt(2, dts.getNumero());
            pst.setString(3, dts.getTipo_habitacion());
            pst.setDate(4, dts.getFecha());
            pst.setString(5, dts.getEstado());
            pst.setString(6, dts.getTurno());
            pst.setInt(7, dts.getIdhabitacion());
            
            pst.setInt(8, dts.getIdlimpieza());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    public boolean existe(Dlimpieza dts) {
    String sql = "SELECT COUNT(*) FROM limpieza WHERE idempleado = ? AND numero = ? AND fecha = ?";

    try (PreparedStatement pst = cn.prepareStatement(sql)) {
        pst.setInt(1, dts.getIdempleado());
        pst.setInt(2, dts.getNumero());
        pst.setDate(3, new java.sql.Date(dts.getFecha().getTime()));
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
        return false;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        return false;
    }
}

}
