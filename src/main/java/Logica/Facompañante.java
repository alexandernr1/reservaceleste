package Logica;

import Datos.Dacompañante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Facompañante {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostraracompañante(String buscar)  {
        DefaultTableModel modelo;

        String[] titulos = {"idacompañante", "Idcliente", "Nombre Apellido", "Tipo documento", "Documento", "Parentesco", "Numero habita", "checkin", "Huesped Principal", "Residencia", "Procedencia", "Estado"};

        String[] registro = new String[12];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from acompañantes where num_huesped_principal like '%" + buscar + "%' order by idcliente";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idacompañante");
                registro[1] = rs.getString("idcliente");
                registro[2] = rs.getString("nombre_apellido");
                registro[3] = rs.getString("tipo_documento");
                registro[4] = rs.getString("documento");
                registro[5] = rs.getString("parentesco");
                registro[6] = rs.getString("num_habitacion");
                registro[7] = rs.getString("checkin");
                registro[8] = rs.getString("num_huesped_principal");
                registro[9] = rs.getString("ciudad_de_residencia");
                registro[10] = rs.getString("ciudad_de_procedencia");
                registro[11] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        } 
    }

    public boolean insertar(Dacompañante dts)  {
        sSQL = "insert into acompañantes (idcliente,nombre_apellido, tipo_documento, documento, parentesco, num_habitacion, checkin, num_huesped_principal, ciudad_de_residencia,ciudad_de_procedencia, estado)"
                + "values (?,?,?,?,?,?,?,?,?,?,?)";
        
        try {PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcliente());
            pst.setString(2, dts.getNombre_apellido());
            pst.setString(3, dts.getTipo_documento());
            pst.setInt(4, dts.getDocumento());
            pst.setString(5, dts.getParentesco());
            pst.setInt(6, dts.getNum_habitacion());
            pst.setDate(7, dts.getCheckin());
            pst.setInt(8, dts.getNum_huesped_principal());
            pst.setString(9, dts.getCiudad_de_residencia());
            pst.setString(10, dts.getCiudad_de_procedencia());
            pst.setString(11, dts.getEstado());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } 

        
    }

    public boolean eliminar(Dacompañante dts) {
        sSQL = "delete from acompañantes where idacompañante=?";

       
        try { PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdacompañante());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } 
    }

    public boolean SalidaAcompañante(Dacompañante dts)  {
        sSQL = "UPDATE acompañantes SET estado = 'Finalizado' "
                + "WHERE idacompañante = ?";

       
        try { PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdacompañante());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } 
    }
     public boolean desocuparacompañante(Dacompañante dts) {
        sSQL = "UPDATE acompañantes SET estado='Finalizado' WHERE idcliente=?";

        try (PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts.getIdcliente());

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al finalizar acompañante: " + e.getMessage());
            return false;
        }
    }
}
