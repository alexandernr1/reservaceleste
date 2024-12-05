package Logica;

import Datos.Dabono;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fabonos {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";

    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {
            "Idabono", "Idingreso", "Idhabitacion", "Numero", "idcliente", "Cliente",
            "Identificación", "Fecha Abono", "Abono habitacion", "Descuentos",
            "Conceptos Descuentos", "Total Abonos", "Privilegios Admon",
            "Privilegios Recep", "Otros Cobros", "Numero Turno", "Documento",
            "Razon Social", "Email", "Numero Noches", "Valor Descuento",
            "Tipo Comprobante", "Numero Comprobante", "IVA 19", "Retencion 35",
            "Retencion 4", "Subtotal", "Efectivo", "Tarjeta", "Transferencia",
            "Total a Pagar", "valor_bruto", "antesIVA", "Parqueadero", "Lavaneria", "Colchon Adi"
        };
        String[] registro = new String[36];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT a.idabono, a.idingreso, a.idhabitacion, h.numero, a.idcliente, "
                + "(SELECT nombres FROM cliente WHERE idcliente = a.idcliente) AS clienten, "
                + "(SELECT apellidos FROM cliente WHERE idcliente = a.idcliente) AS clienteap, "
                + "(SELECT numdocumento FROM cliente WHERE idcliente = a.idcliente) AS clientenu, "
                + "a.fechaabono, a.abonohabitacion, a.descuentos, a.conceptodescuento, "
                + "a.totalabonos, a.privilegiosadmon, a.privilegiosrecepcion, a.otroscobros, a.numero_turno, "
                + "a.documento, a.razon_social, a.email, a.numeronoches, a.valordescuento,"
                + "a.tipocomprobante, a.numerocomprobante, a.iva19, a.retencion35, a.retencion4, "
                + "a.subtotal, a.efectivo, a.tarjeta, a.transferencia, a.totalapagar, a.valor_bruto, a.antesIVA, a.parqueadero, a.lavanderia, a.colchonadi "
                + "FROM abono a "
                + "INNER JOIN habitacion h ON a.idhabitacion = h.idhabitacion "
                + "WHERE h.numero LIKE ? "
                + "ORDER BY a.idabono DESC LIMIT 30";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setString(1, "%" + buscar + "%");

            try ( ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    registro[0] = rs.getString("idabono");
                    registro[1] = rs.getString("idingreso");
                    registro[2] = rs.getString("idhabitacion");
                    registro[3] = rs.getString("numero");
                    registro[4] = rs.getString("idcliente");
                    registro[5] = rs.getString("clienten") + " " + rs.getString("clienteap");
                    registro[6] = rs.getString("clientenu");
                    registro[7] = rs.getString("fechaabono");
                    registro[8] = rs.getString("abonohabitacion");
                    registro[9] = rs.getString("descuentos");
                    registro[10] = rs.getString("conceptodescuento");
                    registro[11] = rs.getString("totalabonos");
                    registro[12] = rs.getString("privilegiosadmon");
                    registro[13] = rs.getString("privilegiosrecepcion");
                    registro[14] = rs.getString("otroscobros");
                    registro[15] = rs.getString("numero_turno");
                    registro[16] = rs.getString("documento");
                    registro[17] = rs.getString("razon_social");
                    registro[18] = rs.getString("email");
                    registro[19] = rs.getString("numeronoches");
                    registro[20] = rs.getString("valordescuento");
                    registro[21] = rs.getString("tipocomprobante");
                    registro[22] = rs.getString("numerocomprobante");
                    registro[23] = rs.getString("iva19");
                    registro[24] = rs.getString("retencion35");
                    registro[25] = rs.getString("retencion4");
                    registro[26] = rs.getString("subtotal");
                    registro[27] = rs.getString("efectivo");
                    registro[28] = rs.getString("tarjeta");
                    registro[29] = rs.getString("transferencia");
                    registro[30] = rs.getString("totalapagar");
                    registro[31] = rs.getString("valor_bruto");
                    registro[32] = rs.getString("antesIVA");
                    registro[33] = rs.getString("parqueadero");
                    registro[34] = rs.getString("lavanderia");
                    registro[35] = rs.getString("colchonadi");

                    totalregistros++;
                    modelo.addRow(registro);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE MOSTRAR LOS DATOS: " + e.getMessage());
        }

        return modelo;
    }

    public Object[] mostrarVistaAbono(String buscar, String turnoActivo) throws SQLException {
        DefaultTableModel modelo;
        String[] titulos = {
            "idabono", "idingreso", "idhabitacion", "N° Habitacion",
            "Fecha Abono", "Precio habitacion", "Descuentos", "Otros Cobros", "N° turno",
            "Documento", "Razon Social", "Email", "N° Noches", "valor Descuento",
            "Efectivo", "Tarjeta", "Transferencia", "Total Apagar", "Parqueadero", "Lavanderia", "Colchon Adi"
        };
        String[] registro = new String[21];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT a.idabono, a.idingreso, a.idhabitacion, h.numero,"
                + "a.fechaabono, a.abonohabitacion, a.descuentos, a.otroscobros, a.numero_turno,"
                + "a.documento, a.razon_social, a.email, a.numeronoches, a.valordescuento,"
                + "a.efectivo, a.tarjeta, a.transferencia, a.totalapagar, a.parqueadero, a.lavanderia, a.colchonadi, "
                + "SUM(a.efectivo) AS totalEfectivo, "
                + "SUM(a.tarjeta) AS totalTarjeta, "
                + "SUM(a.transferencia) AS totalTransferencia "
                + "FROM abono a "
                + "INNER JOIN habitacion h ON a.idhabitacion = h.idhabitacion "
                + "INNER JOIN cliente c ON a.idcliente = c.idcliente "
                + "INNER JOIN inicioturno t ON a.numero_turno = t.numero_turno "
                + "WHERE c.numdocumento LIKE '%" + buscar + "%' "
                + "AND t.estado = 'Activo' "
                + "GROUP BY a.idabono "
                + "ORDER BY a.idabono DESC";

        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sSQL);

        int totalEfectivo = 0;
        int totalTarjeta = 0;
        int totalTransferencia = 0;

        try {
            while (rs.next()) {
                registro[0] = rs.getString("idabono");
                registro[1] = rs.getString("idingreso");
                registro[2] = rs.getString("idhabitacion");
                registro[3] = rs.getString("numero");
                registro[4] = rs.getString("fechaabono");
                registro[5] = rs.getString("abonohabitacion");
                registro[6] = rs.getString("descuentos");
                registro[7] = rs.getString("otroscobros");
                registro[8] = rs.getString("numero_turno");
                registro[9] = rs.getString("documento");
                registro[10] = rs.getString("razon_social");
                registro[11] = rs.getString("email");
                registro[12] = rs.getString("numeronoches");
                registro[13] = rs.getString("valordescuento");
                registro[14] = rs.getString("efectivo");
                registro[15] = rs.getString("tarjeta");
                registro[16] = rs.getString("transferencia");
                registro[17] = rs.getString("totalapagar");
                registro[18] = rs.getString("parqueadero");
                registro[19] = rs.getString("lavanderia");
                registro[20] = rs.getString("colchonadi");

                totalEfectivo += rs.getInt("totalEfectivo");
                totalTarjeta += rs.getInt("totalTarjeta");
                totalTransferencia += rs.getInt("totalTransferencia");

                totalregistros++;
                modelo.addRow(registro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE MOSTRAR LOS DATOS: " + e.getMessage());
        }

        return new Object[]{modelo, totalEfectivo, totalTarjeta, totalTransferencia};
    }

    public boolean insertar(Dabono dts) {
        sSQL = "INSERT INTO abono (idingreso, idhabitacion, idcliente, fechaabono, abonohabitacion, descuentos, conceptodescuento,"
                + " totalabonos, privilegiosadmon, privilegiosrecepcion, otroscobros, numero_turno,"
                + " habitacion, cliente, documento, razon_social, email, numeronoches, valordescuento,"
                + " tipocomprobante, numerocomprobante, iva19, retencion35, retencion4,"
                + " subtotal, efectivo, tarjeta, transferencia, totalapagar, valor_bruto, antesIVA, costoalojamiento, idinicioturno, turno, parqueadero, lavanderia, colchonadi)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts.getIdingreso());
            pst.setInt(2, dts.getIdhabitacion());
            pst.setInt(3, dts.getIdcliente());
            pst.setString(4, dts.getFechaabono());
            pst.setInt(5, dts.getAbonohabitacion());
            pst.setString(6, dts.getDescuentos());
            pst.setString(7, dts.getConceptodescuento());
            pst.setInt(8, dts.getTotalAbonos());
            pst.setString(9, dts.getPrivilegiosAdmon());
            pst.setString(10, dts.getPrivilegiosrecepcion());
            pst.setInt(11, dts.getOtroscobros());
            pst.setInt(12, dts.getNumero_turno());
            pst.setInt(13, dts.getHabitacion());
            pst.setString(14, dts.getCliente());
            pst.setString(15, dts.getDocumento());
            pst.setString(16, dts.getRazon_social());
            pst.setString(17, dts.getEmail());
            pst.setInt(18, dts.getNumeronoches());
            pst.setInt(19, dts.getValordescuento());
            pst.setString(20, dts.getTipocomprobante());
            pst.setString(21, dts.getNumerocomprobante());
            pst.setInt(22, dts.getIva19());
            pst.setInt(23, dts.getRetencion35());
            pst.setInt(24, dts.getRetencion4());
            pst.setInt(25, dts.getSubtotal());
            pst.setInt(26, dts.getEfectivo());
            pst.setInt(27, dts.getTarjeta());
            pst.setInt(28, dts.getTransferencia());
            pst.setInt(29, dts.getTotalapagar());
            pst.setInt(30, dts.getValor_bruto());
            pst.setInt(31, dts.getAntesIVA());
            pst.setInt(32, dts.getCostoalojamiento());
            pst.setInt(33, dts.getIdinicioturno());
            pst.setString(34, dts.getTurno());
            pst.setInt(35, dts.getParqueadero());
            pst.setInt(36, dts.getLavanderia());
            pst.setInt(37, dts.getColchonadi());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public DefaultTableModel mostrarAbonoCongelado(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {
            "Idabono", "Numero", "idcliente", "Cliente",
            "Identificación", "Fecha Abono", "Abono habitacion", "Descuentos", "N° Noches", "Costo"};
        String[] registro = new String[10];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select idabono, habitacion, idcliente, cliente, documento, fechaabono, abonohabitacion, descuentos, numeronoches, costoalojamiento "
                + "from reserva1.abono  "
                + "WHERE documento LIKE ? ";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setString(1, "%" + buscar + "%");

            try ( ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    registro[0] = rs.getString("idabono");
                    registro[1] = rs.getString("habitacion");
                    registro[2] = rs.getString("idcliente");
                    registro[3] = rs.getString("cliente");
                    registro[4] = rs.getString("documento");
                    registro[5] = rs.getString("fechaabono");
                    registro[6] = rs.getString("abonohabitacion");
                    registro[7] = rs.getString("descuentos");
                    registro[8] = rs.getString("numeronoches");
                    registro[9] = rs.getString("costoalojamiento");

                    totalregistros++;
                    modelo.addRow(registro);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE MOSTRAR LOS DATOS: " + e.getMessage());
        }

        return modelo;
    }

    public boolean editar(Dabono dts) {
        sSQL = "UPDATE abono SET idingreso=?, idhabitacion=?, idcliente=?, fechaabono=?, abonohabitacion=?, descuentos=?, conceptodescuento=?, "
                + "totalabonos=?, privilegiosadmon=?, privilegiosrecepcion=?, otroscobros=?, numero_turno=?, "
                + "habitacion=?, cliente=?, documento=?, razon_social=?, email=?, numeronoches=?, valordescuento=?, "
                + "tipocomprobante=?, numerocomprobante=?, iva19=?, retencion35=?, retencion4=?, "
                + "subtotal=?, efectivo=?, tarjeta=?, transferencia=?, totalapagar=?, valor_bruto=?, antesIVA=?, "
                + "costoalojamiento=?, idinicioturno=?, turno=?, parqueadero=?, lavanderia=?, colchonadi=? "
                + "WHERE idabono=?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts.getIdingreso());
            pst.setInt(2, dts.getIdhabitacion());
            pst.setInt(3, dts.getIdcliente());
            pst.setString(4, dts.getFechaabono());
            pst.setInt(5, dts.getAbonohabitacion());
            pst.setString(6, dts.getDescuentos());
            pst.setString(7, dts.getConceptodescuento());
            pst.setInt(8, dts.getTotalAbonos());
            pst.setString(9, dts.getPrivilegiosAdmon());
            pst.setString(10, dts.getPrivilegiosrecepcion());
            pst.setInt(11, dts.getOtroscobros());
            pst.setInt(12, dts.getNumero_turno());
            pst.setInt(13, dts.getHabitacion());
            pst.setString(14, dts.getCliente());
            pst.setString(15, dts.getDocumento());
            pst.setString(16, dts.getRazon_social());
            pst.setString(17, dts.getEmail());
            pst.setInt(18, dts.getNumeronoches());
            pst.setInt(19, dts.getValordescuento());
            pst.setString(20, dts.getTipocomprobante());
            pst.setString(21, dts.getNumerocomprobante());
            pst.setInt(22, dts.getIva19());
            pst.setInt(23, dts.getRetencion35());
            pst.setInt(24, dts.getRetencion4());
            pst.setInt(25, dts.getSubtotal());
            pst.setInt(26, dts.getEfectivo());
            pst.setInt(27, dts.getTarjeta());
            pst.setInt(28, dts.getTransferencia());
            pst.setInt(29, dts.getTotalapagar());
            pst.setInt(30, dts.getValor_bruto());
            pst.setInt(31, dts.getAntesIVA());
            pst.setInt(32, dts.getCostoalojamiento());
            pst.setInt(33, dts.getIdinicioturno());
            pst.setString(34, dts.getTurno());
            pst.setInt(35, dts.getParqueadero());
            pst.setInt(36, dts.getLavanderia());
            pst.setInt(37, dts.getColchonadi());

            pst.setInt(38, dts.getIdabono()); // Este es el parámetro para el WHERE

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(Dabono dts) {
        sSQL = "DELETE FROM abono WHERE idabono = ?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts.getIdabono());

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public int generarComprobante() {
        String serie = "";
        sSQL = "SELECT MAX(CAST(numerocomprobante AS UNSIGNED)) FROM abono WHERE numerocomprobante REGEXP '^[0-9]+$';";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                serie = rs.getString(1);
                if (serie != null) {
                    // Incrementar el valor de serie
                    return Integer.parseInt(serie) + 1;
                } else {
                    // Si no hay registros, el primer número de turno es 1
                    return 1;
                }
            } else {
                // Si la consulta no devuelve resultados, también retornamos 1
                return 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el número: " + e.getMessage());
            return 0;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir el número: " + e.getMessage());
            return 0;
        }
    }

}
