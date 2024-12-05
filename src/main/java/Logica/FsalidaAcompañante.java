package Logica;

import Datos.Dacompañante;
import Datos.DsalidaAcompañante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FsalidaAcompañante {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    
    
     public boolean insertar(DsalidaAcompañante dts) {
        sSQL = "insert into salidaacompañantes (idacompañante, idcliente,nombre_apellido, tipo_documento, documento, parentesco, num_habitacion, checkin, checkoup, num_huesped_principal, ciudad_de_residencia,ciudad_de_procedencia)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getIdacompañante());
            pst.setInt(2, dts.getIdcliente());
            pst.setString(3, dts.getNombre_apellido());
            pst.setString(4, dts.getTipo_documento());
            pst.setInt(5, dts.getDocumento());
            pst.setString(6, dts.getParentesco());
            pst.setInt(7, dts.getNum_habitacion());
            pst.setString(8, dts.getCheckin());
             pst.setString(9, dts.getCheckoup());
            pst.setInt(10, dts.getNum_huesped_principal());
            pst.setString(11, dts.getCiudad_de_residencia());
            pst.setString(12, dts.getCiudad_de_procedencia());
         

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(DsalidaAcompañante dts) {
        sSQL = "delete from salidaacompañantes where idsalidaAcompañante=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdacompañante());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
   

}
