package Logica;

import Datos.Dingreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fingreso {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Idingreso", "Idhabitacion", "Habitacion", "Tipo Habi", "Caracteristicas", "Idcliente", "Cliente", "Telefono", "Documento",
            "Fecha ingreso", "Numero personas", "Tipo cliente", "Costo alojamiento", "Motivo viaje", "Estado",
            "Ciudad Recidencia", "Ciudad Procedencia", "Placa"};

        String[] registro = new String[18];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT i.idingreso, i.idhabitacion, h.numero, h.tipohabitacion, h.caracteristicas, i.idcliente, "
                + "(SELECT nombres FROM cliente WHERE idcliente=i.idcliente) AS clienten, "
                + "(SELECT apellidos FROM cliente WHERE idcliente=i.idcliente) AS clienteap, "
                + "(SELECT numdocumento FROM cliente WHERE idcliente=i.idcliente) AS clientenu, "
                + "(SELECT telefono FROM cliente WHERE idcliente=i.idcliente) AS clientete, "
                + "i.fecha_hora_ingreso, i.num_personas, i.tipo_cliente, i.costoalojamiento, "
                + "i.motivo_viaje, i.estado, i.ciudad_de_recidencia, i.ciudad_de_procedencia, i.placa "
                + "FROM ingreso i "
                + "INNER JOIN habitacion h ON i.idhabitacion=h.idhabitacion "
                + "WHERE (SELECT numdocumento FROM cliente WHERE idcliente=i.idcliente) LIKE ? "
                + "ORDER BY idingreso DESC LIMIT 40";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setString(1, "%" + buscar + "%");
            try ( ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    registro[0] = rs.getString("idingreso");
                    registro[1] = rs.getString("idhabitacion");
                    registro[2] = rs.getString("numero");
                    registro[3] = rs.getString("tipohabitacion");
                    registro[4] = rs.getString("caracteristicas");
                    registro[5] = rs.getString("idcliente");
                    registro[6] = rs.getString("clienten") + " " + rs.getString("clienteap");
                    registro[7] = rs.getString("clientete");
                    registro[8] = rs.getString("clientenu");
                    registro[9] = rs.getString("fecha_hora_ingreso");
                    registro[10] = rs.getString("num_personas");
                    registro[11] = rs.getString("tipo_cliente");
                    registro[12] = rs.getString("costoalojamiento");
                    registro[13] = rs.getString("motivo_viaje");
                    registro[14] = rs.getString("estado");
                    registro[15] = rs.getString("ciudad_de_recidencia");
                    registro[16] = rs.getString("ciudad_de_procedencia");
                    registro[17] = rs.getString("placa");

                    totalregistros++;
                    modelo.addRow(registro);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los ingresos: " + e.getMessage());
            return null;
        }
        return modelo;
    }

    public DefaultTableModel vistaingreso(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Idingreso", "Idhabitacion", "Habitacion", "Idcliente", "Cliente", "Telefono", "Documento",
            "Fecha ingreso", "Numero personas", "Tipo cliente", "Costo alojamiento", "Motivo viaje", "Estado",
            "Ciudad Residencia", "Ciudad Procedencia", "N° Turno"};

        String[] registro = new String[16];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT "
                + "i.idingreso, "
                + "i.idhabitacion, "
                + "h.numero AS habitacion, "
                + "i.idcliente, "
                + "CONCAT(c.nombres, ' ', c.apellidos) AS nombre_cliente, "
                + "c.telefono AS clientete, "
                + "c.numdocumento AS clientenu, "
                + "i.fecha_hora_ingreso, "
                + "i.num_personas, "
                + "i.tipo_cliente, "
                + "i.costoalojamiento, "
                + "i.motivo_viaje, "
                + "i.estado, "
                + "i.ciudad_de_recidencia, "
                + "i.ciudad_de_procedencia, "
                + "i.num_turno "
                + "FROM ingreso i "
                + "JOIN habitacion h ON i.idhabitacion = h.idhabitacion "
                + "JOIN cliente c ON i.idcliente = c.idcliente "
                + "JOIN inicioturno t ON i.num_turno = t.numero_turno "
                + "WHERE t.estado = 'Activo' "
                + "AND CONCAT(c.nombres, ' ', c.apellidos) LIKE ? "
                + "ORDER BY i.idingreso DESC;";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setString(1, "%" + buscar + "%");
            try ( ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    registro[0] = rs.getString("idingreso");
                    registro[1] = rs.getString("idhabitacion");
                    registro[2] = rs.getString("habitacion");
                    registro[3] = rs.getString("idcliente");
                    registro[4] = rs.getString("nombre_cliente");
                    registro[5] = rs.getString("clientete");
                    registro[6] = rs.getString("clientenu");
                    registro[7] = rs.getString("fecha_hora_ingreso");
                    registro[8] = rs.getString("num_personas");
                    registro[9] = rs.getString("tipo_cliente");
                    registro[10] = rs.getString("costoalojamiento");
                    registro[11] = rs.getString("motivo_viaje");
                    registro[12] = rs.getString("estado");
                    registro[13] = rs.getString("ciudad_de_recidencia");
                    registro[14] = rs.getString("ciudad_de_procedencia");
                    registro[15] = rs.getString("num_turno");

                    totalregistros++;
                    modelo.addRow(registro);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los ingresos: " + e.getMessage());
            return null;
        }
        return modelo;
    }

    public boolean insertar(Dingreso dts) {
        sSQL = "INSERT INTO ingreso (idhabitacion, idcliente, fecha_hora_ingreso, num_personas, tipo_cliente, "
                + "costoalojamiento, motivo_viaje, estado, ciudad_de_recidencia, ciudad_de_procedencia, "
                + "num_habitacion, documento, tipo_documento, tipo_habitacion, idinicioturno, turno, num_turno, placa) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts.getIdhabitacion());
            pst.setInt(2, dts.getIdcliente());
            pst.setString(3, dts.getFecha_hora_ingreso());
            pst.setInt(4, dts.getNum_personas());
            pst.setString(5, dts.getTipo_cliente());
            pst.setInt(6, dts.getCostoalojamiento());
            pst.setString(7, dts.getMotivo_viaje());
            pst.setString(8, dts.getEstado());
            pst.setString(9, dts.getCiudad_de_recidencia());
            pst.setString(10, dts.getCiudad_de_procedencia());
            pst.setInt(11, dts.getNum_habitacion());
            pst.setString(12, dts.getDocumento());
            pst.setString(13, dts.getTipo_documento());
            pst.setString(14, dts.getTipo_habitacion());
            pst.setInt(15, dts.getIdinicioturno());
            pst.setString(16, dts.getTurno());
            pst.setInt(17, dts.getNum_turno());
            pst.setString(18, dts.getPlaca());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el ingreso: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(Dingreso dts) {
        sSQL = "DELETE FROM ingreso WHERE idingreso = ?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts.getIdingreso());

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el ingreso: " + e.getMessage());
            return false;
        }
    }

    public boolean editar(Dingreso dts) {
        sSQL = "UPDATE ingreso SET idhabitacion = ?, idcliente = ?, fecha_hora_ingreso = ?, num_personas = ?, "
                + "tipo_cliente = ?, costoalojamiento = ?, motivo_viaje = ?, estado = ?, "
                + "ciudad_de_recidencia = ?, ciudad_de_procedencia = ?, num_habitacion = ?, "
                + "documento = ?, tipo_documento = ?, tipo_habitacion = ?, idinicioturno = ?, turno = ?, num_turno = ?, placa = ? "
                + "WHERE idingreso = ?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts.getIdhabitacion());
            pst.setInt(2, dts.getIdcliente());
            pst.setString(3, dts.getFecha_hora_ingreso());
            pst.setInt(4, dts.getNum_personas());
            pst.setString(5, dts.getTipo_cliente());
            pst.setInt(6, dts.getCostoalojamiento());
            pst.setString(7, dts.getMotivo_viaje());
            pst.setString(8, dts.getEstado());
            pst.setString(9, dts.getCiudad_de_recidencia());
            pst.setString(10, dts.getCiudad_de_procedencia());
            pst.setInt(11, dts.getNum_habitacion());
            pst.setString(12, dts.getDocumento());
            pst.setString(13, dts.getTipo_documento());
            pst.setString(14, dts.getTipo_habitacion());
            pst.setInt(15, dts.getIdinicioturno());
            pst.setString(16, dts.getTurno());
            pst.setInt(17, dts.getNum_turno());
            pst.setString(18, dts.getPlaca());

            pst.setInt(19, dts.getIdingreso());

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar el ingreso: " + e.getMessage());
            return false;
        }
    }

    public boolean finalizar(Dingreso dts) {
        sSQL = "UPDATE ingreso SET estado = 'Finalizado' WHERE idingreso = ?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts.getIdingreso());

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al finalizar el ingreso: " + e.getMessage());
            return false;
        }
    }

    public boolean activar(Dingreso dts) {
        sSQL = "UPDATE ingreso SET estado = 'Activo' WHERE idingreso = ?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts.getIdingreso());

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al activar el ingreso: " + e.getMessage());
            return false;
        }
    }

    public int obtenerIdHabitacionAnterior(int idIngreso) {
        sSQL = "SELECT idhabitacion FROM ingreso WHERE idingreso = ?";
        int idHabitacion = -1;

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, idIngreso);
            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    idHabitacion = rs.getInt("idhabitacion");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ID de la habitación anterior: " + e.getMessage());
        }

        return idHabitacion;
    }

    public boolean existeIngreso(Dingreso dts) {
        sSQL = "SELECT COUNT(*) FROM ingreso WHERE idhabitacion = ? AND fecha_hora_ingreso = ? AND idcliente = ?";
        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts.getIdhabitacion());
            pst.setString(2, dts.getFecha_hora_ingreso());
            pst.setInt(3, dts.getIdcliente());

            ResultSet rs = pst.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true; // Ya existe un ingreso similar
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar ingreso: " + e.getMessage());
        }
        return false; // No existe un ingreso similar
    }

    public Object[] DatosReserva(int habitacion) {
        Object[] reserva = new Object[9]; // Usa Object[] para poder almacenar varios tipos de datos

        sSQL = "SELECT r.cliente, r.documento, r.telefono, "
                + "r.numhabitacion, r.tipohabitacion, r.costoalojamiento, r.idcliente, h.caracteristicas, h.idhabitacion "
                + "FROM reserva r "
                + "INNER JOIN habitacion h ON h.numero = r.numhabitacion "
                + "WHERE r.numhabitacion = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, habitacion);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Si es una fecha en formato String
                reserva[0] = rs.getString("cliente");
                reserva[1] = rs.getString("documento");
                reserva[2] = rs.getString("telefono");
                reserva[3] = rs.getInt("numhabitacion");
                reserva[4] = rs.getString("tipohabitacion");
                reserva[5] = rs.getInt("costoalojamiento");
                reserva[6] = rs.getString("caracteristicas");
                reserva[7] = rs.getInt("idhabitacion");
                reserva[8] = rs.getInt("idcliente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de reserva: " + e.getMessage());
        }

        return reserva;
    }
}
