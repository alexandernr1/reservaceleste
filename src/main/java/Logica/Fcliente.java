package Logica;

import Datos.Dcliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fcliente {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";

    public Integer totalregistros;

    public DefaultTableModel mstrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombres", "Apelliodos", "TipoDocumeto", "NúmeoDocumento", "Teléfono", "Dirección", "Email", "Pais", "Ciudad"};

        String[] registro = new String[10];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from cliente where numdocumento like '%" + buscar + "%' order by idcliente";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idcliente");
                registro[1] = rs.getString("nombres");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("tipodocumento");
                registro[4] = rs.getString("numdocumento");
                registro[5] = rs.getString("telefono");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("email");
                registro[8] = rs.getString("pais");
                registro[9] = rs.getString("ciudad");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;

        }
    }

    public boolean insertar(Dcliente dts) {

        sSQL = "insert into cliente (nombres, apellidos, tipodocumento, numdocumento, telefono, direccion,  email, pais, ciudad)"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombres());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getTipodocumento());
            pst.setString(4, dts.getNumdocumento());
            pst.setString(5, dts.getTelefono());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getEmail());
            pst.setString(8, dts.getPais());
            pst.setString(9, dts.getCiudad());

            int n = pst.executeUpdate();

            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } 

    }

    public boolean editar(Dcliente dts) throws SQLException {
        sSQL = "UPDATE cliente SET nombres=?, apellidos=?, tipodocumento=?, numdocumento=?, "
                + "telefono=?, direccion=?,  email=?,  pais=?, ciudad=? WHERE idcliente=?";
       
        try { PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNombres());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getTipodocumento());
            pst.setString(4, dts.getNumdocumento());
            pst.setString(5, dts.getTelefono());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getEmail());
            pst.setString(8, dts.getPais());
            pst.setString(9, dts.getCiudad());

            pst.setInt(10, dts.getIdcliente());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } 

    }

    public boolean eliminar(Dcliente dts)  {
        sSQL = "delete from cliente where idcliente=?";
       
        try { PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdcliente());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } 
    }
    public boolean existeCliente(String numdocumento) {
//    Connection cn = Conexion.getConnection();
    sSQL = "SELECT COUNT(*) FROM cliente WHERE numdocumento = ?";
    try {
        PreparedStatement pst = cn.prepareStatement(sSQL);
        pst.setString(1, numdocumento);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // Retorna true si existe el cliente
        }
    } catch (SQLException e) {
        Logger.getLogger(Fcliente.class.getName()).log(Level.SEVERE, null, e);
    } 
    return false;
}

}
