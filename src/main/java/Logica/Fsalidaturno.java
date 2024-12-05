package Logica;

import Datos.Dsalidaturno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Alexander nieves romero
 */
public class Fsalidaturno {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    public Integer totalregistros;

//   public DefaultTableModel mostrar(String buscar) {
//    DefaultTableModel modelo;
//
//    String[] titulos = {"Idsalida", "Idingreso", "idcliente", "idhabitacion", "idabono", "Idempleado", "Numero", "Cliente", "Numnoches", "Costo", "Fecha Ingreso", "Fecha Salida", "Fecha Emision", "Tipo Cliente", "Tipo comprobante", "N Comprobante", "Forma Pago", "valor Noches", "Abonos", "Valor Total", "Descunetos", "Cobros Extra", "Otros Cobros", "Total Pago"};
//    String[] registro = new String[24];
//
//    totalregistros = 0;
//    modelo = new DefaultTableModel(null, titulos);
//
//    sSQL = "SELECT s.idsalida, s.idingreso, s.idcliente, s.idhabitacion, s.idabono, s.idempleado, " +
//            "s.numero, s.cliente, s.numnoches, s.costoalojamiento, s.fechaingreso, s.fechasalida, " +
//            "s.fechaemision, s.tipocliente, s.tipocomprobante, s.num_comprobante, s.formapago, s.valor_noches, " +
//            "s.abonos, s.valor_total, s.descuentos, s.cobros_extra, s.otros_cobros, s.totalpago " +
//            "FROM salida s WHERE s.numero LIKE '%" + buscar + "%' ORDER BY idsalida DESC";
//
//    try {
//        Statement st = cn.createStatement();
//        ResultSet rs = st.executeQuery(sSQL);
//
//        while (rs.next()) {
//            registro[0] = rs.getString("idsalida");
//            registro[1] = rs.getString("idingreso");
//            registro[2] = rs.getString("idcliente");
//            registro[3] = rs.getString("idhabitacion");
//            registro[4] = rs.getString("idabono");
//            registro[5] = rs.getString("idempleado");
//            registro[6] = rs.getString("numero");
//            registro[7] = rs.getString("cliente");
//            registro[8] = rs.getString("numnoches");
//            registro[9] = rs.getString("costoalojamiento");
//            registro[10] = rs.getString("fechaingreso");
//            registro[11] = rs.getString("fechasalida");
//            registro[12] = rs.getString("fechaemision");
//            registro[13] = rs.getString("tipocliente");
//            registro[14] = rs.getString("tipocomprobante");
//            registro[15] = rs.getString("num_comprobante");
//            registro[16] = rs.getString("formapago");
//            registro[17] = rs.getString("valor_noches");
//            registro[18] = rs.getString("abonos");
//            registro[19] = rs.getString("valor_total");
//            registro[20] = rs.getString("descuentos");
//            registro[21] = rs.getString("cobros_extra");
//            registro[22] = rs.getString("otros_cobros");
//            registro[23] = rs.getString("totalpago");
//
//            totalregistros = totalregistros + 1;
//            modelo.addRow(registro);
//        }
//
//        return modelo;
//
//    } catch (SQLException e) {
////        JOptionPane.showMessageDialog(null, "NO SE PUEDE MOSTRAR LOS DATOS: " + e.getMessage());
//        return null;
//    }
//}
    public boolean insertar(Dsalidaturno dts) {
        sSQL = "insert into salidaturno (idabonos, idempleado, idhabitacion, empleado, turno, fecha_hora_inicio, fecha_hora_salida,"
                + " habitaciones_ocupadas, total_recibos, base, tarjetas, efectivo, transferencias, totalhabitaciones, total_abonos, otros_ingresos, total_recaudo, entrega_admon, total_efectivo, observaciones, numero_turno, parqueadero, lavanderia)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdabonos());
            pst.setInt(2, dts.getIdempleado());
            pst.setInt(3, dts.getIdhabitacion());
            pst.setString(4, dts.getEmpleado());
            pst.setString(5, dts.getTurno());
            pst.setString(6, dts.getFecha_hora_inicio());
            pst.setString(7, dts.getFecha_hora_salida());
            pst.setInt(8, dts.getHabitaciones_ocupadas());
            pst.setInt(9, dts.getTotal_recibos());
            pst.setInt(10, dts.getBase());
            pst.setInt(11, dts.getTarjetas());
            pst.setInt(12, dts.getEfectivo());
            pst.setInt(13, dts.getTransferencias());
            pst.setInt(14, dts.getTotalhabitaciones());
            pst.setInt(15, dts.getTotal_abonos());
            pst.setInt(16, dts.getOtros_ingresos());
            pst.setInt(17, dts.getTotal_recaudo());
            pst.setInt(18, dts.getEntrega_admon());
            pst.setInt(19, dts.getTotal_efectivo());
            pst.setString(20, dts.getObservaciones());
            pst.setInt(21, dts.getNumero_turno());
            pst.setInt(22,dts.getParqueadero());
            pst.setInt(23,dts.getLavanderia());

            int n = pst.executeUpdate();

//        JOptionPane.showMessageDialog(null, "DATOS ALMACENADOS CORRECTAMENTE");
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public ResultSet realizarConsulta(String inicioturno) throws SQLException {

        sSQL = "select *from inicioturno where numero_turno=?";

        PreparedStatement pst = cn.prepareStatement(sSQL);
        pst.setString(1, inicioturno);

        return pst.executeQuery();
    }

    public int obtenerTotalHabitacionesOcupadas() {
        int totalOcupadas = 0;

        try {
            String sSQL = "SELECT COUNT(*) AS total FROM habitacion WHERE estado = 'Ocupado'";

            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                totalOcupadas = rs.getInt("total");

            }

        } catch (SQLException e) {
        }

        return totalOcupadas;
    }
    
      public ResultSet Consultapago(int pago) throws SQLException {

        sSQL = "select *from pago where numero_turno=?";

        PreparedStatement pst = cn.prepareStatement(sSQL);
        pst.setInt(1, pago);

        return pst.executeQuery();
    }

   

    public double obtenerCostoTotalAlojamiento() {
        double totalCosto = 0.0;

        try {
            String sSQL = "SELECT SUM(precio) AS totalCosto FROM habitacion WHERE estado = 'Ocupado'";
            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                totalCosto = rs.getDouble("totalCosto");
            }
        } catch (SQLException e) {
        }

        return totalCosto;
    }

    public String estadoturno() {
        String estado = "";
        String sSQL = "select estado from inicioturno ORDER BY numero_turno DESC LIMIT 1;";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                estado = rs.getString("estado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el estado del turno: " + e.getMessage());
        }

        return estado;
    }

    public int numeroturno() {
        int numeroturno = 0;
         sSQL = "SELECT numero_turno FROM inicioturno WHERE estado = 'Activo' ORDER BY numero_turno DESC LIMIT 1";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                numeroturno = rs.getInt("numero_turno");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el numero del turno: " + e.getMessage());
        }

        return numeroturno;
    }

    public int[] totalmedio_pagos(int numeroturno) {
        int[] mediosDePago = new int[3]; // Un array para almacenar los totales de efectivo, tarjeta y transferencia

        // Consulta SQL para obtener los totales de medios de pago durante un turno activo
        String sSQL = "SELECT SUM(efectivo) AS efectivo, SUM(tarjeta) AS tarjeta, SUM(transferencia) AS transferencia "
                + "FROM abono WHERE numero_turno = ?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, numeroturno);

            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    mediosDePago[0] = rs.getInt("efectivo"); // Total en efectivo
                    mediosDePago[1] = rs.getInt("tarjeta");  // Total en tarjeta
                    mediosDePago[2] = rs.getInt("transferencia"); // Total en transferencia
                }
            }

            return mediosDePago; // Retornar el array con los totales
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener totales en medios de pago: " + e.getMessage());
            return new int[]{0, 0, 0}; // En caso de error, retornar un array con valores 0
        }
    }
    
    public int[] totalmedio_pagos_pago(int numeroturno) {
        int[] mediosDePago_pago = new int[3]; // Un array para almacenar los totales de efectivo, tarjeta y transferencia

        // Consulta SQL para obtener los totales de medios de pago durante un turno activo
        String sSQL = "SELECT SUM(efectivo) AS efectivo, SUM(tarjeta) AS tarjeta, SUM(transferencias) AS transferencias "
                + "FROM salida WHERE numero_turno = ?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, numeroturno);

            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    mediosDePago_pago[0] = rs.getInt("efectivo"); // Total en efectivo
                    mediosDePago_pago[1] = rs.getInt("tarjeta");  // Total en tarjeta
                    mediosDePago_pago[2] = rs.getInt("transferencias"); // Total en transferencia
                }
            }

            return mediosDePago_pago; // Retornar el array con los totales
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener totales en medios de pago: " + e.getMessage());
            return new int[]{0, 0, 0}; // En caso de error, retornar un array con valores 0
        }
    }

    public int totalAbonos(int numero) {
        int numeroturno = 0;
        String sSQL = "SELECT SUM(totalapagar) AS totalapagar from abono where numero_turno = ?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, numero);
            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    numeroturno = rs.getInt("totalapagar");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la suma de toteles a pagar: " + e.getMessage());
        }

        return numeroturno;
    }

    public String Consultaempleado(int idEmpleado) throws SQLException {
        String empleado1 = "";
        String sSQL = "SELECT empleado FROM inicioturno WHERE idinicioturno =? AND estado ='Activo';";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, idEmpleado);

            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    empleado1 = rs.getString("empleado");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el dato del empleado: " + e.getMessage());
        }

        return empleado1;
    }

    public int sumatotales(int inicioturno2) {
        int netorecaudado = 0;

        sSQL = "SELECT SUM(deuda_anterior) AS deuda_anterior from reserva1.pago where numero_turno = ?";
        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, inicioturno2);

            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    netorecaudado = rs.getInt("deuda_anterior");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la suma de deudas anterior: " + e.getMessage());
        }
         return netorecaudado;
    }
   public int sumaDeudaAnterior(int inicioturno3) {
        int deuda_anterior = 0;

        sSQL = "SELECT SUM(deuda_anterior) AS deuda_anterior from pago where numero_turno = ?";
        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, inicioturno3);

            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    deuda_anterior = rs.getInt("deuda_anterior");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la suma de deuda Aterior: " + e.getMessage());
        }
         return deuda_anterior;
    }

     public int[] parque_lavan(int Num_Turno) {
        int[] parque_lavan = new int[2]; // Un array para almacenar los totales de efectivo, tarjeta y transferencia

        // Consulta SQL para obtener los totales de medios de pago durante un turno activo
        String sSQL = "SELECT sum(parqueadero) as parqueadero, sum(lavanderia) as lavanderia FROM reservac.abono where numero_turno = ?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, Num_Turno);

            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                   parque_lavan[0] = rs.getInt("parqueadero"); // Total en efectivo
                   parque_lavan[1] = rs.getInt("lavanderia");  // Total en tarjeta
                    
                }
            }

            return parque_lavan; // Retornar el array con los totales
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el valor: " + e.getMessage());
            return new int[]{0, 0, 0}; // En caso de error, retornar un array con valores 0
        }
    }

}
