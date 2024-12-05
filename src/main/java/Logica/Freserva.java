package Logica;

import Datos.Dreserva;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Freserva {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Idreserva", "Idhabitacion", "FechaReserva", "FechaIngreso",
            "FechaSalida", "Estado", "Numnoches", "Numpersonas", "cliente", "Documento",
            "Telefono", "Numero Hbit", "Costo", "Tipo", "Empleado", "idcliente"};
        String[] registro = new String[16];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from reserva  where documento like '%" + buscar + "%' order by idreserva desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idreserva");
                registro[1] = rs.getString("idhabitacion");
                registro[2] = rs.getString("fechareserva");
                registro[3] = rs.getString("fechaingreso");
                registro[4] = rs.getString("fechasalida");
                registro[5] = rs.getString("estado");
                registro[6] = rs.getString("numnoches");
                registro[7] = rs.getString("numpersonas");
                registro[8] = rs.getString("cliente");
                registro[9] = rs.getString("documento");
                registro[10] = rs.getString("telefono");
                registro[11] = rs.getString("numhabitacion");
                registro[12] = rs.getString("costoalojamiento");
                registro[13] = rs.getString("tipohabitacion");
                registro[14] = rs.getString("empleado");
                registro[15] = rs.getString("idcliente");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(Dreserva dts) {
        sSQL = "insert into reserva (idhabitacion,fechareserva,fechaingreso,fechasalida,estado,numnoches, "
                + "numpersonas,cliente,documento,telefono,numhabitacion,costoalojamiento,tipohabitacion,empleado, "
                + "idinicioturno,num_turno,turno, idcliente)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdhabitacion());
            pst.setString(2, dts.getFechareserva());
            pst.setString(3, dts.getFechaingreso());
            pst.setDate(4, dts.getFechasalida());
            pst.setString(5, dts.getEstado());
            pst.setInt(6, dts.getNumnoches());
            pst.setInt(7, dts.getNumpersonas());
            pst.setString(8, dts.getCliente());
            pst.setInt(9, dts.getDocumento());
            pst.setString(10, dts.getTelefono());
            pst.setInt(11, dts.getNumhabitacion());
            pst.setInt(12, dts.getCostoalojamiento());
            pst.setString(13, dts.getTipohabitacion());
            pst.setString(14, dts.getEmpleado());
            pst.setInt(15, dts.getIdinicioturno());
            pst.setInt(16, dts.getNum_turno());
            pst.setString(17, dts.getTurno());
            pst.setInt(18, dts.getIdcliente());

            int n = pst.executeUpdate();

            return n != 0; // JOptionPane.showMessageDialog(null, "DATOS ALMACENADOS CORRECTAMENTE");

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(Dreserva dts) {
        sSQL = "delete from reserva where idreserva=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdreserva());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(Dreserva dts) {
        sSQL = "update reserva set idhabitacion=?,fechareserva=?,fechaingreso=?,fechasalida=?,estado=?,numnoches=?,numpersonas=?,cliente=?,documento=?,telefono=?,numhabitacion=?,costoalojamiento=?,tipohabitacion=?,empleado=?,idinicioturno=?,num_turno=?,turno=?"
                + " where idreserva=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdhabitacion());
            pst.setString(2, dts.getFechareserva());
            pst.setString(3, dts.getFechaingreso());
            pst.setDate(4, dts.getFechasalida());
            pst.setString(5, dts.getEstado());
            pst.setInt(6, dts.getNumnoches());
            pst.setInt(7, dts.getNumpersonas());
            pst.setString(8, dts.getCliente());
            pst.setInt(9, dts.getDocumento());
            pst.setString(10, dts.getTelefono());
            pst.setInt(11, dts.getNumhabitacion());
            pst.setInt(12, dts.getCostoalojamiento());
            pst.setString(13, dts.getTipohabitacion());
            pst.setString(14, dts.getEmpleado());
            pst.setInt(15, dts.getIdinicioturno());
            pst.setInt(16, dts.getNum_turno());
            pst.setString(17, dts.getTurno());

            pst.setInt(18, dts.getIdreserva());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean CambiarEstado(Dreserva dts1) {
        sSQL = "UPDATE reserva SET estado='Anulada' WHERE numhabitacion=?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts1.getNumhabitacion());

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cambiar el estado a 'Anulada': " + e.getMessage());
            return false;
        }
    }

    public boolean AnularReservas() {
        String sSQL = "UPDATE reserva set estado = 'Anulada'"; // Consulta corregida
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            int n = pst.executeUpdate(); // Ejecuta la consulta
            return n > 0; // Devuelve true si se eliminaron registros
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Muestra el error en un mensaje de diálogo
            return false;
        }

    }

    public ResultSet realizarConsultaReserva(String habitacion) {
        sSQL = "SELECT cliente, documento, telefono, numpersonas, numhabitacion, "
                + "costoalojamiento, tipohabitacion "
                + "FROM reserva "
                + "WHERE numhabitacion = ?";
        ResultSet rs = null;
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, habitacion);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos de reserva: " + e.getMessage());
        }
        return rs; // Retornar el ResultSet
    }

}
