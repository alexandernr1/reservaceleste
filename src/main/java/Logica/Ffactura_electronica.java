package Logica;

import Datos.Dfactura_electronica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Ffactura_electronica {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";

    public boolean insertar(Dfactura_electronica dts) throws SQLException {

        sSQL = "insert into factura_electronica (documento, DV,razon_social,tipo_persona,tipo_documento,departamento,municipio,direccion,telefono,email,regimen_fiscal,responsabilidades_fiscales,idcliente)"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = cn.prepareStatement(sSQL);
        try {

            pst.setInt(1, dts.getDocumento());
            pst.setInt(2, dts.getDv());
            pst.setString(3, dts.getRazon_social());
            pst.setString(4, dts.getTipo_persona());
            pst.setString(5, dts.getTipo_documento());
            pst.setString(6, dts.getDepartamento());
            pst.setString(7, dts.getMunicipio());
            pst.setString(8, dts.getDireccion());
            pst.setString(9, dts.getTelefono());
            pst.setString(10, dts.getEmail());
            pst.setString(11, dts.getRegimen_fiscal());
            pst.setString(12, dts.getResponsabilidades_fiscales());
            pst.setInt(13, dts.getIdcliente());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
            }

        }

    }

   public boolean existeCliente(int documento) {
    String sql = "SELECT COUNT(*) FROM factura_electronica WHERE documento = ?";
    try (PreparedStatement pst = cn.prepareStatement(sql)) {
        pst.setInt(1, documento);
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al verificar la existencia del cliente: " + e.getMessage());
        // Manejar la excepción según sea necesario (log, rethrow, etc.)
    }
    return false; // Retornar false si hay un error o si no se encuentra el cliente
}


   public boolean actualizar(Dfactura_electronica dts) {
    String sql = "UPDATE factura_electronica SET DV=?, razon_social=?, tipo_persona=?, tipo_documento=?, departamento=?, municipio=?, direccion=?, telefono=?, email=?, responsabilidades_fiscales=?, regimen_fiscal=?, idcliente=? WHERE documento=?";
    try (PreparedStatement pst = cn.prepareStatement(sql)) {
        pst.setInt(1, dts.getDv());
        pst.setString(2, dts.getRazon_social());
        pst.setString(3, dts.getTipo_persona());
        pst.setString(4, dts.getTipo_documento());
        pst.setString(5, dts.getDepartamento());
        pst.setString(6, dts.getMunicipio());
        pst.setString(7, dts.getDireccion());
        pst.setString(8, dts.getTelefono());
        pst.setString(9, dts.getEmail());
        pst.setString(10, dts.getResponsabilidades_fiscales());
        pst.setString(11, dts.getRegimen_fiscal());
        pst.setInt(12, dts.getIdcliente()); // Nota: Debes pasar el idcliente antes del documento
        pst.setInt(13, dts.getDocumento());

        return pst.executeUpdate() > 0;
    } catch (SQLException e) {
        System.err.println("Error al actualizar el cliente: " + e.getMessage());
        // Manejar la excepción según sea necesario (log, rethrow, etc.)
    }
    return false; // Retornar false si hay un error en la actualización
}


}
